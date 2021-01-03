package day0102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 특정거리의도시찾기_메모리초과 {
	static class Pos{
		int y;
		int x;
		int d;
		Pos(int y, int x, int d){
			this.y= y;
			this.x=x;
			this.d=d;
		}
	}

	static int[][] graph;
	static boolean[] visit;
	static ArrayList<Integer> ansList;
	static Queue<Pos> queue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//도시의개수
		int N = scan.nextInt();
		//도로의개수. 단방향도로 M개
		int M = scan.nextInt();
		//출발도시에서 k거리만큼에 존재한 도시를 구하즈앗! 여러개면 번호낮은순으로 오름차순.
		int K = scan.nextInt();
		//출발도시의 vertex
		int X = scan.nextInt();

		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		ansList = new ArrayList<>();
		queue = new LinkedList<>();
		for(int i = 0; i < M; ++i) {
			int src = scan.nextInt();
			int dest = scan.nextInt();
			graph[src][dest] = 1;
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
		int[] adjVertex = graph[vertex];
		for(int x =0; x<adjVertex.length; ++x) {
			if(adjVertex[x] == 1 && !visit[vertex]) {

				Pos pos = new Pos(vertex, x, curDistance);
				queue.offer(pos);
			}
		}
		visit[vertex] = true;
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			if (pos.d == distance && !visit[pos.x]) {
				ansList.add(pos.x);
			}

			adjVertex = graph[pos.x];
			for(int x =0; x < adjVertex.length; ++x) {
				if(adjVertex[x] == 1 && !visit[x]) {

					Pos nextPos = new Pos(pos.x, x, pos.d+1);
					queue.offer(nextPos);
				}
			}
			visit[pos.x] = true;
		}
	}
}
