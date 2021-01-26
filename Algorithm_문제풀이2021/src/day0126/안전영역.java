package day0126;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {

	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
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
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int[][] map = new int[N][N];
		visit = new boolean[N][N];
		int maxHeight = -987654321;
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				map[i][j] = scan.nextInt();
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		int maxAns = -987564321;
		for (int height = 0; height <= maxHeight; ++height) {
			int ans = 0;
			int[][] copyMap = new int[N][N];
			//copyMap만들기. 침수지역은 -1로 표시.
			for(int y = 0; y<N; ++y) {
				for(int x = 0; x<N; ++x) {
					if(map[y][x] <= height) { //이 부분때문에 고생많이함. height를 0부터 하거나, height을 1부터하면 등호를 <로 바꿔줘야한다.
						copyMap[y][x] = -1;
					} else {
						copyMap[y][x] = map[y][x];
					}
					visit[y][x] = false;
				}
			}

			for(int y = 0; y<N; ++y) {
				for(int x = 0; x<N; ++x) {
					if(!visit[y][x] && copyMap[y][x] != -1) {
						bfs(copyMap, y, x);
						++ans;
					}
				}
			}
			maxAns = Math.max(maxAns, ans);
		}
		System.out.println(maxAns);
	}

	static public void bfs(int[][] map, int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		visit[y][x] = true;
		q.add(new Pos(y,x));
		while(!q.isEmpty()) {
			Pos curPos = q.poll();
			for(int d = 0; d<4; ++d) {
				int ny = curPos.y + dir[d][0];
				int nx = curPos.x + dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx] && map[ny][nx] != -1) {
					visit[ny][nx] = true;
					q.add(new Pos(ny, nx));
				}
			}
		}
	}
}
