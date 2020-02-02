package day0202;

import java.util.Scanner;

public class 알파벳을순자로변환 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		for(int i=0; i<s.length(); ++i)
			System.out.print(s.charAt(i)-64+" ");
	}
}
