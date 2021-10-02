package DP;

import java.util.Scanner;

/*
 * 첫 볼륨 : S
 * 연주해야하는 곡의 개수 : N개
 * 가능한 볼륨의 범위 : 0~M
 *
 * i번 곡을 연주하기 전에 볼륨을 V[i]만큼 바꿔야 한다.
 * i번 곡을 연주하기 직전 볼륨이 P라면, i번 곡은 P+V[i] 또는 P-V[i]로 연주해야 한다.
 * 마지막 곡을 연주할 수 잇는 볼륨 중 최댓값을 구해라.
 *
 *
 *              ==> S+V[1]+V[2]
 *   ==> S+V[1]
 *              ==> S+V[1]-V[2]
 * S                                ...
 *              ==> S-V[1]+V[2]
 *   ==> S-V[1]
 *              ==> S-V[1]-V[2]
 *
 *
 *  가능한 방법의 수는 2^N가지이다.
 *  그러나, N제한이 100이다. 2^100 = 매우큼.
 *  모든 방법 시도 불가.
 *
 *  평범한 배낭에서 무게 K에 제한이 있었듯이 이 문제에서는 가능한 볼륨의 범위가 제한이 있음.
 *  M의 최댓값은 1000.
 *  따라서 O(NM)으로 풀기 쌉가능.
 *  D[i][j] = i번 곡을 볼륨 j로 연주할 수 있으면 1 없으면 0
 *
 *
 * */
public class 기타리스트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];

        boolean[][] d = new boolean[n+1][m+1];

        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        d[0][s] = true;
        for (int i=0; i<=n-1; i++) {
            for (int j=0; j<=m; j++) {
                if (d[i][j] == false) {
                    continue;
                }
                if (j-a[i+1] >= 0) {
                    d[i+1][j-a[i+1]] = true;
                }
                if (j+a[i+1] <= m) {
                    d[i+1][j+a[i+1]] = true;
                }
            }
        }
        int ans = -1;
        for (int i=0; i<=m; i++) {
            if (d[n][i]) ans = i;
        }
        System.out.println(ans);
	}
}
