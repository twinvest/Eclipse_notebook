package day0109;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동 {
	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
			this.y =y;
			this.x =x;
		}
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static boolean inside(int y, int x, int size) {
		return (x>=0 && x<size) && (y>=0 && y<size);
	}
	static int N;
	static int LOW;
	static int HIGH;
	static int[][] map;
	static int[][] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		LOW = scan.nextInt();
		HIGH = scan.nextInt();
		map = new int[N][N];
		visit = new int[N][N];

		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				map[i][j] = scan.nextInt();
				visit[i][j] = 0;
			}
		}
		int ans = 0;
		while(true) {
			int zone = 0;
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					for(int d = 0; d<4; ++d) {
						int ny = i + dir[d][0];
						int nx = j + dir[d][1];
						//네 방향중 하나라도 bfs를 조질 수 있는곳이 있으면 bfs를 조지기 시작한다.
						if(inside(ny,nx,N) && visit[ny][nx] == 0 && Math.abs(map[i][j]-map[ny][nx]) >= LOW && Math.abs(map[i][j]-map[ny][nx]) <= HIGH ) {
							visit[i][j] = ++zone;
							bfs(i, j, zone);
						}
					}
				}
			}


			for(int z = 1; z<=zone; ++z) {
				int sum = 0;
				int count = 0;
				for(int i = 0; i<N; ++i) {
					for(int j = 0; j<N; ++j) {
						if(visit[i][j] == z) {
							sum += map[i][j];
							++count;
						}
					}
				}
				//map갱신
				int cur = sum/count;
				for(int i = 0; i<N; ++i) {
					for(int j = 0; j<N; ++j) {
						if(visit[i][j] == z) {
							map[i][j] = cur;
						}
					}
				}
			}
			//true를 반환하면 아무곳도 방문한곳이 없다는것임.
			if(check())
				break;
			++ans;
			//visit배열 방문하지 않은 상태로 전부초기화
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					visit[i][j] = 0;
				}
			}
		}
		System.out.println(ans);
	}

	static void bfs(int y, int x, int zone) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(y, x));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			for(int d = 0; d<4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];
				if(inside(ny, nx, map.length) && visit[ny][nx] == 0 && Math.abs(map[cur.y][cur.x]-map[ny][nx]) >= LOW && Math.abs(map[cur.y][cur.x] - map[ny][nx]) <= HIGH ) {
					visit[ny][nx] = zone;
					q.offer(new Pos(ny, nx));
				}
			}
		}
	}

	static boolean check() {
		//visit배열이 전부 0이면 true를 반환. 방문한곳이 한곳도 없다는것임. true반환후 while문 탈출함.
		boolean flag = true;
		for(int i = 0; i <N; ++i) {
			for(int j = 0; j <N; ++j) {
				if(visit[i][j] != 0)
					flag = false;
			}
		}
		return flag;
	}
}
