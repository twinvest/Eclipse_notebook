package day0212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 좌표정렬하기2 {
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		Pos(int y, int x){
			this.y = y;
			this.x =x;
		}
		@Override
		public int compareTo(Pos o) {
			if(this.y == o.y) {
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.y, o.y);
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Pos> list = new ArrayList<>();
		for(int  i=0; i<N; ++i) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			list.add(new Pos(y,x));
		}
		Collections.sort(list);
		for(Pos cur : list) {
			System.out.println(cur.x+" "+cur.y);
		}
	}

}
