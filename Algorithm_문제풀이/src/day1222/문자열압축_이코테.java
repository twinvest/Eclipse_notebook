package day1222;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열압축_이코테 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> ansList = new ArrayList<>();
		String str = scan.next();
		//1부터 str의 length까지 1씩 올려보면서 짜른다.
		if(str.length() == 1) {
			ansList.add(1);
		}

		for(int i = 1; i<str.length(); ++i) {
			//짜를길이
			String before = "";
			String cur = "";
			String ans = "";
			int recurCount = 1;

			for(int j = 0; j < str.length(); j = j+i) {
				//범위를 벗어난 경우의 처리
				if(j+i > str.length()) {
					if(recurCount > 1)
						ans += recurCount;
					ans += before;
					ans += str.substring(j, str.length());
				}
				//범위가 아직 안인 경우
				else {
					//처음인 경우
					if(before.isEmpty()) {
						before = str.substring(j, j+i);
						continue;
					}
					//다음 for문이 마지막인 경우이자 딱 맞는경우.
					if(j+i == str.length()) {
						cur = str.substring(j, j+i);
						if(before.equals(cur)) {
							++recurCount;
							ans += recurCount + before;
						} else {
							ans += before + cur;
						}
					}
					//범위 안의 경우
					else {
						cur = str.substring(j, j+i);
						if(before.equals(cur)) {
							++recurCount;
						} else {
							if(recurCount == 1) {
								ans += before;
							}
							else {
								ans += recurCount + before;
								recurCount = 1;
							}
						}
						before = cur;
					}
				}
			}
			ansList.add(ans.length());
		}
		Collections.sort(ansList);
		System.out.println(ansList.get(0));
	}
}
