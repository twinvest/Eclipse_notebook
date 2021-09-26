package 수학;
/*
 * 이항계수
 * n개 중에 k개를 순서 없이 고르는 방법
 * 즉, nCk
 * 또는 (n)
 *    (k) 로 쓴다.
 *
 * 정의에 의해서, n!/k! * (n-k)!로 나타내기도 한다.
 * 일반적으로, O(n)에 구할 수 있다.
 * 그러나, 문제가 있는데 바로 !이라는것...매우 큰 값이다.
 * 20!만 되도 구할 수 없게 됨.
 *
 * 따라서, 이항계수를 구하는 방법에 대해 고민해볼 필요가 있다.
 * 파스칼의 삼각형을 사용할 수 있다.
 * ㄱ. 이항 계수를 삼각형 모양으로 배열한다.
 * ㄴ. n번 줄에는 수를 n개만 쓴다.
 * ㄷ. 각 줄의 첫번째와 마지막 수는 1이다.
 * ㄹ. 나머지 수는 윗 줄의 왼쪽수와 오른쪽 수를 더해서 만든다.
 *                 1
 *                1 1
 *               1 2 1
 *              1 3 3 1
 *             1 4 6 4 1
 *           1 5 10 10 5 1
 *          1 6 15 20 15 6 1
 *
 *      i번째 줄의 j번째 수 가 iCj가 된다. O(n^2)
 *
 * 즉, C[n][k] = n번줄의 k번째 수라고 했을때,
 * C[n][1] = 1, C[n][n] = 1 이다.
 * C[n][k] = C[n-1][k-1] + C[n-1][k]이다.
 * 코드는 이항계수2.java에서 확인할 것!
 *
 * */


import java.util.Scanner;
public class 이항계수 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 1;
        for (int i=1; i<=n; i++) {
            ans *= i;
        }
        for (int i=1; i<=m; i++) {
            ans /= i;
        }
        for (int i=1; i<=n-m; i++) {
            ans /= i;
        }
        System.out.println(ans);
    }
}