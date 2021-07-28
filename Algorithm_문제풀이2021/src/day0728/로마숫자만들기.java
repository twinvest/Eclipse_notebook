package day0728;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 로마숫자만들기 {
	static String[] arr = {"I","V","X","L"};
	static String[] result;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		result = new String[scan.nextInt()];
		rePerm(0);
		System.out.println(set.size());
	}
	static void rePerm(int idx) {
		if( idx == result.length ) {
			int sum = 0;
			for(int i=0; i<result.length; ++i) {
				if(result[i].equals("I"))
					sum += 1;
				else if(result[i].equals("V"))
					sum += 5;
				else if(result[i].equals("X"))
					sum += 10;
				else
					sum += 50;
			}
			set.add(sum);
			return;
		}

		for(int i = 0; i < arr.length; i++)
		{
			result[idx] = arr[i];
			rePerm(idx + 1);
			result[idx] = "";
		}
	}
}