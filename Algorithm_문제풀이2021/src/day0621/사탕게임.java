package day0621;

import java.util.Scanner;

public class 사탕게임 {
	static int N;
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	static boolean inside(int y, int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}
	static char[][] map;
	static int ans = -987654321;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new char[N][N];
		for(int i =0; i<N; ++i) {
			String str = scan.next();
			for(int  j=0; j<str.length(); ++j) {
				map[i][j] = str.charAt(j);
			}
		}

		for(int i =0; i<N; ++i) {
			for(int  j=0; j<N; ++j) {
				search(i,j);
			}
		}
		System.out.println(ans);

	}

	static void search(int y, int x) {
		for(int d=0; d<4; ++d) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			//범위를 벗어나지 않았고 인접한곳이 다르면
			if(inside(ny,nx) && map[y][x] != map[ny][nx]) {
				//일단 둘의 위치를 바꾼다.
				char tmp = map[ny][nx];
				map[ny][nx] = map[y][x];
				map[y][x] = tmp;

				//먹을 수 있는 사탕의 개수를 반환하는 함수
				ans =  Math.max(ans ,calc());

				map[y][x] = map[ny][nx];
				map[ny][nx] = tmp;
			}
		}
	}

	static int calc() {
		int ret = 0;
		//행계산
		for(int i =0; i<N; ++i) {
			int cnt = 1;
			char prev = ' ';
			char cur = ' ';
			for(int j =0; j<N; ++j) {
				cur = map[i][j];
				if(cur == prev) {
					prev = cur;
					++cnt;
				} else {
					prev = cur;
					ret = Math.max(ret, cnt);
					cnt = 1;
				}

			}
			ret = Math.max(ret, cnt);
		}

		//열계산
		for(int i =0; i<N; ++i) {
			int cnt = 1;
			char prev = ' ';
			char cur = ' ';
			for(int j =0; j<N; ++j) {
				cur = map[j][i];
				if(cur == prev) {
					prev = cur;
					++cnt;
				} else {
					prev = cur;
					ret = Math.max(ret, cnt);
					cnt = 1;
				}

			}
			ret = Math.max(ret, cnt);
		}

		return ret;
	}

}
