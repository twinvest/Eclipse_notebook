package day0403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 빙산 {
	static class Pos {
		int y;
		int x;
		Pos(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static boolean inside(int y, int x) {
		return y>=0 && y<N && x>=0 && x<M;
	}
	static int N;
	static int M;
	static int[][] originMap;
	static int[][] copyMap; //1년이 진화할때 마다 갱신할 맵
	static boolean[][] visit;
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		originMap = new int[N][M];
		copyMap = new int[N][M];
		for(int i =0; i<N;++i) {
			for(int j =0; j<M; ++j) {
				originMap[i][j] = scan.nextInt();
				copyMap[i][j] = originMap[i][j];
			}
		}

		boolean flag = true;
		while(flag) {
			for(int i =0; i<N; ++i) {
				for(int j =0; j<M; ++j) {
					if(originMap[i][j] != 0) {
						iceBergMinus(i,j);
					}
				}
			}

			//위 2중 for문을통해 1년차만큼 감소된 빙산의 높이를 구한 후 이를 originMap으로 복사뜬다.
			for(int i =0; i<N; ++i) {
				for(int j =0; j<M; ++j) {
					originMap[i][j] = copyMap[i][j];
				}
			}
			//1년이 지났으므로 1증가.
			++ans;

			//1년치만큼 감소된 빙산을 가지고 연결요소의 개수를 찾는 bfs를 조진다.
			int numOfComponent = 0;
			visit = new boolean[N][M];
			for(int i=0; i<N; ++i) {
				for(int j=0; j<M; ++j) {
					if(!visit[i][j] && originMap[i][j] != 0) {
						bfs(i,j);
						++numOfComponent;
					}
				}
			}
			//연결요소의 개수가 1개 초과면 while 탈출
			flag = (numOfComponent > 1) ? false : true;

			//만약 빙산이 다 녹을때까지 분리되지 않으면
			if(numOfComponent == 0) {
				flag = false;
				ans = 0;
			}
		}
		System.out.println(ans);
	}

	static void iceBergMinus(int y, int x) {
		int numOfWater = 0;
		for(int d=0; d<4; ++d) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			if(inside(ny,nx) && originMap[ny][nx] ==0) {
				++numOfWater;
			}
		}
		//0이상이면 뺀값을 저장하고 0이하면 0을 저장한다.
		copyMap[y][x] = (originMap[y][x] - numOfWater) >= 0 ? (originMap[y][x] - numOfWater) : 0;
	}

	static void bfs(int y, int x) {
		Pos pos = new Pos(y,x);
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(pos);
		visit[y][x] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int d =0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx] && originMap[ny][nx] != 0) {
					q.add(new Pos(ny,nx));
					visit[ny][nx] = true;
				}
			}
		}
	}
}
