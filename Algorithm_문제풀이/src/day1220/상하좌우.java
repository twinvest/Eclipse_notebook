package day1220;

import java.util.Scanner;

public class 상하좌우 {
	static boolean inside(int y, int x, int Size)
	{
		return (y>=1 && y<Size+1) && (x>=1 && x<Size+1);
	}
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		String[] plans = str.split(" ");
		String[] pos = {"R","L","D","U"};
		int[] cur = {1, 1};

		for(String plan : plans) {
			for(int d = 0; d < 4; ++d) {
				int nx = cur[0] + dir[d][1];
				int ny = cur[1] + dir[d][0];
				if(inside(nx, ny, n) && plan.equals(pos[d])) {
					cur[0] = nx;
					cur[1] = ny;
				}
			}
		}
		System.out.println(cur[1]+" "+cur[0]);
	}
}
