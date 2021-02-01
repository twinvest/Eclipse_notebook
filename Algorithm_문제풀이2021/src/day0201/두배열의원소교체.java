package day0201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class 두배열의원소교체 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i = 0; i<N; ++i) {
			list1.add(scan.nextInt());
		}
		for(int i = 0; i<N; ++i) {
			list2.add(scan.nextInt());
		}
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.reverse(list2);
		for(int i = 0; i<K; ++i) {
			if(list1.get(i) < list2.get(i)) {
				list1.remove(i);
				list1.add(i, list2.get(i));
			} else {
				break;
			}
		}

		Iterator<Integer> iter = list1.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			 sum += iter.next();
		}
		System.out.println(sum);
	}

}
