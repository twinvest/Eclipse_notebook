package day0206;

import java.util.Arrays;
import java.util.Scanner;

public class ĳ�����潺 {
	static int[][] position = {{2,2,2,0,0},{2,2,0,2,0},{2,2,0,0,2},{2,0,2,0,2},{2,0,2,2,0},{2,0,0,2,2},{0,2,2,2,0},{0,2,2,0,2},{0,2,0,2,2},{0,0,2,2,2}};
	static int[][] position2 = {{0,1,2},{0,1,3},{0,1,4},{0,2,4},{0,2,3},{0,3,4},{1,2,3},{1,2,4},{1,3,4},{2,3,4}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] ans = new int[10];

		int I =scan.nextInt();
		int J =scan.nextInt();
		int attackDistance = scan.nextInt();

		int[][] map = new int [I+1][J];
		for(int i =0; i<I; ++i)
		{
			for(int j =0; j<J; ++j)
			{
				map[i][j] = scan.nextInt();
			}
		}



		for(int i=0; i<10; ++i)
		{
			//�ü�ä������.
			for(int l=0; l<J; ++l)
				map[I][l] = position[i][l];

			//����. ��, ������ �ǹ�. �ؿ� �ڵ�� ���� �� �ȿ� ������.
			for(int )
			{

			}
			//�ü�����
			//�ϴ� �� ���� �ü� ��ġ���� �Ѹ� ���� �� �ִ»��� ���
			for(int l =0; l<3; ++l)
			{
				int cury = I;
				int curx = position2[i][l];

				//2���������� �Ÿ��ȿ� �ִ� ������ �� ����. for���� ���ʺ��� ������ �Ʒ��� �����ϸ鼭 ����������~~
				out : for(int z=0; z<I; ++z)
				{
					for(int j =0; j<J; ++j)
					{
						if(map[j][z] == 1)
						{
							if(Math.abs(z-cury) + Math.abs(j-curx) <= attackDistance)
							{
								ans[i]++;
								break out;
							}
						}
					}
				}
			}

			//�� ������.
			for(int l=0; l<)

			/*
			for(int l = 0; l<I+1; ++l)
			{
				for(int j =0; j<J; ++j)
				{
					System.out.print(map[l][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
			*/
		}
		Arrays.sort(ans);
		System.out.println(ans[9]);
	}

}