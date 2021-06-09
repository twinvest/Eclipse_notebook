package day0609;

import java.util.ArrayList;
import java.util.Scanner;

public class 순열사이클 {
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for(int i =0; i<testCase; ++i) {
			int numOfVertex = scan.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for( int j=0; j <= numOfVertex; ++j ) {
				graph.add(new ArrayList<>());
			}
			for( int j=1; j <= numOfVertex; ++j ) {
				graph.get(j).add(scan.nextInt());
			}

			visit = new boolean[numOfVertex+1];
			int ans = 0;
			for(int j=1; j<=numOfVertex; ++j) {
				if(!visit[j]) {
					visit[j] = true;
					dfs(graph, j);
					++ans;
				}
			}
			System.out.println(ans);
		}
	}

	static void dfs(ArrayList<ArrayList<Integer>> graph, int cur) {
		for(int next : graph.get(cur)) {
			if(!visit[next]) {
				visit[next] = true;
				dfs(graph, next);
			}
		}
	}
}
