package day0127;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약 {
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static class Pos{
		int y;
		int x;
		char color;
		Pos(int y,int x, char color){
			this.y = y;
			this.x = x;
			this.color = color;
		}
	}

	static char[][] map;
	static boolean[][] visit1;
	static boolean[][] visit2;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new char[N][N];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];
		for(int i =0; i<N; ++i) {
			String str = scan.next();
			for(int j =0; j<str.length(); ++j) {
				map[i][j] = str.charAt(j);
			}
		}
		int ans1 = 0;
		int ans2 = 0;
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(!visit1[i][j]) {
					bfs1(i,j);
					++ans1;
				}
			}
		}
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(!visit2[i][j]) {
					bfs2(i,j);
					++ans2;
				}
			}
		}

		System.out.println(ans1+" "+ans2);
	}

	static void bfs1(int y, int x) {
		visit1[y][x] = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x,map[y][x]));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int d =0;d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				if(inside(ny,nx) && !visit1[ny][nx] && pos.color == map[ny][nx]) {
					visit1[ny][nx] = true;
					q.add(new Pos(ny, nx, map[ny][nx]));
				}
			}
		}
	}

	static void bfs2(int y, int x) {
		visit2[y][x] = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x,map[y][x]));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int d =0;d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				if(inside(ny,nx) && !visit2[ny][nx] && pos.color == map[ny][nx]) {
					visit2[ny][nx] = true;
					q.add(new Pos(ny, nx, map[ny][nx]));
				} else if(inside(ny,nx) && !visit2[ny][nx] && pos.color == 'R' && map[ny][nx] == 'G') {
					visit2[ny][nx] = true;
					q.add(new Pos(ny, nx, map[ny][nx]));
				} else if(inside(ny,nx) && !visit2[ny][nx] && pos.color == 'G' && map[ny][nx] == 'R') {
					visit2[ny][nx] = true;
					q.add(new Pos(ny, nx, map[ny][nx]));
				}
			}
		}
	}

}
