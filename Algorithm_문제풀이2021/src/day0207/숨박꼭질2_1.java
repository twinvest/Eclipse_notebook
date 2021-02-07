package day0207;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨박꼭질2_1 {
	static class Pos{
		int x;
		int time;
		Pos (int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	static boolean inside(int x) {
		return (x>=0 && x<100001);
	}
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		if(N==K) {
			System.out.println(0);
			System.out.println(1);
		}else {
			bfs(N,K);
			System.out.println(ans);
			System.out.println(cnt);
		}

	}
	static int ans = 0;
	static int cnt = 0;
	static public void bfs(int N, int K) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(N, 0));
		while(!q.isEmpty()) {
			Pos now = q.poll();
			int x = now.x;
			int sec = now.time;
			visit[x] = true;
			if (ans != 0 && ans < sec)
				return;

			if (ans == sec && x == K) //이미 목적지에 한번 방문했으면, 횟수증가!
				cnt++;

			if (ans == 0 && x == K) { //목적지에 처음 방문한 경우, 기록 후 횟수증가!
				ans = sec;
				cnt++;
			}

			if(inside(x-1) && !visit[x-1]) q.add(new Pos(x-1, sec+1));
			if(inside(x+1) && !visit[x+1]) q.add(new Pos(x+1, sec+1));
			if(inside(2*x) && !visit[2*x]) q.add(new Pos(2*x, sec+1));
		}
	}
}
