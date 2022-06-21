package day1217;

import java.util.Scanner;

//못풀었음
public class 볼링공고르기_그리디버전 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int weight = scan.nextInt();
		int[] arr = new int[N];
		int[] weights = new int[weight+1];
		for(int i = 0; i<N; ++i) {
			arr[i] = scan.nextInt();
			++weights[arr[i]];
		}
		int result = 0;
		for(int i = 1; i<weights.length; ++i) {
			N -= weights[i];
			result += weights[i] * N;
		}
		System.out.println(result);
	}

}
