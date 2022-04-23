package 브루트포스;

import java.util.Scanner;

public class 사다리조작_재귀 {
	static int N,M,H,ans;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		H=scan.nextInt();
		visit = new boolean[H+2][N+2];
		for(int i =0; i<M; ++i) {
			visit[scan.nextInt()][scan.nextInt()] = true;
		}
		ans = 4;
		dfs(0,1);
		System.out.println(ans == 4 ? -1 : ans);
	}

	static boolean go() {
		for(int j=1; j<=N; ++j) {
			int cur = j;

			for(int i =1; i<=H; ++i) {
				if(visit[i][cur] == true) {
					cur++;
				}
				else if(visit[i][cur-1] == true) {
					cur--;
				}
			}

			if(cur != j)
				return false;
		}

		return true;
	}

	static void dfs(int depth, int y) {
		//현재 answer보다 더 깊은 depth는 검색하지 않을거임.
		if(ans <= depth)
			return;
		//go함수가 true를 뱉으면
		if(go()) {
			ans = depth;
			return;
		}
		//depth가 3이면 검색을 멈출거임.
		if(depth == 3)
			return;

		for(int Y=y; Y<=H; Y++) {
			for(int X=1; X<=N; ++X) {
				//가로선이 연속하는지 체크. 연속하지 않아야함.
				if(visit[Y][X] != true && visit[Y][X-1] != true && visit[Y][X+1] != true ) {
					//가로선 하나를 놓는다.
					visit[Y][X] = true;
					dfs(depth+1, Y);
					//가로선 하나를 치운다.
					visit[Y][X] = false;
				}
			}
		}

	}

}
