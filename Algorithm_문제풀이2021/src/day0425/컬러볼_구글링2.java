package day0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 컬러볼_구글링2 {
	static class Ball implements Comparable<Ball>{
		public int color, weight, idx;
		public Ball(int color, int weight, int idx) {
			this.color = color;
			this.weight = weight;
			this.idx = idx;
		}

		@Override
		public int compareTo(Ball comp) {
			if(this.weight == comp.weight) {
				return Integer.compare(this.color, comp.color);
			}
			return Integer.compare(this.weight, comp.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] S = new int[2001];
		int[] C = new int[200001];
		int[] ans = new int[200001];
		Ball[] ballArr = new Ball[N];
		for(int i = 0; i<N; i++){
			String str1[] = br.readLine().split(" ");
			int c = Integer.parseInt(str1[0]) -1;
			int w = Integer.parseInt(str1[1]);
			ballArr[i] = new Ball(c, w, i);
		}

		//weight순으로 오름차순 정렬
		Arrays.sort(ballArr);
		int sum = 0;
		for(int i =0; i<N; ++i) {
			int weight = ballArr[i].weight;
			int color = ballArr[i].color;
			int index = ballArr[i].idx;

			sum += weight; //전체 누적합.
			C[color] += weight; //같은색 누적합.
			S[weight] += weight; //같은 사이즈 다른색 누적합.
			ans[index] = sum - C[color] - S[weight] + weight;
			/*
			 * 3
			 * 1 5
			 * 1 5
			 * 1 5
			 * 같은 반례를 위해 if문 추가되어야함.
			 * 만약 바로 직전에 봤던 것이 현재것과 색깔이 같고 무게가 같은 경우
			 * */
			if(i > 0 && weight == ballArr[i-1].weight && color == ballArr[i-1].color) {
				ans[index] = ans[ballArr[i-1].idx];
			}
		}

		for(int i =0; i<N; ++i) {
			System.out.println(ans[i]);
		}

	}

}
