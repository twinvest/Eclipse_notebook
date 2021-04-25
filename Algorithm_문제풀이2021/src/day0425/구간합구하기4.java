package day0425;

import java.util.Scanner;

public class 구간합구하기4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int T = scan.nextInt();
		int[] arr = new int[N];
		int[] sumArr = new int[N+1];
		int sum = 0;
		for(int i=0; i<N; ++i) {
			arr[i] = scan.nextInt();
			sum += arr[i];
			sumArr[i+1] = sum;
		}
		for(int t =0; t<T; ++t) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(sumArr[b] - sumArr[a-1]);
		}
	}

}
