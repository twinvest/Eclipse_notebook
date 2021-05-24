package day0522;

import java.util.Scanner;
/*
 * https://songsunbi.tistory.com/80
 * */
public class 퇴사 {
	static int[] t = new int[21];
	static int[] p = new int[21];
	static int[] dp = new int[21];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i =1; i<=N; ++i) {
			t[i] = scan.nextInt();
			p[i] = scan.nextInt();
		}

		int next = 0;
		for (int i = N; i > 0; i--) {
	        next = i + t[i];
	        //next가 N일자보다 큰 경우.
	        if (next > N + 1) {
	            dp[i] = dp[i + 1];
	        }
	        else {
	            dp[i] = Math.max(dp[i + 1], dp[next] + p[i]);
	        }

	    }
		System.out.println(dp[1]);
	}
}
