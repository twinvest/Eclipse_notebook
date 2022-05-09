package day0509;

import java.util.ArrayList;
import java.util.Scanner;

public class 달팽이 {
	static int N;
	static int M;
	static int[][]map;
	static ArrayList<Integer> ansList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][N];
		int r = N/2;
		int c = N/2;
		int index = 0;
		map[r][c] = ++index;
		for(int k = 1; k<=r; ++k) {
			for(int i = r-k, j = c-k+1; j<=c+k; ++j) {
				map[i][j] = ++index;

			}

			for(int i = r-k+1, j = r+k; i<=r+k; ++i) {
				map[i][j] = ++index;

			}

			for(int i = r+k, j = c+k-1; j>=c-k; --j) {
				map[i][j] = ++index;

			}

			for(int i = r+k-1, j = c-k; i>=r-k; --i) {
				map[i][j] = ++index;

			}
		}
		StringBuilder sb = new StringBuilder();
		int ii = 0, jj = 0;
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(map[i][j] == M) {
					ii = i+1;
					jj = j+1;
				}
				sb.append(map[i][j] +" ");
			}
			sb.append("\n");
		}
		sb.append(ii+" "+jj);

		System.out.println(sb.toString());

	}

}
