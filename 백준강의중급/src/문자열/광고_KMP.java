package 문자열;
import java.util.Scanner;
public class 광고_KMP {
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
        int n = sc.nextInt();
        String p = sc.next();
        int[] next = preprocessing(p);
        System.out.println(n-next[n-1]);
    }
}