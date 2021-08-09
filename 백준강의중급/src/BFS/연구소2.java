package BFS;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소2 {
	static class Pair {
	    int x, y;
	    Pair(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
    static int[][] a;
    static int[][] d;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int n, m;
    static ArrayList<Pair> candi = new ArrayList<>();
    static int ans = -1;


    static void bfs() {
    	//d는 방문배열 전부 -1로 초기화
        for (int i=0; i<n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 3) { //바이러스가 있는 곳이 시작 위치
                    q.add(new Pair(i,j)); //모두 q에 집어넣는다.
                    d[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    //벽이 아니면서 방문한 적이 없다면
                	if (a[nx][ny] != 1 && d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        int cur = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                //벽이 아니면서
            	if (a[i][j] != 1) {
                    //방문한 적이 없다면
            		if (d[i][j] == -1) //이 경우는 벽에 가로막혀서 더이상 뻗어나갈 수 없었을 때 발생한다.
            			return;
            		//bfs를 조지고 난 후에 d에 기록된 시간중에 제일 높은거
                    if (cur < d[i][j])
                    	cur = d[i][j];
                }
            }
        }

        //만약 cur이 ans보다 작다면 ans를 cur로 바꾼다.
        if (ans == -1 || ans > cur) {
            ans = cur;
        }
    }

    //index번째를 고를지 말지 선택하는 함수 go
    static void go(int index, int cnt) {
        //만약 끝까지 선택을 했다면
    	if (index == candi.size()) {
            //이때 m개를 골랐다면
    		if (cnt == m) {
                bfs(); //bfs를 동작시킨다.
            }
        } else {
            int x = candi.get(index).x;
            int y = candi.get(index).y;

            a[x][y] = 3; //실제 바이러스
            go(index+1, cnt+1); //선택하는 경우
            a[x][y] = 0; //빈칸

            go(index+1, cnt); //선택하지 않는 경우
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        d = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                //입력받은 값이 2(바이러스를 놓을 수 있는곳)면
                if (a[i][j] == 2) {
                    a[i][j] = 0; //일단 0(빈칸)으로 만들고
                    candi.add(new Pair(i,j)); //후보에 집어 넣는다. candi의 최대 size는 10이다.
                }
            }
        }

        go(0,0);
        System.out.println(ans);
    }
}