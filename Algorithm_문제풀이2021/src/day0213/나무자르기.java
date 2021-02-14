package day0213;

import java.util.Scanner;

public class 나무자르기 {
	static long[] list;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long target = scan.nextLong();
		long max = -987654321;
		list = new long[N];
		for(int i =0; i<N; ++i) {
			long num = scan.nextLong();
			list[i] = num;
			if(max<num)
				max = num;
		}
		binarySearch(0, max, target);
		System.out.println(ans);
	}
	static long ans = 987654321;
	static void binarySearch(long start, long end, long target) {

		if(start > end) {
			return;
		}

		long mid = (start + end) / 2;
		long total = 0;
		for(int i = 0; i<list.length; ++i) {
			if(list[i]>mid) {
				total += list[i] - mid;
			}
		}
		//떡의 양이 모자른 경우
		if(total < target) {
			//끝을 줄여 왼쪽부분탐색
			binarySearch(start, mid-1, target);
		}
		//떡의 양이 목표보다 넘치는 경우
		else if(total >= target) {
			ans = mid;
			//시작점을 늘려 오른쪽부분탐색
			binarySearch(mid+1, end, target);
		}
	}
}