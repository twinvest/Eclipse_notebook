package 브루트포스;

import java.util.ArrayList;
import java.util.Scanner;

public class 부등호 {
	static int[] arr = {0,1,2,3,4,5,6,7,8,9};
	static boolean[] visit = new boolean[10];
	static int[] sel;
	static String[] inequalArray;
	static boolean[] inequalBoolArray;
	static ArrayList<String> ansList = new ArrayList<>();
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		sel = new int[num+1];
		inequalArray = new String[num];
		for(int i =0; i<num; ++i) {
			inequalArray[i] = sc.next();
		}
		rePerm(0);
		System.out.println(ansList.get(ansList.size()-1));
		System.out.println(ansList.get(0));

	}
	static void rePerm(int idx) {
		if( idx == sel.length ) {
			boolean bool;
			for(int i =0; i<inequalArray.length; ++i) {
				if(inequalArray[i].equals("<")) {
					bool = sel[i] < sel[i+1] ? true : false;
				}else {
					bool = sel[i] > sel[i+1] ? true : false;
				}
				if(!bool)
					return;
			}

			String ans ="";
			for(int i =0; i<sel.length; ++i) {
				ans += sel[i];
			}
			ansList.add(ans);
			return;
		}

		for(int i = 0; i < arr.length; i++)
		{
			if(!visit[i]) {
				visit[i] = true;
				sel[idx] = arr[i];
				rePerm(idx + 1);
				visit[i] = false;
			}
		}
	}
}