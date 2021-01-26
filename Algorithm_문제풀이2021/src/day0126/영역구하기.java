package day0126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 영역구하기 {
	static boolean inside(int y, int x) {
		return (y>=0 && y<M) && (x>=0 && x<N);
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static class Pos{
		int y;
		int x;
		Pos(int y,int x){
			this.y = y;
			this.x = x;
		}
	}
	static boolean[][] visit;
	static int M;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt();
		N = scan.nextInt();
		int[][] map = new int[M][N];
		visit = new boolean[M][N];
		int K = scan.nextInt();
		for(int i = 0; i<K; ++i) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			for (int y = y1; y < y2; y++)
				for (int x = x1; x < x2; x++)
					map[y][x] = 1;

			/* 이것도 구하는 공식임. 이거 고민하느라 시간오래걸림.
			for(int y = M-y2; y<=M-1-y1; ++y ) {
				for(int x = x1; x<=x2-1;++x) {
					map[y][x] = 1;
				}
			}
			*/
		}
		ArrayList<Integer> ansList = new ArrayList<>();
		for(int i = 0; i<M; ++i) {
			for(int j = 0; j<N; ++j) {
				if(!visit[i][j] && map[i][j] == 0) {
					int ans = bfs(map, i, j);
					ansList.add(ans);
				}
			}
		}
		Collections.sort(ansList);
		System.out.println(ansList.size());
		for(int ans : ansList) {
			System.out.print(ans+" ");
		}

	}

	static public int bfs(int[][] map, int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		visit[y][x] = true;
		q.add(new Pos(y,x));
		int ans = 1;
		while(!q.isEmpty()) {
			Pos curPos = q.poll();
			for(int d = 0; d<4; ++d) {
				int ny = curPos.y + dir[d][0];
				int nx = curPos.x + dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx] && map[ny][nx] == 0) {
					visit[ny][nx] = true;
					q.add(new Pos(ny, nx));
					++ans;
				}
			}
		}
		return ans;
	}

}
