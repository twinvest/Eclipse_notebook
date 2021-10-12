package 브루트포스;

import java.util.Scanner;

public class 파이프옮기기1 {
	static int[][] map;
	static long[][][] dp;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		dp = new long[N][N][3];
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<N; ++j) {
				map[i][j] = scan.nextInt();
				for(int k=0; k<3; ++k) {
					dp[i][j][k] = -1;
				}
			}
		}
		long ans = dfs(0,0,0,1,0);
		System.out.println(ans);
	}

	static long dfs(int y1, int x1, int y2, int x2, int dir) {
		//목적지라면
		if(y2 == N-1 && x2 == N -1) {
			return 1;
		}
		//방문한적이있다면
		if(dp[y2][x2][dir] != -1) {
			return dp[y2][x2][dir];
		}
		long ans = 0;
		//3개를 확인 가로인지 세로인지 대각선인지
		//가로
		if(y1 == y2) {
			if(x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0) {
					ans += dfs(y1,x1+1,y2,x2+1,0); //가로에서 가로
				}
			}
			if(x2+1 >=0 && x2+1 <N && y2+1 >=0 && y2+1 <N) {
				if(map[y2][x2+1] == 0 && map[y2+1][x2+1] == 0 && map[y2+1][x2] == 0) {
					ans += dfs(y1,x1+1,y2+1,x2+1,2); //가로에서 대각선
				}
			}
		}
		//세로
		else if(x1 == x2) {
			if(y2+1 >=0 && y2+1 <N) {
				if(map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1,y2+1,x2,1); //세로에서 세로
				}
			}
			if(y2+1 >=0 && y2+1 <N && x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0 && map[y2+1][x2+1] == 0 && map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1,y2+1,x2+1,2); //세로에서 대각선
				}
			}

		}
		//대각선
		else {
			if(x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0) {
					ans += dfs(y1+1,x1+1,y2,x2+1,0); //대각선에서 가로
				}
			}
			if(y2+1 >=0 && y2+1 <N) {
				if(map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1+1,y2+1,x2,1); //대각선에서 세로
				}
			}
			if(y2+1 >=0 && y2+1 <N && x2+1 >=0 && x2+1 <N) {
				if(map[y2][x2+1] == 0 && map[y2+1][x2+1] == 0 && map[y2+1][x2] == 0) {
					ans += dfs(y1+1,x1+1,y2+1,x2+1,2); //대각선에서 대각선
				}
			}
		}
		dp[y2][x2][dir] = ans;
		return ans;
	}
}
