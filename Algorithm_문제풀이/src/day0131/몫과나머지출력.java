package day0131;

import java.util.Scanner;

public class ������������ {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			System.out.println("#"+t+" "+num1/num2+" "+num1%num2);
		}
	}
}
