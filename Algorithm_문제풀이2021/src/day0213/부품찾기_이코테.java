package day0213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 부품찾기 {

	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 0; i<N; ++i) {
			list.add(scan.nextInt());
		}
		Collections.sort(list);
		int M = scan.nextInt();
		int[] sel = new int[M];
		for(int i =0; i<M; ++i) {
			sel[i] = scan.nextInt();
			boolean flag = binarySearch(0,list.size()-1,sel[i]);
			if(flag) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
	static boolean binarySearch(int start, int end, int target) {
		int mid = (start + end) / 2;
		if(start > end)
			return false;
		else {
			if(list.get(mid) < target) {
				return binarySearch(mid+1, end, target);
			}
			else if(list.get(mid) > target) {
				return binarySearch(start, mid-1, target);
			} else {
				return true;
			}
		}
	}

}
