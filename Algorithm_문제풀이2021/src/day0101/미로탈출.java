package day0101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {
	static class Pos{
		int y;
		int x;
		int distance;
		Pos(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}


	}
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<M);
	}
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static int N;
	static int M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];

		for(int i = 0; i<N; ++i) {
			String str = scan.next();
			for(int j = 0; j < str.length(); ++j) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}

		bfs(0,0);

	}

	static void bfs(int y, int x) {
		Queue<Pos> queue = new LinkedList<Pos>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(new Pos(y, x, 1));

		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			for(int d = 0 ; d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				int nd = pos.distance + 1;
				if(inside(ny, nx) && map[ny][nx] == 1 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					queue.offer(new Pos(ny,nx,nd));
					if(ny == N-1 && nx == M-1 ) {
						System.out.println(nd);
					}
				}
			}
		}
	}

}
