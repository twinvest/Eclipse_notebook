package DP;

import java.util.Scanner;
/*
 *
 * D[i] = i번에 오는 최소점프 횟수
 *
 * */
public class 점프점프 {
    public static void main(String[] args) {
        //method1();
        method2();
    }

    //  1 ... j ... i  j에서 시작해서 i로 갈 수 있는칸 없는칸을 모두 조사하는 방법.
    static void method1() {
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = -1;
        }
        d[0] = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (d[j] != -1 && i-j <= a[j]) {
                    if (d[i] == -1 || d[i] > d[j] + 1) {
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        System.out.println(d[n-1]);

    }


    // 1 ... i ... j   i에서 j로 갈 수 있는칸만 조사.
    static void method2() {
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = -1;
        }
        d[0] = 0;
        for (int i=0; i<n-1; i++) {
            if (d[i] == -1) //갈 수 없는칸
            	continue;

            for (int j=1; j<=a[i]; j++) {
                if (i+j >= n) {
                    break;
                }
                if (d[i+j] == -1 || d[i+j] > d[i] + 1) {
                    d[i+j] = d[i] + 1;
                }
            }
        }
        System.out.println(d[n-1]);
    }
}