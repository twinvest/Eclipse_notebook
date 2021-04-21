package day0420;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 강의실배정 {
	static class Lecture implements Comparable<Lecture>{
		long startTime;
		long endTime;
		Lecture(long startTime, long endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Lecture comp) {
			if(this.endTime == comp.endTime) {
				return Long.compare(this.startTime, comp.startTime);
			}
			return Long.compare(this.endTime, comp.endTime);
		}
	}
	static ArrayList<Lecture> list = new ArrayList<Lecture>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numOfLecture = scan.nextInt();
		for(int i=0; i<numOfLecture; ++i) {
			long start = scan.nextLong();
			long end = scan.nextLong();
			Lecture lectrue = new Lecture(start, end);
			list.add(lectrue);
		}

		Collections.sort(list);
		long preEnd = list.get(0).endTime;
		int ans = 1;
		for(int i=1; i<list.size();++i) {
			if(preEnd > list.get(i).startTime) {
				continue;
			}
			preEnd = list.get(i).endTime;
			++ans;
			//System.out.println("start : "+list.get(i).startTime +", "+ "end : " +list.get(i).endTime);
		}
		System.out.println(ans);
	}

}
