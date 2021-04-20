package day0331;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {
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
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static boolean inside(int y, int x) {
		return ( y>=0 && y<R ) && ( x>=0 && x<C );
	}

	static Pos end;
	static Pos start;
	static Queue<Pos> q = new LinkedList<>();
	static Queue<Pos> q2 = new LinkedList<>();
	static int R;
	static int C;
	static int ans = -987654321;
	static String[][] map;
	static String[][] map2;
	static boolean[][] visit;


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		map = new String[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; ++i) {
			String tmp = scan.next();
			for(int j =0; j<tmp.length(); ++j) {
				map[i][j] = tmp.charAt(j) +"";
				if(map[i][j].equals("D")) {
					end = new Pos(i,j,-1);
				}
				if(map[i][j].equals("S")) {
					start = new Pos(i,j,0);
					q2.add(start);
				}
				if(map[i][j].equals("*")) {
					q.add(new Pos(i,j,0));
				}
			}
		}

		bfs();
		System.out.println(ans == -987654321 ? "KAKTUS" : ans);

	}

	static void bfs() {
		while(!q2.isEmpty()) {
			//1초마다 물번지는로직.
			int size = q.size();
			for(int i =0; i<size;++i) {
				Pos cur = q.poll();
				for(int d =0; d<4; ++d) {
					int ny = cur.y + dir[d][0];
					int nx = cur.x + dir[d][1];
					if(inside(ny,nx) && map[ny][nx].equals(".")) {
						map[ny][nx] = "*";
						q.add(new Pos(ny,nx,cur.d+1));
					}
				}
			}

			//1초마다 갈수있는곳으로 이동.
			int size2 = q2.size();
			for(int i =0; i<size2;++i) {
				Pos start = q2.poll();
				for(int d=0; d<4; ++d) {
					int ny = start.y + dir[d][0];
					int nx = start.x + dir[d][1];

					if(ny == end.y && nx ==end.x) {
						ans = start.d+1;
						return;
					}

					if (inside(ny,nx) && (map[ny][nx].equals("*") || map[ny][nx].equals("X")))
						continue;

					if(inside(ny,nx) && !visit[ny][nx]) {
						visit[ny][nx] = true;
						q2.add(new Pos(ny,nx,start.d+1));
					}
				}
			}
		}
	}
}