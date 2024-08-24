package day0221;

import java.util.Arrays;

public class 순열 {
	static int[] arr = {0,0,0,1,1};
	static int[] result = new int[arr.length];
	static boolean[] visited = new boolean[arr.length];
	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int depth) {
		if( depth == result.length ) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i = 0; i < arr.length; i++) {

			if( !visited[i] ) {
				result[depth] = arr[i];
				visited[i] = true;

				perm(depth + 1);

				visited[i] = false;
				result[depth] = 0;
			}
		}
	}
}