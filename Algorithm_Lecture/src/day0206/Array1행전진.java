package day0206;

import java.util.Scanner;

public class Array1วเภüม๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] arr = new int[N][N];

		for(int i=0; i<N; ++i)
			for(int j=0; j<N; ++j)
				arr[i][j] = scan.nextInt();

		for(int i=N-1; i>0; --i)
		{
			for(int j =0; j<N; ++j)
			{
				arr[i][j] = arr[i-1][j];
			}
			System.out.println();
			System.out.println();
			for(int k=0; k<N; ++k)
			{
				for(int l =0; l<N; ++l)
				{
					System.out.print(arr[k][l]+" ");
				}
				System.out.println();
			}

		}
	}

}
