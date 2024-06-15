package 브루트포스;

import java.util.Scanner;

public class 로또 {
	static int k;
	static int[] arr;
	static int[] sel;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			k=scan.nextInt();
			if(k==0) break;
			arr = new int[k];
			sel = new int[6];
			for(int i =0; i<k; ++i)
				arr[i] = scan.nextInt();
			combination(0, 0);
			System.out.println();
		}

	}
	static void combination(int idx, int s_idx) {
		if( s_idx == sel.length )
		{
			for(int i =0; i<sel.length; ++i) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if( idx == arr.length )
			return;

		sel[s_idx] = arr[idx];
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}
}
