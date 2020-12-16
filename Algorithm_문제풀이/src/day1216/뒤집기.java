package day1216;

import java.util.Scanner;

public class 뒤집기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String ans = str.charAt(0)+"";
		for(int i =1; i<str.length(); ++i) {
			if(str.charAt(i) == '0' && str.charAt(i-1) != '0') {
				ans += str.charAt(i);
			} else if(str.charAt(i) == '1' && str.charAt(i-1) != '1') {
				ans += str.charAt(i);
			}
		}
		int black = 0;
		int white = 0;
		for(int i = 0; i <ans.length(); ++i) {
			if(ans.charAt(i) == '0') ++white;
			else ++black;
		}

		if(black>=white && ans.length() != 1)
			System.out.println(white);
		else if(black < white && ans.length() != 1)
			System.out.println(black);
		if(ans.length() == 1) {
			System.out.println(0);
		}


	}

}
