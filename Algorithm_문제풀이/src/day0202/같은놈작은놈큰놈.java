package day0202;

import java.util.Scanner;

public class °°Àº³ğÀÛÀº³ğÅ«³ğ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		for(int t=1; t<=testcase; ++t)
		{
			int num1= scan.nextInt();
			int num2= scan.nextInt();
			if(num1>num2) System.out.println("#"+t+" "+">");
			else if(num1==num2) System.out.println("#"+t+" "+"=");
			else System.out.println("#"+t+" "+"<");
		}
	}
}
