package day0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pos{
	int y;
	int x;
	int direction;
	int limit;
	int depth;
	Pos(int y, int x, int direction, int limit, int depth)
	{
		this.y =y;
		this.x =x;
		this.direction = direction;
		this.limit = limit;
		this.depth = depth;
	}
}

public class 말이되고픈원숭이2 {
	static boolean inside(int y, int x)
	{
		return (y>=0 && y<H) && (x>=0 && x<W);
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}}; //12방탐색
	static int H;
	static int W;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<Pos> q = new LinkedList<>();
	static boolean flag;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int limit = scan.nextInt();
		W = scan.nextInt();
		H = scan.nextInt();
		map = new int[H][W];
		visit = new boolean[31][H][W];
		for(int i=0; i<H; ++i)
			for(int j=0; j<W; ++j)
				map[i][j] = scan.nextInt();

		int y=0, x=0;
		visit[limit][y][x] = true;
		for(int d=0; d<12; ++d)
		{
			int nexty = y + dir[d][0];
			int nextx = x + dir[d][1];
			//범위를 벗어난 경우
			if(!inside(nexty, nextx) || map[nexty][nextx] == 1)
				continue;
			if(limit == 0 && d>=4)
				continue;
			if(d<4) {
				visit[limit][nexty][nextx] = true;
				q.add(new Pos(nexty, nextx, d, limit, 1));
			}
			else if(d>=4) {
				visit[limit][nexty][nextx] = true;
				q.add(new Pos(nexty, nextx, d, limit-1, 1));
			}
		}
		flag =  true;
		do
		{
			y = q.peek().y;
			x = q.peek().x;
			int d = q.peek().direction;
			int cur_limit = q.peek().limit;
			int cur_depth = q.peek().depth;
			q.poll();
			if(d<4)
				bfs(y,x,cur_depth+1,cur_limit);
			else if(d>=4)
				bfs(y,x,cur_depth+1,cur_limit-1);
		}while(flag);
		System.out.println(ans+1);
	}

	static int ans;
	static void bfs(int y, int x, int depth, int limit)
	{
		if(y == H-1 && x == W-1)
		{
			flag = false;
			ans = depth;
			return;
		}
		for(int d=0; d<12; ++d)
		{
			int nexty = y + dir[d][0];
			int nextx = x + dir[d][1];
			//범위를 벗어난 경우
			if(!inside(nexty, nextx) || map[nexty][nextx] == 1 || visit[limit][nexty][nextx] == true)
				continue;
			if(limit == 0 && d>3)
				continue;
			if(d<4) {
				visit[limit][nexty][nextx] = true;
				q.add(new Pos(nexty, nextx, d, limit, depth));
			}

			else if(d>=4) {
				visit[limit][nexty][nextx] = true;
				q.add(new Pos(nexty, nextx, d, limit-1, depth));
			}
		}
	}
}