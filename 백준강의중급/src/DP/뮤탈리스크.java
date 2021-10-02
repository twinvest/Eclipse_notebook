package DP;

import java.util.Scanner;

/*
 * SCV가 N개 있다. (1<=N<=3, 1<=체력<=60)
 * 뮤탈리스크 1개가 있다. 뮤탈리스크는 SCV를 공격한다.
 * 한 번에 세 개의 SCV를 공격한다.
 * ㄱ. 첫번째로 공격받는 SCV는 체력 9를 잃는다.
 * ㄴ. 첫번째로 공격받는 SCV는 체력 3를 잃는다.
 * ㄷ. 첫번째로 공격받는 SCV는 체력 1를 잃는다.
 *
 * SCV는 체력이 0 또는 그이하가 되면 파괴되고, 한 번의 공격에서 같은 SCV를 여러번 공격할 수 없다.
 * SCV를 모두 파괴하기 위해 공격해야 하는 횟수의 최솟값을 구하는 문제
 *
 * 가능한 체력 조합의 가지수는 61^3 = 226981
 * 61인 이유는 (체력이 0 또는 그이하)도 포함시켰기 때문에입니다.
 *
 * 자, 다시 문제로 돌아가서...
 * 공격할 수 있는 순서는 총 6가지가 있음.
 * 1,2,3
 * 1,3,2
 * 2,1,3
 * 2,3,1
 * 3,1,2
 * 3,2,1
 *
 * D[i][j][k] = SCV의 체력이 i,j,k일 때, 모두 파괴하기 위해 공격해야 하는 횟수의 최솟값.
 * 공격할 수 있는 순서는 총 6가지가 있음.
 * 1,2,3 : D[i-9][j-3][k-1]
 * 1,3,2 : D[i-9][j-1][k-3]
 * 2,1,3 : D[i-3][j-9][k-1]
 * 2,3,1 : D[i-3][j-1][k-9]
 * 3,1,2 : D[i-1][j-9][k-3]
 * 3,2,1 : D[i-1][j-3][k-9]
 *
 *
 *
 * */
public class 뮤탈리스크 {
	//시간복잡도는 O(61^3 * 3!)이다.

	public static int[][][] d = new int[61][61][61];
    public static int go(int i, int j, int k) {
        if (i < 0) return go(0, j, k); //만약 인자로 음수값이 넘어왔으면 0을 넣어준다.
        if (j < 0) return go(i, 0, k); //만약 인자로 음수값이 넘어왔으면 0을 넣어준다.
        if (k < 0) return go(i, j, 0); //만약 인자로 음수값이 넘어왔으면 0을 넣어준다.

        if (i == 0 && j == 0 && k == 0) return 0; //문제의 정답을 찾은거임. 즉, SCV를 모두 파괴한것임.

        //메모이제이션
        if (d[i][j][k] != -1)
        	return d[i][j][k];

        int ans = 10000000;

        if (ans > go(i-1, j-3, k-9)) {
            ans = go(i-1, j-3, k-9);
        }
        if (ans > go(i-1, j-9, k-3)) {
            ans = go(i-1, j-9, k-3);
        }
        if (ans > go(i-3, j-1, k-9)) {
            ans = go(i-3, j-1, k-9);
        }
        if (ans > go(i-3, j-9, k-1)) {
            ans = go(i-3, j-9, k-1);

        }
        if (ans > go(i-9, j-1, k-3)) {
            ans = go(i-9, j-1, k-3);
        }
        if (ans > go(i-9, j-3, k-1)) {
            ans = go(i-9, j-3, k-1);
        }

        ans += 1; //이번에 공격한거 +1추가 해줌.
        d[i][j][k] = ans;
        return d[i][j][k];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scv = new int[3];
        for (int i=0; i<n; i++) {
            scv[i] = sc.nextInt();
        }

        for (int i=0; i<=60; i++) {
            for (int j=0; j<=60; j++) {
                for (int k=0; k<=60; k++) {
                    d[i][j][k] = -1;
                }
            }
        }

        System.out.println(go(scv[0], scv[1], scv[2]));
    }

}
