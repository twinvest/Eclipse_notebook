package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기3_내가푼거실패 {

	static class Pos{
		int y;
		int x;
		int distance;
		int dayAndnight; //0이면 낮, 1이면 밤
		Pos(int y, int x, int distance, int dayAndnight){
			this.y = y;
			this.x=x;
			this.distance = distance;
			this.dayAndnight = dayAndnight;
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

	static int N,M,K;
	static char[][] map, originMap;
	static boolean[][] visit;
	static int ans = 987654321;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		map = new char[N][M];
		originMap = new char[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; ++i) {
			String str = scan.next();
			for(int j=0; j<str.length(); ++j) {
				map[i][j]=str.charAt(j);
				originMap[i][j] = str.charAt(j);
			}
		}
		solution2(0,0);
		System.out.println(ans);
	}

	static void solution2(int start, int depth) {

		if (depth == K) {
			bfs();
			return;
		}

		for (int i = start; i < N * M; i++) {
			int x = i / M;
			int y = i % M;

			if (map[x][y] == '1') {
				map[x][y] = '0';
				solution2(i + 1, depth + 1);
				map[x][y] = '1';
			}
		}
	}

	static void print() {
		for(int i = 0; i<map.length; ++i) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}


	static void bfs() {
		//y, x, 이동한거리, 낮(0)과 밤(1)
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,1,0)); //낮을 넣어준다.
		visit[0][0] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.y == N-1 && cur.x == M-1) {
				ans = cur.distance;
				break;
			}

			for(int d=0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				//범위를 벗어났으면
				if(!inside(ny,nx))
					continue;
				//방문한곳이라면
				if(visit[ny][nx])
					continue;

				//벽이라면
				if(map[ny][nx] == '1' && originMap[ny][nx] == '1')
					continue;

				//현재 밤이라면 벽을깰 수 없다.
				if(map[ny][nx] == '0' && originMap[ny][nx] == '1' && cur.dayAndnight == 1) {
					q.add(new Pos(cur.y,cur.x,cur.distance+1, 0 ));
					visit[cur.y][cur.x] = true;
				}else if(map[ny][nx] == '0' && originMap[ny][nx] == '1' && cur.dayAndnight == 0) {
					q.add(new Pos(ny,nx,cur.distance+1, 1 ));
					visit[ny][nx] = true;
				}else if(map[ny][nx] == '0') {
					q.add(new Pos(ny,nx,cur.distance+1, cur.dayAndnight==1 ? 0 : 1 ));
					visit[ny][nx] = true;
				}

			}

		}
	}
}