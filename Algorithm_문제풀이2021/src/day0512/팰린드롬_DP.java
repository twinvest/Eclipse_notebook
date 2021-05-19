package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬_DP {
	static int[] arr;
	static boolean[][] dp;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new boolean[N+1][N+1];

		st = new StringTokenizer(br.readLine());
		for ( int i = 1; i <= N; ++i ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		palindrome();
		StringBuilder sb = new StringBuilder();
		for ( int i =0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(dp[start][end]) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
	static void palindrome() {
		//길이가 1인 경우는 무조건 팰린드롬이니 전부 true로 넣어준다.
		for(int i = 1; i<=N; ++i) {
			dp[i][i] = true;
		}

		//길이가 2인 경우는 arr[i]와 arr[i+1]이 같은 경우는 팰린드롬이기 때문에 이 경우에 모두 true로 넣어준다.
		for(int i = 1; i<N; ++i) {
			if(arr[i] == arr[i+1]) {
				dp[i][i+1] = true;
			}
		}

		//길이가 3이상인 경우부터는
		//i는 검사하고자하는 길이를 의미. 즉, i가 2라고 가정하면 길이는 3임. arr[1]~arr[4]까지가 팰린드롬인가?
		//이때, arr[1]과 arr[4]가 같고 dp[2][3]이 이미 팰린드롬이라면 dp[1][4]도 팰린드롬이 됨.
		for(int i = 2; i<N; ++i) {
			for(int j = 1; j<=N-i; ++j) {
				if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) {
					dp[j][j+i] = true;
				}
			}
		}
	}
}
