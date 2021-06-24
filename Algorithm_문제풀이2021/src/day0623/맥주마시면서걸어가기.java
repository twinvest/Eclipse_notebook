package day0623;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 맥주마시면서걸어가기 {
	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static ArrayList<Pos> martList = new ArrayList<>();
	static Pos home;
	static Pos target;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for(int t = 0; t<testCase; ++t) {
			int numOfMart = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			home = new Pos(y,x);
			for(int i = 0; i<numOfMart; ++i) {
				x = scan.nextInt();
				y = scan.nextInt();
				Pos mart = new Pos(y,x);
				martList.add(mart);
			}

			x = scan.nextInt();
			y = scan.nextInt();
			target = new Pos(y,x);
			bfs();
		}

	}
	static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(home);

		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(Math.abs(cur.y - target.y) + Math.abs(cur.x - target.x) <= 1000) {
				System.out.println("happy");
				return;
			} else {

				for(Pos mart : martList) {
					if(Math.abs(cur.y - mart.y) + Math.abs(cur.x - mart.x) <= 1000) {
						q.add(mart);
						martList.remove(mart);
						break;
					}
				}

			}
		}

		System.out.println("sad");

	}

}
