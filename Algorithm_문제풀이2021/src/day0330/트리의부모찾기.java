package day0330;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의부모찾기 {
	public static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	static boolean[] visit;
	static int[] ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numOfNode = scan.nextInt();
		visit = new boolean[numOfNode+1];
		ans = new int[numOfNode+1];
		for(int i=0; i<=numOfNode;++i) {
			tree.add(new ArrayList<>());
		}
		//인접리스트 생성
		for(int i =0; i<numOfNode-1;++i) {
			int vertex1 = scan.nextInt();
			int vertex2 = scan.nextInt();
			tree.get(vertex1).add(vertex2);
			tree.get(vertex2).add(vertex1);
		}

		dfs(1);
		for(int i =2; i<ans.length;++i) {
			System.out.println(ans[i]);
		}
	}

	static void dfs(int vertex) {
		visit[vertex] = true;
		for(int i=0; i<tree.get(vertex).size(); ++i) {
			int nextVertex = tree.get(vertex).get(i);
			//다음 노드를 아직 방문하지 않았다면
			if(!visit[nextVertex]) {
				//방문하러가기전 이전 노드(직전의 부모노드)를 기록한다.
				ans[nextVertex] = vertex;
				//방문한다.
				dfs(nextVertex);
			}
		}
	}

}
