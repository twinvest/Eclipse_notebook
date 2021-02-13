package day0212;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class 통나무건너뛰기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i =0; i<n; ++i) {
			int numOfTree = scan.nextInt();
			int[] ansArr = new int[numOfTree];
			ArrayList<Integer> list = new ArrayList<>();
			Deque<Integer> dq = new ArrayDeque<Integer>();

			for(int j=0; j<numOfTree; ++j) {
				list.add(scan.nextInt());
			}
			Collections.sort(list);
			Collections.reverse(list);

			boolean flag = true;
			for(int num : list) {
				if(flag) {
					flag=false;
					dq.addFirst(num);
				} else {
					flag=true;
					dq.addLast(num);
				}
			}
			int index = 0;
			while(!dq.isEmpty()) {
				ansArr[index++]=dq.getFirst();
				dq.pop();
			}
			int max = -987654321;
			for(int j = 1; j<ansArr.length; ++j) {
				int gap = Math.abs(ansArr[j]-ansArr[j-1]);
				if(max < gap)
					max = gap;
			}
			int gap = Math.abs(ansArr[0] - ansArr[ansArr.length-1]);
			if(max < gap)
				max = gap;
			System.out.println(max);
		}
	}
}
