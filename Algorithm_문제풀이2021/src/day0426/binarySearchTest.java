package day0426;

import java.util.ArrayList;

public class binarySearchTest {
	static ArrayList<Integer> poketList = new ArrayList<>();
	public static void main(String[] args) {

		poketList.add(1);
		poketList.add(8);
		poketList.add(15);
		poketList.add(26);
		poketList.add(32);
		int ans = binarySearch(0, poketList.size()-1, 33);
		System.out.println(ans);
	}
	static int binarySearch(int start, int end, int target) {
		if(target > poketList.get(end)) {
			return -1;
		}
		int mid = (start + end) / 2;
		if(start >= end) {
			return mid;
		}
		if(poketList.get(mid) > target) {
			return binarySearch(start, mid-1, target);
		} else if (poketList.get(mid) < target) {
			return binarySearch(mid+1, poketList.size()-1, target);
		} else {
			return mid;
		}
	}
}
