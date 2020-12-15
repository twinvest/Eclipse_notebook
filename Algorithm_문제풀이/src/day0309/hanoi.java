package day0309;

import java.util.Scanner;

public class hanoi {
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		hanoi(N, 1, 2, 3);
		System.out.println(result.toString());
	}

	//cnt : 먗개의 원판을 옮길것인지.
	//기둥 세 개
	//원판갯수(맨아래원판번호), 시작, 임시, 목적
	private static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt == 0) return;

		//시작기둥의 n-1덩어리 원판을 임시기둥으로 옮기고
		hanoi(cnt-1, from, to, temp);
		//시작기둥의 n번째 원판을 목적기둥으로 옮김
		result.append(cnt+" : "+from+"=>"+to+"\n");
		//임시기둥의 n-1덩어리 원판을 목적기둥으로 옮김.
		hanoi(cnt-1, temp, from, to);
	}
}
