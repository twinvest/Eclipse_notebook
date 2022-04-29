package 연습장;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 정렬및우선순위큐 {
	static class Pair implements Comparable<Pair>{
		int y;
		int x;

		Pair(int y, int x){
			this.y=y;
			this.x=x;
		}
		@Override
		public int compareTo(Pair comp) {
			if(this.y == comp.y) {
				//y가 같을 시 x에 대해 내림차순
				return Integer.compare(comp.x, this.x);
			}
			//y에 대해서 오름차순
			return Integer.compare(this.y, comp.y);
		}

	}

	public static void main(String[] args) {
		//정렬전 list
		ArrayList<Pair> list = new ArrayList<Pair>();
		list.add(new Pair(5,3));
		list.add(new Pair(5,1));
		list.add(new Pair(4,3));
		list.add(new Pair(4,4));

		for(int i =0; i<list.size(); ++i) {
			System.out.println("y : "+list.get(i).y+"  , x : " +list.get(i).x);
		}

		System.out.println();
		System.out.println();
		Collections.sort(list);
		//정렬 후 list
		for(int i =0; i<list.size(); ++i) {
			System.out.println("y : "+list.get(i).y+"  , x : " +list.get(i).x);
		}

		System.out.println();
		System.out.println();

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(5);
		pq.add(3);
		pq.add(2);
		pq.add(1);
		pq.add(4);
		//pq는 기본적으로 오름차순으로 뱉음.
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}

		System.out.println();
		System.out.println();

		//pq2는 구현한 comparable에 따라 정렬됨.
		PriorityQueue<Pair> pq2 = new PriorityQueue<>();
		pq2.add(new Pair(5,3));
		pq2.add(new Pair(5,1));
		pq2.add(new Pair(4,3));
		pq2.add(new Pair(4,4));
		while(!pq2.isEmpty()) {
			System.out.println("y : "+pq2.peek().y+"  , x : " +pq2.peek().x);
			pq2.poll();
		}
	}

}
