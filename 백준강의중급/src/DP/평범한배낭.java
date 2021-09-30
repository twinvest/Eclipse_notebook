package DP;

import java.util.Scanner;

/*
 * N개의 물건이 있고, 각 물건은 무게 W[i]와 가치V[i]를 갖는다.
 * 배낭에는 무게 K까지만 물건을 넣을 수 있다.
 * 배낭에 넣을 수 있는 물건 가치의 최댓값을 구하는 문제
 *
 * 각각의 물건은 가방에 들어가거나 들어가지 않는 두 가지 경우가 있다.
 * 따라서 경우의 수는 2^N가지이다.
 * 그런데 N의 최댓값이 100이니 모든 경우를 확인하는건 불가능하다.
 *
 * 그렇기 때문에 원래 이 문제는 풀 수 없는 문제이다. 그러나, 우리는 활용할 수 있는 정보(조건)가(이) 있다.
 * 바로, 무게에 제한이 있다는 사실이다. k<=100,000
 * 따라서, 각각의 무게에 대해서, 넣을 수 있는 가장 큰 가치를 알아내는 방식으로 접근하면 된다.
 *
 * D[i][j] = i번째 물건까지 고려했고, 배낭에 넣은 물건 무게의 합이 j일 때, 가치의 최댓값
 *
 *
 * 1 ... i  ==> 이때 무게의 합은 j
 *
 *
 * ㄱ. i번째 물건이 들어간 경우
 *     DP[i][j] = DP[i-1][j-W[i]] + V[i]
 *
 * ㄴ. i번째 물건이 들어가지 않은 경우
 *	   DP[i][j] = DP[i-1][j]
 *
 * 이때, 시간복잡도는 O(NK)
 *
 *
 * */
public class 평범한배낭 {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i=1; i<=n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[][] d = new int[n+1][k+1];
        for (int i=1; i<=n; i++) { //i번째 물건에 대해 고려할거다.
            for (int j=1; j<=k; j++) { //그때마다 모든 무게를 구해준다.
                d[i][j] = d[i-1][j]; //i번째 물건이 들어가지 않는 경우로 먼저 초기화
                if (j-w[i] >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i-1][j-w[i]]+v[i]); //i번째 물건이 가방에 들어가는 경우와 들어가지 않는 경우 중 가치가 더 큰 것을 고른다.
                }
            }
        }
        System.out.println(d[n][k]);
    }
}
