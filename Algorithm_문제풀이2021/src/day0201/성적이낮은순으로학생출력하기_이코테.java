package day0201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 성적이낮은순으로학생출력하기 {
	static class Student implements Comparable<Student> {
		String name;
		int score;
		Student(String name, int score){
			this.name = name;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			return Integer.compare(this.score, o.score);
		};
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Student> studentList = new ArrayList<>();
		for(int i = 0; i<N;++i) {
			String name = scan.next();
			int score = scan.nextInt();
			studentList.add(new Student(name, score));
		}
		Collections.sort(studentList);
		for(Student s : studentList) {
			System.out.print(s.name+" ");
		}
	}

}
