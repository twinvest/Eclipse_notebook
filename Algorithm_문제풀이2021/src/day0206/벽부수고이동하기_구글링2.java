package day0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기_구글링2 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        bfs(1, 1);
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0, 1));

        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N && p.y == M) {
                System.out.println(p.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int breakWall = p.breakWall;
                int count = p.count;

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;

                if(map[nx][ny] == 1) { //벽
                    if (breakWall == 0 && !visited[nx][ny][1]) { //벽을 부신 적 없음
                        visited[nx][ny][1] = true;
                        q.add(new Point(nx, ny, 1, count + 1));
                    }
                } else { //빈 칸
                    if(!visited[nx][ny][breakWall]) {
                        q.add(new Point(nx, ny, breakWall, count + 1));
                        visited[nx][ny][breakWall] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Point {
        int x; int y;
        int breakWall;
        int count;

        public Point(int x, int y, int breakWall, int count) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
            this.count = count;
        }
    }
}