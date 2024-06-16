package 브루트포스;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 *
 * 4^10으로 줄였다잉
 *
 *
 *
 *
 * */
public class 연산자끼워넣기2 {
	static int numOfSeq;
	static ArrayList<Integer> seqList = new ArrayList<>();
	static ArrayList<Integer> ansList = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] operator = new int[4];

		numOfSeq = scan.nextInt();
		for(int i = 0; i <numOfSeq; ++i) {
			seqList.add(scan.nextInt());
		}
		for(int i = 0; i < 4;++i) {
			operator[i] = scan.nextInt();
		}

		dfs("", operator);

		Collections.sort(ansList);
		System.out.println(ansList.get(ansList.size()-1));
		System.out.println(ansList.get(0));

	}

	static void dfs(String str, int[] operator) {
		if(str.length() == numOfSeq -1) {
			String[] arr = new String[str.length()];
			for(int i =0; i<arr.length; ++i) {
				arr[i] = str.charAt(i)+"";
			}
			calc(arr);
			return;
		}

		if(operator[0] != 0) {
			--operator[0];
			dfs(str+"+", operator);
			++operator[0];
		}

		if(operator[1] != 0) {
			--operator[1];
			dfs(str+"-", operator);
			++operator[1];
		}

		if(operator[2] != 0) {
			--operator[2];
			dfs(str+"*", operator);
			++operator[2];
		}

		if(operator[3] != 0) {
			--operator[3];
			dfs(str+"/", operator);
			++operator[3];
		}

	}


	static void calc(String[] operation) {
		int sum = seqList.get(0);
		for(int i =0; i < operation.length; ++i) {
			if(operation[i].equals("+")) {
				sum += seqList.get(i+1);
			}
			if(operation[i].equals("-")) {
				sum -= seqList.get(i+1);
			}
			if(operation[i].equals("*")) {
				sum *= seqList.get(i+1);
			}
			if(operation[i].equals("/")) {
				sum /= seqList.get(i+1);
			}
		}
		ansList.add(sum);
	}

}
