package day1212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 큰수의법칙_이코테 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		int sum = 0 ;
		int[] arr = new int[2];

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i<n; ++i)
			list.add(scan.nextInt());
		Collections.sort(list);
		Collections.reverse(list);

		arr[0] = list.get(0);
		arr[1] = list.get(1);
		int flag = 0;
		for(int i = 1; i <= m; ++i) {
			if( flag != k ) {
				sum += arr[0];
				System.out.print(arr[0]+" ");
				++flag;
			} else {
				sum += arr[1];
				System.out.print(arr[1]+" ");
				flag = 0;
			}
		}
		System.out.println();
		System.out.println(sum);
	}
}
