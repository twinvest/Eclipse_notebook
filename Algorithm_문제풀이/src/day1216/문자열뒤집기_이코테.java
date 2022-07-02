package day1216;

import java.util.Scanner;

public class 문자열뒤집기_이코테 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String ans = str.charAt(0)+"";
		//덩어리들을 압축한다.
		for(int i =1; i<str.length(); ++i) {
			if(str.charAt(i) == '0' && str.charAt(i-1) != '0') {
				ans += str.charAt(i);
			} else if(str.charAt(i) == '1' && str.charAt(i-1) != '1') {
				ans += str.charAt(i);
			}
		}

		int black = 0;
		int white = 0;
		//압축된덩어리의 개수를 센다. 길이가 더 짧은게 정답이다.
		for(int i = 0; i <ans.length(); ++i) {
			if(ans.charAt(i) == '0') ++white;
			else ++black;
		}

		if(black>=white && ans.length() != 1)
			System.out.println(white);
		else if(black < white && ans.length() != 1)
			System.out.println(black);
		//덩어리를 압축한 길이가 1이란것은 1111111111111이런 경우이다.
		if(ans.length() == 1) {
			System.out.println(0);
		}
	}
}
