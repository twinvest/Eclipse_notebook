package BFS;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 말이되고픈원숭이 {
    static final int[] dx = {0,0,1,-1,-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,-1,0,0,1,2,2,1,-1,-2,-2,-1};
    static final int[] cost = {0,0,0,0,1,1,1,1,1,1,1,1}; //앞에 4개는 0, 뒤에 8개는 1. 즉, 나이트처럼이동한 횟수를 기록하기 위해서.
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][][] d = new int[n][m][l+1];
        //3차원 배열을 모두 -1로 초기화
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                Arrays.fill(d[i][j],-1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        q.add(0);
        d[0][0][0] = 0; //(0,0)에서 말처럼 이동한 횟수는 0번을 의미.
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int c = q.remove();
            for (int k=0; k<12; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nc = c+cost[k];
                //범위 안에 있고
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    //장애물이면 continue
                	if (a[nx][ny] == 1)
                		continue;
                	//만약에 말처럼 움직일 수 있는  횟수가 남아있고
                    if (nc <= l) {
                    	//해당좌표를 방문한 적이 없다면
                        if (d[nx][ny][nc] == -1) {
                            d[nx][ny][nc] = d[x][y][c] + 1;
                            q.add(nx); q.add(ny); q.add(nc);
                        }
                    }
                }
            }
        }


        int ans = -1;
        //문제의 정답이 항상 d[n-1][m-1][l]에 들어있는 것은 아니다.
        //2번만 말처럼 움직여서 최소횟수로 도달할 수도 있고 3번만에 갈 수도 있기때문에.
        for (int i=0; i<=l; i++) {
            if (d[n-1][m-1][i] == -1) continue;
            if (ans == -1 || ans > d[n-1][m-1][i]) {
                ans = d[n-1][m-1][i];
            }
        }
        System.out.print(ans);
    }
}