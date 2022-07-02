package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 아기상어_구글링1 {

    public static final int max_val = 401, max_int = 21;
    public static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
    public static int [][] a, check;
    public static int [] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n + 1][n + 1];
        check = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());

                if(a[i][j] == 9){
                    shark_x = i;
                    shark_y = j;
                    a[i][j] = 0;
                }
            }
        }

        while(true){
            init_check();
            bfs(shark_x, shark_y); //이 bfs를 한번 돌때마다 먹을 수 있는 고기 중 제일 적합한 고기를 찾아냄. 그리고 그 고기의 위치를 min_x와 min_y에 갱신.
            if(min_x != max_int && min_y != max_int){
                result += check[min_x][min_y];
                eat_cnt++;
                if(eat_cnt == shark_size){
                    shark_size++;
                    eat_cnt = 0;
                }
                a[min_x][min_y] = 0;
                shark_x = min_x;
                shark_y = min_y;
            }
            else{
                break;
            }
        }

        System.out.println(result);
    }

    public static void init_check(){
        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                check[i][j] = -1;
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<info> q = new LinkedList<info>();
        check[x][y] = 0; //방문하면 0으로 초기화
        q.add(new info(x, y));

        while(!q.isEmpty()){
            info cur = q.poll();
            x = cur.x;
            y = cur.y;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위를 벗어났으면
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                //방문을 했거나 현재고기가 shark보다 사이즈가 크면
                if(check[nx][ny] != -1 || a[nx][ny] > shark_size) continue;
                //4방으로 거리 1씩증가
                check[nx][ny] = check[x][y] + 1;

                //a가 0이거나 shark의 size랑 같다면 아래 if문을 타지 않고 q에 바로들어가고
                //그렇지 않으면(즉, 먹을 수 있는 고기를 발견했다면) 이 if문을 탐
                if(a[nx][ny] != 0 && a[nx][ny] < shark_size){
                    //해당 고기까지의 최단 경로를 발견했다면
                	if(min_dist > check[nx][ny]){
                        min_x = nx;
                        min_y = ny;
                        min_dist = check[nx][ny];
                    }
                	//최단 경로가 같은 물고기가 여러개 발견된 경우임. 이때 먹을 녀석 한마리를 가려내야함. 즉, 문제에서 주어진대로 가장위에 있는 물고기. 그런 물고기가 여러마리면 가장 왼쪽에 있는 물고기를 먹어야함.
                    else if(min_dist == check[nx][ny]){
                    	//가장 위에 있는 고기를 먹어야한다. min_x가 내가 주로 표시하는 y좌표임.
                    	if(min_x == nx){ //즉, y가 여러명이면
                            if(min_y > ny){ //더 왼쪽걸 먹는다.
                                min_x = nx;
                                min_y = ny;
                            }
                        }
                    	//y가 더 높은 놈이 있으면 그 놈을 먹는다.
                    	else if(min_x > nx){
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }
                q.add(new info(nx, ny));
            }
        }

    }
}

class info{
    int x, y;

    info(int x, int y){
        this.x = x;
        this.y = y;
    }
};