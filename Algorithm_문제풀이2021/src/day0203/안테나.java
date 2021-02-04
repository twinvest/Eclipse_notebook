package day0203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 안테나 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0; i<N; ++i) {
			list.add(scan.nextInt());
		}
		Collections.sort(list);
		int minSum = 987654321;
		int index = -1;
		for(int i = 0; i<list.size(); ++i) {
			int sum = 0;
			int cur = list.get(i);
			for(int j = 0; j<list.size(); ++j) {
				if(i ==j) continue;
				sum += Math.abs(cur - list.get(j));
			}
			if(minSum > sum) {
				minSum = sum;

				index = i;
			}
		}
		System.out.println(list.get(index));
	}

}
