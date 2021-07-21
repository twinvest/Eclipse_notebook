package day0526;

import java.util.Scanner;

public class 평범한배낭_bottomUp {
	static int[] W = new int[101];
	static int[] V = new int[101];
	static int[][] dp = new int[101][100001];
	static int N,K;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();

		for(int i =1; i<=N; ++i) {
			W[i] = scan.nextInt();
			V[i] = scan.nextInt();
		}

		//dp배열 초기화
		for(int i =0; i<=N; ++i) {
			dp[i][0] = 0;
			dp[0][i] = 0;
		}

		for(int i = 1; i<=N; ++i) {
			for(int j = 1; j<=K; ++j) {
				//가방에 물건을 넣을 수 있으면
				if(W[i] <= j) {
					//i-1의 의미에 대해 깊게 생각해봄.
					//DP[i - 1][j]는 "기존에 탐색했던 물건들로만 무게 j를 만드는 경우"를 의미하고
					//DP[i - 1][j - Weight[i]]는 "기존에 탐색했던 물건들로만 무게 j - Weight[i] 를 만들고, 현재 물건을 가방에 넣는 경우"를 의미
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
				}
				//해당 물건을 가방에 넣을 수 없으면
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
