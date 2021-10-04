package DP;

/*
 * 스타트는 B,O,J,B,O,J ... 순으로 보도블럭을 밟으면서 점프해야 한다.
 * 한 번 점프를 할 때는 k^2만큼의 에너지가 필요하다.
 * 예를 들어, i에서 j로 점프할때는 (j-i)^2만큼의 에너지가 필요하다.
 *
 * D[N] = N에 오는 최소 에너지
 *
 * ... i .... N
 * i에서 N으로 점프시
 * D[N] = min(D[i] + (N-i)^2)
 * 이 때, N번칸이 'B'이면 i번칸은 'J'여야된다.
 *      N번칸이 'O'이면 i번칸은 'B'여야된다.
 *      N번칸이 'J'이면 i번칸은 'O'여야된다.
 *
 *
 * */

import java.util.Scanner;

public class BOJ거리 {

	//x라는 칸을 밟을건데, 그전에 무엇이 와야하는지
	static char get_prev(char x) {
        if (x == 'B') {
            return 'J';
        } else if (x == 'O') {
            return 'B';
        } else if (x == 'J') {
            return 'O';
        } else {
            return ' ';
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] d = new int[n];
        for (int i=0; i<n; i++) d[i] = -1;
        d[0] = 0;

        for (int i=1; i<n; i++) {
            //prev(j)에서 now(i)로 갈거임.
        	char now = s.charAt(i);
            char prev = get_prev(now);
            for (int j=0; j<i; j++) {
                //일단 j를 갈 수 있어야하고
            	if (d[j] == -1) continue;
                //prev와 j가 같은지 확인하고
            	if (s.charAt(j) != prev) continue;
            	int cost = d[j] + (i-j)*(i-j);
                if (d[i] == -1 || d[i] > cost) {
                    d[i] = cost;
                }
            }
        }
        System.out.println(d[n-1]);
    }
}
