package day0219;

import java.util.Scanner;

public class º£½ÃÀÇ²Þ {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean inside(int y, int x)
	{
		return (N>y && y>=0) && (M>x && x>=0);
	}
	static int N,M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		for(int i = 0; i<N; ++i)
			for(int j=0; j<M; ++j)
				map[i][j] = scan.nextInt();

		for(int i = 0; i<N; ++i)
		{
			for(int j=0; j<M; ++j)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
