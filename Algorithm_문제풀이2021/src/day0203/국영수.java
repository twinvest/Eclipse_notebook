package day0203;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class 국영수 {
	static class Student implements Comparable<Student>{
		String name;
		int korean;
		int english;
		int math;
		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if(this.korean == o.korean) {
				if(this.korean == o.korean && this.english == o.english) {
					if(this.korean == o.korean && this.english == o.english && this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					return Integer.compare(o.math, this.math);
				}
				return Integer.compare(this.english, o.english);
			}
			return Integer.compare(o.korean, this.korean);
		};


	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Student> list = new ArrayList<>();
		for(int i = 0; i<n; ++i) {
			String name = scan.next();
			int korean = scan.nextInt();
			int english = scan.nextInt();
			int math = scan.nextInt();
			list.add(new Student(name, korean, english, math));
		}
		Collections.sort(list);
		for(Student s : list) {
			System.out.println(s.name);
		}
	}

}
