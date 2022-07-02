package day1220;

import java.util.Scanner;

public class 왕실의나이트_이코테 {
	public static int[][] dir = {
			 {1,2}
			,{-1,2}
			,{-1,-2}
			,{1,-2}
			,{2,1}
			,{2,-1}
			,{-2,1}
			,{-2,-1}

	};
	public static boolean inside(int y, int x) {
		return (x>=0 && x<8) && (y>=0 && y<8);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String pos = scan.next();
		int x = pos.charAt(0) - 'a';
		int y = Integer.parseInt(pos.charAt(1)+"")-1;
		int count = 0;
		for(int i = 0; i < 8; ++i) {
			int ny = y+dir[i][0];
			int nx = x+dir[i][1];
			if(inside(ny, nx)) ++count;
		}
		System.out.println(count);
	}

}
