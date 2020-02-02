package day0202;

import java.util.Scanner;

public class 더블더블 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i=0; i<=num; ++i)
			System.out.print((int)Math.pow(2, i)+" ");
	}
}