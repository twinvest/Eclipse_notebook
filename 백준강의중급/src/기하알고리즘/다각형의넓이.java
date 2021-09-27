package 기하알고리즘;
/*
 * 앞서 공부한 CCW에서
 * 두 벡터의 곱은 P1P3, P1P2를 이용해 만들 수 있는 평행사변형의 넓이이기도하다.
 * 따라서, 여기서 절반으로 나누면 삼각형의 넓이를 구할 수 있게 된다.
 * boj의 '다각형의 면적'이라는 문제의 코드이다
 *
 *
 * */

import java.util.Scanner;
public class 다각형의넓이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n+1];
        long[] y = new long[n+1];
        for (int i=0; i<n; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }
        x[n] = x[0]; y[n] = y[0];
        long ans = 0;
        for (int i=0; i<n; i++) {
            ans += x[i] * y[i+1];
            ans -= y[i] * x[i+1];
        }
        if (ans < 0) ans = -ans;
        System.out.print((ans/2) + ".");
        if (ans%2 == 0) {
            System.out.println("0");
        } else {
            System.out.println("5");
        }
    }
}
