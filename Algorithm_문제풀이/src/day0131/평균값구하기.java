package day0131;

import java.util.Scanner;

public class 평균값구하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			double sum = 0;
			double[] arr = new double[10];
			for(int i=0; i<arr.length; ++i)
			{
				arr[i] =scan.nextInt();
				sum += arr[i];
			}
			int avg = (int)Math.round(sum/10);
			System.out.println("#"+t+" "+avg);
		}
	}
}