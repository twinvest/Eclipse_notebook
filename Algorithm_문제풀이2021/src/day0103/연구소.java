package day0103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소 {
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<M);
	}
	static int N;
	static int M;
	static class Pos {
		int y;
		int x;
		Pos(int y , int x){
			this.y =y;
			this.x= x;
		}
	}
	static ArrayList<Integer> ansList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		int[][] map = new int[N][M];
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				map[i][j] = scan.nextInt();
			}
		}

		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				if(map[i][j] == 0)
					map[i][j] = 1;
				else
					continue;
				for(int k = 0; k<N; ++k) {
					for(int l = 0; l<M; ++l) {
						if(map[k][l] == 0)
							map[k][l] = 1;
						else
							continue;
						for(int a = 0; a<N; ++a) {
							for(int b = 0; b<M; ++b) {
								if(map[a][b] == 0)
									map[a][b] = 1;
								else
									continue;
								bfs(map);
								map[a][b] = 0;
							}
						}
						map[k][l] = 0;
					}
				}
				map[i][j] = 0;
			}
		}
		Collections.sort(ansList);
		System.out.println(ansList.get(ansList.size()-1));
	}

	static void bfs(int[][] map) {
		int[][] copyMap = new int[N][M];
		for(int i =0; i< N; ++i) {
			for(int j =0; j< M; ++j) {
				copyMap[i][j] = map[i][j];
			}
		}

		Queue<Pos> q = new LinkedList<>();
		for(int i =0; i< N; ++i) {
			for(int j =0; j< M; ++j) {
				if(copyMap[i][j] == 2)
					q.add(new Pos(i,j));
			}
		}

		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int d =0; d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				if(inside(ny,nx) && copyMap[ny][nx] == 0) {
					copyMap[ny][nx] = 2;
					q.add(new Pos(ny, nx));
				}
			}
		}
		int ans = 0;
		for(int i =0; i< N; ++i) {
			for(int j =0; j< M; ++j) {
				if(copyMap[i][j] == 0)
					++ans;
			}
		}
		ansList.add(ans);
	}
}
