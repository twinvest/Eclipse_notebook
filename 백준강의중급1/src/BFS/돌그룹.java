package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 돌그룹 {
	static class Pos{
		int A,B,C;
		Pos(int A, int B, int C){
			this.A=A;
			this.B=B;
			this.C=C;
		}
	}
	static boolean inside(int A, int B, int C) {
		return (A>=1 && A<=500) && (B>=1 && B<=500) && (C>=1 && C<=500);
	}
	static int A,B,C;
	static boolean ans = false;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();
		ans = false;
		visit = new boolean[1501][1501];
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(A,B,C));
		visit[A][B] = true;
		visit[B][C] = true;
		visit[A][C] = true;


		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if((cur.A + cur.B + cur.C) % 3 != 0) {
				ans = false;
				break;
			}

			if(cur.A == cur.B && cur.B == cur.C && cur.A == cur.C) {
				ans = true;
				break;
			}


			//첫번째 경우
			if(cur.A != cur.B) {
				int nextA = 0;
				int nextB = 0;
				//돌의 개수가 작은 쪽을 X, 큰쪽을 Y라고 정한다.
				//X에 있는 돌의 개수를 X+X
				//Y에 있는 돌의 개수를 Y-X
				if(cur.A < cur.B) {
					nextA = cur.A + cur.A;
					nextB = cur.B - cur.A;

				}else if(cur.A > cur.B) {
					nextA = cur.A - cur.B;
					nextB = cur.B + cur.B;
				}

				if(!visit[nextA][nextB] ){
					q.add(new Pos(nextA, nextB, cur.C));
					visit[nextA][nextB] = true;
				}

			}
			//두번째 경우
			if(cur.B != cur.C) {
				int nextB = 0;
				int nextC = 0;
				//돌의 개수가 작은 쪽을 X, 큰쪽을 Y라고 정한다.
				//X에 있는 돌의 개수를 X+X
				//Y에 있는 돌의 개수를 Y-X
				if(cur.B < cur.C) {
					nextB = cur.B+cur.B;
					nextC = cur.C-cur.B;
				}else if(cur.B > cur.C) {
					nextB = cur.B - cur.C;
					nextC = cur.C + cur.C;
				}

				if(!visit[nextB][nextC]) {
					visit[nextB][nextC] = true;
					q.add(new Pos(cur.A, nextB, nextC));
				}

			}
			//세번째 경우
			if(cur.A != cur.C) {
				int nextA = 0;
				int nextC = 0;
				//돌의 개수가 작은 쪽을 X, 큰쪽을 Y라고 정한다.
				//X에 있는 돌의 개수를 X+X
				//Y에 있는 돌의 개수를 Y-X
				if(cur.A < cur.C) {
					nextA = cur.A + cur.A;
					nextC = cur.C - cur.A;
				}else if(cur.A > cur.C) {
					nextA = cur.A - cur.C;
					nextC = cur.C + cur.C;
				}

				if(!visit[nextA][nextC]) {
					visit[nextA][nextC] = true;
					q.add(new Pos(nextA, cur.B, nextC));
				}

			}
		}
		System.out.println(ans == true ? "1" : "0");
	}
}
