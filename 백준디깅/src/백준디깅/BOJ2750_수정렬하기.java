package 백준디깅;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2750_수정렬하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0; i<n; ++i) {
			int a = scan.nextInt();
			list.add(a);
		}
		Collections.sort(list);
		for(int i =0; i<list.size(); ++i) {
			System.out.println(list.get(i));
		}
	}
}
