package day0802;

import java.util.Scanner;
public class 파이프옮기기1 {

	static int[][] map, dp;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		dp = new int[N][N];
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				map[i][j] = scan.nextInt();
			}
		}
		int ans = dfs(0,0,0,1);
		System.out.println(ans);
	}

	static int dfs(int y1, int x1, int y2, int x2) {
		//목적지라면
		if(y2 == N-1 && x2 == N -1) {
			return 1;
		}
		int ans = 0;
		//3개를 확인 가로인지 세로인지 대각선인지
		//가로
		if(y1 == y2) {
			if(x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0) {
					ans += dfs(y1,x1+1,y2,x2+1);
				}
			}
			if(x2+1 >=0 && x2+1 <N && y2+1 >=0 && y2+1 <N) {
				if(map[y2][x2+1] == 0 && map[y2+1][x2+1] == 0 && map[y2+1][x2] == 0) {
					ans += dfs(y1,x1+1,y2+1,x2+1);
				}
			}
		}
		//세로
		else if(x1 == x2) {
			if(y2+1 >=0 && y2+1 <N) {
				if(map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1,y2+1,x2);
				}
			}
			if(y2+1 >=0 && y2+1 <N && x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0 && map[y2+1][x2+1] == 0 && map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1,y2+1,x2+1);
				}
			}
		}
		//대각선
		else {
			if(x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0) {
					ans += dfs(y1+1,x1+1,y2,x2+1);
				}
			}
			if(y2+1 >=0 && y2+1 <N) {
				if(map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1+1,y2+1,x2);
				}
			}
			if(y2+1 >=0 && y2+1 <N && x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0 && map[y2+1][x2+1] == 0 && map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1+1,y2+1,x2+1);
				}
			}
		}
		return ans;
	}
}