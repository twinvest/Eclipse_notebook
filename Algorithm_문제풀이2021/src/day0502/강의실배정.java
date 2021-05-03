package day0502;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 강의실배정 {
	static class Lecture implements Comparable<Lecture>{
		int start;
		int end;
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture comp) {
			return Integer.compare(this.end, comp.end);
		}
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfLecture = scan.nextInt();
		ArrayList<Lecture> list = new ArrayList<>();
		for(int i =0; i<numOfLecture; ++i) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			Lecture lecture = new Lecture(start, end);
			list.add(lecture);
		}

		Comparator<Lecture> startTime = new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				return Integer.compare(o1.start, o2.start);
			}
		};

		//시작시간을 기준으로 오름차순 정렬을 시킨다.
		list.sort(startTime);

		//종료시간을 기준으로 오름차순 정렬한다.
		PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();
		pq.add(list.get(0));
		int ans = 1;

		for(int i =1; i < list.size(); ++i) {
			if(pq.peek().end > list.get(i).start) {
				ans++;
				pq.add(list.get(i));
			} else {
				pq.poll();
				pq.add(list.get(i));
			}
		}
		System.out.println(ans);
	}
}
