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
			{-1,0}//,
			//{-1,-1},
			//{-1,1},
			//{1,1},
			//{1,-1}
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		String[] plan = str.split(" ");
		int y = 1, x = 1;
		for(String a : plan) {
			if(a.equals("L") && inside(y,x-1, n)) {
				y = y;
				x = x - 1;
			}
			if(a.equals("R") && inside(y,x+1, n)) {
				y = y;
				x = x + 1;
			}
			if(a.equals("U") && inside(y-1,x, n)) {
				y = y - 1;
				x = x;
			}
			if(a.equals("D") && inside(y+1,x, n)) {
				y = y + 1;
				x = x;
			}
		}
		System.out.println(y+" "+x);
	}

}
