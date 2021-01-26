package day0124;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {
	static public class Pos {
		int y;
		int x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static boolean inside(int y, int x) {
		return ( y >= 0 && y < N ) && ( x >= 0 && x < M );
	}
	static int ans;
	static int[][] map;
	static boolean[][] visit;
	static int M;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for(int i = 0; i < testCase; ++i) {
			ans = 0;
			M = scan.nextInt();
			N = scan.nextInt();
			map = new int[N][M];
			visit = new boolean[N][M];
			int numOfVegetable = scan.nextInt();
			for(int j =0; j<numOfVegetable; ++j) {
				int X = scan.nextInt();
				int Y = scan.nextInt();
				map[Y][X] = 1;
			}

			for(int y = 0; y<N;++y) {
				for(int x = 0; x<M; ++x) {
					if(visit[y][x] == false && map[y][x] == 1) {
						bfs(y,x);
						++ans;
					}
				}
			}
			System.out.println(ans);
		}
	}

	static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(y,x));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int d =0; d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				if(inside(ny, nx) && !visit[ny][nx] && map[ny][nx] == 1) {
					visit[ny][nx] = true;
					q.add(new Pos(ny, nx));
				}
			}
		}
	}
}