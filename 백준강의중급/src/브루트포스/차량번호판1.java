package 브루트포스;

import java.util.Scanner;

public class 차량번호판1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int ans = go(s,0,' ');
		System.out.println(ans);
	}

	static int go(String s, int index, char last) {
		if(s.length() == index) {
			return 1;
		}

		char start = (s.charAt(index) == 'c' ? 'a' : '0');
		char end = (s.charAt(index) == 'c' ? 'z' : '9');
		int ans = 0;
		for(char i = start; i<=end; ++i) {
			if( i != last ) {
				ans += go(s, index+1, i);
			}
		}
		return ans;
	}

}
