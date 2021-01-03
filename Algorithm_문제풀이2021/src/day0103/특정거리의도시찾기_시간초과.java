package day0103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 특정거리의도시찾기_시간초과 {
	static class Pos{
		int src;
		int dest;
		int d;


		Pos(int src, int dest){
			this.src = src;
			this.dest = dest;
		}
	}

	static ArrayList<Pos> graph;
	static ArrayList<Integer> ansList;
	static Queue<Pos> queue;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//도시의개수
		int N = scan.nextInt();
		//도로의개수. 단방향도로 M개
		int M = scan.nextInt();
		//출발도시에서 k거리만큼에 존재한 도시를 구하즈앗! 여러개면 번호낮은순으로 오름차순.
		int K = scan.nextInt();
		//출발도시의 vertex
		int X = scan.nextInt();

		graph = new ArrayList<>();
		queue = new LinkedList<>();
		ansList = new ArrayList<>();
		visit = new boolean[N+1];
		for(int i = 0; i<M; ++i) {
			int src = scan.nextInt();
			int dest = scan.nextInt();
			graph.add(new Pos(src, dest));
		}
		search(X,K,1);
		if(ansList.size() == 0)
			ansList.add(-1);
		Collections.sort(ansList);
		for(int ans : ansList) {
			System.out.println(ans);
		}

	}

	static void search(int vertex, int distance, int curDistance) {
		for(Pos pos : graph) {
			if(pos.src == vertex && !visit[vertex]) {
				pos.d = curDistance;
				queue.add(pos);
			}
		}

		visit[vertex] = true;

		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			if(pos.d == distance && !visit[pos.dest])
				ansList.add(pos.dest);

			for(Pos nextPos : graph) {
				if(nextPos.src == pos.dest && !visit[pos.dest]) {
					nextPos.d = pos.d+1;
					queue.add(nextPos);
				}
			}
			visit[pos.dest] = true;
		}
	}
}
