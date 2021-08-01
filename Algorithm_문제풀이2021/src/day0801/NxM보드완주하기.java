package day0801;

import java.util.Scanner;
/*
 *
 * 백트래킹과 구현의 정수를 볼 수 있는 문제...
 *
 * */
public class NxM보드완주하기 {
    static char[][] a;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int n, m;

    static boolean ok(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    //공이 x,y에 있고 방문하지 않은 빈칸의 개수가 cnt개를 의미. 반환형 int는 몇 번 더 이동해야 모든칸을 방문할 수 있는지를 나타냄.
    static int go(int x, int y, int cnt) {
        int ans = -1;
        //방문할 칸이 더이상 없으면
        if (cnt == 0) {
            return 0; //이동할 횟수가 0을 의미.
        }

        for (int k=0; k<4; k++) {

            int nx = x+dx[k];
            int ny = y+dy[k];
            //범위 안에 있고 빈칸이면
            while (ok(nx, ny) && a[nx][ny] == '.') {
                a[nx][ny] = '#'; //이동한 곳은 장애물로 변경해준다.
                cnt -= 1;
                nx += dx[k];
                ny += dy[k];
            }
            //위 while문에서 이동을 시킨 후 검사를 했으니 while문을 탈출했으면 한칸을 다시 뒤로 밀어준다.
            nx -= dx[k];
            ny -= dy[k];

            //현재칸과 같지 않을때만. 즉, 위 while문을 통해 이동을 했을때만 해당 if문 안으로 진입.
            if (!(x == nx && y == ny)) {
                int temp = go(nx, ny, cnt);
                //불가능한 경우가 아니라면
                if (temp != -1) {
                    if (ans == -1 || ans > temp+1) {
                        ans = temp+1; //여기서 temp+1의 +1은 위 while문에서 한 방향으로 쭉 이동한것을 1번 이동했음으로 치는것이다.
                    }
                }
            }

            //다시 원래칸으로 복귀 시켜준다.
            while (!(x == nx && y == ny)) {
                a[nx][ny] = '.';
                cnt += 1;
                nx -= dx[k];
                ny -= dy[k];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();
            a = new char[n][m];
            int cnt = 0;
            for (int i=0; i<n; i++) {
                a[i] = sc.next().toCharArray();
                for (int j=0; j<m; j++) {
                    if (a[i][j] == '.') {
                        cnt += 1;
                    }
                }
            }
            int ans = -1;
            //모든 위치에서 시작해본다.
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] == '.') {
                        a[i][j] = '#';
                        int temp = go(i, j, cnt-1);
                        if (temp != -1) {
                            if (ans == -1 || ans > temp) {
                                ans = temp;
                            }
                        }
                        a[i][j] = '.';
                    }
                }
            }
            System.out.printf("Case %d: %d\n", tc, ans);
            tc += 1;
        }
    }
}