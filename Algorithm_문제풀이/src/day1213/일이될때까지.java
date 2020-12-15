package day1213;

import java.util.Scanner;

public class 일이될때까지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int count = 0;
		while( n != 1) {
			if( n % k == 0) {
				n /= k;
				++count;
			} else {
				n -= 1;
				++count;
			}
		}
		System.out.println(count);
	}

}
