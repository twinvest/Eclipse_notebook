package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x,y,dist,boom,day;
	Node(int x, int y, int dist, int boom, int day){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.boom = boom;
		this.day = day;
	}
}

public class 벽부수고이동하기3_구글링 {

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int map[][];
	static boolean visit[][][][];
	static int n,m,k,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][k+1][2];

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		ans = -1;
		bfs();

		System.out.println(ans);

	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1,0,0)); //x, y, dist, boom, day
		visit[0][0][0][0] = true;

		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;

			if(x == n-1 && y == m-1) {
				ans = now.dist;
				return;
			}

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;

				if(map[nx][ny] == 0) {
					if(now.day == 0 && !visit[nx][ny][now.boom][now.day+1]) {
						q.add(new Node(nx,ny,now.dist+1,now.boom,now.day+1));
						visit[nx][ny][now.boom][now.day+1] = true;
					}
					else if(now.day == 1 && !visit[nx][ny][now.boom][now.day-1]){
						q.add(new Node(nx,ny,now.dist+1,now.boom,now.day-1));
						visit[nx][ny][now.boom][now.day-1] = true;
					}
				}else { //낮은 0 밤은 1
					if(now.boom < k && now.day == 0 && !visit[nx][ny][now.boom+1][now.day+1]) {
						visit[nx][ny][now.boom+1][now.day+1] = true;
						q.add(new Node(nx,ny,now.dist+1,now.boom+1,now.day+1));
					}else if(now.boom < k && now.day == 1 && !visit[x][y][now.boom][now.day-1]) {
						visit[x][y][now.boom][now.day-1] = true;
						q.add(new Node(x,y,now.dist+1,now.boom,now.day-1));
					}
				}

			}

		}

	}
}