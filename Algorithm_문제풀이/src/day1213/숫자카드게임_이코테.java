package day1213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 숫자카드게임_이코테 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int y = scan.nextInt();
		int x = scan.nextInt();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for ( int i =0; i < y; ++i ) {
			ArrayList<Integer> subList = new ArrayList<>();
			for (int j = 0; j<x; ++j) {
				int num = scan.nextInt();
				subList.add(num);
			}
			Collections.sort(subList);
			list.add(subList);
		}
		int max = -987654321;
		for(int i =0;i <y; ++i) {
			if(max < list.get(i).get(0)) {
				max = list.get(i).get(0);
			}
		}
		System.out.println(max);
	}
}
