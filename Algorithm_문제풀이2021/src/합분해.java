import java.util.Scanner;

public class 합분해 {
	static int N, K;
	static int[][] dp = new int[201][201];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		for(int i =0; i<=N; ++i) {
			dp[0][i] = 0;
			dp[1][i] = 1;
		}

		for(int i = 2; i <= K; ++i) {
			for(int j =0; j <= N; ++j) {
				for(int l=0; l <= j; ++l) {
					dp[i][j] += dp[i-1][j-l];
					dp[i][j] %= 1000000000;
				}
			}
		}
		System.out.println(dp[K][N]);

	}

}
