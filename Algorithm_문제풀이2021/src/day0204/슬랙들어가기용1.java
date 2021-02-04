package day0204;

import java.util.Scanner;

public class 슬랙들어가기용1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		String s = B+"";
		for(int i = s.length()-1; i>=0; --i) {
			int num = Integer.parseInt(s.charAt(i)+"");
			System.out.println(A * num);
		}
		System.out.println(A*B);
	}

}
