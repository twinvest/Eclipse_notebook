package day0713;

import java.util.Scanner;

public class 금광 {
	static int N,M, ans;
	static int[][] map, dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for(int t=1; t<=testCase; ++t) {
			N = scan.nextInt();
			M = scan.nextInt();
			map = new int[N+1][M+1];
			dp = new int[N+1][M+1];
			for(int i=1; i<=N; ++i) {
				for(int j=1; j<=M; ++j) {
					map[i][j] = scan.nextInt();
				}
			}
			ans = -987654321;
			solution();
			System.out.println(ans);
		}
	}
	static void solution() {
		for(int i=1; i<=N; ++i) {
			dp[i][1] = map[i][1];
		}

		for(int j = 2; j<=M; ++j) {
			for(int i =1; i<=N; ++i) {
				//첫행
				if(i == 1) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j-1]) + map[i][j];
				}
				//마지막행
				else if(i == N) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1]) + map[i][j];
				}
				//그 외 중간행들
				else {
					dp[i][j] = Math.max(Math.max(dp[i][j-1], dp[i+1][j-1]), dp[i-1][j-1]) +map[i][j];
				}
				ans = Math.max(dp[i][j], ans);
			}
		}
	}
}
