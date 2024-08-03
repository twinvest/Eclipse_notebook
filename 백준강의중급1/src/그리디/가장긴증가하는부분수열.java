package 그리디;

import java.util.Scanner;
/*
 * LIS문제
 * https://bitwise.tistory.com/215
 * https://namu.wiki/w/%EC%B5%9C%EC%9E%A5%20%EC%A6%9D%EA%B0%80%20%EB%B6%80%EB%B6%84%20%EC%88%98%EC%97%B4
 * */
public class 가장긴증가하는부분수열 {
	static int[] dp = new int[1001];
	static int[] arr = new int[1001];
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 1; i<=N; ++i) {
			arr[i] = scan.nextInt();
			dp[i] = 1;
		}

		for(int i =1; i<=N; ++i) {
			int cur = arr[i];
			for(int j =1; j<=i; ++j) {
				int comp = arr[j];
				//cur보다 comp가 작을때는 계속 진입해서 dp[i]와 dp[j+1]을 비교해 dp[i]를 계속 갱신해준다.
				if(cur > comp) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}

}
