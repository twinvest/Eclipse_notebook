package 수학;

import java.util.Scanner;
public class 행렬제곱 {
	/*
	 * 행렬 A의 B제곱을 구하는 문제
	 * 앞서본 a의b제곱과 동일하다.
	 *
	 * 짝수일때 : A^2B   = A^B * A^B
	 * 홀수일때 : A^2B+1 = A^B * A^2B
	 *
	 * 순수곱셈 시간에 똑같이 O(logb)가 걸리고 행렬곱셈 자체에 O(N^3)이 걸린다.
	 * 따라서, O(N^3 * logb)의 시간복잡도가 나온다.
	 *
	 *
	 * */
    final static int mod = 1000;
    static int[][] multiplication(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                c[i][j] = 0;
                for (int k=0; k<n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
                c[i][j] %= mod;
            }
        }
        return c;
    }

    static void move(int[][] a, int[][] b) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[][] a = new int[n][n];
        int[][] ans = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                ans[i][j] = 0;
            }
            ans[i][i] = 1; //단위행렬
        }

        int[][] temp;
        while (m > 0) {
            if (m%2 == 1) {
                temp = multiplication(ans, a);
                move(ans, temp);
            }
            temp = multiplication(a, a);
            move(a, temp);
            m /= 2;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}