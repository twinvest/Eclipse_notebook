package 수학;

/*
 * 백준 코드인데
 * https://giiro.tistory.com/entry/%EB%B0%B1%EC%A4%80-17436-%EC%86%8C%EC%88%98%EC%9D%98-%EB%B0%B0%EC%88%98
 * 아래 url코드 보면 매우 쉽게 이해된다.
 *
 *
 * */

import java.util.Scanner;
public class 소수의배수_재귀 {
    static int n;
    static int[] a;
    static long m;
    static long go(int index, long num) {
        if (index >= n) return 0;
        long ans = 0;
        if (num*a[index] > m) return 0;
        ans += m/(num*a[index]);
        ans += go(index+1, num); //index번째를 포함하지 않는 경우.
        ans -= go(index+1, num*a[index]); //index번째를 포함하는 경우.
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextLong();
        a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(go(0, 1));
    }
}