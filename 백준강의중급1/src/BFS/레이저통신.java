package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 레이저통신 {
	static char[][] map;
	static boolean[][] visit;
	static int W,H, ans;
	static class Pos{
		int y;
		int x;
		int preD;
		int cnt;
		Pos(int y, int x, int preD, int cnt){
			this.y=y;
			this.x=x;
			this.preD = preD;
			this.cnt = cnt;;

		}
	}
	static boolean inside(int y, int x) {
		return (y>=0 && y<H) && (x>=0 && x<W);
	}
	static int[][] dir = {
			{1,0},
			{0,-1},
			{-1,0},
			{0,1},
	};
	static ArrayList<Pos> startend = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		W = scan.nextInt();
		H = scan.nextInt();
		map = new char[H][W];
		visit = new boolean[H][W];

		for(int i = 0; i<H; ++i) {
			String str = scan.next();
			for(int j =0; j<W; ++j) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'C') {
					startend.add(new Pos(i,j,-1,-1));
				}
			}
		}

		bfs();
		//System.out.println();

	}
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(startend.get(0).y, startend.get(0).x, -1, 0));
		visit[startend.get(0).y][startend.get(0).x] = true;


		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.y == startend.get(1).y && cur.x == startend.get(1).x) {
				System.out.println(cur.cnt);
				break;
			}


			for(int d =0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];
				int preD = cur.preD;

				if(!inside(ny,nx)) continue;
				if(visit[ny][nx]) continue;
				if(map[ny][nx] == '*') continue;

				visit[ny][nx] = true;
				if(preD == -1) {
					q.add(new Pos(ny,nx,d,cur.cnt));
				}
				if(preD == 0) {
					if(d==1 || d==3) {
						q.add(new Pos(ny,nx,d,cur.cnt+1));
					} else {
						q.add(new Pos(ny,nx,d,cur.cnt));
					}
				}else if(preD == 1){
					if(d==0 || d==2) {
						q.add(new Pos(ny,nx,d,cur.cnt+1));
					} else {
						q.add(new Pos(ny,nx,d,cur.cnt));
					}
				}else if(preD == 2){
					if(d==1 || d==3) {
						q.add(new Pos(ny,nx,d,cur.cnt+1));
					} else {
						q.add(new Pos(ny,nx,d,cur.cnt));
					}
				}else if(preD == 3){
					if(d==0 || d==2) {
						q.add(new Pos(ny,nx,d,cur.cnt+1));
					} else {
						q.add(new Pos(ny,nx,d,cur.cnt));
					}
				}

			}

		}
	}

}
