package day1226;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class 덱을이용한뱀 {
	static int[][] dir = {
			{0,1} //오른쪽
			,{1,0} //아래
			,{0,-1} //왼쪽
			,{-1,0} //위
	};
	static boolean inside(int y, int x, int size) {
		return (y >= 0 && y < size) && (x >= 0 && x < size);
	}
	static class Direction {
		int time;
		String c;
		Direction(int time, String c){
			this.time = time;
			this.c = c;
		}
	}

	static class Pos {
		int y, x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
		@Override
		public boolean equals(Object o){
			boolean isT = false;
			Pos comp = (Pos)o;
			if(this.y == comp.y && this.x == comp.x){
				isT = true;
			}
			return isT;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Queue<Direction> directionList = new LinkedList<>();
		Deque<Pos> snakeList = new ArrayDeque<>();

		int N = scan.nextInt();
		int[][] map = new int[N][N];
		int numOfApple = scan.nextInt();
		for(int i = 0; i<numOfApple; ++i) {
			int y = scan.nextInt();
			int x = scan.nextInt();
			map[y-1][x-1] = 1; //맵에서 1은 apple을 의미
		}

		int numOfDirection = scan.nextInt();
		for(int i = 0; i<numOfDirection; ++i) {
			int time = scan.nextInt();
			String c = scan.next();
			directionList.add(new Direction(time, c));
		}
		int y = 0;
		int x = 0;
		int d = 0;
		int time = 0;
		boolean flag = true;
		int preY = -1;
		int preX = -1;
		//while문을 탈출하는 경우는 1. 범위를 벗어난 경우 2. 뱀이 자신의 몸을 밟는 경우
		while(flag) {

			//다음으로 갈위치
			int ny = y +dir[d][0];
			int nx = x +dir[d][1];

			//탈출조건1
			if(!inside(ny, nx, N)) {
				flag = false;
				++time;
				continue;
			}
			//탈출조건2
			Iterator<Pos> iter = snakeList.iterator();
			while(iter.hasNext()) {
				Pos pos = iter.next();
				if(ny == pos.y && nx == pos.x) {
					flag = false;
				}
			}
			if(!flag) {
				++time;
				continue;
			}

			//사과가 있는 경우
			if(map[ny][nx] == 1) {
				map[ny][nx] = 0;
				boolean visitFlag = false;
				if(snakeList.contains(new Pos(y, x))) {
					visitFlag = true;
				}
				if(!visitFlag)
					snakeList.addFirst(new Pos(y, x));
				snakeList.addFirst(new Pos(ny, nx));
			}
			//사과가 없는 경우
			else {
				if(!snakeList.isEmpty()) {
					snakeList.removeLast();
				}
				snakeList.addFirst(new Pos(ny, nx));
			}

			y = ny;
			x = nx;

			++time;
			//해당시간인지 확인
			if(!directionList.isEmpty() && time == directionList.peek().time) {
				if ("D".equals(directionList.peek().c)) {
					++d;
				}else {
					--d;
				}
				directionList.poll();
			}
			if(d == -1) {
				d = 3;
			}
			if(d % 4 == 0)
				d = 0;
		}
		System.out.println(time);
	}
}
