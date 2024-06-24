package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pos{
	int y;
	int x;
	int cnt;
	Pos(int y, int x, int cnt){
		this.y=y;
		this.x=x;
		this.cnt = cnt;
	}
}
public class 데스나이트 {
	static int[][] dir = {
			{-2,-1},
			{-2,1},
			{0,-2},
			{0,2},
			{2,-1},
			{2,1},
	};
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}
	static int[][] map;
	static boolean[][] visit;
	static int N, r1, c1, r2, c2, ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N =scan.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		r1 = scan.nextInt();
		c1 = scan.nextInt();
		r2 = scan.nextInt();
		c2 = scan.nextInt();
		bfs(r1,c1);
	}

	static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x,0));
		visit[y][x] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.y == r2 && cur.x == c2) {
				ans = cur.cnt;
				break;
			}

			for(int d=0; d<6; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				//범위를 벗어났거나 방문을 했던 곳이라면
				if(!inside(ny,nx) || visit[ny][nx])
					continue;

				q.add(new Pos(ny,nx,cur.cnt+1));
				visit[ny][nx] = true;
			}
		}
		System.out.println(ans == 0 ? -1 : ans);
	}

}
