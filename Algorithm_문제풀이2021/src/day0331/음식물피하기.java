package day0331;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 음식물피하기 {
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static boolean inside(int y, int x) {
		return ( y>=0 && y<N ) && ( x>=0 && x<M );
	}

	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

	static int N;
	static int M;
	static int numOfTrash;
	static int ans = -987654321;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		numOfTrash = scan.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];

		for(int i =0; i<numOfTrash; ++i ) {
			int y = scan.nextInt();
			int x = scan.nextInt();
			map[y-1][x-1] = 1; //1은 trash를 의미.
		}

		for(int i =0; i<N; ++i) {
			for(int j =0; j<M; ++j) {
				//방문하지 않았고 해당좌표가 쓰레기면
				if(!visit[i][j] && map[i][j] == 1) {
					ans = Math.max(ans,bfs(i,j));
				}
			}
		}
		System.out.println(ans);
	}
	static int bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(y,x));
		visit[y][x] = true;
		int size = 1;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int d =0; d<4; ++d) {
				int ny = pos.y+dir[d][0];
				int nx = pos.x+dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx] && map[ny][nx] == 1) {
					++size;
					visit[ny][nx] = true;
					q.add(new Pos(ny,nx));
				}
			}
		}
		return size;
	}
}
