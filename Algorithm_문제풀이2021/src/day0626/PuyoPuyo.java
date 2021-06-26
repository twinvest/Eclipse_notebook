package day0626;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PuyoPuyo {
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static boolean inside(int y, int x) {
		return (y>=0 && y<12) && (x>=0 && x<6);
	}
	static class Pos{
		int y; int x; char color;
		Pos(int y, int x, char color){
			this.y = y;
			this.x = x;
			this.color = color;
		}
	}

	static char[][] Map = new char[12][6];
	static boolean[][] visit = new boolean[12][6];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i =0; i<Map.length; ++i) {
			String str = scan.next();
			for(int j =0; j<str.length(); ++j) {
				Map[i][j] = str.charAt(j);
			}
		}

		int ans = 0;
		while(true) {
			boolean flag = true;

			label : for(int i =0; i<12; ++i) {
				for(int j =0; j<6; ++j) {
					//빈칸이 아니고 방문하지 않았다면
					if(Map[i][j] != '.' && !visit[i][j]) {
						if(bfs(i,j)) {
							i = -1;
							flag = false;
							continue label;

						}
					}
				}
			}

			if(flag)
				break;
			else {
				++ans;
				//pirntMap();
				visit = new boolean[12][6];
				gravity();
				//pirntMap();
			}
		}
		System.out.println(ans);
	}
	static boolean bfs(int y, int x) {

		Queue<Pos> q = new LinkedList<>();
		ArrayList<Pos> bombList = new ArrayList<>();
		q.add(new Pos(y,x,Map[y][x]));
		bombList.add(new Pos(y,x,Map[y][x]));
		visit[y][x] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int d=0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				if(inside(ny,nx) && !visit[ny][nx] && Map[ny][nx] == Map[y][x]) {
					visit[ny][nx] = true;
					q.add(new Pos(ny,nx,Map[ny][nx]));
					bombList.add(new Pos(ny,nx,Map[ny][nx]));
				}

			}
		}

		if(bombList.size()>=4) {
			//visit = new boolean[12][6];
			for(int i =0; i<bombList.size(); ++i) {
				Pos pos = bombList.get(i);
				Map[pos.y][pos.x] = '.';
			}

			return true;
		}else {
			return false;
		}
	}

	static void gravity() {
		for(int j =0; j<6; ++j) {
			Queue<Character>  q = new LinkedList<>();
			for(int i = 11; i>=0; --i) {
				if(Map[i][j] != '.') {
					q.add(Map[i][j]);
				}
				Map[i][j] = '.';
			}

			int i = 11;
			while(!q.isEmpty()) {
				Map[i--][j] = q.poll();
			}
		}
	}
	static void pirntMap() {
		System.out.println();
		for(int i =0; i<12; ++i) {
			for(int j =0; j<6; ++j) {
				System.out.print(Map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
