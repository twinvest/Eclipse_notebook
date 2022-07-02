package day0510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {
	static int L,C;
	static String[] arr;
	static String[] sel;
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		L = scan.nextInt();
		C = scan.nextInt();

		arr = new String[C];
		sel = new String[L];

		for(int i =0; i<C; ++i) {
			arr[i] = scan.next();
		}
		Arrays.sort(arr);
		list.add("a"); list.add("e"); list.add("i"); list.add("o"); list.add("u");
		search(0,0);
	}

	static void search(int idx, int s_idx) {
		if(sel.length == s_idx) {
			int mCount = 0; //모음카운트
			int jCount = 0; //자음카운트
			for ( int i = 0; i<sel.length; ++i ) {
				String tmp = sel[i];
				if(list.contains(tmp)) ++mCount;
				else ++jCount;
			}

			if(mCount >= 1 && jCount >=2) {
				for(int  i = 0; i<sel.length; ++i) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			return;
		}
		if(arr.length == idx) {
			return;
		}
		sel[s_idx] = arr[idx];
		search(idx+1, s_idx+1);
		search(idx+1, s_idx);

	}
}
