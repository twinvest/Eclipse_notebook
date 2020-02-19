package day0219;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¹Ì·Î1 {
	static class Pos
	{
		int y;
		int x;
		Pos(int y, int x)
		{
			this.y=y;
			this.x=x;
		}
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean inside(int y, int x)
	{
		return (y>=0 && y<16) && (x>=0 && x<16);
	}
	static boolean flag;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Pos> q;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int t=1; t<=10; ++t)
		{
			scan.nextInt();
			q = new LinkedList<>();
			map = new int[16][16];
			visit = new boolean[16][16];
			for(int i=0; i<16; ++i)
			{
				String tmp = scan.next();
				for(int j=0; j<16; ++j)
					map[i][j] = Integer.parseInt(tmp.charAt(j)+"");

			}
			flag = false;

			visit[1][1] = true;
			q.add(new Pos(1,1));
			bfs();

			if(flag)
				System.out.println("#"+t+" "+"1");
			else
				System.out.println("#"+t+" "+"0");
		}
	}
	static void bfs()
	{
		while(!q.isEmpty())
		{
			Pos
			p = q.poll();
			int y = p.y;
			int x = p.x;
			if(map[y][x] == 3)
			{
				flag = true;
				break;
			}
			for(int d=0; d<4; ++d)
			{
				int nexty = y + dir[d][0];
				int nextx = x + dir[d][1];
				if(!inside(nexty, nextx) || map[nexty][nextx] == 1 || visit[nexty][nextx] == true)
					continue;
				visit[nexty][nextx] = true;
				q.add(new Pos(nexty, nextx));
			}
		}
	}
}