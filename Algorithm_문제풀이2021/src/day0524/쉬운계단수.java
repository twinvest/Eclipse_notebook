package day0524;

import java.util.Scanner;

public class 쉬운계단수 {
	static long[][] dp = new long[101][11];
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();

		//1자리일때 1~9까지 모두 1로 채운다.
		for ( int j = 1; j <= 9; ++j ) {
			dp[1][j] = 1;
		}

		//2자리이상인 경우
		for(int i =2; i<=N; ++i) {
			dp[i][0] = dp[i-1][1]; //0과 9는 점화식이 통하지 않음.
			dp[i][9] = dp[i-1][8]; //0과 9는 점화식이 통하지 않음.
			//1~8인경우
			//dp[2][0] = 0이다. 왜냐하면, 0으로 끝나는 숫자는 10 하나이기 때문에
			//dp[2][1] = 1이다. 왜냐하면, 1으로 끝나는 숫자는 21 하나이기 때문에
			//dp[2][2] = 2이다. 왜냐하면, 2로 끝나는 숫자는 12, 32  두개이기 때문에
			for(int j = 1; j < 9; ++j) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
		}
		//만약, 자릿수가 3이고 끝자리가 4일때 경우의수를 찾는 방법은
		//dp[3][4] = dp[2][3] + dp[2][5]이다.
		//왜냐하면, 이전자릿수(2)에서 끝자리 숫자가 3과 5일때의 경우의 수를 더하면 되기때문에.
		//즉, 23 43 45 65에 끝자리수가 4가 붙어서 234, 434, 454, 654가 된다.

		long sum = 0;
		for(int j=0; j<10; ++j) {
			sum = (sum + dp[N][j]) % 1000000000;
		}
		System.out.println(sum);
	}
}