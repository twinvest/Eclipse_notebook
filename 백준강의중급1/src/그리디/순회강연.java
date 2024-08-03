package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
 *
 * https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2109-%EC%88%9C%ED%9A%8C%EA%B0%95%EC%97%B0-Java
 * 블로그 참고
 *
 * */
public class 순회강연 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//1. max[10001] 배열을 만든다.
		int[] max = new int[10001];

		//2. 입력을 받는다.
		int n = stoi(br.readLine());
		int sum = 0;
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = stoi(input[0]);
			arr[i][1] = stoi(input[1]);
		}

		//3. p(강연료) 기준으로 내림차순 정렬한다.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});

		//4. 배열을 순차적으로 돌며,
		// for d -> 0 까지 감소시키며 max[d]와 비교하여 d가 더 클경우 최댓값으로 갱신하고 for문 종료.
		for(int i = 0; i < n; i++) {
			int cost = arr[i][0];
			int dueDate = arr[i][1];
			for(int j = dueDate; j >= 1; j--) {
				if(max[j] < cost) {
					max[j] = cost;
					break;
				}
			}
		}
		for(int i = 0; i < 10001; i++)
			sum += max[i];

		System.out.println(sum);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}