package DP;

import java.util.Scanner;

/*
 * 일이삼 더하기 문제
 * dp[n] = 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수
 *
 *  ㅁ + ㅁ + ... + ㅁ = n
 *      dp[n-1] + 1 = n
 *      dp[n-2] + 2 = n
 *      dp[n-3] + 3 = n
 *
 *  따라서, dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
 *
 *
 *
 * 그러나, 이문제를 풀고 싶은게 아니라...
 * 일이삼더하기4를 풀어보자.
 * 이 문제는 '합을 이루고 있는 수의 순서만 다른 것'은 같은 것으로 친다.
 *
 * n = 4
 * 1+1+1+1
 * 2+1+1(1+1+2, 1+2+1)
 * 2+2
 * 1+3(3+1)
 *
 * 사실 이 두 문제는 매우 유사한데 dp배열을 업데이트 하는 순서에 따라 dp배열 값이 상이해진다.
 *
 *
 * int n = 4;
 * int m = 3;
 * int nums = {1,2,3};
 * int d[n];
 * d[0] = 1;
 * for(int i = 1; i<=n; ++i){ //i라는 숫자를 만드는 방법을 찾을건데
 * 	for(int j = 0; j<=m; ++j){ //i하나를 만들기 위해 그 때마다, 모든 j번째 수를 이용할거야.
 * 		if(i-nums[j] >= 0){
 * 			d[i] += d[i-nums[j]]
 * 		}
 * 	}
 * }
 *
 *
 * for(int j = 0; j<m; ++j){ //j번째 수를 사용해서
 * 	for(int i = 1; i<=n; ++i){ //1~n까지 만들거야.
 * 		if(i-nums[j] >= 0){
 * 			d[i] += d[i-nums[j]]
 * 		}
 * 	}
 * }
 *
 *
 * */
public class 일이삼더하기4 {

	static final long mod = 10009L;
    static final int limit = 10000;
    static int[] d = new int[limit+1];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        d[0] = 1;
        //+1로 만들 수 있는 것들을 먼저 만들어준다.
        for (int i=1; i<=limit; i++) {
            if (i-1 >= 0) {
                d[i] += d[i-1];
            }
        }

        //+2로 만들 수 있는 것들을 다음으로 만들어준다.
        for (int i=1; i<=limit; i++) {
            if (i-2 >= 0) {
                d[i] += d[i-2];
            }
        }

        //+3로 만들 수 있는 것들을 그다음으로 만들어준다.
        for (int i=1; i<=limit; i++) {
            if (i-3 >= 0) {
                d[i] += d[i-3];
            }
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }

}
