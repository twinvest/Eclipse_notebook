package DP;

import java.util.Scanner;

public class 팰린드롬물음표_BottomUp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        boolean[][] d = new boolean[n][n];

        //길이가 1인 것들을 대상으로 먼저 dp배열 업데이트 시켜준다.
        for (int i=0; i<n; i++) {
            d[i][i] = true;
        }

        //길이가 2인 것들을 대상으로 먼저 dp배열 업데이트 시켜준다.
        for (int i=0; i<n-1; i++) {
            if (a[i] == a[i+1]) {
                d[i][i+1] = true;
            }
        }

        for (int k=3; k<=n; k++) { //길이가 3인것부터 다시 확인해준다.
            for (int i=0; i<=n-k; i++) { //시작위치 i
                int j = i+k-1;           //시작위치 i와 길이 k를 가지고 끝위치 j를 구해준거임.
                if (a[i] == a[j] && d[i+1][j-1]) {
                    d[i][j] = true;
                }
            }
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            if (d[s-1][e-1]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}