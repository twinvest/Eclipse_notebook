package day0207;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static class Pos{
		int y;
		int x;
		int d;
		Pos(int y, int x, int d){
			this.y =y;
			this.x = x;
			this.d =d;
		}

	}
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<M);
	}
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		for(int i =0;i <N; ++i) {
			String str = scan.next();
			for(int j =0;j <str.length(); ++j) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}

		Queue<Pos> q = new LinkedList<Pos>();
		visit[0][0] = true;
		q.add(new Pos(0,0,1));
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.y == N-1 && now.x == M-1) {
				System.out.println(now.d);
				break;
			}

			for(int d = 0; d<4; ++d) {
				int ny = now.y + dir[d][0];
				int nx = now.x + dir[d][1];
				if(inside(ny,nx) && map[ny][nx] == 1 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new Pos(ny, nx, now.d+1));
				}
			}
		}
	}
}
