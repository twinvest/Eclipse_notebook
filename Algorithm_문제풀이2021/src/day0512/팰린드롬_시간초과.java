package day0512;

import java.util.Scanner;

public class 팰린드롬_시간초과 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N];
		for ( int i = 0; i < N; ++i ) {
			arr[i] = scan.nextInt();
		}
		int M = scan.nextInt();

		for ( int i =0; i<M; ++i) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			if(isPalindrome(start-1, end-1)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	public static boolean isPalindrome(int s, int e) {
	    while(s < e) {
	        if(arr[s++] != arr[e--]) {
	            return false;
	        }
	    }
	    return true;
	}

}
