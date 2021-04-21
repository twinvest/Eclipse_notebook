package day0421;

import java.util.ArrayList;
import java.util.Scanner;
public class 촌수계산 {
	static int start, end, ans, count;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfPeople = scan.nextInt();
		visit = new boolean[numOfPeople+1];
		start = scan.nextInt();
		end = scan.nextInt();
		for(int i=0; i<=numOfPeople; ++i) {
			graph.add(new ArrayList<>());
		}
		int numOfEdge = scan.nextInt();
		for(int i =0; i<numOfEdge; ++i) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		dfs(start);
		if(flag) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
	static boolean flag = false;
	static void dfs(int vertex) {
		visit[vertex] = true;
		++count;
		for(int nextVertex : graph.get(vertex)) {
			if(!visit[nextVertex]) {
				if(nextVertex == end) {
					ans = count;
					flag = true;
				} else {
					dfs(nextVertex);
				}
			}
		}
		--count;
	}
}
