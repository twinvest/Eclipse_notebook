package day0221;

import java.util.Arrays;
/*
 *
 * [1, 2]
   [1, 3]
   [1, 4]
   [2, 3]
   [2, 4]
   [3, 4]
 *
 * */
public class 조합 {
	static int[] arr = {1,2,3,4};
	static int[] sel = new int[2];
	static int cnt = 0;
	public static void main(String[] args) {
		combination(0, 0);
		System.out.println(cnt);
	}
	static void combination(int idx, int s_idx) {
		if( s_idx == sel.length )
		{
			System.out.println(Arrays.toString(sel));
			return;
		}
		if( idx == arr.length )
			return;

		sel[s_idx] = arr[idx];
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}
}