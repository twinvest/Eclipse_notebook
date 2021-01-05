package day0104;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경쟁적전염 {
	static class Pos{
		int y;
		int x;
		int t;
		Pos(int y, int x, int t){
			this.y=y;
			this.x=x;
			this.t=t;
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

		endTime = scan.nextInt();
		X = scan.nextInt();
		Y = scan.nextInt();

		ArrayList<Queue<Pos>> qList = new ArrayList<>();
		for(int i = 0; i<=K; ++i) {
			Queue<Pos> q = new LinkedList<>();
			qList.add(q);
		}

		int[][] map = new int[N][N];
		for(int i =0; i<N;++i) {
			for(int j =0; j<N;++j) {
				map[i][j] = scan.nextInt();
				if(map[i][j] != 0) {
					qList.get(map[i][j]).offer(new Pos(i,j, 1));
				}
			}
		}

		int curTime = 0;
		while(endTime != curTime) {
			++curTime;
			int index = curTime % K+1;
			if(index == 0) index = 1;  //이거 index어떻게 처리할지 생각해보자.

			int curT = qList.get(index).peek().t;
			int nextT = curT;
			while(curT != nextT) {
				Pos pos = qList.get(index).poll();
				nextT = pos.t;
				for(int d = 0; d<4; ++d) {
					int ny = pos.y + dir[d][0];
					int nx = pos.x + dir[d][1];



				}
			}

		}

	}

	static boolean mapCheck(int[][] map) {
		boolean flag = false;
		int len = map.length;
		for(int i =0; i<len; ++i) {
			for(int j =0; j<len; ++j) {
				if(map[i][j] == 0) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}


}
