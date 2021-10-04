package DP;

import java.util.Arrays;
import java.util.Scanner;


/*
 * D[a][b][c][p1][p2] = A,B,C의 개수가 (a,b,c)이고, 전날 일한 사람이 p1, 그 전날 일한 사람이 p2인 것이 가능한가?
 *
 * . . . . . . . p2 p1 A ? : D[a+1][b][c][A][p1]
 * . . . . . . . p2 p1 B ? : D[a][b+1][c][B][p1] 단, 이 때 (p1 != B)를 만족해야 한다.
 * . . . . . . . p2 p1 C ? : D[a][b][c+1][C][p1] 단, 이 때 (p1 != C) && (p2 != C)를 만족해야 한다.
 * */

public class 출근기록 {
	static int[] limit = new int[3];
    static int[][][][][] d = new int[51][51][51][3][3];
    static int n;
    static int go(int a, int b, int c, int p1, int p2) {
        int ans = d[a][b][c][p1][p2];
        if (a+b+c == n) {
            d[a][b][c][p1][p2] = 1;
            return d[a][b][c][p1][p2];
        }
        if (ans != -1) return ans;
        if (a+1 <= limit[0] && go(a+1, b, c, 0, p1) == 1) {
            d[a][b][c][p1][p2] = 1;
            return d[a][b][c][p1][p2];
        }
        if (b+1 <= limit[1] && p1 != 1) {
            if (go(a, b+1, c, 1, p1) == 1) {
                d[a][b][c][p1][p2] = 1;
                return d[a][b][c][p1][p2];
            }
        }
        if (c+1 <= limit[2] && p1 != 2 && p2 != 2) {
            if (go(a, b, c+1, 2, p1) == 1) {
                d[a][b][c][p1][p2] = 1;
                return d[a][b][c][p1][p2];
            }
        }
        d[a][b][c][p1][p2] = 0;
        return d[a][b][c][p1][p2];
    }
    static String back(int a, int b, int c, int p1, int p2) {
        if (a+b+c == n) {
            return "";
        }
        if (a+1 <= limit[0] && go(a+1, b, c, 0, p1) == 1) {
            return "A" + back(a+1, b, c, 0, p1);
        }
        if (b+1 <= limit[1] && p1 != 1) {
            if (go(a, b+1, c, 1, p1) == 1) {
                return "B" + back(a, b+1, c, 1, p1);
            }
        }
        if (c+1 <= limit[2] && p1 != 2 && p2 != 2) {
            if (go(a, b, c+1, 2, p1) == 1) {
                return "C" + back(a, b, c+1, 2, p1);
            }
        }
        return "";
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        n = s.length();
        for (int i=0; i<n; i++) {
            limit[s.charAt(i)-'A'] += 1;
        }
        for (int i=0; i<51; i++) {
            for (int j=0; j<51; j++) {
                for (int k=0; k<51; k++) {
                    for (int l=0; l<3; l++) {
                        Arrays.fill(d[i][j][k][l], -1);
                    }
                }
            }
        }
        int ans = go(0, 0, 0, 0, 0);
        if (ans == 0) {
            System.out.println(-1);
        } else {
            System.out.println(back(0, 0, 0, 0, 0));
        }
    }
}
