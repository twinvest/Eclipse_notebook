package day0213;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치 {
	static long[] map;
	static long numOfWifi;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfHouse = scan.nextInt();
		map = new long[numOfHouse];
		numOfWifi = scan.nextLong();
		for(int i =0; i<numOfHouse; ++i) {
			map[i] = scan.nextLong();
		}
		Arrays.sort(map);

		binarySearch(0,map[numOfHouse-1]);
		System.out.println(ans);

	}
	static long ans = 0;
	static void binarySearch(long start, long end) {
		if(start>end) {
			return;
		}
		long mid = (start + end)/2;
		if(map[0] + (mid * (numOfWifi-1)) > map[map.length-1] ) {
			binarySearch(start, mid-1);
		} else {
			ans = mid;
			binarySearch(mid+1, end);
		}
	}
}
