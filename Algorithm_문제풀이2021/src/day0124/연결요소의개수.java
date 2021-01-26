package day0124;

import java.util.ArrayList;
import java.util.Scanner;

public class 연결요소의개수 {
	static int ans = 0;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfVertex = scan.nextInt();
		int numOfEdge = scan.nextInt();
		visit = new boolean[numOfVertex+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i<=numOfVertex; ++i) {
			graph.add(new ArrayList<>());
		}

		for(int i =0;i <numOfEdge; ++i) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for(int i = 1; i < visit.length; ++i) {
			if(!visit[i]) {
				dfs(i, graph);
				++ans;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int curVertex, ArrayList<ArrayList<Integer>> graph) {
		if(!visit[curVertex]) {
			visit[curVertex] = true;
			for(int nextVertex : graph.get(curVertex)) {
				dfs(nextVertex, graph);
			}
		}
	}

}
