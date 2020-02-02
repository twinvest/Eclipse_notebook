package day0202;

import java.util.Scanner;

public class 일대일가위바위보 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		if(num1>num2)
		{
			if(num1 == 3 && num2==1)
			{
				System.out.println("B");
				return;
			}
			System.out.println("A");
		}
		else
		{
			if(num2 == 3 && num1==1)
			{
				System.out.println("A");
				return;
			}
			System.out.println("B");
		}
	}
}
