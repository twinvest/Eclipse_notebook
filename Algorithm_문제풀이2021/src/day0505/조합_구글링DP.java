package day0505;

import java.math.BigInteger;
import java.util.Scanner;

class 조합_구글링DP {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();

		BigInteger[][] dp=new BigInteger[101][101];

		dp[1][0]=dp[1][1]=BigInteger.ONE;
		for(int i=2;i<=100;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || i==j) dp[i][j]=BigInteger.ONE;
				else dp[i][j]=dp[i-1][j].add(dp[i-1][j-1]);
			}
		}

		System.out.println(dp[n][m]);
	}


}