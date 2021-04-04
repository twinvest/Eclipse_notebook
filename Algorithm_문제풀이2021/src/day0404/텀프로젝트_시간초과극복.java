package day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_시간초과극복 {
	static int numOfStudent;
	static int[] studentArr = new int[100001];
	static boolean[] visit = new boolean[100001];
	static boolean[] finished = new boolean[100001];
	static int startV;
	static int endV;
	static int ans;
	/*
	 * visited 배열은 기존에 풀었던 DFS 문제들에서도 사용하는 배열이였지만 finished배열은 처음 등장하는 배열.
	 * finished 배열은 더 이상 이 노드를 방문하지 않을 것을 확신하는 경우에만 true가 된다.
	 *
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
                finished[j] = false;
			}

			//1번학생부터 탐색시작.
			for(int j =1; j<=numOfStudent; ++j) {
				startV = j;
				if(!visit[j]) {
					dfs(j);
				}
			}
			System.out.println(numOfStudent - ans);
		}
	}

	static void dfs(int now) {
		visit[now] = true;
		int nextVertex = studentArr[now];
		if(!visit[nextVertex]) {
			dfs(nextVertex);
		} else {
			if(!finished[nextVertex]) {
				//팀원을 모두 센다
				for(int i=nextVertex; i!=now; i=studentArr[i]) {
					++ans;
				}
				++ans; //자기 자신을 센다
			}
		}
		finished[now] = true; //더 이상 해당 노드를 방문할 일이 없다
	}
}