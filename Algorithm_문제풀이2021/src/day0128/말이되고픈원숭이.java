package day0128;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이 {
	static int K, C, R;
	static int minMoveCnt;
	static int[][] map;
	static int[][] dirM = {{0,-1},{0,1},{1,0},{-1,0}};
	static int[][] dirH = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		K = scan.nextInt();
		C = scan.nextInt();
		R = scan.nextInt();
		map = new int[R][C];
		for(int r = 0; r<R; ++r) {
			for(int c=0; c<C; ++c) {
				map[r][c] = scan.nextInt();
			}
		}

		minMoveCnt = Integer.MAX_VALUE;
		bfs();
		System.out.println(minMoveCnt == Integer.MAX_VALUE ? -1 : minMoveCnt);
	}
	static class Monkey{
		int row, col;
		int depth;  //이동횟수
		int horseMove; //말로이동한회수
		public Monkey(int row, int col, int depth, int horseMove) {
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.horseMove = horseMove;
		}
	}
	static boolean inside(int row,int col) {
		return 0 <= row && row <R && 0 <= col && col < C;
	}

	static void bfs() {
		//K는 회수이므로 +1필요. (말로 이동한 횟수)
		boolean[][][] visit = new boolean[R][C][K+1];
		Queue<Monkey> q = new LinkedList<>();
		Monkey start = new Monkey(0,0,0,0);
		q.offer(start);
		visit[0][0][0] = true;

		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			//목적지에 도착한 경우
			if(cur.row == R-1 && cur.col == C-1) {
				minMoveCnt = cur.depth;
				return;
			}

			//원숭이처럼 이동해보기
			moveLikeMonkey(q,cur,visit);
			//만약 가능하다면 말처럼 이동해보기
			if(cur.horseMove < K) {
				moveLikeHorse(q,cur,visit);
			}
		}
	}

	static void moveLikeMonkey(Queue<Monkey> q, Monkey cur, boolean[][][] visit) {
		for(int d =0; d<4; ++d) {
			int ny = cur.row + dirM[d][0];
			int nx = cur.col + dirM[d][1];
			//범위안이면서 장애물이 없으면
			if(inside(ny,nx) && map[ny][nx] == 0) {
				//그리고 방문하지 않았으면
				if(!visit[ny][nx][cur.horseMove]) {
					Monkey newMonkey = new Monkey(ny,nx, cur.depth+1, cur.horseMove);
					visit[ny][nx][cur.horseMove] = true;
					q.offer(newMonkey);
				}
			}
		}
	}

	static void moveLikeHorse(Queue<Monkey> q, Monkey cur, boolean[][][] visit) {
		for(int d =0; d<8; ++d) {
			int ny = cur.row + dirH[d][0];
			int nx = cur.col + dirH[d][1];
			//범위안이면서 장애물이 없으면
			if(inside(ny,nx) && map[ny][nx] == 0) {
				//그리고 방문하지 않았으면
				int nk = cur.horseMove+1;
				if(!visit[ny][nx][nk]) {
					Monkey newMonkey = new Monkey(ny,nx, cur.depth+1, nk);
					visit[ny][nx][nk] = true;
					q.offer(newMonkey);
				}
			}
		}
	}
}
