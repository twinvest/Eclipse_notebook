package day0208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pos{
	int y;
	int x;
	Pos(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}

public class 농작물수확하기 {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}}; //오른쪽 왼쪽 아래 위
	static boolean inside(int y, int x, int Size)
	{
		return (y>=0 && y<Size) && (x>=0 && x<Size);
	}
	static int calcIndex(int N)
	{
		int sum = 5;
		if(N==3 || N==1) return 1;
		if(N==5) return 5;

		int base = 5;
		int index = 0;
		while(base != N)
		{
			base +=2;
			++index;
		}

		for(int i =1; i<=index; ++i)
		{
			sum += (4 * (i+1));
		}
		return sum;
	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{

			int sum = 0;
			Queue<Pos> q = new LinkedList<>();
			int N = scan.nextInt();
			String[] arr = new String[N];
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			for(int i =0 ; i<N; ++i)
				arr[i] = scan.next();

			for(int i=0; i<N; ++i)
				for(int j=0; j<N; ++j)
					map[i][j] = Integer.parseInt(arr[i].charAt(j)+"");

			int index = calcIndex(N);
			int y = N/2;
			int x = N/2;
			visit[y][x] = true;
			sum += map[y][x];
			q.add(new Pos(y, x));
			for(int i = 0; i<index; ++i)
			{
				Pos p = q.poll();
				y = p.y;
				x = p.x;
				//4방탐색
				for(int d=0; d<4; ++d)
				{
					int nexty = y+dir[d][0];
					int nextx = x+dir[d][1];
					if(inside(nexty, nextx, N) && visit[nexty][nextx]==false)
					{
						sum += map[nexty][nextx];
						visit[nexty][nextx] = true;
						q.add(new Pos(nexty, nextx));
					}
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}