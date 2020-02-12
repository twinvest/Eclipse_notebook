package day0210;

import java.util.Scanner;

public class 말이되고픈원숭이 {
	static boolean inside(int y, int x)
	{
		return (y>=0 && y<H) && (x>=0 && x<W);
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}}; //12방탐색
	static int H;
	static int W;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int limit = scan.nextInt();
		W = scan.nextInt();
		H = scan.nextInt();
		map = new int[H][W];
		for(int i=0; i<H; ++i)
			for(int j=0; j<W; ++j)
				map[i][j] = scan.nextInt();
		int ans = dfs(0,0,0,limit);
		System.out.println(ans);
	}

	//limit은 0이되면 더이상 못씀.
	static int dfs(int y, int x, int depth, int limit)
	{
		int depth1 = 0;
		int depth2 = 0;
		if(y == H-1 && x == W-1)
			return depth;
		for(int d=0; d<12; ++d)
		{
			int nexty = y + dir[d][0];
			int nextx = x + dir[d][1];

			//범위를 벗어난 경우
			if(!inside(nexty, nextx))
				continue;
			//말처럼 움직이지 못하는 경우
			if(limit == 0 && d>3)
				continue;
			//다음가볼곳인데 그곳이 장애물이면 컨티뉴
			if(map[nexty][nextx] == 1)
				continue;
			if(d<4)
				depth1 = dfs(nexty, nextx, depth+1, limit);
			else
				depth2 = dfs(nexty, nextx, depth+1, limit-1);
		}
		return Math.min(depth1, depth2);
	}
}