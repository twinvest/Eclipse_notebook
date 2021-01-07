package day0104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경쟁적전염  {
	static class Pos implements Comparable<Pos> {
		int y;
		int x;
		int t;
		int virus;
		Pos(int y, int x, int t, int virus){
			this.y=y;
			this.x=x;
			this.t=t;
			this.virus = virus;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.virus, o.virus);
		}


	}

	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};

	static boolean inside(int y, int x, int size) {
		return (y>=0 && y<size) && (x>=0 && x<size);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N, K;
		N = scan.nextInt();
		K = scan.nextInt();
		int endTime, X, Y;

		Queue<Pos> q = new LinkedList<>();
		ArrayList<Pos> posList = new ArrayList<>();
		int[][] map = new int[N][N];
		for(int i =0; i<N;++i) {
			for(int j =0; j<N;++j) {
				map[i][j] = scan.nextInt();
				if(map[i][j] != 0) {
					posList.add(new Pos(i,j,0,map[i][j]));
				}
			}
		}

		Collections.sort(posList); //이 문제에서 핵심임
		for(Pos pos : posList) {
			//q.offer(pos); 이코드 런타임에러뜸.
			q.offer(new Pos(pos.y, pos.x, pos.t, pos.virus));
		}

		endTime = scan.nextInt();
		X = scan.nextInt();
		Y = scan.nextInt();

		int time = 0;
		while(time != endTime) {
			while(!q.isEmpty() && q.peek().t == time) { //q.isEmpty()를 먼저하지 않으면 이 라인에서 런타임에러뜸.
				Pos pos = q.poll();
				for(int d =0;d<4; ++d) {
					int ny = pos.y + dir[d][0];
					int nx = pos.x + dir[d][1];
					if(inside(ny,nx,N) && map[ny][nx] == 0 && pos.t == time) {
						map[ny][nx] = pos.virus;
						q.offer(new Pos(ny,nx,pos.t+1,pos.virus));
					}
				}
			}
			++time;
		}
		System.out.println(map[X-1][Y-1]);
	}
}
