package day0201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class 위에서아래로 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i<N; ++i)
			list.add(scan.nextInt());
		Collections.sort(list);
		Collections.reverse(list);
		for(int a : list) {
			System.out.print(a+" ");
		}

	}

}
