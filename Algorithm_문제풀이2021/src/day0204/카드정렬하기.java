package day0204;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); 내림차순~!~!
		int N = scan.nextInt();
		for(int i = 0; i<N; ++i) {
			int num = scan.nextInt();
			pq.add(num);
		}

		int sum = 0;
		while(pq.size() != 1) {
			int one = pq.poll();
			int two = pq.poll();
			sum += (one + two);
			pq.add(one+two);
		}
		System.out.println(sum);
	}

}
