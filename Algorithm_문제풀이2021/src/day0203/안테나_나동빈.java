package day0203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 안테나_나동빈 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0; i<N; ++i) {
			list.add(scan.nextInt());
		}
		Collections.sort(list);
		System.out.println(list.get((N-1)/2));
	}
}
