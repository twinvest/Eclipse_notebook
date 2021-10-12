package 브루트포스;

import java.util.Scanner;
public class 테트리스 {
    static int[] a;
    static int n, m;

    static int calc(int i, String s) {
        //맵을 벗어나면
    	if (i + s.length() > n) return 0;

        int base = a[i] - (s.charAt(0) - '0');
        for (int j=0; j<s.length(); j++) {
            if (base != a[i+j] - (s.charAt(j) - '0')) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = 0;
        //0열부터 n-1열까지 전부 놓아볼것이다.
        for (int i=0; i<n; i++) {
            if (m == 1) {
                ans += calc(i, "0") + calc(i, "0000");
            } else if (m == 2) {
                ans += calc(i, "00");
            } else if (m == 3) {
                ans += calc(i, "001") + calc(i, "10"); //빈칸의 높이는 1로 표현되는 것이다.
            } else if (m == 4) {
                ans += calc(i, "100") + calc(i, "01");
            } else if (m == 5) {
                ans += calc(i, "000") + calc(i, "01") + calc(i, "101") + calc(i, "10");
            } else if (m == 6) {
                ans += calc(i, "000") + calc(i, "00") + calc(i, "011") + calc(i, "20"); //회전시켰을 때 빈칸의 높이는 2로 표현되는 것이다.
            } else if (m == 7) {
                ans += calc(i, "000") + calc(i, "00") + calc(i, "110") + calc(i, "02");
            }
        }
        System.out.println(ans);
    }
}