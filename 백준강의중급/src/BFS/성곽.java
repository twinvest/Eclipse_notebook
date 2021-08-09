package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 성곽 {
	static class Pair {
	    int x;
	    int y;
	    Pair(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}

    static int n;
    static int m;

    static int[][] a = new int[50][50]; //입력받은맵
    static int[][] d = new int[50][50]; //d[i][j] : (i,j)의 방번호
    static int[] room = new int[50*50+1]; //room[i] : 방 i의 크기

    static int[] dx = {0,-1,0,1}; //왼쪽 위 오른쪽 아래
    static int[] dy = {-1,0,1,0}; //왼쪽 위 오른쪽 아래

    static int bfs(int sx, int sy, int rooms) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sx, sy));
        d[sx][sy] = rooms;
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            cnt += 1;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                //범위를 벗어나면 continue
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                	continue;
                //이미 방번호가 정해져있다면 continue
                if (d[nx][ny] != 0)
                	continue;
                //벽이라면 continue
                if ((a[x][y] & (1<<k)) > 0)
                	continue;
                //위 조건들을 모두 통과했다면
                q.add(new Pair(nx, ny));
                d[nx][ny] = rooms;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int rooms = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (d[i][j] == 0) {
                    rooms += 1;
                    room[rooms] = bfs(i, j, rooms);
                }
            }
        }
        System.out.println(rooms); //방의 개수 출력
        int ans = 0;
        for (int i=1; i<=rooms; i++) {
            if (ans < room[i]) {
                ans = room[i];
            }
        }
        System.out.println(ans); //가장 큰 방 출력

        ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int x = i;
                int y = j;
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    //범위를 벗어나면 continue
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    	continue;
                    //인접한 방이 현재 방과 같은 방이면 continue
                    if (d[nx][ny] == d[x][y])
                    	continue;
                    //여기 까지 왔단것은 nx, ny에 있는 곳이 범위 안이면서 다른방이란것.
                    //근데 그 때 바라본 방향이 벽이면
                    if ((a[x][y] & (1<<k)) > 0) {
                    	//벽을 제거했다고 가정하고 둘이 더해본다.
                    	if (ans < room[d[x][y]]+room[d[nx][ny]]) {
                            ans = room[d[x][y]]+room[d[nx][ny]];
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}