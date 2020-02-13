package day0213;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Position
{
	int y;
	int x;
	Position(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}
public class º¸±Þ·Î {

	static Queue<Position> q;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	static int[][] weighted;
	static boolean[][] visit;
	static int size;
	static boolean inside(int y, int x) {
		return (y >= 0 && y < size) && (x >= 0 && x < size);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase= scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			size = scan.nextInt();
			map = new int[size][size];
			visit = new boolean[size][size];
			weighted = new int[size][size];
			q = new LinkedList<>();
			//for(int i=0; i<size; ++i)
			//	for(int j=0; j<size; ++j)
			//		weighted[i][j] = 9999;

			for(int i=0; i<size; ++i)
			{
				String s = scan.next();
				for(int j=0; j<s.length(); ++j)
				{
					map[i][j] = Integer.parseInt(s.charAt(j)+"");
				}
			}
			bfs();
			System.out.println("#"+t+" "+weighted[size-1][size-1]);
		}
	}
	static void bfs()
	{
		q.add(new Position(0,0));
		visit[0][0] = true;
		while(!q.isEmpty())
		{
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			for(int d=0; d<4; ++d)
			{
				int nexty = y + dir[d][0];
				int nextx = x + dir[d][1];
				if(inside(nexty, nextx))
				{
					if(visit[nexty][nextx] == false || weighted[nexty][nextx] > weighted[y][x] + map[nexty][nextx])
					{
						weighted[nexty][nextx] = weighted[y][x] + map[nexty][nextx];
						q.add(new Position(nexty, nextx));
						visit[nexty][nextx] = true;
					}
				}
			}
		}
	}
}
