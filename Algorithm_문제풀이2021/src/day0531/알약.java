package day0531;

/*
 * https://kimtaehyun98.tistory.com/67
 * */
import java.util.Scanner;

public class 알약 {
	static long[][] dp = new long[31][31];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		for(int h = 0; h<=30; ++h) {
			for(int w = 0; w<=30; ++w) {
				if(h>w)
					continue;
				if(h == 0)
					dp[w][h] = 1;
				else
					dp[w][h] = dp[w-1][h] + dp[w][h-1];
			}
		}

		while(true) {
			int N = scan.nextInt();
			if(N==0) break;
			System.out.println(dp[N][N]);
		}

	}

}
