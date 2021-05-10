package day0509;

import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();

		str1 = "0" + str1;
		str2 = "0" + str2;

		int M = str1.length();
		int N = str2.length();

		int[][] dp = new int[N][M];
		for(int j = 0; j<M; ++j) {
			dp[0][j] = 0;
		}

		int max = 0;
		int ans = -987654321;
		for(int i = 1; i<N; ++i) {
			max = 0;
	        dp[i][0] = 0;
	        for (int j = 1; j < M; j++) {
	            if (str2.charAt(i) == str1.charAt(j)){
	                max = dp[i-1][j - 1] + 1;
	                dp[i][j] = max;
	            }
	            else {
	                if(dp[i][j - 1] > dp[i - 1][j])
	                	dp[i][j] = dp[i][j-1];
	                else
	                	dp[i][j] = dp[i-1][j];
	            }
	        }
	        ans = Math.max(ans, max);
		}
		System.out.println(ans);
	}
}
