package day0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 직사각형탈출_구글링2 {
    static int[] dx = {0,0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] graph;
    static int n, m, h, w, sx, sy, ex, ey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < m; j++){
                graph[i][j] = line[j].charAt(0);
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        sx -= 1; sy -= 1; ex -= 1; ey -= 1; // (0, 0)을 시작점으로 맞추기
        int answer = bfs();
        System.out.println(answer);
    }

    public static boolean isNotWall(int x, int y, int dir){
        ArrayList<Point> boundary = new ArrayList<Point>();
        switch (dir){
            case 0:
                for(int i = x; i < x+h; i++)
                    boundary.add(new Point(i, y));
                break;

            case 1:
                for(int i = x; i < x+h; i++){
                    boundary.add(new Point(i, y+w-1));
                }
                break;
            case 2:
                for(int i = y; i < y+w; i++) {
                    boundary.add(new Point(x, i));
                }
                break;
            case 3:
                for(int i = y; i < y+w; i++){
                    boundary.add(new Point(x+h-1, i));
                }
                break;
        }
        for (Point point : boundary) {
            if(graph[point.x][point.y] == '1'){
                return false;
            }
        }
        return true;
    }

    public static boolean isInBoundary(int x, int y){
        return (0 <= x && x + h - 1 < n && 0 <= y && y + w - 1 < m);
    }

    public static int bfs(){
        int[][] visited = new int[n][m];

        // 왼쪽 상단 모서리만을 기준으로 생각한다.
        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(sx, sy));
        visited[sx][sy] = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            if(currX == ex && currY == ey)
            	return visited[currX][currY];

            for(int i = 0; i < 4; i++){

            	int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(isInBoundary(nx, ny)){
                    if(visited[nx][ny] == 0){
                        if(isNotWall(nx,ny, i)){
                            visited[nx][ny] = visited[currX][currY] + 1;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}