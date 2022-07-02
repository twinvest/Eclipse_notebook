package day1217;

import java.util.Scanner;

public class 볼링공고르기_조합버전_이코테 {


		static int[] arr;
		static int[] sel = new int[2];
		static int count = 0;
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int N = scan.nextInt();
			arr = new int[N];
			int weight = scan.nextInt();
			for(int i =0; i<arr.length; ++i)
				arr[i] = scan.nextInt();
			combination(0, 0);
			System.out.println(count);
		}
		static void combination(int idx, int s_idx) {
			if( s_idx == sel.length )
			{
				if(sel[0] == sel[1]) {
					return;
				}else {
					++count;
					return;
				}
			}
			if( idx == arr.length )
				return;
			sel[s_idx] = arr[idx];
			combination(idx+1, s_idx+1);
			combination(idx+1, s_idx);

	}

}
