package day0309;

import java.util.Scanner;

public class factorial {
	// n! : n * (n-1)!

	//n! 계산
	private static long factorial(int n)
	{
		//기저(재귀탈출)파트
		if(n == 1) return 1;

		//유도(파생)파트
		return n * factorial(n-1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(factorial(N));
	}

}
