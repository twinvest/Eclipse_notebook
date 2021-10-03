package DP;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/11060 점프점프 문제의 2차원 버전이라고 보면 된다.
 *
 *  두가지 방법으로 풀어보자.
 *  첫번째는 D[i][j] = (i,j)칸에 갈 수 있는 경로의 개수
 *  (1,1) => (?,?) => (?,?) => (?,?) => (?,?) => (i,j)
 *  (i,j)는 반드시 왼쪽 또는 위쪽에서 왔을것이다.
 *  ㄱ. 왼쪽에서온 경우 D[i][k] (k의 범위는 k<j, j-k == A[i][k] )
 *  ㄴ. 위에서 온 경우 D[k][j] (k의 범위는 k<i i-k == A[k][j])
 *
 *
 *
 * */
public class 점프 {
	static int[][] a = new int[100][100];
    static long[][] d = new long[100][100];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        d[0][0] = 1; //(0,0)에 갈수있는 방법은 1가지.

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0) continue;
                // (i,k+a[i][k]) -> (i,j)
                //왼쪽에서 온 경우를 계산
                for (int k=0; k<j; k++) {
                    if (k+a[i][k] == j) {
                        d[i][j] += d[i][k];
                    }
                }
                // (k+a[k][j],j) -> (i,j)
                //위에서 온 경우를 계산
                for (int k=0; k<i; k++) {
                    if (k+a[k][j] == i) {
                        d[i][j] += d[k][j];
                    }
                }
            }
        }
        System.out.println(d[n-1][n-1]);
    }
}
