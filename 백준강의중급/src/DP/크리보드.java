package DP;

import java.util.Scanner;

/*
 * D[N] = 버튼을 N번 눌러서 화면에 출력가능한 A의 최대갯수
 * 버튼을 1번과 234번으로 나눠볼 수 있다.
 * 234는 한개와 같이 움직인다.(연속해서 눌러줘야한다.)
 *
 *
 * 마지막에 1번 버튼을 눌렀을 때, D[N] = D[N-1] + 1
 * 마지막에 연달아 2,3,4번 버튼을 눌렀을 때, D[N] = D[N-3] * 2
 *
 * . . . . . . ctrlA, ctrlC, ctrlV
 *     N-3번
 *
 *
 * 위 두 가지 경우뿐만 아니라 이런 경우도 생각할 수 있다.
 * . . . . . .  ctrlA, ctrlC, ctrlV, ctrlV
 *     N-4번
 * 이때, D[N] = D[N-4] * 3
 *
 * 이 경우만 있을까? 아니다.
 * 위 두 가지 경우뿐만 아니라 이런 경우도 생각할 수 있다.
 * . . . . . .  ctrlA, ctrlC, ctrlV, ctrlV, ctrlV
 *     N-5번
 * 이때, D[N] = D[N-5] * 4
 *
 * 이것을 일반화 시켜보자. ctrlV를 횟수를 j라고 하자.
 * D[N] = D[N-(j+2)] * j+1 ==> j+2인 이유는 ctrlA와 ctrlC
 *
 * 따라서, 전체 점화식은 D[N] = max(D[N-1], D[N-(j+2)] * j+1)
 * ㄱ. 마지막에 1번 버튼을 누른경우
 * ㄴ. 마지막에 2(ctrlA),3(ctrlC)번 버튼을 누르고 4번 버튼을 j번 누른 경우
 *
 *
 *
 * */
public class 크리보드 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        for (int i=1; i<=n; i++) {
            d[i] = d[i-1] + 1;
            for (int j=1; j<=i-3; j++) {
                long cur = d[i-(j+2)]*(j+1);
                if (cur > d[i]) {
                    d[i] = cur;
                }
            }
        }
        System.out.println(d[n]);
    }
}