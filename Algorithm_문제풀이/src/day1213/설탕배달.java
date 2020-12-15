package day1213;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count = 0;
		while(true) {
			if( N % 5 == 0) {
				count += (N/5);
				System.out.println(count);
				break;
			}
			N -= 3;
			count++;
			if( N == 0 ) {
				System.out.println(count);
				break;
			}

			if(N < 0 ) {
				System.out.println("-1");
				break;
			}
		}
	}
}