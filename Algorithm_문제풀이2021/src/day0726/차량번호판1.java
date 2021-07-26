package day0726;

import java.util.Scanner;

public class 차량번호판1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int ans = 1;
		char c = s.charAt(0);
		if( c == 'c') {
			ans = 26;
		} else {
			ans = 10;
		}
		char prev = c;
		for(int i = 1; i<s.length(); ++i) {
			char cur = s.charAt(i);
			if(prev == cur) {
				if(cur == 'c') {
					ans *= 25;
				} else {
					ans *= 9;
				}
			} else {
				if(cur == 'c') {
					ans *= 26;
				} else {
					ans *= 10;
				}
			}
			prev = cur;
		}
		System.out.println(ans);
	}

}
