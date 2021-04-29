import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class day0430 {
	static class Lecture implements Comparable<Lecture>{
		int start;
		int end;

		Lecture(int start, int end) {
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
		for(int i=0; i<numOfLecture;++i) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			list.add(new Lecture(start, end));
		}

		Comparator<Lecture> startTime = new Comparator<day0430.Lecture>() {
			@Override
			public int compare(Lecture a, Lecture b) {
				return Integer.compare(a.start, b.start);
			}
		};

		list.sort(startTime);
		PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();
		pq.add(list.get(0));
		int ans = 1;
		for(int i = 1; i<list.size(); ++i) {
			//앞서본 강의의 끝 시간보다 다음에 올 강의의 시작시간이 더 작은 경우. 즉, 겹치는 경우.
			if(pq.peek().end > list.get(i).start) {
				//강의실이 하나 더 필요.
				++ans;
				pq.add(list.get(i));
			} else {
				pq.poll();
				pq.add(list.get(i));
			}


		}


	}

}
