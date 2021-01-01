package day0101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS기본템플릿 {
	public static void main(String[] args) {
		boolean[] visit = new boolean[9];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		//1번정점은 2번정점과 3번정점 그리고 8번정점과 연결되어 있음을 의미
		ArrayList<Integer> vertex1 = new ArrayList<>();
		vertex1.add(2); vertex1.add(3); vertex1.add(8);

		ArrayList<Integer> vertex2 = new ArrayList<>();
		vertex2.add(1); vertex2.add(7);

		ArrayList<Integer> vertex3 = new ArrayList<>();
		vertex3.add(1); vertex3.add(4); vertex3.add(5);

		ArrayList<Integer> vertex4 = new ArrayList<>();
		vertex4.add(3); vertex4.add(5);

		ArrayList<Integer> vertex5 = new ArrayList<>();
		vertex5.add(3); vertex5.add(4);

		ArrayList<Integer> vertex6 = new ArrayList<>();
		vertex6.add(7);

		ArrayList<Integer> vertex7 = new ArrayList<>();
		vertex7.add(2); vertex7.add(6); vertex7.add(8);

		ArrayList<Integer> vertex8 = new ArrayList<>();
		vertex8.add(1); vertex8.add(7);

		ArrayList<Integer> vertex0 = new ArrayList<>(); //더미


		//vertex들을 graph리스트에 담는다.
		graph.add(vertex0); //더미
		graph.add(vertex1);
		graph.add(vertex2);
		graph.add(vertex3);
		graph.add(vertex4);
		graph.add(vertex5);
		graph.add(vertex6);
		graph.add(vertex7);
		graph.add(vertex8);

		BFS기본템플릿 기본템플릿 = new BFS기본템플릿();
		기본템플릿.bfs(graph, 1, visit);

	}
	public void bfs(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visit) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		visit[vertex] = true;

		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v+" ");
			for(int nextV : graph.get(v)) {
				if(visit[nextV] == false) {
					queue.offer(nextV);
					visit[nextV] = true;
				}
			}

		}
	}
}
