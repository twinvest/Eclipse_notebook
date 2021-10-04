package DP;

import java.util.Scanner;

/*
 * N과 K가 주어졌을 때, 아래 두 조건을 만족하는 문자열 S를 아무거나 찾는 문제.
 *
 * 1. 문자열 S의 길이는 N이고, A,B,C로만 이루어져 있다.
 * 2. 0<=i<j<N이고, S[i] < S[j]를 만족하는 (i,j)쌍이 K개가 있다.
 *                     A<B
 *                     A<C
 *                     B<C
 *
 * 3<=N<=30, 0<=K<=N(N-1)/2
 *
 * D[i][a][b][p] = 길이가 i이고, A의 개수가 a개, B의 개수가 b개, S[i]<S[j]쌍이 p개 있는 문자열이 가능한가?
 * C의 개수 = i-a-b이다.
 *
 * . . . . . . A : D[i+1][a+1][b][p]
 * . . . . . . B : D[i+1][a][b+1][p+a]
 * . . . . . . C : D[i+1][a][b][p+a+b]
 *     길이는i
 *
 * */
public class ABC {
	   static boolean[][][][]d = new boolean[31][31][31][436];
	    static char[] ans;
	    static int n, k;

	    //go에서 정답을 찾으면 true 정답을 못찾으면 false를 리턴한다.
	    static boolean go(int i, int a, int b, int p) {
	        if (i == n) {
	            if (p == k) return true; //정답을 찾은경우. 계속해서 무조건 true를 리턴하게 된다.
	            else return false;
	        }

	        //이 if문의 d[i][a][b][p]가 true이면 함수를 호출한 적이 있다는 것.
	        //호출을해서 위 i==n조건에 걸려 true를 리턴하지 못했다면 false를 리턴했다는 것이고 그런곳은 방문할 필요가 없기에 바로 false를 리턴한다.
	        if (d[i][a][b][p])
	        	return false;
	        //방문체크.
	        d[i][a][b][p] = true;

	        ans[i] = 'A';
	        if (go(i+1, a+1, b, p))
	        	return true;

	        ans[i] = 'B';
	        if (go(i+1, a, b+1, p+a))
	        	return true;

	        ans[i] = 'C';
	        if (go(i+1, a, b, p+a+b))
	        	return true;

	        return false;
	    }
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        k = sc.nextInt();
	        ans = new char[n];
	        if (go(0, 0, 0, 0)) {
	            System.out.println(new String(ans));
	        } else {
	            System.out.println(-1);
	        }
	    }
}
