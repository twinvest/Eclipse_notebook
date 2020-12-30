package day1229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 치킨배달 {
	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
	static Pos[] arr;
	static Pos[] sel;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt(); //고르는 개수
		int[][] map = new int[N][N];
		ArrayList<Pos> house = new ArrayList<>();
		ArrayList<Pos> chickenShop = new ArrayList<>();

		for(int i = 0 ; i < N; ++i) {
			for(int j = 0 ; j < N; ++j) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 2)
					chickenShop.add(new Pos(i, j));
				if(map[i][j] == 1)
					house.add(new Pos(i, j));
			}
		}

		arr = new Pos[chickenShop.size()];
		for(int i = 0; i < chickenShop.size(); ++i) {
			arr[i] = chickenShop.get(i);
		}
		sel = new Pos[M];
		combination(0, 0, house);
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	static public void combination(int idx, int s_idx, ArrayList<Pos> house) {
		if(s_idx == sel.length) {
			int rSum = 0;
			for(Pos home : house) {
				int x1 = home.x;
				int y1 = home.y;
				int minR = 987654321;
				for(Pos chikenPos : sel) {
					int x2 = chikenPos.x;
					int y2 = chikenPos.y;
					int r = Math.abs(x1-x2) + Math.abs(y1-y2);
					if(r < minR) {
						minR = r;
					}
					//System.out.print("["+chikenPos.y+","+chikenPos.x+"]");
				}
				rSum += minR;
			}
			list.add(rSum);
			return;
		}
		if(idx == arr.length) {
			return;
		}
		sel[s_idx] = arr[idx];

		combination(idx+1, s_idx+1, house);
		combination(idx+1, s_idx, house);
	}

}
