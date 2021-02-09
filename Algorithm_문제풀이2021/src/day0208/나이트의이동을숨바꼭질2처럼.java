package day0208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동을숨바꼭질2처럼 {
	static int[][] map;
	static boolean[][] visit;
	static int size;
	static int endY;
	static int endX;
	static int ans;
	static int cnt;
	static class Pos{
		int y;
		int x;
		int d;
		Pos(int y, int x, int d){
			this.y =y;
			this.x= x;
			this.d = d;
		}
	}
	static boolean inside(int y,int x) {
		return (y>=0 && y<size) && (x>=0 && x<size);
	}
	static int[][] dir = {
			 {-2,1}
			,{-2,-1}
			,{-1,-2}
			,{-1,2}
			,{1,-2}
			,{2,-1}
			,{2,1}
			,{1,2}
	};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();
		for(int t=0; t<testCase; ++t) {

			size = scan.nextInt();
			map = new int[size][size];
			visit = new boolean[size][size];
			ans = 0;
			cnt = 0;
			int startY = scan.nextInt();
			int startX = scan.nextInt();
			endY = scan.nextInt();
			endX = scan.nextInt();
			bfs(startY, startX);
			System.out.println(ans);
			System.out.println(cnt);
		}
	}

	static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y, x, 0));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			if(ans != 0 && pos.d > ans) {
				return;
			}

			if(pos.y == endY && pos.x == endX && ans!=0 && ans == pos.d) {
				++cnt;
			}

			if(pos.y == endY && pos.x == endX && ans == 0) {
				ans = pos.d;
				++cnt;
				//return;
			}
			for(int d= 0;d<8; ++d) {
				int ny = pos.y+dir[d][0];
				int nx = pos.x+dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new Pos(ny,nx,pos.d+1));
				}
			}
		}
	}
}