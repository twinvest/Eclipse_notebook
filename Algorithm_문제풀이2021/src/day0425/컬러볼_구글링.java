package day0425;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 컬러볼_구글링 {

	static class Ball implements Comparable<Ball>{
		public int color, weight, idx;
		public Ball(int color, int weight, int idx) {
			this.color = color;
			this.weight = weight;
			this.idx = idx;
		}

		@Override
		public int compareTo(Ball comp) {
			return Integer.compare(this.weight, comp.weight);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int numOfBall = Integer.parseInt(br.readLine());
		int[] score = new int[numOfBall];
		int[] color = new int[numOfBall+1];
		int total = 0;
		Ball[] ballArr = new Ball[numOfBall];
		for(int i = 0; i<numOfBall; i++){
			String str1[] = br.readLine().split(" ");
			int c = Integer.parseInt(str1[0]);
			int w = Integer.parseInt(str1[1]);
			ballArr[i] = new Ball(c, w, i);
		}
		//size순으로 오름차순 정렬
		Arrays.sort(ballArr);

		for(int i =0, j=0; i<numOfBall; ++i) {
			for(; ballArr[j].weight < ballArr[i].weight; ++j) {
				total = total + ballArr[j].weight;
				color[ballArr[j].color] += ballArr[j].weight;
			}
			score[ballArr[i].idx] += total - color[ballArr[i].color];
		}
		for(int i = 0; i<numOfBall; i++){
			bw.write(score[i] + "\n");
		}
		bw.flush();
	}
}
