package day0623;
import java.util.Scanner;
/*
 *
 * 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * DP[a][b] = c 의 의미는 "a개 더해서 그 합이 b가 되는 경우의 수는 c개 입니다." 이다.
 *
 * */
public class 합분해 {
	static int N, K;
	static int[][] dp = new int[201][201];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		for(int i =0; i<=N; ++i) {
			dp[0][i] = 0; //0개를 더해서 i를 만들어내는 경우의 수
			dp[1][i] = 1; //1개를 더해서 i를 만들어내는 경우의 수
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
