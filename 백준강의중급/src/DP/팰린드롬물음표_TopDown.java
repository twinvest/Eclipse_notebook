package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
 *
 * 어떤 문자열이 팰린드롬인지 아닌지 알아내는 방법에는 두 가지가 있다.
 * ㄱ. A가 있을 때, A를 뒤집은 수열 A^R을 만든다. 그 후 A와 A^R이 같은지 비교한다.
 *    예를 들어, "12321"을 뒤집으면 "12321"이고 두 개는 같다. 그렇기 때문에 팰린드롬이다.
 *    이 때, 수열의 길이를 N이라고 한다면 뒤집은 수열을 만드는데 O(N)
 *    두 수열이 같은지 비교하는데 O(N)이 걸린다.
 *
 * ㄴ. 두번째 방법은 인덱스끼리 비교하는것이다.
 *    0번인덱스, 4번인덱스
 *    1번인덱스 , 3번인덱스
 *    2번인덱스
 *    ㄱ과 똑같이 시간복잡도는 O(N)이다.
 *
 * ㄴ방법을 조금 유심히 봐보면 재귀적으로 바라볼 수 있다.
 *    i . . . . . . . . j   ==> 이런 문자열이 있다고 하자!
 *    1. A[i] == A[j]
 *    2. i+1 ~ j-1이 팰린드롬이다.
 *
 *    2번을 다시 봐보면,
 *      i+1 . . . . j-1
 *      2-1. A[i+1] == A[j-1]
 *      2-2. i+2 ~ j-2이 팰린드롬이다.
 *
 *
 *
 * */
public class 팰린드롬물음표_TopDown {
	/*
	 * D[i][j] = A[i] ~ A[j]가 팰린드롬이면 1, 아니면 0
	 * ㄱ. 길이가 1(홀수의 기저사례인 1)인 부분 수열은 반드시 팰린드롬이다. 즉, D[i][i] = 1.
	 * ㄴ. 길이가 2(짝수의 기저사례인 2)인 부분 수열은 두 수가 같을 때만 팰린드롬이다.
	 *    즉, D[i][i+1] = 1(A[i] == A[i+1])
	 *       D[i][i+1] = 0(A[i] != A[i+1])
	 *
	 */
	static int[] a;
	static int[][] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        d = new int[n][n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            Arrays.fill(d[i],-1);
        }
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sb.append(go(x-1,y-1));
            sb.append('\n');
        }
        System.out.println(sb);
	}

	public static int go(int x, int y) {
		//길이가 1일때를 의미.
		if (x == y) {
			return 1;
		}
		//길이가 2일때를 의미.
		else if (x+1 == y) {
			if (a[x] == a[y]) {
				return 1;
			} else {
				return 0;
			}
		}
		//메모이제이션 부분
		if (d[x][y] != -1) {
			return d[x][y];
		}

		//팰린드롬이 아닌거임.
		if (a[x] != a[y]) {
			return d[x][y] = 0;
		}
		//i+1 ~ j-1이 팰린드롬인지 아닌지 확인하러ㄱㄱ
		else {
			return d[x][y] = go(x+1,y-1);
		}
	}
}
