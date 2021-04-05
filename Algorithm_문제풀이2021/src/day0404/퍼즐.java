package day0404;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼즐 {
	static class Pos {
		int[][] map;
		int y;
		int x;
		int t;
		Pos(int[][] src, int t) {
			map = new int[3][3];
			for(int i =0; i<3; ++i) {
				for(int j =0; j<3; ++j) {
					map[i][j] = src[i][j];
					if(map[i][j] == 0) {
						this.y=i;
						this.x=j;
					}
				}
			}
			this.t = t;
		}

		Pos(int y, int x, int t){
			this.y=y;
			this.x=x;
			this.t=t;
		}

		@Override
		public boolean equals(Object obj) {
			Pos comp = (Pos)obj;
			boolean flag = true;
			for(int i=0; i<3; ++i) {
				for(int j=0; j<3; ++j) {
					if(this.map[i][j] != comp.map[i][j]) {
						flag = false;
					}
				}
			}
			return flag;
		}

	}
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static int[][] goal = {
			{1,2,3},
			{4,5,6},
			{7,8,0}
	};
	static boolean inside(int y, int x) {
		return y>=0 && y<3 && x>=0 && x<3;
	}
	static ArrayList<Pos> visitList = new ArrayList<>();
	static int[][] start = new int[3][3];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i =0; i<3; ++i) {
			for(int j =0; j<3; ++j) {
				start[i][j] = scan.nextInt();
			}
		}
		bfs();
		System.out.println(ans == -987654321 ? "-1" : ans);

	}
	static int ans = -987654321;

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(start,0));
		visitList.add(new Pos(start,0));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			boolean flag = true;
			for(int i=0; i<3; ++i) {
				for(int j=0; j<3; ++j) {
					if(cur.map[i][j] != goal[i][j]) {
						flag = false;
					}
				}
			}

			if(flag) {
				ans = cur.t;
				break;
			}

			for(int d=0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];
				Pos nextPos = new Pos(0,0,0);
				if(inside(ny,nx)) {
					int[][] map = new int[3][3];
					for(int i =0; i<3; ++i) {
						for(int j =0; j<3; ++j) {
							map[i][j] = cur.map[i][j];
						}
					}
					int tmp = cur.map[ny][nx];
					map[ny][nx] = 0;
					map[cur.y][cur.x] = tmp;
					nextPos = new Pos(map, cur.t+1);
				}

				if(inside(ny,nx) && !visitList.contains(nextPos)) {
					q.add(nextPos);
					visitList.add(nextPos);
				}
			}
		}
	}
}
