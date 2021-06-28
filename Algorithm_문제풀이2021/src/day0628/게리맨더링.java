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
	static int ans = 987654321;
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

		if(ans == 987654321)
			ans = -1;
		System.out.println(ans);

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

		if(search(group1) && search(group2)) {
			int team1 =0;
			int team2= 0;
			for(int a : group1) {
				team1 += peopleArr[a];
			}

			for(int a : group2) {
				team2 += peopleArr[a];
			}
			ans = Math.min(Math.abs(team1 - team2), ans);
		}
	}

	static boolean bfs(int vertex, ArrayList<Integer> group) {
		boolean[] targetVisit = new boolean[N+1];
		boolean[] visit = new boolean[N+1];
		for(int num : group) {
			targetVisit[num] = true;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		visit[vertex] = true;

		while(!q.isEmpty()) {
			int cnt = 0;
			int cur = q.poll();
			for(int num : group) {
				if(targetVisit[num] == visit[num])
					++cnt;
			}

			if(cnt == group.size())
				return true;

			for(int next : graph.get(cur)) {
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
				}
			}
		}

		return false;

	}

	static boolean search(ArrayList<Integer> group) {
		boolean flag = false;
		for(int vertex : group) {
			flag = bfs(vertex, group);
			if(flag) break;
		}
		return flag;
	}

}
