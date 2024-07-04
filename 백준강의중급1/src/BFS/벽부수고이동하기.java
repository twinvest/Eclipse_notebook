package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
	static int N,M,K,ans=-1;
	static char[][] map;
	static boolean[][][] visit;
	static class Pos{
		int y;
		int x;
		int kCnt;
		int distance;
		Pos(int y, int x, int kCnt, int distance){
			this.y=y;
			this.x=x;
			this.kCnt=kCnt;
			this.distance = distance;
		}
	}
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<M);
	}
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
	};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();

		map = new char[N][M];
		visit = new boolean[N][M][2];
		for(int i =0; i<N; ++i) {
			String str = scan.next();
			for(int j =0; j<M; ++j) {
				char ch = str.charAt(j);
				map[i][j] = ch;
			}
		}

		bfs();
		System.out.println(ans);
	}
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,0,1));
		visit[0][0][0] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.y == N-1 && cur.x == M-1) {
				ans = cur.distance;
				return;
			}

			for(int d=0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				if(!inside(ny,nx)) continue;

				if(map[ny][nx] == '1' && 1 >= cur.kCnt+1 && !visit[ny][nx][cur.kCnt+1]) {
					q.add(new Pos(ny,nx,cur.kCnt+1,cur.distance+1));
					visit[ny][nx][cur.kCnt+1] = true;
				} else if(map[ny][nx] == '0' && !visit[ny][nx][cur.kCnt]) {
					q.add(new Pos(ny,nx,cur.kCnt,cur.distance+1));
					visit[ny][nx][cur.kCnt] = true;
				}

			}
		}

	}

}
