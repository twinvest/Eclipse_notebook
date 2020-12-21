package day1221;

import java.util.Scanner;

public class 게임개발 {

	static int[][] dir = {
			 {-1,0}  //북
			,{0,1}   //동
			,{1,0}   //남
			,{0,-1}  //서
	};

	static boolean inside(int y, int x) {
		return (x >= 0 && x < M) && (y>=0 && y<N);
	}
	static int N, M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		int y = scan.nextInt();
		int x = scan.nextInt();
		int d = scan.nextInt(); //쳐다보고 있는 방향

		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				map[i][j] = scan.nextInt();
				visit[i][j] = false;
			}
		}

		visit[y][x] = true;
		int count = 1;
		int turnTime = 0;
		while(true) {
			d -= 1;
			if(d == -1)
				d = 3;

			int ny = y + dir[d][0];
			int nx = x + dir[d][1];

			if(inside(ny, nx) && !visit[ny][nx] && map[ny][nx] == 0) {
				y = ny;
				x = nx;
				visit[y][x] = true;
				++count;
				turnTime = 0;
				continue;
			} else {
				++turnTime;
			}
			if(turnTime == 4) {
				ny = y - dir[d][0]; //다시제자리를 의미
				nx = x - dir[d][1]; //다시제자리를 의미
				//돌아갈 수 있는경우
				if(map[ny][nx] == 0) {
					//돌아간다
					y = ny;
					x = nx;
					break;
				}
				//돌아가려는 자리가 바다인 경우
				else {
					break;
				}
			}
		}
		System.out.println(count);

	}
}
