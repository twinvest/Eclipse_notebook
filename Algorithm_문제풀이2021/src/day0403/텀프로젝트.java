package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트 {
	static int numOfStudent;
	static int[] studentArr = new int[100001];
	static boolean[] visit = new boolean[100001];

	static int startV;
	static int endV;
	static int ans;
	/*
	 * 이 문제의 핵심은 무방향 그래프에서 탐색을 시작한 곳으로 다시 돌아올 수 있느냐 인듯?
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCase = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCase; ++i) {
			ans = 0;
			numOfStudent = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=numOfStudent; ++j) {
				studentArr[j] = Integer.parseInt(st.nextToken());
                visit[j] = false;
			}

			//1번학생부터 탐색시작.
			for(int j =1; j<=numOfStudent; ++j) {
				visitNum = 0;
				startV = j;
				if(!visit[j]) {
					dfs(j);
					visit[j] = true;
				}
			}
			System.out.println(numOfStudent - ans);
		}
	}
	static int visitNum = 0;
	static boolean flag = false;
	static boolean dfs(int vertex) {
		//순환을 이뤘을 때
		flag = false;
		if(visit[vertex] && startV == studentArr[endV]) {
			ans += visitNum;
			flag = true;
			return flag;
		}
		//방문하지 않았다면
		if(!visit[vertex]) { //!visit2[studentArr[vertex]]) {
			//방문하고
			visit[vertex] = true;
			++visitNum;
			endV = vertex;
			flag = dfs(studentArr[vertex]);
			if(!flag) {
				visit[vertex] = false;
			}
		}
		return flag;
	}
}