package day0701;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {
	static int F,S,G,U,D;
	static int ans = 987654321;
	static boolean[] visit = new boolean[1000001];
	static boolean inside(int positon) {
		return (positon>=1 && positon<=F);
	}
	static class Pos{
		int position;
		int cnt;
		Pos(int position, int cnt){
			this.position = position;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		F = scan.nextInt();
		S = scan.nextInt();
		G = scan.nextInt();
		U = scan.nextInt();
		D = scan.nextInt();
		bfs();
		if(ans == 987654321) {
			System.out.println("use the stairs");
		}else {
			System.out.println(ans);
		}

	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(S,0));
		visit[S] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.position == G) {
				ans = cur.cnt;
				break;
			}

			//1. 위로가는 경우
			if(inside(cur.position + U) && !visit[cur.position + U]) {
				visit[cur.position + U] = true;
				q.add(new Pos(cur.position + U, cur.cnt+1));
			}
			//2. 아래로 가는 경우
			if(inside(cur.position - D) && !visit[cur.position - D]) {
				visit[cur.position - D] = true;
				q.add(new Pos(cur.position - D, cur.cnt+1));
			}
		}
	}
}
