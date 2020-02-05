package day0205;

import java.util.Scanner;

public class 간단한압축풀기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int numOfAlpha = scan.nextInt();
			char[] arr =new char[numOfAlpha];
			int[] len =new int[numOfAlpha];
			
			for(int i=0; i<numOfAlpha; ++i)
			{
				arr[i] = scan.next().charAt(0);
				len[i] = scan.nextInt();
			}
			System.out.println("#"+t);
			int index = 0;
			for(int i=0; i<numOfAlpha; ++i)
			{
				for(int j =0; j<len[i]; ++j)
				{
					System.out.print(arr[i]);
					++index;
					if(index==10)
					{
						System.out.println();
						index = 0;
					}							
				}
			}
			System.out.println();
		}
	}
}
