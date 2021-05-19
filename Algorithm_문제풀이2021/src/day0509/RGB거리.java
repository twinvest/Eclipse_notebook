package day0509;

import java.util.Scanner;

public class RGB거리 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] colorCost = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		for(int i = 1; i<=N; ++i) {
			for(int j = 0; j<3; ++j) {
				colorCost[i][j] = scan.nextInt();
			}
		}

		colorCost[0][0]=0; colorCost[0][1]=0; colorCost[0][2]=0;
		dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;

		for(int i = 1; i<=N; ++i) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + colorCost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + colorCost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + colorCost[i][2];
		}

		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
