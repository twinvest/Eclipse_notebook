package day0221;

import java.util.Arrays;

public class 조합 {
	static int[] arr = {1,2,3};
	static int[] sel = new int[2];
	static int cnt = 0;
	public static void main(String[] args) {
		cnt++;
		combination(0, 0);
		System.out.println(cnt);
	}
	static void combination(int idx, int s_idx) {
		if( s_idx == sel.length )
		{
			//다고른곳
			System.out.println(Arrays.toString(sel));
			return;
		}
		//더이상 고를게 없는것
		if( idx == arr.length )
			return;

		sel[s_idx] = arr[idx];
		cnt++;
		combination(idx+1, s_idx+1);
		cnt++;
		combination(idx+1, s_idx);
	}
}