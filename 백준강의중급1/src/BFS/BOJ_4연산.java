package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4연산 {

	static long s, t;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		s = Long.parseLong(st.nextToken()); // 시작 숫자
		t = Long.parseLong(st.nextToken()); // 목표 숫자

		bfs(s, t);
	}

	static void bfs(long start, long target) {
		// 아스키 코드 순서대로 배열 생성
		String[] order = new String[] {"*", "+", "-", "/"};
		// 중복 체크할 Set
		HashSet<Long> set = new HashSet<>();

		// s와 t가 같으면 0 출력
		if(start == target) {
			System.out.println(0);
			return;
		}

		Queue<Num> que = new LinkedList<>();
		set.add(start);
		que.add(new Num(start, ""));

		while(!que.isEmpty()) {
			Num now = que.poll();

			long nowNum = now.num;
			String nowHistory = now.hisory;

			long next = nowNum; // 연산 후의 숫자

			// 목표 숫자에 도달하면 현재까지 해왔던 연산 출력
			if(nowNum == target) {
				System.out.println(nowHistory);
				return;
			}

			// 아스키 코드 순서대로 연산
			for(int t=0; t<4; t++) {
				switch(t) {
					case 0:
						next = nowNum * nowNum;
						break;
					case 1:
						next = nowNum + nowNum;
						break;
					case 2:
						next = nowNum - nowNum;
						break;
					case 3:
						if(nowNum != 0) {
							next = nowNum / nowNum;
						}
						break;
				}
				// 중복된 숫자가 아니면
				if(!set.contains(next)) {
					// Set과 Queue에 삽입
					set.add(next);
					que.add(new Num(next, nowHistory + order[t]));
				}
			}
		}

		// 바꿀 수 없는 경우 -1 출력
		System.out.println(-1);
		return;
	}

	static class Num {
		// 숫자
		long num;
		// 해당 숫자까지 해왔던 연산을 저장할 변수
		String hisory = "";

		Num(long num, String history){
			this.num = num;
			this.hisory = history;
		}
	}
}
