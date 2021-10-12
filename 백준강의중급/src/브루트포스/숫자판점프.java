package 브루트포스;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 숫자판점프 {
	static Set<Integer> ans = new HashSet<>();
	static int[][] map = new int[5][5];
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i =0; i<5; ++i) {
			for(int j =0; j<5; ++j) {
				map[i][j] = scan.nextInt();
			}
		}

		for(int i =0; i<5; ++i) {
			for(int j =0; j<5; ++j) {
				go(i,j,map[i][j],1);
			}
		}

		System.out.println(ans.size());
	}

	static void go(int x, int y, int num, int len) {
		if(len == 6) {
			ans.add(num);
			return;
		}

		for(int d=0; d<4; ++d) {
			int nx = x+dir[d][0];
			int ny = y+dir[d][1];
			if(0<=nx && nx<5 && 0<=ny && ny<5) {
				go(nx, ny, num*10+map[nx][ny], len+1);
			}
		}
	}
}
