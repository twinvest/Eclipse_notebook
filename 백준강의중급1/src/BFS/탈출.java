package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {

	static class Pos {
		int y;
		int x;
		int t;
		Pos(int y , int x, int time){
			this.y =y;
			this.x= x;
			this.t = time;
		}
	}
	static int R,C, ans=987654321;
	static char[][] map;
	static boolean[][] visit;

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static boolean inside(int y, int x) {
		return (y>=0 && y<R) && (x>=0 && x<C);
	}
	static Pos[] startend = new Pos[2];
	static ArrayList<Pos> waterList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R=scan.nextInt();
		C=scan.nextInt();
		map = new char[R][C];
		visit = new boolean[R][C];

		for(int i =0; i<R; ++i) {
			String str = scan.next();
			for(int j =0; j<C; ++j) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					startend[0] = new Pos(i,j,0);
				}
				if(map[i][j] == 'D') {
					startend[1] = new Pos(i,j,-1);
				}
				//if(map[i][j] == '*') waterQ.add(new Pos(i,j,-1));
			}
		}
		bfs();
		System.out.println(ans == 987654321 ? "KAKTUS" : ans);

	}
	static Queue<Pos> q = new LinkedList<>();
	static Queue<Pos> waterQ = new LinkedList<>();
	static void bfs() {
		q.add(startend[0]);
		visit[startend[0].y][startend[0].x] = true;;

		while(!q.isEmpty()) {
			waterBfs();
//			int waterQsize = waterQ.size();
//			for(int i =0; i<waterQsize;++i) {
//				Pos cur = waterQ.poll();
//				for(int d =0; d<4; ++d) {
//					int ny = cur.y + dir[d][0];
//					int nx = cur.x + dir[d][1];
//					if(inside(ny,nx) && map[ny][nx] == '.') {
//						map[ny][nx] = '*';
//						waterQ.add(new Pos(ny,nx,-1));
//					}
//				}
//			}


			int size = q.size();
			for(int k=0; k<size; ++k) {
				Pos cur = q.poll();
				if(cur.y == startend[1].y && cur.x == startend[1].x) {
					ans = cur.t;
					return;
				}

				for(int d=0; d<4; ++d) {
					int ny = cur.y + dir[d][0];
					int nx = cur.x + dir[d][1];

					if(!inside(ny,nx)) continue;
					if(map[ny][nx] == 'X' || map[ny][nx] == '*') continue;
					if(visit[ny][nx]) continue;

					q.add(new Pos(ny,nx,cur.t+1));
					visit[ny][nx] = true;
				}
			}

		}

	}

	static void mapPrint() {
		System.out.println();
		for(int i =0; i <R; ++i) {
			for(int j =0; j <C; ++j) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void waterBfs() {
		for(int i =0; i<R; ++i) {
			for(int j =0; j<C; ++j) {
				if(map[i][j] == '*') {
					waterList.add(new Pos(i,j,-1));
				}
			}
		}

		for(int i=0; i<waterList.size(); ++i) {
			Pos cur = waterList.get(i);
			for(int d=0; d<4; ++d) {
				int ny = cur.y +dir[d][0];
				int nx = cur.x +dir[d][1];

				if(!inside(ny,nx)) continue;
				if(map[ny][nx] == '*') continue;
				if(map[ny][nx] == 'D' || map[ny][nx] == 'X') continue;
				if(map[ny][nx] == '.') map[ny][nx] = '*';

			}

		}
	}
}
