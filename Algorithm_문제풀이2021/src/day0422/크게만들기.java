package day0422;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 크게만들기 {
	static class Pos {
		int index;
		int number;
		Pos(int index, int number){
			this.index = index;
			this.number = number;
		}

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		String num = scan.next();
		String ans = "";
		ArrayList<Pos> list = new ArrayList<>();

		//index순으로 오름차순정렬
		Comparator<Pos> indexOrder = new Comparator<Pos>() {
			@Override
			public int compare(Pos a, Pos b) {
				return Integer.compare(a.index, b.index);
			}
		};

		//number순으로 오름차순정렬
		Comparator<Pos> numberOrder = new Comparator<Pos>() {
			@Override
			public int compare(Pos a, Pos b) {
				return Integer.compare(a.number, b.number);
			}
		};

		for(int index =0; index<num.length(); ++index) {
			int number = Integer.parseInt(num.charAt(index)+"");
			Pos pos = new Pos(index, number);
			list.add(pos);
		}

		list.sort(numberOrder);
		for(int i =0; i<K; ++i) {
			list.remove(0); //제일 앞에걸 K번 지운다.
		}

		list.sort(indexOrder);
		for(int i =0; i<list.size(); ++i) {
			ans+= list.get(i).number+"";
		}
		System.out.println(ans);
	}

}
