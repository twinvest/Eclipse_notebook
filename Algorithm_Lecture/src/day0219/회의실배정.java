package day0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
class Pos implements Comparable<Pos>
{
	int start;
	int end;
	Pos(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Pos o) {
		 if (this.end > o.end) {
             return 1;
         } else if (this.end < o.end) {
             return -1;
         }
         return this.start - this.end;
	}
}

public class 회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfcon = Integer.parseInt(br.readLine());
		ArrayList<Pos> list = new ArrayList<>();
		for(int i=0; i<numOfcon; ++i)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Pos(start, end));
		}
		Collections.sort(list);
		int ans = 0;
		int curstart = 0;
		int curend = -1;
		for(int i=0; i<list.size(); ++i)
		{
			curstart = list.get(i).start;
            if (curstart >= curend) {
                curend = list.get(i).end;
                ans++;
            }
		}
		System.out.println(ans);
	}
}