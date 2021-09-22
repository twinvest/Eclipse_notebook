package 문자열;
/*
 * KMP에서 fail의 의미를 다시 생각해보쟈.
 * fail[i] = P의 i까지 부분문자열에서 prefix == suffix가 될 수 있는 부분문자열 중에서 가장 긴것의 길이다.
 *
 * abcdabc
 * 0000123
 *
 * 아래 문장은 문제의 지문이다. 여기까지만 해석하면 fail의 길이만 구하면 된다.
 * "문자열 S의 부분 문자열 T 중에서, 접두사(Prefix)도 될 수 있고, 접미사(Prefix)도 될 수 있고"
 *
 * 그러나, 여기서 끝나는 것이 아니라 조건이 하나 더 있다.
 * "두 경우가 아닌 위치에도 등장하는 T를 카멜레온 부분 문자열이라고 한다"
 *
 * 즉, 정리하면 처음과 마지막을 제외하고 pi[n]( fail[n]같은말 )이 한번더 나와야한다.
 *
 *
 *          문자열S
 * =======================
 * pi[n]    pi[n]    pi[n]
 *
 *
 * 그런데, 위에 문자열을 잘라놓고 보면 아래와 같다.
 *
 *
 * 길이가 i인 문자열 S2
 * ==============
 * pi[i]    pi[i]
 *
 *
 * 즉, 우리는 이러한 사실을 알 수 있다. 카멜레온 문자열이 되기 위해선 pi[n]과 분명히 똑같은 길이의 pi[i]가 이미 존재했다는 것.
 *
 * abcdabceabc
 * 00001230123
 * 즉, 이렇게 말이다. pi[11] = 3
 *                pi[7] = 3
 *
 *
 * 그런데, 이게 꼭 정답이 아닐 수 도 있다.
 * 예를 들어, ababcabdabab
 *         001201201234
 * 이때, pi[12] = 4이지만 이게 없다고 바로 끝마치면 정답을 찾을 수 없음.
 * 즉, abab에서도 반복되는게 있음.
 * 따라서, fail[fail[n]]도 확인해야함. 존나 이해하기 어려워지는데
 * pi[pi[11]] = 2를 의미. 즉, ab를 의미한다.
 *
 *
 * */

import java.util.Scanner;
public class 카멜레온부분문자열_KMP {

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
        int n = s.length();
        int[] pi = preprocessing(s); //kmp의 fail값을 모두 pi에 저장.

        //cnt배열에다가 pi배열의 값을 모두 추가해준다.
        int[] cnt = new int[n+1];
        for (int i=0; i<n-1; i++) {
            cnt[pi[i]] += 1;
        }

        for (int i=n; i!=0; i=pi[i-1]) {
            //1이상이면, 즉 같은 길이가 존재한다면
        	if (cnt[i] >= 1) {
                System.out.println(s.substring(0,i));
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}