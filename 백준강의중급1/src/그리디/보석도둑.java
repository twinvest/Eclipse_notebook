package 그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * 문제 접근
 * 가방리스트는 무게순으로 오름차순, 보석리스트도 무게순으로 오름차순 정렬
 * 가방의 개수만큼 for문을 돌리는데
 * 이때, 다이아의 무게(diamondList[idx].weight)가 bagList[i]의 무게보다 작으면 priorityQ(보석의 무게로 내림차순정렬된 우선순위큐)에 일단 전부 다 넣음.
 *      이러면 i번째 가방에 집어넣을 보석을 확정할 수 있게됨... priorityQ의 가장 위(top)에 있는 보석의 가격이 해당 i시점에 고를 수 있는 가장 비싼 보석임.
 * 이 후 for문을 돌때는 당연히 bagList[i+1]에서 더 큰 가방이 등장할 것이고 우선순위큐에 들어가 있는 가장 위(top)보석도 다음 가방(bagList[i+1])에 들어갈 수 있음을 의미.
 *
 * */

public class 보석도둑 {
	static class Diamond implements Comparable<Diamond>{
		int weight;
		int price;
		public Diamond(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo (Diamond comp) {
			//무게가 같을때 가격으로 내림차순을 해야하지 않을까?라고 생각했는데
			//안해도 됨~왜인지 생각해보시면, 무게가 같으면 전부 pq에 들어갈 것이고
			//pq에 들어가면 내림차순으로 정렬될테니까ㅋ
			if(this.weight == comp.weight) {
				return Integer.compare(this.weight, comp.weight);
			}
			return Integer.compare(this.weight, comp.weight);
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int K = scan.nextInt();
		ArrayList<Diamond> diamondList = new ArrayList<>();
		ArrayList<Integer> bagList = new ArrayList<>();
		for(int i =0; i<N; ++i) {
			int weight = scan.nextInt();
			int price = scan.nextInt();
			diamondList.add(new Diamond(weight, price));
		}

		for(int i =0; i<K; ++i) {
			bagList.add(scan.nextInt());
		}

		Collections.sort(diamondList);
		Collections.sort(bagList);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		long ans = 0;
		int idx = 0;

		for(int i=0; i<K; ++i) {
			while(idx < N && diamondList.get(idx).weight <= bagList.get(i)) {

				pq.add(diamondList.get(idx++).price);

			}
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
	}

}