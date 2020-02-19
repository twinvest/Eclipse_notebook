package day0219;

import java.util.Arrays;

public class ¼ø¿­ {
	static int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	public static void main(String[] args) {
		perm(0);
	}

	static void perm(int idx)
	{
		if(idx == arr.length)
		{
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i = idx; i < arr.length; i++)
		{
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}

	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
