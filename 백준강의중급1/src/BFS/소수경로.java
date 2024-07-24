package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소수경로 {

	static boolean[] isNotPrime = new boolean[100001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		checkPrime();

		StringTokenizer st= null;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int answer = Integer.parseInt(st.nextToken());

			sb.append(bfs(src,answer)+"\n");
		}
		System.out.println(sb.toString());

	}

	static String bfs(int src, int answer) {
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();

		map.put(src,0);
		q.add(src);

		while(!q.isEmpty()) {
			int pos = q.poll();
			int move = map.get(pos);

			if(pos == answer) {
				return move+"";
			}

			int[] pNum = {pos/1000, (pos/100)%10, (pos/10)%10, pos%10};
			for(int i=0; i<4; i++) {
				for(int j=0; j<10; j++) {
					if(i==0 && j==0) continue; // 1000이상

					int tmp = pNum[i];
					pNum[i] = j;
					int next = changePassword(pNum);
					pNum[i] = tmp;

					if(isNotPrime[next]) continue;

					if(!map.containsKey(next)) {
						q.add(next);
						map.put(next, move+1);
					}
				}
			}
		}

		return "Impossible";
	}

	static int changePassword(int[] pNum) {
		int num =0;
		for(int i=0; i<4; i++) {
			num += pNum[i]*(Math.pow(10, 3-i));
		}
		return num;

	}

	static void checkPrime() {
		for(int i=2; i<10000; i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i; j<10000; j+=i) {
					isNotPrime[j] = true;
				}
			}

		}
	}
}