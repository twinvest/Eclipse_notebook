package day1222;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열재정렬 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		ArrayList<Character> alphabetic = new ArrayList<>();
		int numeric = 0;
		for(int i = 0 ; i < str.length(); ++i) {
			if(Character.isAlphabetic(str.charAt(i))) {
				alphabetic.add(str.charAt(i));
			} else {
				numeric += Integer.parseInt(str.charAt(i)+"");
			}
		}
		Collections.sort(alphabetic);
		str = "";
		for(char c : alphabetic) {
			str += c;
		}
		str += numeric;
		System.out.println(str);

	}

}
