package day0221;


import java.util.Arrays;

public class 중복순열 {
	static int[] arr = {1,2,3};
	static int[] result = new int[3];
	public static void main(String[] args) {
		rePerm(0);
	}
	static void rePerm(int idx) {
		if( idx == arr.length ) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for(int i = 0; i < arr.length; i++)
		{
			result[idx] = arr[i];
			rePerm(idx + 1);
			result[idx] = 0;
		}
	}
}