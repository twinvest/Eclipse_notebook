package day0519;

import java.util.Scanner;
/*
 * 재귀   : https://sihyungyou.github.io/baekjoon-9095/
 *  DP : https://jyami.tistory.com/15
 *
 * */
public class 일이삼더하기 {
	static int[] dp;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i<=11; ++i) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		int testCase = scan.nextInt();
		for(int t = 0; t<testCase; ++t) {
			System.out.println(dp[scan.nextInt()]);
		}
	}
}