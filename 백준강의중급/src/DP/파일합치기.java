package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 연속된 파일만 합칠 수 있다.
 * 파일은 2개의 연속된 파일을 합치는 것이다.
 *
 * 파일이5개 있다고 하자. A1 A2 A3 A4 A5
 * 그리고 모든 파일이 다음과 같이 하나로 합쳐졌다고 하자. (A1 A2 A3 A4 A5)
 * 바로 이전 단계의 경우는 4개가 있을 것이다.
 * (A1)(A2 A3 A4 A5)
 * (A1 A2)(A3 A4 A5)
 * (A1 A2 A3)(A4 A5)
 * (A1 A2 A3 A4)(A5)
 *
 * 이를 파일의 시작위치와 끝위치를 이용해 다음과 같이 표현하자.
 * (1,5) =
 * (1,1) + (2,5)
 * (1,2) + (3,5)
 * (1,3) + (4,5)
 * (1,4) + (5,5)
 *
 * 따라서, 다음과 같이 DP를 정의할 수 있다.
 * DP[i][j] = i번 파일부터 j번 파일까지 합치는 최소비용.
 *
 * i ... k ... j
 * (i, k)(k+1, j)이 합쳐진것.
 * 이때, k는 i보다는 크거나 같고 j보다는 작음. j보다 작은이유는 k+1이부터 시작이니까.
 *
 *
 * DP[i][j] = DP[i][k] + DP[k+1][j] + 합치는비용
 *
 *
 * */


public class 파일합치기 {
    static int[] a;
    static int[][] d;
    public static int go(int i, int j) {
        //파일이 하나인 경우. 파일 합칠게 없음.
    	if (i == j) {
            return 0;
        }
    	//메모이제이션
        if (d[i][j] != -1) {
            return d[i][j];
        }


        int ans = -1;
        int sum = 0;
        //i부터 j번째 까지의 합을 구해준다.
        for (int k=i; k<=j; k++) {
            sum += a[k];
        }

        //가능한 k의 범위를 전부 조사한다
        for (int k=i; k<=j-1; k++) {
            int temp = go(i, k) + go(k+1, j) + sum;
            if (ans == -1 || ans > temp) {
                ans = temp;
            }
        }
        d[i][j] = ans;
        return ans;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        while (t-- > 0) {
            int n = Integer.valueOf(bf.readLine());
            String[] nums = bf.readLine().split(" ");
            a = new int[n+1];
            d = new int[n+1][n+1];
            for (int i=1; i<=n; i++) {
                a[i] = Integer.valueOf(nums[i-1]);
                Arrays.fill(d[i], -1);
            }

            System.out.println(go(1, n)); //1번부터 n번까지 파일 합치기
        }
    }
}