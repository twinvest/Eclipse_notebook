package day0211;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 통나무옮기기 {
	static int N;
	static String[][] map;
	static boolean inside(int y,int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}
	static class Pos {
		public int y1, x1, y2, x2, y3, x3;
		int move;
		boolean rotate;
		Pos(int y1, int x1, int y2, int x2, int y3, int x3, int move){
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
			this.y3 = y3;
			this.x3 = x3;
			this.move = move;
		}
		Pos(int y1, int x1, int y2, int x2, int y3, int x3, int move,boolean rotate){
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
			this.y3 = y3;
			this.x3 = x3;
			this.move = move;
			this.rotate = rotate;
		}
		@Override
		public boolean equals(Object obj) {
			Pos comp = (Pos)obj;
			if(comp.x1 == this.x1 && comp.x2 == this.x2 && comp.x3 == this.x3 && comp.y1 == this.y1 && comp.y2 == this.y2 && comp.y3 == this.y3) {
				return true;
			}
			return false;
		}

	}
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static int[][] dir2 = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
			,{-1,-1}
			,{-1,1}
			,{1,-1}
			,{1,1}
	};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new String[N][N];

		int sIndex = 0;
		int eIndex = 0;
		int[] start = new int[6];
		int[] end = new int[6];
		for(int i =0; i<N; ++i) {
			String str = scan.next();
			for(int j = 0; j <str.length(); ++j) {
				map[i][j] = str.charAt(j)+"";
				if(map[i][j].equals("B")) {
					start[sIndex] = i;
					start[sIndex+1] = j;
					sIndex += 2;
				}
				if(map[i][j].equals("E")) {
					end[eIndex] = i;
					end[eIndex+1] = j;
					eIndex += 2;
				}
			}
		}
		Pos startPos  = new Pos(start[0],start[1],start[2],start[3],start[4],start[5],0);
		Pos endPos = new Pos(end[0],end[1],end[2],end[3],end[4],end[5],0);

		bfs(startPos, endPos);
		System.out.println(ans);
	}
	static int ans = 0;
	static public void bfs(Pos start, Pos end) {
		Queue<Pos> q = new LinkedList<Pos>();
		ArrayList<Pos> visit = new ArrayList<Pos>();
		q.add(start);
		visit.add(start);

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			//initMap(cur);
			if(cur.y1 == end.y1 && cur.y2 == end.y2 && cur.y3 == end.y3 && cur.x1 == end.x1 && cur.x2 == end.x2 && cur.x3 == end.x3) {
				ans = cur.move;
				return;
			}
			for(int d = 0; d<5; ++d) {
				if(d == 4) {
					Pos nextPos = isRotate(cur,visit);
					if(nextPos.rotate) {
						nextPos.rotate = false;
						visit.add(nextPos);
						q.add(nextPos);
					}
				} else {
					int ny1 = cur.y1 + dir[d][0];
					int nx1 = cur.x1 + dir[d][1];
					int ny2 = cur.y2 + dir[d][0];
					int nx2 = cur.x2 + dir[d][1];
					int ny3 = cur.y3 + dir[d][0];
					int nx3 = cur.x3 + dir[d][1];
					if(inside(ny1, nx1) && inside(ny2, nx2) && inside(ny3, nx3) && !map[ny1][nx1].equals("1") && !map[ny2][nx2].equals("1") && !map[ny3][nx3].equals("1")) {
						if(!visit.contains(new Pos(ny1,nx1,ny2,nx2,ny3,nx3,cur.move))) {
							visit.add(new Pos(ny1,nx1,ny2,nx2,ny3,nx3,cur.move+1));
							q.add(new Pos(ny1,nx1,ny2,nx2,ny3,nx3,cur.move+1));
						}
					}
				}
			}
		}
	}
	/*
	static void initMap(Pos cur) {
		int count = 0;
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(map[i][j].equals("B")){
					++count;
					map[i][j] = "0";
				}
				if(count == 3) break;
			}
		}
		map[cur.y1][cur.x1] = "B";
		map[cur.y2][cur.x2] = "B";
		map[cur.y3][cur.x3] = "B";
	}
	*/
	static Pos isRotate(Pos pos, ArrayList<Pos> visit) {
		//가로로 있는 상태
		if(pos.y1 == pos.y2 && pos.y2 == pos.y3) {
			int ny2 = pos.y2;
			int nx2 = pos.x2;
			int ny1 = ny2-1;
			int nx1 = nx2;
			int ny3 = ny2+1;
			int nx3 = nx2;
			if(inside(ny2, nx2) && inside(ny1, nx1) && inside(ny3, nx3)) {
				for(int d=0; d<8; ++d){
					int ny = ny2 + dir2[d][0];
					int nx = nx2 + dir2[d][1];
					if(map[ny][nx].equals("1") || !inside(ny, nx) ) {
						return new Pos(0,0,0,0,0,0,0, false);
					}
				}
				if(!visit.contains(new Pos(ny1,nx1, ny2,nx2, ny3, nx3, 0))) {
					return new Pos(ny1,nx1, ny2,nx2, ny3, nx3, pos.move+1, true);
				}
			}
		}
		//세로로 있는 상태
		else {
			if(pos.x1 == pos.x2 && pos.x2 == pos.x3) {
				int ny2 = pos.y2;
				int nx2 = pos.x2;
				int ny1 = ny2;
				int nx1 = nx2-1;
				int ny3 = ny2;
				int nx3 = nx2+1;
				if(inside(ny2, nx2) && inside(ny1, nx1) && inside(ny3, nx3)) {
					for(int d=0; d<8; ++d){
						int ny = ny2 + dir2[d][0];
						int nx = nx2 + dir2[d][1];
						if(map[ny][nx].equals("1") || !inside(ny, nx) ) {
							return new Pos(0,0,0,0,0,0,0, false);
						}
					}
					if(!visit.contains(new Pos(ny1,nx1, ny2,nx2, ny3, nx3, 0))) {
						return new Pos(ny1,nx1, ny2,nx2, ny3, nx3, pos.move+1, true);
					}
				}
			}
		}
		return new Pos(0,0,0,0,0,0,0, false);
	}

}