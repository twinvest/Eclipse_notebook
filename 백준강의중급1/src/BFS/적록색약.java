package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약 {
	static boolean[][] visit;
	static char[][] map, map2;
	static int N;
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static boolean inside(int y,int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}

	static class Pos{
		int y;
		int x;
		char color;
		Pos(int y, int x, char color){
			this.y=y;
			this.x=x;
			this.color = color;
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new char[N][N];
		map2 = new char[N][N];

		visit = new boolean[N][N];
		for(int i =0; i<N; ++i) {
			String str = scan.next();
			for(int j =0; j<N; ++j) {
				map[i][j] = str.charAt(j);
				map2[i][j] = str.charAt(j);
				if(map2[i][j] == 'G')
					map2[i][j] = 'R';
			}
		}

		int cnt=0, cnt2 = 0;
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(!visit[i][j])
					cnt += bfs(i,j, 1);
			}
		}

		visit = new boolean[N][N];
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(!visit[i][j])
					cnt2 += bfs(i,j, 2);
			}
		}

		System.out.println(cnt+" "+cnt2);

	}

	static int bfs(int i, int j, int ver) {
		Queue<Pos> q = new LinkedList<>();
		boolean dummy = ver == 1 ? q.add(new Pos(i,j,map[i][j])) : q.add(new Pos(i,j,map2[i][j]));

		visit[i][j] = true;
		char color = ver == 1 ? map[i][j] : map2[i][j];

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int d =0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				if(!inside(ny,nx)) continue;
				if(visit[ny][nx]) continue;
				if(ver == 1) {
					if(color != map[ny][nx])
						continue;
				}else {
					if(color != map2[ny][nx])
						continue;
				}
				if(ver == 1) {
					q.add(new Pos(ny,nx,map[ny][nx]));
				}else {
					q.add(new Pos(ny,nx,map2[ny][nx]));
				}

				visit[ny][nx] = true;
			}
		}
		return 1;
	}

}
