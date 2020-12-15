package day0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로 {
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N;
	static double E;
	static long[][] islands;
	static long[][] graph; //정점들 간의 거리 그래프

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; ++t)
		{
			sb.append("#").append(t).append(" ");
			N= Integer.parseInt(br.readLine());
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			islands = new long[N][2];
			for(int n=0; n<N; ++n)
			{
				islands[n] = new long[] {Long.parseLong(xLine.nextToken()), Long.parseLong(yLine.nextToken()) };
			}
			E = Double.parseDouble(br.readLine());
			//입력된 자료를 기반으로 섬 간의 가중치 그래프를 구해봅시다.
			graph = new long[N][N];
			long[] from, to;
			for(int r=0; r<N; ++r)
			{
				from = islands[r];
				for(int c=r+1; c<N; c++) {
					to = islands[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0] - to[0]) + (from[1] - to[1]) * (from[1] - to[1]);
				}
			}
			double cost = prim(0) * E;
			sb.append(Math.round(cost));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static long prim(int start)
	{
		//mst에 들어가지 않은 녀석들
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//모든 정점들을 다 관리
		Edge[] dynamicGraph = new Edge[N];

		for(int n=0; n<dynamicGraph.length; ++n)
		{
			dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
			//pq.add(dynamicGraph[n]);
			if(n== start) {
				dynamicGraph[n].cost=0;
			}
			pq.add(dynamicGraph[n]);
		}
		long cost = 0;
		while(!pq.isEmpty()) {
			Edge front = pq.poll(); //mst에 포함되는 녀석
			cost += front.cost;
			//자식탐색
			for(int i=0; i<dynamicGraph.length; ++i)
			{
				Edge child = dynamicGraph[i];
				//pq는 비MST
				if(pq.contains(child)) {
					long tempCost = graph[front.idx][child.idx];
					if(tempCost < child.cost) {
						child.cost = tempCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		return cost;
	}
	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;

		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}


		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}


		@Override
		public int compareTo(Edge o) {
			// o.cost - Long.MIN_VALUE
			//return this.cost - o.cost > 0 ? 1 : -1;
			return Long.compare(this.cost, o.cost);
		}

	}
}
