package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 레이저통신_구글링 {
    static int w, h;
    static char[][] map;
    static Node[] target = new Node[2];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node implements Comparable<Node> {
        int x, y, dir, mirrors;

        public Node(int x, int y, int dir, int mirrors) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirrors - o.mirrors;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];


        for (int i = 0, idx = 0; i < h; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'C') target[idx++] = new Node(i, j, -5, -1);
            }
        }

        System.out.println(bfs(target[0]));
    }

    private static int bfs(Node start) {
        int min = Integer.MAX_VALUE;
        Node goal = target[1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[][][] visited = new int[4][h][w];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < h; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        q.offer(start);

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == goal.x && now.y == goal.y) {
                min = Math.min(min, now.mirrors);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int nextMirrors = (now.dir == i) ? now.mirrors : now.mirrors + 1;
                if (!isInRange(nextX, nextY) || map[nextX][nextY] == '*' || Math.abs(now.dir - i) == 2) continue;

                if (visited[i][nextX][nextY] > nextMirrors) {
                    q.offer(new Node(nextX, nextY, i, nextMirrors));
                    visited[i][nextX][nextY] = nextMirrors;
                }
            }
        }

        return min;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

}