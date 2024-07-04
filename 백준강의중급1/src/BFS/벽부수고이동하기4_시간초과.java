package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기4_시간초과 {
	static class Pos{
		int y;
		int x;

		Pos(int y, int x){
			this.y=y;
			this.x=x;
		}
	}

	static boolean inside(int y, int x){
		return (y>=0 && y<N) && (x>=0 && x<M);
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
	};

	static int N,M, ans;
	static char[][] map;
	static String[][] ansMap;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		map = new char[N][M];
		ansMap = new String[N][M];
		for(int i=0; i<N; ++i) {
			String str = scan.next();
			for(int j =0; j<M; ++j) {
				map[i][j] = str.charAt(j);
			}
		}

		for(int i=0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				if(map[i][j] == '1') {
					map[i][j] = '0';
					bfs(i,j);
					ansMap[i][j] = ans+"";
					map[i][j] = '1';
				}else if(map[i][j] == '0') {
					ansMap[i][j] = "0";
				}
			}
		}

		for(int i=0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				System.out.print(ansMap[i][j]);
			}
			System.out.println();
		}

	}

	static void bfs(int i, int j) {
		visit = new boolean[N][M];

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i,j));
		visit[i][j] = true;
		ans = 1;

		while(!q.isEmpty()) {
			Pos cur = q.poll();

			for(int d=0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				if(!inside(ny, nx))
					continue;

				if(visit[ny][nx])
					continue;
				if(map[ny][nx] == '1')
					continue;

				q.add(new Pos(ny,nx));
				visit[ny][nx] = true;
				++ans;
			}
		}

	}

}
