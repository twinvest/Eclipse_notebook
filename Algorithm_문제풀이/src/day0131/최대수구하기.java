package day0131;

import java.util.Scanner;

public class 최대수구하기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int[] arr = new int[10];
			int max = -987654321;
			for(int i=0; i<arr.length; ++i)
			{
				arr[i] = scan.nextInt();
				if(arr[i]> max)
					max = arr[i];
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
