package day0708;

import java.util.Scanner;

public class 정수삼각형 {
	static int N;
	static int[][] dp;
	static int[][] arr;
	static int answer;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		dp = new int[N+1][N+1];
		arr = new int[N+1][N+1];

		for(int i =1; i<=N; ++i) {
			for(int j=1; j<=i; ++j) {
				arr[i][j] = scan.nextInt();
			}
		}

		answer = dp[1][1] = arr[1][1];
		for(int i = 2; i<=N; ++i) {
			for(int j = 1; j<=i; ++j) {
				// 1) 삼각형 제일 왼쪽 끝인 경우
	            if(j == 0){
	                dp[i][j] = dp[i-1][j] + arr[i][j];
	            // 2) 삼각형 제일 오른쪽 끝인 경우
	            }else if(j == i){
	            	dp[i][j] = dp[i-1][j-1] + arr[i][j];
	            }
	            // 3) 삼각형 왼쪽, 오른쪽 끝인 아닌 내부인 경우
	            else{
	            	dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
	            }
	            answer = Math.max(dp[i][j], answer);
			}
		}
		System.out.println(answer);
	}

}
