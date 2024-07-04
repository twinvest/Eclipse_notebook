package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 움직이는미로탈출 {
	static char[][][] map;
	static boolean[][][] visit;
	static class Pos{
		int y;
		int x;
		int time;
		Pos(int y, int x, int time){
			this.y=y;
			this.x=x;
			this.time = time;
		}
	}
	static boolean inside(int y, int x) {
		return (y>=0 && y<8) && (x>=0 && x<8);
	}
	static int[][] dir = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
			{-1,1},
			{-1,-1},
			{1,1},
			{1,-1},
			{0,0}
	};
	static ArrayList<Pos> wallList = new ArrayList<>();
	static int limitTime;
	public static void main(String[] args) {
		map = new char[8][8][10];
		visit = new boolean[8][8][10];
		Scanner scan = new Scanner(System.in);
		for(int i =0; i<8; ++i) {
			String str = scan.next();
			for(int j=0; j<8; ++j) {
				char ch = str.charAt(j);
				map[i][j][0] = ch;
				if(ch == '#') wallList.add(new Pos(i,j,0));
			}
		}

		wallSimulation();
		//printMap();
		System.out.println(bfs() ? "1" :"0");
	}

	static void printMap() {
		for(int t=0; t<limitTime; ++t) {
			for(int i=0; i<8; ++i) {
				for(int j=0; j<8; ++j) {
					System.out.print(map[i][j][t] +" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	static void wallSimulation() {
		for(int t =1; t<=9; ++t) {

			for(int i=0; i<8; ++i) {
				for(int j=0; j<8; ++j) {
					map[i][j][t] = '.';
				}
			}

			if(wallList.size() == 0) {
				limitTime = t;
				break;
			}

			for(int k =0; k<wallList.size();++k) {
				Pos cur = wallList.get(k);
				cur.y +=1;
				if(cur.y == 8) {
					wallList.remove(k);
					--k;
					continue;
				}

				map[cur.y][cur.x][t] = '#';
			}
		}
	}

	static boolean bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(7,0,0));

		//요걸 방문처리하는순간 시작하는 칸에 한번더 못있음...
		//visit[7][0][0] = true; ㅅㅂ이게 지리노...

		while(!q.isEmpty()) {
			Pos cur = q.poll();

			if(cur.x == 7 && cur.y == 0)
				return true;

			if(cur.time >= limitTime)
				return true;

			if(map[cur.y][cur.x][cur.time] == '#')
				continue;

			for(int d=0; d<9; ++d) {
				int ny = cur.y + dir[d][0];
				int nx = cur.x + dir[d][1];

				//방문할 곳이 범위를 벗어났다면
				if(!inside(ny,nx)) continue;
				//현재시간에서 이동할 곳이 벽이라면
				if(map[ny][nx][cur.time] == '#') continue;
				//현재시간에서 이동할 곳이 방문한 곳이라면
				if(visit[ny][nx][cur.time]) continue;

				visit[ny][nx][cur.time] = true;
				q.add(new Pos(ny,nx,cur.time+1));
			}
		}

		return false;
	}

}
