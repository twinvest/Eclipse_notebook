package day0124;

import java.util.ArrayList;
import java.util.Scanner;

public class 바이러스 {
	static int ans = 0;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfComputer = scan.nextInt();
		int numOfEdge = scan.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		visit = new boolean[numOfComputer+1];
		for(int i = 0; i<=numOfComputer; ++i) {
			graph.add(new ArrayList<Integer>());
		}

		for(int i = 0; i<numOfEdge; ++i) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		dfs(1, graph);
		System.out.println(ans-1);
	}

	static public void dfs(int curVertex, ArrayList<ArrayList<Integer>> graph) {
		if(!visit[curVertex]) {
			visit[curVertex] = true;
			++ans;
			for(int nextVertex : graph.get(curVertex)) {
				dfs(nextVertex, graph);
			}
		}
	}
}
