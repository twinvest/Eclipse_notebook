package day0127;

import java.util.ArrayList;
import java.util.Scanner;

public class 알파벳 {
	static boolean inside(int y, int x) {
		return (y>=0 && y<R) && (x>=0 && x<C);
	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static ArrayList<Character> visitList = new ArrayList<>();
	static Character[][] map;
	static int R;
	static int C;
	static int maxNum = -987654321;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		map = new Character[R][C];
		for(int i = 0; i<R; ++i) {
			String line = scan.next();
			for(int j =0; j<line.length(); ++j) {
				map[i][j] = line.charAt(j);
			}
		}

		dfs(0,0);
		visitList.remove(map[0][0]); //마지막 백트래킹. 처음 집어넣어줬던 (0,0)의 좌표까지 깔끔하게 빼준다.
		System.out.println(maxNum);
	}

	static void dfs(int y, int x) {
		visitList.add(map[y][x]);
		maxNum = Math.max(maxNum, visitList.size());
		for(int d =0; d<4; ++d) {
			int ny = y + dir[d][0];
			int nx = x + dir[d][1];
			//범위가 합당하거나 아직 방문하지 않은 알파벳이라면
			if(inside(ny, nx) && !visitList.contains(map[ny][nx])) {
				dfs(ny, nx);
				//dfs를 끝내고 돌아왔을때는 방문한것을 제거해준다.
				visitList.remove(map[ny][nx]);
			}
		}
	}
}