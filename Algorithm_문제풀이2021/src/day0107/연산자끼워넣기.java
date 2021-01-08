package day0107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 연산자끼워넣기 {
	static String[] arr;
	static String[] result;
	static boolean[] visited;
	static ArrayList<Integer> seqList = new ArrayList<>();
	static ArrayList<String> operList = new ArrayList<String>();
	static ArrayList<Integer> ansList = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] operator = new int[4];

		int numOfSeq = scan.nextInt();
		for(int i = 0; i <numOfSeq; ++i) {
			seqList.add(scan.nextInt());
		}
		for(int i = 0; i < 4;++i) {
			operator[i] = scan.nextInt();
			if(i == 0) {
				for(int j = 0; j<operator[i]; ++j)
					operList.add("+");
			}
			if(i == 1) {
				for(int j = 0; j<operator[i]; ++j)
					operList.add("-");
			}
			if(i == 2) {
				for(int j = 0; j<operator[i]; ++j)
					operList.add("*");
			}
			if(i == 3) {
				for(int j = 0; j<operator[i]; ++j)
					operList.add("/");
			}

		}
		arr = new String[numOfSeq-1];
		result = new String[numOfSeq-1];
		visited = new boolean[numOfSeq-1];
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = operList.get(i);
		}

		perm(0);
		Collections.sort(ansList);
		System.out.println(ansList.get(ansList.size()-1));
		System.out.println(ansList.get(0));

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

	static void perm(int depth) {
		if( depth == result.length ) {
			//System.out.println(Arrays.toString(result));
			calc(result);

			return;
		}
		for(int i = 0; i < arr.length; i++) {

			if( !visited[i] ) {
				result[depth] = arr[i];
				visited[i] = true;

				perm(depth + 1);

				visited[i] = false;
				result[depth] = "";
			}
		}
	}

}
