package 그리디;

import java.util.Scanner;

public class 잃어버린괄호 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String tmp = "";
		int[] arr = new int[50];
		boolean[] arr2 = new boolean[50];
		int index = 0;
		for(int i = 0;i <str.length(); ++i) {
			if(str.charAt(i) == '-' || str.charAt(i) == '+') {
				arr[index] = Integer.parseInt(tmp);
				++index;
				if(str.charAt(i) == '-')
					arr2[index] = true;
				tmp = "";
			} else {
				tmp += str.charAt(i);
			}
			//마지막길이일때처리
			if(str.length() -1 == i) {
				arr[index++] = Integer.parseInt(tmp);
			}
		}
		boolean flag = false;
		int sum = 0;
		for(int i =0; i<index; ++i) {
			if(arr2[i] == false && !flag)
				sum+=arr[i];
			else {
				flag = true;
				sum-=arr[i];
			}
		}
		System.out.println(sum);
	}
}
