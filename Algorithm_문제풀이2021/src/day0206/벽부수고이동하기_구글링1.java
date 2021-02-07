package day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_구글링1 {

    static int N, M, res = -1, map[][];
    static boolean visited[][][];
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

    static class pos {
        // x좌표, y좌표, 지금까지 거리, 벽을 부순 횟수
        int x, y, d, k;

        public pos(int x, int y, int d, int k) {
            this.x = x;
            this.y = y;
            this.d = d; //이동한거리.
            this.k = k; //벽을 부신횟수.
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<pos> q = new LinkedList<>();
        // 시작 칸과 끝나는 칸도 거리에 포함
        q.add(new pos(0, 0, 1, 0));

        while (!q.isEmpty()) {
            pos now = q.poll();
            // 목적지에 도착
            if(now.x == N-1 && now.y == M-1) {
                res = now.d;
                break;
            }
            // 상하좌우로 탐색
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];

                // 범위를 벗어날 경우
                if(xx < 0 || yy < 0 || xx >= N || yy >= M) continue;
                // 이동할 수 있는 곳으로 이동할 경우
                if(map[xx][yy] == 0) {
                    // 방문체크
                    if(visited[xx][yy][now.k])
                    	continue;
                    q.add(new pos(xx,yy,now.d+1,now.k));
                    visited[xx][yy][now.k] = true;
                }
                // 벽을 부수고 이동해야할 경우
                else {
                    // 벽을 부술 수 없거나, 이미 왔던 길일 경우 pass
                    if(now.k != 0 || visited[xx][yy][now.k+1])
                    	continue;
                    // 벽을 부술 수 있다면 부수고 이동
                    q.add(new pos(xx,yy,now.d+1,now.k+1));
                    visited[xx][yy][now.k+1] = true;
                }
            }
        }
        System.out.println(res);
    }
}