package 그리디;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 삼십 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<s.length(); ++i) {
			list.add(Integer.parseInt(s.charAt(i)+"") );
		}

		if(list.size()>100000) {
			System.out.println(-1);
			System.exit(-1);
		}

		Collections.sort(list, Collections.reverseOrder());


		if(list.get(list.size()-1) != 0) {
			System.out.println(-1);
		}else {
			String answer = "";
			for(int i =0; i<list.size(); ++i)
				answer += list.get(i);

			BigInteger num1 = new BigInteger(answer);
			BigInteger num2 = new BigInteger("30");
			if(Integer.parseInt(num1.remainder(num2).toString())  == 0) {
				System.out.println(answer);
			}else {
				System.out.println(-1);
			}
		}

	}

}
