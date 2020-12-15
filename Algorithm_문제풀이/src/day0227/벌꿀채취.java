package day0227;

import java.util.Scanner;

public class 벌꿀채취 {
	static class struct
	{
		int num1;
		int num2;
		struct(int num1, int num2)
		{
			this.num1 = num1;
			this.num2 = num2;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			int N = scan.nextInt(); //배열사이즈
			int M = scan.nextInt(); //풀 수 있는 벌꿀개수
			int C = scan.nextInt(); //벌꿀 담을 수 있는 한계
			int[][] map = new int[N][N];
			for(int i=0; i<N; ++i)
			{
				for(int j=0; j<N; ++j)
				{
					map[i][j] = scan.nextInt();
				}
			}
			int y=0, x=0;
			int max1=-987654321;
			int max2=-987654321;
			int summax = -987654321;
			for(int i=0; i<N; ++i)
			{
				for(int j=0; j<=N-M; ++j)
				{
					int sum = 0;
					for(int k=j; k<j+M; ++k)
					{
						sum += map[i][k];
					}
					if(sum <= C && summax < sum)
					{
						y = i;
						x = j;
						max1 = map[i][j];
						max2 = map[i][j+1];
						summax = sum;
						//map[i][j] > max1 && map[i][j+1] > max2
						//dfs
					}
					//else if(sum > C)
					//{

					//	dfs
					//}
				}
			}
			System.out.println(y+","+x+","+summax+","+max1+","+max2);

		}
	}
}
