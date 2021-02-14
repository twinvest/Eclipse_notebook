package day0214;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
	static int N;
	static int M;
	static long[] arr;
	static long[] arr2;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N =scan.nextInt();
		arr = new long[N];
		for(int i =0; i<N; ++i) {
			arr[i] = scan.nextLong();
		}
		Arrays.sort(arr);
		int M = scan.nextInt();
		arr2 = new long[M];
		for(int i =0; i<M; ++i) {
			arr2[i] = scan.nextLong();
		}

		for(int i =0; i<M; ++i) {
			ans = 987654321;
			binarySearch(0, arr.length-1, arr2[i]);
			System.out.println(ans == 987654321 ? 0 : ans);
		}

	}
	static int ans = 987654321;
	static void binarySearch(int start, int end, long target) {
		if(start > end) {
			return;
		}
		int mid = (start + end) / 2;
		if(arr[mid] > target) {
			binarySearch(start, mid-1, target);
		} else if (arr[mid] < target) {
			binarySearch(mid+1, end, target);
		} else {
			ans = 1;
			return;
		}
	}
}
