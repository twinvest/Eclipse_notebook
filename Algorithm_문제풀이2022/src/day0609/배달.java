package day0609;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 배달 {
	static int N,M;
	static int startY = -1;
	static int startX = -1;
	static int endY1 = -1;
	static int endX1 = -1;
	static int endY2 = -1;
	static int endX2 = -1;
	static int ans = 0;
	static String[][] map;
	static boolean[][][] visit;
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<M);
	}
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static class Pos {
		int y;
		int x;
		int prevdir;
		int time;
		boolean flag1, flag2;
		Pos(int y, int x, int dir, int time, boolean flag1, boolean flag2) {
			this.y = y;
			this.x = x;
			this.prevdir = dir;
			this.time = time;
			this.flag1 = flag1;
			this.flag2 = flag2;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new String[N][M];
		visit = new boolean[N][M][4];

		int cnt = 0;
		for(int i =0; i<N; ++i) {
			String s = scan.next();
			for(int j =0; j<s.length(); ++j) {
				char c = s.charAt(j);
				map[i][j] = c + "";

				if ( map[i][j].equals("S") ) {
					startY = i;
					startX = j;
				}

				if ( map[i][j].equals("C") ) {
					if(cnt == 0) {
						endY1 = i;
						endX1 = j;
					}
					if(cnt == 1) {
						endY2 =i;
						endX2 =j;
					}
					++cnt;
				}
			}
		}


		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(startY, startX, -1, 0,false,false));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int y = cur.y;
			int x = cur.x;
			if( (y == endY1 && x == endX1) || (y == endY2 && x == endX2) ) {

				if((y == endY1 && x == endX1) && !cur.flag1) {
					//Pos newStart = new Pos(y,x,cur.prevdir,cur.time,true,cur.flag2);
					visit = new boolean[N][M][4];
					visit[y][x][cur.prevdir] = true;
					q.clear();
					cur.flag1 = true;
					//q.add(newStart);

				}
				if((y == endY2 && x == endX2) && !cur.flag2) {
					//Pos newStart = new Pos(y,x,cur.prevdir,cur.time,cur.flag1,true);
					visit = new boolean[N][M][4];
					visit[y][x][cur.prevdir] = true;
					q.clear();
					cur.flag2 = true;
					//q.add(newStart);
				}

				if(cur.flag1 && cur.flag2) {
					return cur.time;
				}

			}
			for(int d=0; d<4; ++d) {
				if(cur.prevdir == d)
					continue;
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx][d] && !map[ny][nx].equals("#")) {
					visit[ny][nx][d] = true;
					q.add(new Pos(ny,nx,d,cur.time+1,cur.flag1, cur.flag2));
				}
			}
		}
		return -1;
	}
}
