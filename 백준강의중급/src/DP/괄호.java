package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 길이 L이 주어졌을 때, 길이가 L인 올바른 괄호 문자열의 개수를 구하는 문제
 *
 * 올바른 괄호 문자열의 조건
 * 첫번째 문자는 항상 '('이다.
 * 그렇다면, 이 첫번째 글자와 대응하는 ')'는 어디있을까? 정답은 모른다이다.
 * DP유형을 풀 때 가장 중요한것이 바로 이 알 수 없는 지점이다. 이를 i번째로 가정하자.
 *
 * (  . . . . . . ) . . . . . .
 *                i
 * 위 문자열의 길이를 L이라고 하자.
 * 괄호안 올바른 문자열의 길이는 따라서 i-2가 됨.
 * i를 기준으로 우측 문자열의 길이는 L-i가 됨.
 *
 * 다음과 같이 정의하자. D[L] = 길이가 L인 올바른 괄호 문자열의 개수
 * 그럼 D[L] = 시그마(D[i-2] * D[L-i])
 *
 * i의 범위는 2 <= i <= L 이다.
 * 이때 L과 i는 항상 짝수여야한다.
 *
 * ===========================================================
 *
 * 위 방법말고 2차원 배열로도 접근을 할 수 있다.
 * D[N][L] = 길이가 N인 모든 괄호문자열, 거기서 짝이 맞지 않는 여는 괄호의 개수 L개
 * ()(() = D[5][1]의 케이스
 * ((((( = D[5][5]의 케이스
 *
 * 문제의 정답은 D[N][0] : 길이가 N인 올바른 괄호 문자열
 *
 * 이 때, L은 항상 0보다 큰 경우에 대해서만 조사할 것이다.
 * 다음과 같은 예시를 보자. (())) ==> 닫는괄호만 1개 더 있다. 이 경우 L = -1. 이 경우 어떻게 해도 올바른 괄호 문자를 만들 수 없다.
 *
 * 문제는 크게 두 가지 케이스가 있다.
 * 끝문자가 ')'인 케이스
 * 끝문자가 '('인 케이스
 *
 * . . . . . . )
 * 위 케이스의 경우 ) 좌측 괄호문자열의 점화식을 세워보면 D[N-1][L+1]
 *
 * . . . . . . (
 * 위 케이스의 경우 ( 좌측 괄호문자열의 점화식을 세워보면 D[N-1][L-1]
 *
 * 즉, 이를 정리하면
 * D[N-1][L+1] + ')'
 * D[N-1][L-1] + '('
 *
 * D[N][L] = D[N-1][L+1] + D[N-1][L-1]
 *
 *
 * */

public class 괄호 {
	static long[] d = new long[5001];
    static long mod = 1000000007L;
    static long go(int n) {
        if (n == 0) {
            return 1;
        } else if (d[n] >= 0) {
            return d[n];
        }
        d[n] = 0;
        for (int i=2; i<=n; i+=2) {
            d[n] += go(i-2) * go(n-i);
            d[n] %= mod;
        }
        return d[n];
    }

    static void method1() {
    	Scanner sc = new Scanner(System.in);
        Arrays.fill(d, -1);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n%2 == 0) {
                System.out.println(go(n));
            } else {
                System.out.println(0);
            }
        }
    }

    static void method2() {
    	Scanner sc = new Scanner(System.in);
        long[][] d = new long[5001][5001];
        long mod = 1000000007L;
        d[0][0] = 1;
        for (int i=1; i<=5000; i++) {
            for (int j=0; j<=i; j++) {
                d[i][j] = 0;
                if (j+1 <= i) {
                    d[i][j] += d[i-1][j+1];
                }
                if (j-1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }
                d[i][j] %= mod;
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n][0]);
        }
    }
    public static void main(String args[]) {
        method1();
        //method2();
    }

}
