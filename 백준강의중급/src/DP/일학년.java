package DP;

import java.util.Scanner;

/*
 * 앞서 풀어본 '기타리스트'문제와 비슷.
 * 식 사이에 '+'와 '-'둘 중 하나를 넣으면 되니 시간복잡도는 O(2^N)
 * 그러나 N의 최댓값이 100이기때문에 시간초과.
 *
 * 활용할 수 있는 조건은 바로 앞에서부터 순차적으로 더한값이 계속해서 0~20사이의 숫자만 허용한다는것.
 * D[i][j] = i까지 수를 사용해서 j를 만드는 방법의 수
 *
 * A1 +- A2 +- A3 +- ... +- Ai-1 + Ai = j ==> 마지막에 Ai를 더해서 D[i][j]를 만들었다. 따라서, D[i-1][j-Ai]
 * A1 +- A2 +- A3 +- ... +- Ai-1 - Ai = j ==> 마지막에 Ai를 빼서 D[i][j]를 만들었다. 따라서, D[i-1][j+Ai]
 * 따라서, D[i][j] = D[i-1][j-Ai] + D[i-1][j+Ai]
 *
 * O(20 * N)만에 해결 가능.
 *
 *
 * */
public class 일학년 {

	static long[][] d = new long[100][21];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n -= 1; //숫자 한개를 뺀 이유는 제일 마지막 숫자 앞에는 등호를 넣을꺼니까.
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        //마지막 수는 따로 goal변수로 입력받는다.
        int goal = sc.nextInt();

        //제일 첫번째 수는 아무것도 추가 없이 만들 수 있으니 1이라고 하자.
        d[0][a[0]] = 1;


        for (int i=1; i<n; i++) {
            for (int j=0; j<=20; j++) {
                if (j-a[i] >= 0) {
                    d[i][j] += d[i-1][j-a[i]];
                }
                if (j+a[i] <= 20) {
                    d[i][j] += d[i-1][j+a[i]];
                }
            }
        }
        System.out.println(d[n-1][goal]);
    }
}
