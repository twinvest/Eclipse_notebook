package day0214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어 {
	static class Pos{
		int y;
		int x;
		int d;
		int weight;
		int numOfEatfish;
		Pos(int y, int x, int d, int weight, int numOfEatfish){
			this.y = y;
			this.x = x;
			this.d = d;
			this.weight = weight;
			this.numOfEatfish = numOfEatfish;
		}
	}
	static boolean inside(int y,int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}
	static int[][] dir = {
			{-1,0},
			{0,-1},
			{0,1},
			{1,0}
	};
	static int[][] originMap;
	static int[][] curMap;
	static boolean[][] visit;
	static int curTime = -987654321;
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		originMap = new int[N][N];
		curMap = new int[N][N];
		visit = new boolean[N][N];
		Pos start = null;
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				originMap[i][j] = scan.nextInt();
				if(originMap[i][j] == 9) {
					start = new Pos(i,j,0,2,0);
					originMap[i][j] = 0;
				}
				curMap[i][j] = originMap[i][j];
			}
		}

		bfs(start);
		System.out.println(curTime == -987654321 ? 0 : curTime);
	}


	static void bfs(Pos start) {
		Queue<Pos> q = new LinkedList<>();
		q.add(start);
		visit[start.y][start.x] = true;

		while(isEat(q.peek())) {
			Pos now = q.poll();
			for(int d =0; d<4; ++d) {
				int ny =now.y + dir[d][0];
				int nx = now.x + dir[d][1];
				if(inside(ny,nx) && curMap[ny][nx] <= now.weight && !visit[ny][nx]) {
					if(curMap[ny][nx] == 0) {
						Pos nextPos = new Pos(ny,nx,now.d+1,now.weight,now.numOfEatfish);
						q.add(nextPos);
					} else {
						//작으면 먹음.
						if(curMap[ny][nx] < now.weight) {
							int nextNumOfEatfish = now.numOfEatfish+1;
							int nextWeight = now.weight;
							if(nextNumOfEatfish == now.weight) {
								nextNumOfEatfish = 0;
								nextWeight += 1;
							}
							Pos nextPos = new Pos(ny,nx,now.d+1,nextWeight,nextNumOfEatfish);
							curMap[ny][nx] = 0;
							while(!q.isEmpty()) {
								q.poll();
							}
							for(int i =0; i<N; ++i) {
								for(int j =0; j<N; ++j) {
									visit[i][j] = false;
								}
							}
							q.add(nextPos);
							visit[ny][nx] = true;
							curTime = Math.max(nextPos.d, curTime);
							break;
						}
						//같으면 이동만 가능.
						else if(curMap[ny][nx] == now.weight){
							Pos nextPos = new Pos(ny,nx,now.d+1,now.weight,now.numOfEatfish);
							q.add(nextPos);
						}
					}
					visit[ny][nx] = true;
				}
			}
		}
	}

	//먹을게 남아있는지 확인하는 함수
	static boolean isEat(Pos now) {
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(curMap[i][j] < now.weight && curMap[i][j] != 0) {
					return true;
				}
			}
		}
		curTime = Math.max(now.d, curTime);
		return false;
	}
}
