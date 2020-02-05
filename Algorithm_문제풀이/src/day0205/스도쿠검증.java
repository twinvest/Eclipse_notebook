package day0205;

import java.util.Scanner;

public class 스도쿠검증 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int t = 1; t <= testcase; ++t) 
		{
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; ++i)
				for (int j = 0; j < 9; ++j)
					arr[i][j] = scan.nextInt();
			
			boolean flag = true;
			
			// 가로검사
			int[] count = new int[10];
			if (flag) 
			{
				for (int i = 0; i < 9; ++i) 
				{
					for (int j = 0; j < 9; ++j) 
					{
						++count[arr[i][j]];
					}
					for (int j = 1; j < 10; ++j) 
					{
						if (count[j] != 1) 
						{
							flag = false;
							break;
						}
					}
					for (int j = 1; j < 10; ++j)
						count[j] = 0;
				}
			}

			for (int j = 1; j < 10; ++j)
				count[j] = 0;

			// 세로검사
			if (flag) 
			{
				for (int i = 0; i < 9; ++i) 
				{
					for (int j = 0; j < 9; ++j) 
					{
						++count[arr[j][i]];
					}
					for (int j = 1; j < 10; ++j) 
					{
						if (count[j] != 1) {
							flag = false;
							break;
						}
					}
					for (int j = 1; j < 10; ++j)
						count[j] = 0;
				}
			}

			for (int j = 1; j < 10; ++j)
				count[j] = 0;

			// 3by3 9번검사
			if (flag) 
			{
				for(int k=0; k<9; k+=3)
				{
					for(int l=0; l<9; l+=3)
					{
			
						for(int i=k; i<k+3; ++i)
						{
							for(int j=l; j<l+3; ++j)
							{
								++count[arr[i][j]];
							}
						}
						
						for (int j = 1; j < 10; ++j) 
						{
							if (count[j] != 1) 
							{
								flag = false;
								break;
							}
						}
						for (int j = 1; j < 10; ++j)
							count[j] = 0;
					}
				}
			}
			System.out.println("#" + t + " " + (flag ? "1" : "0"));
		}
	}
}