package day0214;

import java.util.Scanner;

public class 랜선자르기 {
	static long[] map;
	static int target;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		target = scan.nextInt();
		map = new long[n];
		for(int i =0; i<n;++i) {
			map[i] = scan.nextLong();
		}
		binarySearch(0,Long.MAX_VALUE);
		System.out.println(ans);
	}
	static long ans = 0;
	static void binarySearch(long start, long end) {
		if(start > end) {
			return;
		}
		long mid = (start + end) /2;
		long cnt = 0;
		for(int i =0; i<map.length; ++i) {
			cnt += (map[i] / mid);
		}

		if(cnt < target) {
			binarySearch(start, mid-1);
		}else {
			ans = mid;
			binarySearch(mid+1, end);
		}
	}
}
