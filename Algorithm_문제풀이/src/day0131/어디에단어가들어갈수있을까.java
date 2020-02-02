package day0131;

import java.util.Scanner;

public class 어디에단어가들어갈수있을까 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase=scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int N =scan.nextInt();
			int lenOfword = scan.nextInt();
			int[][] arr =new int[N][N];
			for(int i =0; i<N; ++i)
				for(int j=0; j< N; ++j)
					arr[i][j] = scan.nextInt();
			
			int ans = 0;
			//가로
			for(int i =0; i<N; ++i)
			{
				int count = 0;
				int j = 0;
				while(true)
				{
					if(arr[i][j] == 0)
					{
						if(count == lenOfword) ans++;
						count = 0;
						++j;
					}else 
					{
						count++;
						j++;
					}
					if(j==N)
					{
						if(count == lenOfword) ans++;
						break;
					}
				}
			}
			//세로
			for(int j =0; j<N; ++j)
			{
				int count = 0;
				int i = 0;
				while(true)
				{
					if(arr[i][j] == 0)
					{
						if(count == lenOfword) ans++;
						count = 0;
						++i;
					}else 
					{
						count++;
						i++;
					}
					if(i==N)
					{
						if(count == lenOfword) ans++;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
