package day0213;

import java.util.ArrayList;
import java.util.Scanner;

public class ÄíÆÎ {
	static class Pos {
		int y;
		int x;
		int time;
		int value;
		Pos(int y, int x, int time, int value) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.value = value;
		}
	}

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static boolean inside(int y, int x) {
		return (y >= 0 && y < size) && (x >= 0 && x < size);
	}

	static boolean[][] visit;
	static int size;
	static int[][] map;
	static ArrayList<Pos> list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		list = new ArrayList<>();
		size = scan.nextInt();
		map = new int[size][size];
		visit = new boolean[size][size];
		for(int i=0; i<size; ++i)
		{
			for(int j=0; j<size; ++j)
			{
				int time = scan.nextInt();
				int value = scan.nextInt();
				list.add(new Pos(i, j, time, value));
			}
		}

		int ans = dfs(0, 0 ,0);
		System.out.println(ans);
	}
	static int maxim = -987654321;
	static int dfs(int y, int x, int curtime) {
		visit[y][x] = true;
		int value = 0;
		int time = 0;
		for(int i=0; i<list.size(); ++i)
		{
			if(list.get(i).y == y && list.get(i).x == x)
			{
				value = list.get(i).value;
				time = list.get(i).time;
			}
		}
		int tmp = value;
		if(curtime <= time)
		{
			int nexttime = 0;
			for (int d = 0; d < 4; ++d)
			{
				int nexty = y + dir[d][0];
				int nextx = x + dir[d][1];
				for(int i=0; i<list.size(); ++i)
				{
					if(list.get(i).y == nexty && list.get(i).x == nextx)
					{
						nexttime = list.get(i).time;
					}
				}
				if (!inside(nexty, nextx) || visit[nexty][nextx] == true)
					continue;
				if(time == curtime)
					value = value - tmp;
				value += dfs(nexty, nextx, curtime+1);
			}
		}

		return maxim = Math.max(value, maxim);
	}
}