package day0213;

import java.util.Scanner;

public class 나무자르기 {
	static int[] list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int target = scan.nextInt();
		int max = -987654321;
		list = new int[N];
		for(int i =0; i<N; ++i) {
			int num = scan.nextInt();
			list[i] = num;
			if(max<num)
				max = num;
		}
		binarySearch(0, max, target);
		System.out.println(ans);
	}
	static int ans = 987654321;
	static void binarySearch(int start, int end, int target) {
		int total = 0;
		if(start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		for(int i = 0; i<list.length; ++i) {
			if(list[i]>mid) {
				total += list[i] - mid;
			}
			if(total == target) {
				ans = mid;
				return;
			}
		}
		if(total < target) {
			ans = mid;
			binarySearch(start, mid-1, target);
		} else {
			ans = mid;
			binarySearch(mid+1, end, target);
		}
	}
}