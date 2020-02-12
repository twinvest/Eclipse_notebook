package day0212;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 행렬찾기 {
	static class Pos
	{
		int y;
		int x;
		int xy;
		Pos(int y, int x)
		{
			this.y = y;
			this.x = x;
		}
		Pos(int y, int x, int xy)
		{
			this(y,x);
			this.xy = xy;
		}
	}
	static boolean inside(int y, int x)
	{
		return (y>=0 && y <N) && (x>=0 && x<N);
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visit;
	static int[][] map;
	static int N;
	static ArrayList<Pos> list;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			ArrayList<Pos> list2 = new ArrayList<>();;
			N = scan.nextInt();
			map = new int[N][N];

			for(int i=0; i<N; ++i)
				for(int j=0; j<N; ++j)
					map[i][j] = scan.nextInt();

			int count = 0;
			visit = new boolean[N][N];

			for(int i=0; i<N; ++i)
			{
				for(int j=0; j<N; ++j)
				{
					if(!visit[i][j] && map[i][j] != 0)
					{
						list = new ArrayList<>();
						list.add(new Pos(i,j));
						dfs(i,j);
						++count;
						int maxy = 0;
						int maxx = 0;
						for(int k = 0; k<list.size(); ++k)
						{
							int cury = list.get(k).y;
							int curx = list.get(k).x;
							if(curx*cury >= maxx*maxy)
							{
								maxy=cury;
								maxx=curx;
							}
							//System.out.println(list.get(k).y+","+list.get(k).x);
						}
						int finaly = maxy-i+1;
						int finalx = maxx-j+1;
						list2.add(new Pos(finaly, finalx, finalx*finaly));
						//System.out.println("끝");

					}
				}
			}
			//for(int i=0; i<list2.size(); ++i)
				//System.out.println(list2.get(i).y+","+list2.get(i).x+","+list2.get(i).xy);
				//list.get(i)
			list2.sort(new Comparator<Pos>() {
				@Override
				public int compare(Pos p1, Pos p2)
				{
					int xy1 = p1.xy;
					int xy2 = p2.xy;
					if(xy1 > xy2) return 1;
					else if(xy1 == xy2)
					{
						if(p1.y > p2.y)
						{
							return 1;
						}
						else
							return -1;
					}
					else return -1;
				}
			});

			System.out.print("#"+t+" "+count+" ");
			for(int i=0; i<list2.size(); ++i)
			{
				System.out.print(list2.get(i).y+" "+list2.get(i).x+" ");
			}
			System.out.println();
		}
	}

	static void dfs(int y, int x)
	{
		visit[y][x] = true;
		for(int d=0; d<4; ++d)
		{
			int nexty = y + dir[d][0];
			int nextx = x + dir[d][1];
			if(!inside(nexty,nextx) || map[nexty][nextx] == 0 || visit[nexty][nextx]==true)
				continue;
			list.add(new Pos(nexty, nextx));
			dfs(nexty, nextx);
		}
	}
}