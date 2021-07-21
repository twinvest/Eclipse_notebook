package day0526;

import java.util.Scanner;

public class 평범한배낭 {
	static int[] W = new int[100];
	static int[] V = new int[100];
	static int[][] dp = new int[101][100001];
	static int N,K;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		for(int i =0; i<N; ++i) {
			W[i] = scan.nextInt();
			V[i] = scan.nextInt();
		}
		System.out.println(go(0,0));
	}

	static int go(int i, int w) {
		if(dp[i][w] > 0)
			return dp[i][w];
		if(i == N)
			return 0;

		int n1 = 0;
		if(w+W[i] <= K)
			n1 = V[i] + go(i+1, w+W[i]); //포함
		int n2 = go(i+1, w); //미포함
		return dp[i][w] = Math.max(n1, n2);
	}
}
