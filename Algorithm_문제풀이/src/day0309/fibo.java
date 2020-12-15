package day0309;

import java.util.Scanner;

public class fibo {
	private static long fibo(int n){
		if(n<=1) return n;
		return fibo(n-1) + fibo(n-2);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(fibo(N));
	}
}