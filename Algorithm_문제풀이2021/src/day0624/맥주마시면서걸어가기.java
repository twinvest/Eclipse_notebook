package day0624;

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
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		ArrayList<Pos> list;
		ArrayList<ArrayList<Integer>> graph;
		for(int t = 0; t < testCase; ++t) {
			int numOfMart = scan.nextInt();
			list = new ArrayList<>();
			graph = new ArrayList<>();
			for(int i =0; i<numOfMart+2; ++i) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				list.add(new Pos(y,x));
				graph.add(new ArrayList<>());
			}

			for(int i =0; i<numOfMart+2; ++i) {
				for(int j =i+1; j<numOfMart+2; ++j) {
					if(Math.abs(list.get(i).y - list.get(j).y) + Math.abs(list.get(i).x - list.get(j).x) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}

			if( bfs(graph, numOfMart) ) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}

	}
	static boolean bfs(ArrayList<ArrayList<Integer>> graph, int N) {
		boolean[] visit = new boolean[N+2];
		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		visit[0] = true;

		while(!q.isEmpty()) {
			int cur = q.poll();

			//N+1이란건 목적지에 도착했다는것임.
			if(cur == N+1) {
				return true;
			}

			for(int next : graph.get(cur)) {
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
				}
			}
		}

		return false;
	}
}
