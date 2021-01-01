package day0101;

import java.util.Scanner;

public class 음료수얼려먹기 {
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
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		for(int i = 0; i<N; ++i) {
			String str = scan.next();
			for(int j = 0; j < str.length(); ++j) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		int ans = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j<M; ++j) {
				if(!visit[i][j] && map[i][j] == 0) {
					visit[i][j] = true;
					dfs(i,j,map,visit);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	static void dfs(int y, int x, int[][] map ,boolean[][] visit) {

		if(!inside(y,x) || map[y][x] == 1) {
			return;
		}


		for(int d = 0; d<4; ++d) {
			int ny = y + dir[d][1];
			int nx = x + dir[d][0];
			if(inside(ny, nx) && !visit[ny][nx] && map[ny][nx] == 0) {
				visit[ny][nx] = true;
				dfs(ny,nx,map,visit);
			}
		}

	}
}
