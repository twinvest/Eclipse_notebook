package day0211;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소2 {
	static int N;
	static int[][] map;
	static int numOfVirus;
	static int[][] dir = {
			{0,1}
			,{0,-1}
			,{1,0}
			,{-1,0}
	};
	static boolean inside(int y,int x) {
		return (y>=0 && y<N) && (x>=0 && x<N);
	}
	static class Pos {
		int y;
		int x;
		int d;
		Pos(int y, int x , int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N][N];
		numOfVirus = scan.nextInt();
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				map[i][j] = scan.nextInt();
			}
		}
		solution3(0,0);
		Collections.sort(ansList);
		System.out.println(ansList.size() == 0 ? -1 : ansList.get(0));
	}

	static void solution3(int idx, int pick) {
		int N = map.length;
		int M = map[0].length;
		if (pick == numOfVirus) {
			bfs();
			//System.out.println(ans);
			return;
		}
		if (idx == N * M) {
			return;
		}
		int r = idx / M;
		int c = idx % M;
		if (map[r][c] == 2) {
			map[r][c] = -1;
			solution3(idx + 1, pick + 1);
			map[r][c] = 2;
		}
		solution3(idx + 1, pick);
	}
	static int ans = 987654321;
	static ArrayList<Integer> ansList = new ArrayList<>();
	static void bfs() {
		int[][] copyMap = new int[N][N];
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] visit = new boolean[N][N];
		for(int i =0; i<N; ++i) {
			for(int  j=0; j<N; ++j) {
				if(map[i][j] == -1) {
					q.add(new Pos(i,j,0));
					visit[i][j] = true;
				}
			}
		}

		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				copyMap[i][j] = map[i][j];
				if(map[i][j] == 2) {
					copyMap[i][j] = 0;
				}
				if(map[i][j] == 1) {
					copyMap[i][j] = -2;
				}
			}
		}
		boolean flag = false;
		ans = 987654321;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(isCheck(copyMap)) {
				flag = true;
				break;
			}
			for(int d =0;d <4; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];
				if(inside(ny,nx) && copyMap[ny][nx] == 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new Pos(ny,nx,cur.d+1));
					copyMap[ny][nx] = cur.d+1;
				}
			}
		}

		if(flag) {
			if(ans == -1) {
				ansList.add(0);
			}else {
				ansList.add(ans);
			}

		}

	}
	static boolean isCheck(int[][] copyMap) {
		int answer = -987654321;
		for(int i =0; i<N; ++i) {
			for(int j =0; j<N; ++j) {
				if(copyMap[i][j] == 0)
					return false;
				if(copyMap[i][j] > answer) {
					answer = copyMap[i][j];
				}
			}
		}
		ans = answer;
		return true;
	}
}
