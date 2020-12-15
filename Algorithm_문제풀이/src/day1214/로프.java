package day1214;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 로프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();

		int[] ans = new int[N+1];
		for(int i = 0; i<N; ++i) {
			int num = scan.nextInt();
			list.add(num);
		}
		Collections.sort(list);
		Collections.reverse(list);

		for(int i = 0; i < list.size(); ++i) {
			ans[i+1] = list.get(i) * (i+1);
		}
		int max = -987654321;
		for(int i = 1; i<ans.length; ++i) {
			if(max < ans[i])
				max = ans[i];
		}
		System.out.println(max);
	}
}