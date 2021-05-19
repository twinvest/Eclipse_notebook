package day0519;

import java.util.Scanner;
/*
 * https://assb.tistory.com/entry/%EB%B0%B1%EC%A4%80-11726%EB%B2%88-2xn-%ED%83%80%EC%9D%BC%EB%A7%81
 *
 * */
public class BOJ_2xN타일링 {
	static int[] DP = new int[1001];
	public static void main(String[] args) {
		DP[1] = 1;
		DP[2] = 2;
		for(int i =3; i<= 1000; ++i) {
			DP[i] = (DP[i-1] + DP[i-2]) % 10007;
		}
		Scanner scan = new Scanner(System.in);
		System.out.println(DP[scan.nextInt()]);
	}
}
