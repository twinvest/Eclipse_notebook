package DP;

import java.util.Scanner;

public class 점프_두번째방법 {

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
	        d[0][0] = 1; //(0,0)은 1개의 방법
	        for (int i=0; i<n; i++) {
	            for (int j=0; j<n; j++) {
	                //칸에 쓰여져있는 수가 0인 경우
	            	if (a[i][j] == 0)
	                	continue;
	                // (i,j) -> (i,j+a[i][j])
	                //오른쪽으로 점프하는 경우
	                if (j+a[i][j] < n) {
	                    d[i][j+a[i][j]] += d[i][j];
	                }
	                // (i,j) -> (i+a[i][j],j)
	                //아래로 점프하는 경우
	                if (i+a[i][j] < n) {
	                    d[i+a[i][j]][j] += d[i][j];
	                }
	            }
	        }
	        System.out.println(d[n-1][n-1]);
	    }
}
