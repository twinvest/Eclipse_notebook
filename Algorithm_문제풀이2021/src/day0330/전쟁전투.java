package day0330;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 전쟁전투 {
	static class Pos {
		int y;
		int x;
		String wb;
		Pos(int y, int x, String wb){
			this.y=y;
			this.x=x;
			this.wb = wb;
		}
	}

	static String[][] map;
	static boolean[][] visit;
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static boolean inside(int y, int x) {
		return y>=0 && y<M && x>=0 && x<N;
	}
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new String[M][N];
		visit = new boolean[M][N];
		for(int i=0; i<M;++i) {
			String tmp = scan.next();
			for(int j=0; j<tmp.length(); ++j) {
				map[i][j] = tmp.charAt(j)+"";
			}
		}
		int w = 0;
		int b = 0;
		for(int i =0; i<M;++i) {
			for(int j =0; j<N;++j) {
				//방문안했으면
				if(!visit[i][j] && map[i][j].equals("W")) {
					w +=  Math.pow(bfs(i,j,"W"), 2);
				}else if(!visit[i][j] && map[i][j].equals("B")) {
					b += Math.pow(bfs(i,j,"B"), 2);
				}
			}
		}
		System.out.println(w+" "+b);

	}
	static int bfs(int y, int x, String wb) {
		int cnt = 1;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y, x, wb));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int d=0; d<4; ++d) {
				int ny = pos.y + dir[d][0];
				int nx = pos.x + dir[d][1];
				if(inside(ny,nx) && !visit[ny][nx] && map[ny][nx].equals(wb)) {
					visit[ny][nx] = true;
					q.add(new Pos(ny,nx,wb));
					++cnt;
				}
			}
		}
		return cnt;
	}

}
