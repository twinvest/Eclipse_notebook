package 문자열;

import java.util.Scanner;

/*
 * fail함수중 가장 큰 길이를 출력하면 됨.
 * 예를 들면, abcdababcaa의 pi배열은 다음과 같음.
 *         00001212311
 *
 * 따라서, 정답은 abc의 길이인 3
 *
 *
 * 그러나, 이게 항상 정답이 되는건 아니다.
 * 이런 예를 봐보자. 위에 문자열에서 가장 앞에 d를 추가한것이다.
 *
 * dabcdababcaa
 * 000010000000
 *
 * 하지만 1은 정답이 아니다. 3이 정답이지...
 *
 * 이런 경우를 처리해주기 위해서 하나씩 지워가면서 최댓값을 구해준다.
 * dabcdababcaa
 *  abcdababcaa
 *   bcdababcaa
 *    cdababcaa
 *      ...
 *           aa
 *            a
 *
 *
 * */
public class Cubeditor_KMP {

	static int[] preprocessing(String p) {
		int m = p.length();
		int[] pi = new int[m];
		pi[0] = 0;
		int j = 0;
		for (int i=1; i<m; i++) {
			while (j>0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				pi[i] = j+1;
				j += 1;
			} else {
				pi[i] = 0;
			}
		}
		return pi;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String a = "";
		int ans = 0;
		int len = s.length();
		for (int k=len-1; k>=0; k--) {
			a = s.charAt(k) + a; //이렇게 한 이유는 abcdabaa 문자열이 있을때,
								 /*   abcdabaa
								  *    bcdabaa
								  *     cdabaa
								  *      dabaa
								  *       abaa
								  *        baa
								  *         aa
								  *          a
								  *
								  *   밑에서 부터 실패함수를 모두 만든다.
								  *
								  * */
			int[] next = preprocessing(a);
			int m = next.length;
			for (int i=0; i<m; i++) {
				if (ans < next[i])
					ans = next[i];
			}
		}
		System.out.println(ans);
	}
}