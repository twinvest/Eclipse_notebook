package 수학;

import java.util.Scanner;

public class 행렬곱셈 {
	static int[][] a;
	static int[][] b;
	static int n,m,k;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();
		a = new int[n][m];
		for(int i =0; i<n; ++i) {
			for(int j =0; j<m; ++j) {
				a[i][j] = scan.nextInt();
			}
		}

		m = scan.nextInt();
		k = scan.nextInt();
		b = new int[m][k];
		for(int i =0; i<m; ++i) {
			for(int j =0; j<k; ++j) {
				b[i][j] = scan.nextInt();
			}
		}

		int[][] c = new int[n][k];
		c = multiplication(a,b);
		for(int i=0; i<n; ++i) {
			for(int j=0; j<k; ++j) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int[][] multiplication(int[][] a, int[][] b) {
        int[][] c = new int[n][k];
        for (int i=0; i<n; i++) {
            for (int j=0; j<k; j++) {
                c[i][j] = 0;
                for (int l=0; l<m; l++) {
                    c[i][j] += a[i][l] * b[l][j];
                }
            }
        }
        return c;
    }

}
