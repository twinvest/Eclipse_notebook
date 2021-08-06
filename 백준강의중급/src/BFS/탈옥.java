package BFS;

import java.util.ArrayDeque;
import java.util.Scanner;
class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 탈옥 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};


    public static int[][] bfs(String[] map, int x, int y) {
        int n = map.length;
        int m = map[0].length();
        int[][] d = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                d[i][j] = -1;
            }
        }
        ArrayDeque<Pair> deque = new ArrayDeque<Pair>(); //빈칸이면 앞에 넣어주고 문이면 뒤에 넣어준다.
        deque.add(new Pair(x, y));
        d[x][y] = 0;
        while (!deque.isEmpty()) {
            Pair p = deque.poll();
            x = p.x;
            y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                //범위안에 있는지
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //이미 방문했는지
                if (d[nx][ny] != -1) continue;
                char c = map[nx].charAt(ny);
                //벽
                if (c == '*')
                	continue;
                //문
                if (c == '#') {
                    d[nx][ny] = d[x][y] + 1;
                    deque.addLast(new Pair(nx, ny));
                }
                //빈칸
                else {
                    d[nx][ny] = d[x][y];
                    deque.addFirst(new Pair(nx, ny));
                }
            }
        }
        return d;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[] a = new String[n+2];
            //가장자리를 빈칸으로 만들어주는 작업//
            for (int i=1; i<=n; i++) {
                a[i] = sc.nextLine();
                a[i] = "." + a[i] + ".";
            }
            n += 2;
            m += 2;
            a[0] = a[n-1] = "";
            for (int j=0; j<m; j++) {
                a[0] += ".";
                a[n-1] += ".";
            }
            //가장자리를 빈칸으로 만들어주는 작업//
            int[][] d0 = bfs(a, 0, 0); // 0,0에서 bfs실행
            int x1, y1, x2, y2;
            x1 = y1 = x2 = y2 = -1;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i].charAt(j) == '$') {
                        if (x1 == -1) {
                            x1 = i;
                            y1 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }
            int[][] d1 = bfs(a, x1, y1); //죄수1에서 bfs실행
            int[][] d2 = bfs(a, x2, y2); //죄수2에서 bfs실행
            int ans = n*m;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    char c = a[i].charAt(j);
                    //벽이면 셋이 만날 수 없음.
                    if (c == '*')
                    	continue;
                    //셋 중 한명이라도 방문한 곳이 아니라면 셋이 만날 수 없음.
                    if (d0[i][j] == -1 || d1[i][j] == -1 || d2[i][j] == -1)
                    	continue;
                    //빈칸이면 더 해준다.
                    int cur = d0[i][j] + d1[i][j] + d2[i][j];
                    //모이는 위치가 문이면 2를 빼준다. 한명만 열면 되니까.
                    if (c == '#')
                    	cur -= 2;
                    if (ans > cur)
                    	ans = cur;
                }
            }
            System.out.println(ans);

        }
    }
}