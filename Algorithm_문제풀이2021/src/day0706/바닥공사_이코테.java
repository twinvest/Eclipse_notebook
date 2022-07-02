package day0706;

import java.util.Scanner;

public class 바닥공사_이코테 {
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i<=N;++i) {
			dp[i] = ((dp[i-2] * 2) + dp[i-1]) % 10007;
		}
		System.out.println(dp[N]);
	}
}
