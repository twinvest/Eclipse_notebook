package day0509;

import java.util.Scanner;

public class 가즈아100문제 {

	public static void main(String[] args) {
		int a, b;
		Scanner scan = new Scanner(System.in);
		a= scan.nextInt();
		b= scan.nextInt();
		if(a > b) System.out.println(">");
		else if (a < b)  System.out.println("<");
		else System.out.println("==");

	}
}
