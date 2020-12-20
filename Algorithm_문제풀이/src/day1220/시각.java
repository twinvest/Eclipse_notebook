package day1220;

import java.util.Scanner;

public class 시각 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String hourCur ="00";
		String minCur ="00";
		String secondCur ="00";
		String temp = "";
		if(N+"".length() == 1) {
			temp = "0"+N;
		}
		String targetCur = temp+"5959";
		int count = 0;
		while(true) {
			String concatCur = hourCur + minCur +secondCur;
			if(concatCur.contains("3")) {
				++count;
			}

			if(hourCur.equals(N+"") && minCur.equals("59") && secondCur.equals("59")) {
				break;
			}

			int second = Integer.parseInt(secondCur+"");
			int min = Integer.parseInt(minCur+"");
			int hour = Integer.parseInt(hourCur+"");

			++second;

			if(second == 60) {
				++min;
				minCur = min + "";
				second = 0;
			}
			secondCur = second + "";

			if(min == 60) {
				++hour;
				hourCur = hour + "";
				min = 0;
			}
			minCur = min +"";

		}
		System.out.println(count);


	}

}
