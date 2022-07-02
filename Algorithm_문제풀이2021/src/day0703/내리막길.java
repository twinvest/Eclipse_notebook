package day0703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * dp[y][x] = (y, x) 지점에서 목적지에 도착할 수 있는 경로의 개수.
 * */
public class 내리막길 {
	static int M,N;
	static int[][] map = new int[500][500];
	static int[][] dp = new int[500][500];
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);

		for(int i =0; i<M; ++i) {
			s = br.readLine().split(" ");
			for(int j =0; j<N; ++j) {
				map[i][j] = Integer.parseInt(s[j]);
				dp[i][j] = -1;
			}
		}

		int ans = dfs(0,0);
		for(int i =0; i<M; ++i) {
			for(int j =0; j<N; ++j) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}

		bw.write(ans+"\n");
		bw.flush();
	}

	static int dfs(int y, int x) {
		if(y == M-1 && x == N-1)
			return 1;

		//방문한적이 있다면
		if(dp[y][x] != -1)
			return dp[y][x];
		//방문한적이 없다면
		dp[y][x] = 0;
		for(int d =0; d<4; ++d) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			if((ny>=0 && ny<M) && (nx>=0 && nx<N) && map[y][x] > map[ny][nx]) {
				dp[y][x] += dfs(ny,nx);
			}
		}
		return dp[y][x];

	}
}
