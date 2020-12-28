package day1228;

import java.util.ArrayList;
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
	static class ChickenLoad {
		int y;
		int x;
		int r;
		ChickenLoad(int y, int x, int r){
			this.y=y;
			this.x=x;
			this.r = r;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt(); //고르는 개수
		int[][] map = new int[N][N];
		ArrayList<Pos> house = new ArrayList<>();
		ArrayList<Pos> chickenShop = new ArrayList<>();
		ArrayList<Pos> selChickenShop = new ArrayList<>(M);

		for(int i = 0 ; i < N; ++i) {
			for(int j = 0 ; j < N; ++j) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 2)
					chickenShop.add(new Pos(i, j));
				if(map[i][j] == 1)
					house.add(new Pos(i, j));
			}
		}
		combination(0, 0, chickenShop, selChickenShop,M);


		/*
		ArrayList<ChickenLoad> chickenLoad = new ArrayList<>();
		for(Pos pos : chickenShop) {
			int x1 = pos.x;
			int y1 = pos.y;
			int rSum = 0;
			for(Pos homePos : house) {
				int x2 = homePos.x;
				int y2 = homePos.y;
				int r = Math.abs(x1-x2) + Math.abs(y1-y2);
				rSum += r;
			}
			chickenLoad.add(new ChickenLoad(y1, x1, rSum));
		}

		for(ChickenLoad chken : chickenLoad) {
			System.out.println(chken.y+","+chken.x+","+chken.r);
		}
	*/

	}

	static void combination(int idx, int s_idx, ArrayList<Pos> chickenShop, ArrayList<Pos> selChickenShop, int M) {
		if( s_idx == M )
		{
			for(Pos pos : selChickenShop) {
				System.out.println(pos.y + "," +pos.x);
			}
			System.out.println();
			return;
		}
		if( idx == chickenShop.size() )
			return;

		selChickenShop.add(chickenShop.get(idx));
		combination(idx+1, s_idx+1, chickenShop,selChickenShop,M);
		combination(idx+1, s_idx, chickenShop,selChickenShop,M );
	}

}
