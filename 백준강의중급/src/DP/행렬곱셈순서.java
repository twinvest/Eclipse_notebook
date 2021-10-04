package DP;

import java.util.Scanner;

/*
 * 크기가 N*M인 행렬 A와 M*K인 B를 곱할 때 필요한 곱셈 연산의 수는 총 N*M*K번이다.(직접해보셈. 실제로그렇다.)
 * 행렬 N개를 곱하는데 필요한 곱셈 연산의 수는 행렬을 곱하는 순서에 따라 다르다.
 *
 * 앞서 봤던 '파일합치기'문제처럼 무조건 연속해서 곱해야한다.
 *
 * */
public class 행렬곱셈순서 {
	static int[][] a;
    static int[][] d;

    //i번째부터 j번째까지
    public static int go(int i, int j) {
        if (d[i][j] > 0) {
            return d[i][j];
        }
        //행렬이 하나일 때는 곱할 필요 없음.
        if (i == j) {
            return 0;
        }

        //두개일 때
        if (i+1 == j) {
            return a[i][0]*a[i][1]*a[j][1];
        }
        d[i][j] = -1;

        //k의 범위는 i<=k<j
        //i ... k ... j
        for (int k=i; k<j; k++) {
            int t1 = go(i,k);
            int t2 = go(k+1,j);
            int t3 = a[i][0]*a[k][1]*a[j][1];
            if (d[i][j] == -1 || d[i][j] > t1+t2+t3) {
                d[i][j] = t1+t2+t3;
            }
        }
        return d[i][j];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n][2];
        for (int i=0; i<n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        d = new int[n][n];
        System.out.println(go(0,n-1));
    }
}
