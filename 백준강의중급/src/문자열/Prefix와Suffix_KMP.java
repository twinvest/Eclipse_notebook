package 문자열;
/*
 * prefix == suffix 인 부분문자열이 문자열 S에서 몇번 등장하는가?
 * 앞선 카멜레온 부분문자열과 동일한 문제이다.
 * ㅅㅂ근데 카멜레온 부분문자열이 이해가 안돼~~
 *
 * */

import java.util.ArrayList;
import java.util.Scanner;
public class Prefix와Suffix_KMP {

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
        int[] pi = preprocessing(s);
        int[] cnt = new int[n+1];
        for (int i=0; i<n; i++) {
            cnt[pi[i]] += 1;
        }

        for (int i=n; i>0; i--) {
            cnt[pi[i-1]] += cnt[i];
        }

        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        for (int i=n; i>0; i=pi[i-1]) {
            ans1.add(i);
            ans2.add(cnt[i]+1);
        }
        int m = ans1.size();
        System.out.println(m);
        for (int i=m-1; i>=0; i--) {
            System.out.println(ans1.get(i) + " " + ans2.get(i));
        }
    }
}