package day0202;

import java.util.Scanner;

public class 연월일달력 {
	public static void main(String[] args)
	{		
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			String s = scan.next();
			
			String sub1 = s.substring(4, 6);
			String sub2 = s.substring(6, 8);
			
			int num1 = Integer.parseInt(sub1);
			int num2 = Integer.parseInt(sub2);
		
		}
	}
}
