package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 돌그룹_2 {
	static class Pos{
		int A,B,C;
		Pos(int A, int B, int C){
			this.A=A;
			this.B=B;
			this.C=C;
		}
	}

	static int A,B,C;
	static boolean ans = false;
	static boolean[][] visit = new boolean[5001][5001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(A,B,C));
		visit[A][500+B] = true;
		visit[500+B][1000+C] = true;
		visit[A][1000+C] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.A == cur.B && cur.B == cur.C && cur.A == cur.C) {
				ans = true;
			}

			//첫번째 경우
			if(cur.A != cur.B) {
				int X = 0;
				int Y = 0;
				//돌의 개수가 작은 쪽을 X, 큰쪽을 Y라고 정한다.
				if(cur.A < cur.B) {
					X = cur.A;
					Y = cur.B;
					int nx = X+X;
					int ny = Y-X;
					//!visit[nx][500+ny][1000+cur.C]
					if((!visit[nx][500+ny] &&!visit[500+ny][1000+cur.C] && !visit[nx][1000+cur.C] )) {
						q.add(new Pos(nx, ny, cur.C));
						visit[nx][500+ny] = true;
						visit[500+ny][1000+cur.C] = true;
						visit[nx][1000+cur.C] = true;
					}
				}else if(cur.A > cur.B) {
					X = cur.B;
					Y = cur.A;
					int nx = X+X;
					int ny = Y-X;
					//!visit[ny][500+nx][1000+cur.C]
					if(!visit[ny][500+nx] && !visit[500+nx][1000+cur.C] && !visit[ny][1000+cur.C] ) {
						q.add(new Pos(ny, nx, cur.C));
						visit[ny][500+nx] = true;
						visit[500+nx][1000+cur.C] = true;
						visit[ny][1000+cur.C] = true;
					}
				}
			}
			//두번째 경우
			if(cur.B != cur.C) {
				int X = 0;
				int Y = 0;
				//돌의 개수가 작은 쪽을 X, 큰쪽을 Y라고 정한다.
				if(cur.B < cur.C) {
					X = cur.B;
					Y = cur.C;
					int nx = X+X;
					int ny = Y-X;
					//!visit[cur.A][500+nx][1000+ny]
					if(!visit[cur.A][500+nx] && !visit[500+nx][1000+ny] && !visit[cur.A][1000+ny]) {
						q.add(new Pos(cur.A, nx, ny));
						visit[cur.A][500+nx] = true;
						visit[500+nx][1000+ny] = true;
						visit[cur.A][1000+ny] = true;
					}

				}else if(cur.B > cur.C) {
					X = cur.C;
					Y = cur.B;
					int nx = X+X;
					int ny = Y-X;
					if(!visit[cur.A][ny+500] && !visit[ny+500][nx+1000] && !visit[cur.A][nx+1000]) {
						q.add(new Pos(cur.A, ny, nx));
						visit[cur.A][ny+500] = true;
						visit[ny+500][nx+1000] = true;
						visit[cur.A][nx+1000] = true;
					}
				}
			}
			//세번째 경우
			if(cur.A != cur.C) {
				int X = 0;
				int Y = 0;
				//돌의 개수가 작은 쪽을 X, 큰쪽을 Y라고 정한다.
				if(cur.A < cur.C) {
					X = cur.A;
					Y = cur.C;
					int nx = X+X;
					int ny = Y-X;
					//!visit[nx][cur.B][ny]
					if(!visit[nx][cur.B+500] && !visit[cur.B+500][ny+1000] && !visit[nx][ny+1000]) {
						q.add(new Pos(nx, cur.B, ny));
						visit[nx][cur.B+500] = true;
						visit[cur.B+500][ny+1000] = true;
						visit[nx][ny+1000] = true;
					}

				}else if(cur.A > cur.C) {
					X = cur.C;
					Y = cur.A;
					int nx = X+X;
					int ny = Y-X;
					//!visit[ny][cur.A][nx]
					if(!visit[ny][cur.B+500] && !visit[cur.B+500][nx+1000] && !visit[ny][nx+1000]) {
						q.add(new Pos(ny, cur.B, nx));
						visit[ny][cur.B+500] = true;
						visit[cur.B+500][nx+1000] = true;
						visit[ny][nx+1000] = true;
					}
				}
			}
		}
		System.out.println(ans == true ? "1" : "0");
	}
}
