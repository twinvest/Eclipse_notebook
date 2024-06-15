package 브루트포스;

import java.util.Scanner;

public class 부분수열의합_6603 {
	static int[] sel;
	static int[] arr;
	static int N,S;
	static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		arr = new int[N];
		for ( int i = 0; i<N; ++i) {
			arr[i] = scan.nextInt();
		}
		for(int i =1; i<=N; ++i) {
			sel = new int[i];
			search(0,0);
		}
		System.out.println(ans);
	}

	static public void search(int idx, int s_idx) {
		if(sel.length == s_idx) {
			int tmpSum = 0;
			for(int i =0; i<sel.length; ++i) {
				tmpSum += sel[i];
			}
			if(tmpSum == S) {
				++ans;
			}
			return;
		}
		if(arr.length == idx) {
			return;
		}
		sel[s_idx] = arr[idx];
		search(idx+1, s_idx+1);
		search(idx+1, s_idx);
	}
}
