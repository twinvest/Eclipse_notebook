package day0628;

import java.util.Scanner;

public class 게리맨더링 {
	static int N;
	static int[] peopleArr = new int[11];
	static int[] sel;
	static int ans = 987654321;
	static int[][] graph = new int[11][11];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for(int i = 1; i <= N; ++i) {
			peopleArr[i] = scan.nextInt();
		}

		for(int i=1; i<=N; ++i) {
			int numOfEdge = scan.nextInt();
			for(int j=0; j<numOfEdge; ++j ) {
				graph[i][scan.nextInt()] = 1;
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

	static int[] group ;
	static boolean[] visit;
	static int partSum;

	static void calc() {
		group = new int[N+1];
		visit = new boolean[N+1];
		for(int i : sel)
			group[i] = 1;

		int people1 = 0;
		int people2 = 0;
		for(int i = 1; i<N+1; i++) {
			if(group[i] == 1 && !visit[i]) {
				partSum = 0;
				dfs(i);
				people1 = partSum;
				break;
			}
		}

		for(int i = 1; i<N+1; i++) {
			if(group[i] == 0 && !visit[i]) {
				partSum = 0;
				dfs(i);
				people2 = partSum;
				break;
			}
		}

		//한곳이라도 방문하지 않은곳이 있다면 종료
		for(int i = 1; i<N+1; i++) {
			if(!visit[i]) {
				return;
			}
		}
		ans = Math.min(Math.abs(people2-people1), ans);
	}



	static void dfs(int vertex) {
		visit[vertex] = true;
		partSum += peopleArr[vertex];
		for(int i = 1; i<=N; i++) {
			//방문했는지, 같은 지역구에 속하는지, 연결이 되어있는지
			if(!visit[i] && group[vertex] == group[i] && graph[i][vertex] == 1) {
				dfs(i);
			}
		}
	}

}
