package day0714;
/*
 * 백준 : 최소편집(https://www.acmicpc.net/problem/15483)
 * 참고할만한 url : https://blog.naver.com/ndb796/220870218783
 * */

import java.util.Scanner;

public class 편집거리_이코테 {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		str1 = " "+str1;
		str2 = " "+str2;
		dp = new int[str1.length()][str2.length()];

		for(int j=0; j<str2.length(); ++j) {
			dp[0][j] = j;
		}

		for(int i=0; i<str1.length(); ++i) {
			dp[i][0] = i;
		}

		for(int i = 1; i<str1.length(); ++i) {
			for(int j = 1; j<str2.length(); ++j) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
				}
			}
		}
		/*
		for(int i =0; i<str1.length(); ++i) {
			for(int j =0; j<str2.length(); ++j) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		*/
		System.out.println(dp[str1.length()-1][str2.length()-1]);

	}

}
