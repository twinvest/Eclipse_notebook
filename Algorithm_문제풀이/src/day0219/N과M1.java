package day0219;

import java.util.Scanner;

public class N과M1 {
	static int[] result;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		result = new int[9];
		visited = new boolean[9];
		perm(0);
	}
	static void perm(int cnt)
	{
		if( cnt == M )
		{
			for(int i=0; i<M; ++i)
			{
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= N; i++)
		{
			if( !visited[i] )
			{
				visited[i] = true;
				result[cnt] = i;
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}
}