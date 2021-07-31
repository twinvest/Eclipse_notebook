package day0730;

import java.util.Scanner;

public class 캠프준비 {
	static int[] arr, sel;
	static int N,L,R,X,ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		L = scan.nextInt();
		R = scan.nextInt();
		X = scan.nextInt();

		arr = new int[N];
		for(int i =0; i<N; ++i)
			arr[i] = scan.nextInt();

		for(int i =2; i<=N;++i) {
			sel = new int[i];
			combination(0, 0);
		}

		System.out.println(ans);

	}
	static void combination(int idx, int s_idx) {
		if( s_idx == sel.length )
		{
			int sum = 0;
			int min = 987654321;
			int max = -987654321;
			for(int i=0; i<sel.length;++i) {
				if(min > sel[i])
					min = sel[i];
				if(max < sel[i])
					max = sel[i];
				sum += sel[i];
			}
			if(max-min >= X && sum>=L && sum<=R) {
				++ans;
			}
			return;
		}
		if( idx == arr.length )
			return;

		sel[s_idx] = arr[idx];
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}
}
