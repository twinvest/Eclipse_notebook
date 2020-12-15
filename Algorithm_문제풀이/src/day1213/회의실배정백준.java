package day1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos> {
	int start;
	int end;

	Pos(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Pos o) {
		//종료시간이 같으면
		if(this.end == o.end) {
			//시작시간을 기준으로 정렬
			return Integer.compare(this.start, o.start);
		}
		//종료시간이 같지 않으면 종료시간으로 정렬
		return Integer.compare(this.end, o.end);
	}
}

public class 회의실배정백준 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfcon = Integer.parseInt(br.readLine());
		ArrayList<Pos> list = new ArrayList<>();
		for (int i = 0; i < numOfcon; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Pos(start, end));
		}
		Collections.sort(list);
		/*
		for(Pos p : list) {
			System.out.println("p.start : " +p.start+", p.end : " +p.end);
		}
		*/

		int ans = 0;
		int curstart = 0;
		int curend = -1;
		for(int i=0; i<list.size();++i) {
			curstart = list.get(i).start;
			if (curstart >= curend) {
				curend =list.get(i).end;
				ans++;
			}
		}
		System.out.println(ans);

	}
}