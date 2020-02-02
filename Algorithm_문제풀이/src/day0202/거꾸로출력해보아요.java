package day0202;

import java.util.Scanner;

public class 거꾸로출력해보아요 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i=num; i>=0; --i) System.out.print(i+" ");
	}
}
