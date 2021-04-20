package day0207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 이분그래프 {
	static class Pos{
		int vertex;
		int color;
		Pos(int vertex, int color){
			this.vertex = vertex;
			this.color = color;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for(int t=0;t <T; ++t) {
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			int numOfvertex = scan.nextInt();
			int numOfEdge = scan.nextInt();
			for(int i = 0; i<=numOfvertex; ++i) {
				graph.add(new ArrayList<>());

			}
			int[] visitcolor = new int[numOfvertex+1];
			boolean[] visit = new boolean[numOfvertex+1];
			for(int i =0; i<numOfEdge; ++i) {
				int v1 = scan.nextInt();
				int v2 = scan.nextInt();
				graph.get(v1).add(v2);
				graph.get(v2).add(v1);
			}

			boolean flag = true;
			//이거때문에 개고생...정점 1만 탐색하면안됨.
			/*
			 * 1만 검색했을 때 이게 반례!!
			 * 1    ==>testCase
			 * 5 4  ==>정점 5개, 간선 4개
			 * 1 2
			 * 3 4
			 * 4 5
			 * 3 5
			 *
			 * */
			for(int v = 1; v<=numOfvertex; ++v) {
				if(!visit[v]) {
					flag = bfs(v, graph, visitcolor, visit);
					if(!flag)
						break;
				}
			}
			//bfs(1, graph, visitcolor, visit);
			System.out.println(flag == true ? "YES":"NO");
		}
	}

	static boolean bfs(int vertex, ArrayList<ArrayList<Integer>> graph, int[] visitColor, boolean[] visit) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(vertex, 1));
		visit[vertex] = true;
		visitColor[vertex] = 1;
		while(!q.isEmpty()) {
			Pos now = q.poll();
			int v = now.vertex;
			int color = now.color;
			int nextColor = 0;
			if(color == 1) {
				nextColor = 2;
			}else if(color == 2) {
				nextColor = 1;
			}

			for(int nextV : graph.get(v)) {
				if(visitColor[nextV] == 0 && !visit[nextV]) {
					q.add(new Pos(nextV, nextColor));
					visitColor[nextV] = nextColor;
					visit[nextV] = true;
				} else if ( now.color == visitColor[nextV] ) {
					return false;
				}
			}
		}
		return true;
	}
}
