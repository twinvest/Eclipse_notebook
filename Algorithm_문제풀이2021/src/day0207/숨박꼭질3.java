package day0207;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨박꼭질3 {
	static class Pos{
		int x;
		int time;
		int numOfTeleport;
		Pos (int x, int time, int numOfTeleport) {
			this.x = x;
			this.time = time;
			this.numOfTeleport = numOfTeleport;
		}
	}
	static boolean inside(int x) {
		return (x>=0 && x<100001);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[][] visit = new boolean[100][100001];
		boolean[] map = new boolean[100001];
		int N = scan.nextInt();
		int K = scan.nextInt();
		map[N] = true;
		map[K] = true;

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(N, 0, 0));
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.x == K) {
				System.out.println(now.time);
				break;
			}

			int nx1 = now.x+1;
			int nx2 = now.x-1;
			int nx3 = now.x * 2;

			if(inside(nx3) && !visit[now.numOfTeleport+1][nx3]) {
				visit[now.numOfTeleport+1][nx3] = true;
				q.add(new Pos(nx3, now.time, now.numOfTeleport+1));
			}

			if(inside(nx2) && !visit[now.numOfTeleport][nx2]) {
				visit[now.numOfTeleport][nx2] = true;
				q.add(new Pos(nx2, now.time+1, now.numOfTeleport));
			}

			if(inside(nx1) && !visit[now.numOfTeleport][nx1]) {
				visit[now.numOfTeleport][nx1] = true;
				q.add(new Pos(nx1, now.time+1, now.numOfTeleport));
			}
		}
	}
}