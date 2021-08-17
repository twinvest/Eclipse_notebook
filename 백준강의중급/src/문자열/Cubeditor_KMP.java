package 문자열;




import java.util.Scanner;
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
				if (ans < next[i]) ans = next[i];
			}
		}
		System.out.println(ans);
	}
}