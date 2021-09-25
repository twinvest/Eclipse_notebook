package 수학;
/*
 *
 * N번째 피보나치 수를 M = 1000000007으로 나눈 나머지를 구하는 문제.
 * N <= 1,000,000,000,000,000,000
 * 주기가 어떻게 될 지 알 수 없다.
 *
 * 행렬곱을 이용해보자.
 * Fn = Fn-1 + Fn-2
 *
 * ( Fn ) =  (1  1) (Fn-1)
 * (Fn-1) =  (1  0) (Fn-2)
 *                    ^
 *                    ㅣ
 *   ㅣㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ㅢ
 *   ㅣ
 * (Fn-1) =  (1  1) (Fn-2)
 * (Fn-2) =  (1  0) (Fn-3)
 *
 *
 * 위에 식은 아래와 같이 표현 가능.
 * (Fn+1   Fn ) =  (1 1) ^ n
 * (Fn    Fn-1) =  (1 0)
 *
 *
 * 즉, O(N^3 * logb) 만에 구할 수 있다.
 *
 *
 *
 *
 *
 *
 *
 * */
import java.util.Scanner;
public class 피보나치수6 {
    final static long mod = 1000000007L;
    static void multiplication(long[][] a, long[][] b, long[][] temp) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                temp[i][j] = 0;
                for (int k=0; k<n; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                }
                temp[i][j] %= mod;
            }
        }
    }
    static void move(long[][] a, long[][] b) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n <= 1) {
            System.out.println(n);
            System.exit(0);
        }
        //n -= 1;
        long[][] ans = new long[2][2];
        long[][] a = new long[2][2];
        long[][] temp = new long[2][2];
        ans[0][0] = ans[1][1] = 1;
        a[0][0] = a[0][1] = a[1][0] = 1;
        while (n > 0) {
            if (n%2 == 1) {
                multiplication(ans, a, temp);
                move(ans, temp);
            }
            multiplication(a, a, temp);
            move(a, temp);
            n /= 2;
        }
        System.out.println(ans[0][1]);
    }
}