
package day0711;

import java.util.Scanner;

public class 병사배치하기 {
	static int N, ans;
	static int[] dp, arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N+1];
		dp = new int[N+1];

		for(int i = 1; i<=N;++i) {
			arr[i] = scan.nextInt();
			dp[i] = 1;
		}
		for(int i =1; i<=N; ++i) {
			int cur = arr[i];
			for(int j =1; j<=i; ++j) {
				int comp = arr[j];
				if(cur < comp) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(N-ans);
	}
}
