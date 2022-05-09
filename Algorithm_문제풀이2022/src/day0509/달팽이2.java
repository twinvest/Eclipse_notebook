package day0509;

import java.util.Scanner;

public class 달팽이2 {
	static int[][] dir = {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0}
	};
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<M);
	}

	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		int cnt = N*M;
		int y =0, x=0, d=0;
		--cnt;
		visit[y][x] = true;
		while(cnt != 0 ) {

			for(int i =1; ;++i) {
				int ny = y + dir[d%4][0] * i;
				int nx = x + dir[d%4][1] * i;
				if(inside(ny,nx) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					--cnt;
				} else {
					y = ny - dir[d%4][0];
					x = nx - dir[d%4][1];
					++d;
					break;
				}
			}

		}
		System.out.println(d-1);



	}

}
