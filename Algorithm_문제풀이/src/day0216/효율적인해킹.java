package day0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class 효율적인해킹{
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static int[] ans = new int[10001];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();

		for(int i=0; i<M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
		int max = 0;
		for(int i=1; i<=N; ++i)
		{
			visit = new boolean[10001];
			dfs(i);
		}
		sb = new StringBuilder();

		for (int i = 1; i <= N; i++)
	        if (max < ans[i])
	            max = ans[i];

		for (int i = 1; i <= N; i++)
	        if (max == ans[i])
	            sb.append(i + " ");

	    System.out.println(sb.toString());
	}

	static void dfs(int node)
	{
		++ans[node];
		visit[node] = true;
		for(int next_node : adj[node])
		{
			if(!visit[next_node])
			{
				dfs(next_node);
			}
		}
	}
}