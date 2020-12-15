package day0304;

import java.util.Arrays;
import java.util.Scanner;

public class 초콜릿과건포도_더최적화 {
	static int result;
	static int n,m;
	static int[][] map;
	static int[][][][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		for(int t=1; t<=TC; ++t)
		{
			n = scan.nextInt();
			m = scan.nextInt();
			map = new int[n][m];
			dp = new int[n+1][m+1][n+1][m+1]; //범위검사안하려고 +1해준것!

			//초기화
			for(int[][][] d1 : dp)
			{
				for(int[][] d2 : d1)
				{
					for(int[] d3 : d2)
					{
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}

			for(int i=0; i<n; ++i)
			{
				for(int j=0; j<m; ++j)
				{
					map[i][j] = scan.nextInt();
				}
			}


			result = dfs(0,0,n,m);
			System.out.println("#"+t+" "+ result);
		}
	}
	static int dfs(int y, int x, int h, int w)
	{
		//종료
		if(w == 1 && h == 1)
		{
			return 0; //마지막 단일조각은 문제에서 비용이 0이라함.
		}
		//가지치기
		if(dp[y][x][h][w] != Integer.MAX_VALUE){
			return dp[y][x][h][w];
		}

		//실행
		//기존에 있던 덩어리의 건포도 개수가 비용!
		int sum = 0;
		for(int i = y; i<y+h; ++i)
		{
			for(int j = x; j<x+w; ++j)
			{
				sum += map[i][j];
			}
		}
		//가로로 나누어서 비용을 최소비용을 구한다.
		for(int i = 1; i<h; ++i)
		{
			//위쪽비용
			if(dp[y][x][i][w] == Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y,x,i,w);
			}
			//아래쪽비용
			if(dp[y+i][x][h-i][w] == Integer.MAX_VALUE) {
				dp[y+i][x][h-i][w] = dfs(y+i,x,h-i,w);
			}
			int sum3 = sum + dp[y][x][i][w] + dp[y+i][x][h-i][w];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		//세로로 나누어서 비용을 최소비용을 구한다.
		for(int i=1; i<w; ++i)
		{
			//왼쪽비용
			if(dp[y][x][h][i] == Integer.MAX_VALUE) {
				dp[y][x][h][i] = dfs(y,x,h,i);
			}
			//오른쪽비용
			if(dp[y][x+i][h][w-i] == Integer.MAX_VALUE) {
				dp[y][x+i][h][w-i] = dfs(y,x+i,h,w-i);
			}
			int sum3 = sum + dp[y][x][h][i] + dp[y][x+i][h][w-i];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		return dp[y][x][h][w];
	}
}