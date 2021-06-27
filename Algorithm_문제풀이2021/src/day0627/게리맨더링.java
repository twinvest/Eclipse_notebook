package day0627;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 풀기전 고민을 많이함. 생각한 접근법
 * bfs를 돌리면서 그룹이된것과 그룹이 되지 않은 것으로 나눔. 그런데 1번정점부터 N번정점까지 모두 돌려봐야할것같다는 생각이 듦.
 * 그룹이 되지 않은 것들은 그들끼리 모아서 BFS를 한번 더 돌려보자.
 *
 * */
public class 게리맨더링 {
	static int[] peopleArr = new int[11];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<Integer> election;
	static boolean[] visit, visit2;
	static int N;
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

		for(int vertex = 1; vertex<=N; ++vertex) {
			visit = new boolean[11];
			election = new ArrayList<>();
			bfs(vertex);
		}

		if(ans == 987654321)
			ans = -1;
		System.out.println(ans);
	}

	static void bfs(int vertex) {
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		visit[vertex] = true;

		while(!q.isEmpty()) {
			int cur = q.poll();
			election.add(cur);
			ans = Math.min(ans, calcPopulataion());

			for(int next : graph.get(cur)) {
				if(!visit[next]) {
					visit[next] = true;
					q.add(next);
				}
			}
		}
	}

	static int bfs2(int vertex) {
		int team2 = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		visit2[vertex] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			team2 += peopleArr[cur];
			for(int next : graph.get(cur)) {
				if(!visit2[next]) {
					visit2[next] = true;
					q.add(next);
				}
			}
		}

		return team2;
	}


	static int calcPopulataion() {
		int team1 = 0;
		int team2 = 0;
		visit2 = new boolean[11];

		for(int i =0; i<election.size(); ++i) {
			team1 += peopleArr[election.get(i)];
			visit2[election.get(i)] = true;
		}

		for(int vertex = 1; vertex <= N; ++vertex) {
			if(!visit2[vertex]) {
				team2 = bfs2(vertex);
				break;
			}
		}

		boolean flag = false;
		for(int i =1; i<=N; ++i) {
			//visit2에서 한번이라도 false가 나오면
			if(!visit2[i]) {
				//두 개 그룹으로 못만드거임.
				flag = true;
			}
		}

		if(flag) {
			return 987654321;
		}else {
			print();
			return Math.abs(team2 - team1);
		}

	}
	static void print() {
		System.out.println();
		for(int i =0; i<election.size(); ++i) {
			System.out.print(election.get(i)+" ");
		}
		System.out.println();
	}
}
