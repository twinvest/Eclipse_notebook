package day0130;

import java.util.Arrays;

public class ¼ø¿­ {
	static int[] arr = {1,2,3};
	static int[] result = new int[arr.length];
	static boolean[] visited = new boolean[arr.length];
	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int idx) {
		if( idx == result.length ) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			if( !visited[i] ) {
				result[idx] = arr[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}