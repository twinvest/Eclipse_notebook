package day0205;

import java.util.Scanner;

public class 쉬운거스름돈 {
	static int[] arr = {50000,10000,5000,1000,500,100,50,10};

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int[] count = new int[8];
			int num = scan.nextInt();
			for(int i=0; i<8; ++i)
			{
				while(num>0)
				{
					++count[i];
					num -= arr[i];
				}
				if(num != 0)
				{
					num += arr[i];
					--count[i];
				}
			}
			System.out.println("#"+t);
			for(int i=0; i<8; ++i)
				System.out.print(count[i]+" ");
			System.out.println();
		}
	}
}
