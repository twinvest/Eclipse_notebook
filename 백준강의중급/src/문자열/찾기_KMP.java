package 문자열;

import java.util.ArrayList;
import java.util.Scanner;
public class 찾기_KMP {
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
    static ArrayList<Integer> kmp(String s, String p) {
        int[] pi = preprocessing(p);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = s.length();
        int m = p.length();
        int j = 0;
        for(int i=0; i<n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == m-1) {
                    ans.add(i-m+1);
                    j = pi[j];
                } else {
                    j += 1;
                }
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        ArrayList<Integer> matched = kmp(s, p);
        System.out.println(matched.size());
        for (int index : matched) {
            System.out.print((index+1) + " ");
        }
        System.out.println();
    }
}