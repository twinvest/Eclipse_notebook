package day0725;

import java.util.Scanner;

public class 퇴사 {
	static int N;
	static int[] time;
	static int[] pay;
	static int[] dp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		pay = new int[N+1];
		time = new int[N+1];

		for(int i=1; i<=N; ++i) {
			time[i] = scan.nextInt();
			pay[i] = scan.nextInt();
		}


		for(int i = N; i>=1; --i) {
			if(i + time[i] > N) {
				dp[i] = 0;
			} else {
				dp[i] = Math.max(dp[i-1], dp[i-time[i]] + pay[i]);
			}


		}

	}

}
