package day0401;

import java.util.Scanner;

public class 로봇청소기 {
	static class Pos{
		int y;
		int x;
		int d;
		Pos(int y, int x, int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	static int[][] dir = {
			{-1,0} //북
			,{0,1} //동
			,{1,0} //남
			,{0,-1} //서
	};
	static boolean inside(int y, int x) {
		return ( y>=0 && y<N ) && ( x>=0 && x<M );
	}
	static Pos cur;
	static int r;
	static int c;
	static int N;
	static int M;
	static int curDirection;
	static int clear;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		r = scan.nextInt();
		c = scan.nextInt();
		curDirection = scan.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i =0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				map[i][j] = scan.nextInt();
			}
		}
		search();
		System.out.println(clear);
	}
	static boolean flag;
	static void search() {
		flag = true;
		while(flag) {
			//1번구현
			if(inside(r,c) && !visit[r][c] && map[r][c] == 0) {
				++clear;
				visit[r][c] = true;
			}

			int count = 0;
			//int tmpDirection = curDirection;
			for(int i =0; i<4; ++i) {
				curDirection -= 1;
				if(curDirection == -1) {
					curDirection = 3;
				}
				int ny = r + dir[curDirection][0];
				int nx = c + dir[curDirection][1];
				//2.a 구현
				if(inside(ny,nx) && map[ny][nx] == 0 && !visit[ny][nx]) {
					r = ny;
					c = nx;
					break;
				}

				++count;
				if(count == 4) {
					int by = r - dir[curDirection][0];
					int bx = c - dir[curDirection][1];
					if(inside(by,bx) && map[by][bx] == 1) {
						flag = false;
						break;
					}
					r = by;
					c = bx;
					i = -1;
					count = 0;
				}
			}
		}
	}

}
