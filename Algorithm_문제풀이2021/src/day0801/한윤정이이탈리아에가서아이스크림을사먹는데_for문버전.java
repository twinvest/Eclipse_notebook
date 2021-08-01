package day0801;

import java.util.Scanner;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_for문버전 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] a = new boolean[201][201];
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u][v] = a[v][u] = true;
		}
		int ans = 0;
		for (int i=1; i<=n-2; i++) {
			for (int j=i+1; j<=n-1; j++) {
				for (int k=j+1; k<=n; k++) {
					if (a[i][j] || a[j][k] || a[k][i]) continue;
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
