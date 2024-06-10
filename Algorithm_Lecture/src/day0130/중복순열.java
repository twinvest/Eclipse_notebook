package day0130;

import java.util.Arrays;

public class 중복순열 {
	static int[] arr = {1,2,3};
	static int[] sel = new int[arr.length];
	public static void main(String[] args) {
		rePerm(0);
	}
	static void rePerm(int idx) {
		if( idx == sel.length ) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for(int i = 0; i < arr.length; i++)
		{
			sel[idx] = arr[i];
			rePerm(idx + 1);
		}

		/*
		sel[idx] = arr[0];
		rePerm(idx+1);
		sel[idx] = arr[1];
		rePerm(idx+1);
		sel[idx] = arr[2];
		rePerm(idx+1);
		*/
	}
}