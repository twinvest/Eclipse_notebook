package 수학;
/*
 * F0 = 0
 * F1 = 1
 * Fn = Fn-1 + Fn-2
 * 0,1,1,2,3,5,8,13,21,34,55,89,144,...
 * 시간복잡도는 O(n)
 *
 *
 * */

import java.util.Scanner;
public class 피보나치수 {

    public static void main(String args[]) {
    	//method1();
    	method2();
    }

    static void method1() {
    	//45번째 까지는 int형으로 구할 수 있음.
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[50];
        d[0] = 0;
        d[1] = 1;
        for (int i=2; i<=45; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }

    static void method2() {
    	//90까지는 long형으로 구할 수 있음.
    	//90번째 이상부터는 8바이트로도 표현하기 어려워진다. 따라서, 피보나치 수를 K로 나눈 나머지를 구하라는 문제가 출제된다.
    	//근데, 피보나치 수를 K로 나눈 나머지는 항상 주기를 갖는다.
    	//이를 피사노 주기라고한다.
    	//왜 그런지는 피사노주기.java를 봐보자.
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[100];
        d[0] = 0;
        d[1] = 1;
        for (int i=2; i<100; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}