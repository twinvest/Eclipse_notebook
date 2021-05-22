package day0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;

		for(int i = 2; i <= N; ++i) {
			dp[i] = dp[i-1] + 1;
			if ( i % 3 == 0 ) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if ( i % 2 == 0 ) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}

		System.out.println(dp[N]);
	}
}
