package day0122;

import java.util.Scanner;
public class 햄버거다이어트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			MAX = 0;
			calLimit = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			for(int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			solve(0, 0, 0);
			System.out.println("#" + tc + " " + MAX);
		}
	}
	static int calLimit;
	static int[] cals;
	static int[] scores;
	static int MAX;
	static void solve(int idx, int score, int cal) {
		if( cal > calLimit )
			return;
		if( idx == cals.length ) {
			if(MAX < score)
				MAX = score;
			return;
		}
		solve(idx + 1, score + scores[idx], cal + cals[idx]);
		solve(idx + 1, score, cal);
	}
}
