package day0205;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
	static class Pos{
		int y;
		int x;
		int distance;
		Pos(int y, int x, int distance){
			this.y =y;
			this.x =x;
			this.distance = distance;
		}
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static boolean inside(int y, int x) {
		return (x>=0 && x<M) && (y>=0 && y<N);
	}
	static int minDistance = 987654321;
	static int N;
	static int M;
	static int[][] map;
	static boolean [][] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i =0;i<N;++i) {
			String s = scan.next();
			for(int j =0; j<s.length(); ++j) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}

		solution3(map, 0, 0);
		System.out.println(minDistance == 987654321 ? "-1" : minDistance);
	}
	static void solution3(int[][] map, int idx, int pick) {
		int N = map.length;
		int M = map[0].length;
		if (pick == 1) {
			bfs();
			return;
		}
		if (idx == N * M) {
			return;
		}
		int r = idx / M;
		int c = idx % M;
		if (map[r][c] == 1) {
			map[r][c] = 0;
			solution3(map, idx + 1, pick + 1);
			map[r][c] = 1;
		}
		solution3(map, idx + 1, pick);
	}

	static void bfs() {
		int[][] copyMap = new int[N][M];
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				copyMap[i][j] = map[i][j];
				visit[i][j] = false;
			}
		}
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,1));
		visit[0][0] = true;
		boolean flag = false;
		int distance = -1;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			if(pos.y == N-1 && pos.x == M-1) {
				flag = true;
				distance = pos.distance;
				break;
			}
			for(int d = 0; d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				if(inside(ny, nx) && !visit[ny][nx] && copyMap[ny][nx] == 0) {
					visit[ny][nx] = true;
					q.add(new Pos(ny, nx, pos.distance+1));
				}
			}
		}
		if(flag) {
			minDistance = Math.min(minDistance, distance);
		}
	}
}
