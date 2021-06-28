package day0628;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게리맨더링 {
	static int N;
	static int[] peopleArr = new int[11];
	static int[] sel;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for(int i = 1; i <= N; ++i) {
			peopleArr[i] = scan.nextInt();
		}

		for(int i=0; i<=N; ++i) {
			graph.add(new ArrayList<>());
		}

		for(int i=1; i<=N; ++i) {
			int numOfEdge = scan.nextInt();
			for(int j=0; j<numOfEdge; ++j ) {
				graph.get(i).add(scan.nextInt());
			}
		}
		for(int i=1; i<=N/2; ++i) {
			sel = new int[i];
			combination(1, 0);
		}

	}

	static void combination(int idx, int s_idx) {
		if( s_idx == sel.length )
		{
			//System.out.println(Arrays.toString(sel));
			calc();
			return;
		}
		if( idx == N+1 )
			return;

		sel[s_idx] = idx;
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}

	static void calc() {
		boolean[] tmpCheck = new boolean[N+1];
		ArrayList<Integer> group1 = new ArrayList<>();
		ArrayList<Integer> group2 = new ArrayList<>();

		for(int i : sel) {
			tmpCheck[i] = true;
			group1.add(i);
		}

		for(int i =1; i<=N; ++i) {
			if(!tmpCheck[i]) {
				group2.add(i);
			}
		}

		boolean flag1 = bfs1(group1.get(0), group1);
		boolean flag2 = bfs2(group2.get(0), group2);

		if (flag1 && flag2) {
			//ans = Math.min(ans, );
		}

	}
	static int ans = 987654321;
	static boolean[] visit1 = new boolean[N+1];
	static boolean[] visit2 = new boolean[N+1];

	static boolean bfs1(int vertex, ArrayList<Integer> group1) {
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		visit1[vertex] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i =0; i<group1.size(); ++i) {

			}

			for(int next : graph.get(cur)) {
				if(!visit1[next]) {
					visit1[next] = true;
					q.add(next);
				}
			}
		}
		return false;
	}

	static boolean bfs2(int vertex, ArrayList<Integer> group2) {
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		visit2[vertex] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int next : graph.get(cur)) {
				if(!visit2[next]) {
					visit2[next] = true;
					q.add(next);
				}
			}
		}
		return false;
	}
}
