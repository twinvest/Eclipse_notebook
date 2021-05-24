package day0524;

import java.util.Scanner;

public class 쉬운계단수 {
	static long[][] dp = new long[101][11];
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for ( int j = 1; j <= 9; ++j ) {
			dp[1][j] = 1;
		}

		for(int i =2; i<=N; ++i) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1; j <= 9; ++j) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]);
			}
		}

		long sum = 0;
		for(int j=0; j<10; ++j) {
			sum += dp[N][j];
		}
		System.out.println(sum);
	}

}
