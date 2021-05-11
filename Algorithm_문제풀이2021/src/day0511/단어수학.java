package day0511;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어수학 {
	static ArrayList<String> strList = new ArrayList<>();     //입력받은 단어들
	static ArrayList<Character> charList = new ArrayList<>(); //실제 사용된 알파벳
	static ArrayList<Integer> permList = new ArrayList<>();

	static boolean[] type = new boolean[26];		          //어떤 알파벳이 사용되었는지 확인하기 위해 선언한 boolean 배열
	static boolean[] visit = new boolean[10];
	static int ans = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i = 0; i<N; ++i) {
			String str = scan.next();
			strList.add(str);
			for(int j = 0; j<str.length(); ++j) {
				int chNum = str.charAt(j) - 'A';
				if(!type[chNum]) {
					type[chNum] = true;
					charList.add(str.charAt(j));
				}
			}
		}

		permutation(10 - charList.size());
		System.out.println(ans);
	}

	static void permutation(int depth) {
		if(depth == 10) {
			makeAns();
			return;
		}
		for(int i = 10 - charList.size(); i<10; ++i) {
			if(!visit[i]) {
				permList.add(i);
				visit[i] = true;
				permutation(depth + 1);
				visit[i] = false;
				permList.remove(permList.size()-1);
			}
		}

	}

	static void makeAns() {
		int tempResult = 0;
		int cnt = 0;

		int[] a = new int[26];
		for(int i = 0; i<charList.size(); ++i) {
			char ch = charList.get(i);
			int numOfCh = permList.get(i);
			a[ch - 'A'] = numOfCh;
		}

		for(int i = 0; i<strList.size(); ++i) {
			int temp = 0;
			for( int j =0; j<strList.get(i).length(); ++j) {
				temp *= 10;
				temp += a[strList.get(i).charAt(j) - 'A'];
			}
			tempResult += temp;
		}
		ans = Math.max(ans, tempResult);
	}

}
