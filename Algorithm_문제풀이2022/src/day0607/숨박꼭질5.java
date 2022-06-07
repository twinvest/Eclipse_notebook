package day0607;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨박꼭질5 {

	static class Pos {
		int time;
		int dist1;
		int dist2;

		Pos(int time, int dist1, int dist2){
			this.time = time;
			this.dist1 = dist1;
			this.dist2 = dist2;
		}

	}
	static int ans = 0;
	static boolean[] visit = new boolean[500001];
	static boolean inside(int dist) {
		return (dist >= 0 && dist<=500000);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dist1 = scan.nextInt();
		int dist2 = scan.nextInt();

		visit[dist1] = true;
		Pos start = new Pos(0, dist1, dist2);
		if(dist1 == dist2) {
			System.out.println(ans);
		} else {

			Queue<Pos> q = new LinkedList<>();
			q.add(start);

			while(!q.isEmpty()) {

				int nextDist1 = q.peek().dist1+1;
				int nextDist2 = q.peek().dist1-1;
				int nextDist3 = q.peek().dist1*2;
				int nextDist4 = q.peek().dist2;

				int time = ++q.peek().time;
				nextDist4 += time;
				q.poll();

				if(nextDist1 == nextDist4 || nextDist2 == nextDist4 || nextDist3 == nextDist4) {
					ans = time;
					break;
				} else {
					if(inside(nextDist1) && inside(nextDist4) && !visit[nextDist1]) {
						q.add(new Pos(time, nextDist1, nextDist4));
						visit[nextDist1] = true;
					}
					if(inside(nextDist2) && inside(nextDist4) && !visit[nextDist2]) {
						q.add(new Pos(time, nextDist2, nextDist4));
						visit[nextDist2] = true;
					}
					if(inside(nextDist3) && inside(nextDist4) && !visit[nextDist3]) {
						q.add(new Pos(time, nextDist3, nextDist4));
						visit[nextDist3] = true;
					}
				}
			}
			if(ans == 0) {
				System.out.println("-1");
			}else {
				System.out.println(ans);
			}

		}
	}
}
