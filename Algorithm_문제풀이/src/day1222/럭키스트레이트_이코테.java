package day1222;

import java.util.Scanner;

public class 럭키스트레이트_이코테 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int mid = (str.length() / 2) -1;
		String front = str.substring(0, mid+1);
		String back = str.substring(mid+1, str.length());
		int frontNumber = 0;
		int backNumber = 0;

		for(int i = 0; i<front.length();++i) {
			frontNumber += Integer.parseInt(front.charAt(i)+"");
			backNumber += Integer.parseInt(back.charAt(i)+"");
		}
		if(frontNumber == backNumber)
			System.out.println("LUCKY");
		else
			System.out.println("READY");

	}

}
