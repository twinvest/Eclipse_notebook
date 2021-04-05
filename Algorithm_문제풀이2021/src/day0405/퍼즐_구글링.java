package day0405;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼즐_구글링 {
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static boolean inside(int y, int x) {
		return y>=0 && y<3 && x>=0 && x<3;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = 0;
		for(int i =0; i<3; ++i) {
			for(int j =0; j<3; ++j) {
				int num = scan.nextInt();
				if(num == 0) num = 9;
				start = start * 10 + num;
			}
		}
		bfs(start);
		if(visitMap.containsKey(123456789)) {
			System.out.println(visitMap.get(123456789));
		}else {
			System.out.println(-1);
		}


	}
	static int ans = -987654321;
	static HashMap<Integer, Integer> visitMap = new HashMap<>();
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visitMap.put(start, 0);


		while(!q.isEmpty()) {
			int curNum = q.poll();
			String cur = curNum+"";
			if(cur.equals("123456789")) {
				break;
			}

			int z = cur.indexOf('9');
			int y = z/3;
			int x = z%3;

			for(int d=0; d<4; ++d) {
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];
				if(inside(ny,nx)) {
					char[] arr = cur.toCharArray();
					char tmpChar = arr[(ny*3) + nx];
					arr[(ny*3) + nx] = '9';
					arr[(y*3)+ x] = tmpChar;
					String tmp = String.valueOf(arr);


					int next = Integer.parseInt(tmp);
					if(!visitMap.containsKey(next)) {
						visitMap.put(next, visitMap.get(curNum)+1);
						q.add(next);
					}
				}
			}
		}
	}
}
