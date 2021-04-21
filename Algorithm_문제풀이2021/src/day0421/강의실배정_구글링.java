package day0421;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 강의실배정_구글링 {
	static class Lecture implements Comparable<Lecture>{
		long startTime;
		long endTime;
		Lecture(long startTime, long endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}

		//종료시간 빠른 순서부터 느린순서로 오름차순 정렬
		@Override
		public int compareTo(Lecture comp) {
			return Long.compare(this.endTime, comp.endTime);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Lecture> list = new ArrayList<Lecture>();

		int numOfLecture = scan.nextInt();
		for(int i =0; i<numOfLecture; ++i) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			list.add(new Lecture(start,end));
		}

		//startTime으로 오름차순정렬.
		Comparator<Lecture> startTime = new Comparator<Lecture>() {
			@Override
			public int compare(Lecture a, Lecture b) {
				//return a.time - b.time; //오름차순정렬
				return Long.compare(a.startTime, b.startTime);
			}
		};

		//시작순서가 빠른 순으로 정렬
		list.sort(startTime);

		PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();
		pq.add(list.get(0));
		int ans = 1;
		for(int i =1;i<list.size(); ++i) {
			//현재 종료시간보다 시작시간이 더 빠른 경우. 즉, 강의실이 하나 더 필요한 경우이다.
			if(pq.peek().endTime > list.get(i).startTime) {
				++ans;
				pq.add(list.get(i));
			}
			//현재 종료시간이랑 시작시간이 같거나 시작시간이 더 느린 경우. 즉, 강의실이 필요없는 경우이다.
			else {
				pq.poll();
				pq.add(list.get(i));
			}
		}
		System.out.println(ans);
	}

}
