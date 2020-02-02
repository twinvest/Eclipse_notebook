package day0131;

import java.util.Scanner;

public class 홀수만더하기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int[] arr = new int[10];
			int sum = 0;
			for(int i=0; i<arr.length; ++i)
			{
				arr[i] =scan.nextInt();
				if(arr[i] % 2 == 1)
					sum += arr[i];
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}
