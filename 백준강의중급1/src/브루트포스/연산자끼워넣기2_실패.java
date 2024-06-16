package 브루트포스;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
/*
 *
 * 기본적인 접근은 다음과 같았다.
 * 주어진 연산자의 개수에서 N-1개를 뽑는 방식으로 조합을 만든 후 그 조합의 결과를 가지고 순열을 돌린다.
 * 이 경우 n이 11이고 연산자의 개수가 각각 10개씩 주어졌다고하면, 40 Combination 10 * 10! 의 연산수가 필요.
 *
 *
 * */


class ArrayWrapper {
    private String[] array;

    public ArrayWrapper(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayWrapper that = (ArrayWrapper) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}

public class 연산자끼워넣기2_실패 {
	static String[] arr;
	static String[] sel;
	static String[] result;
	static boolean[] visited;
	static HashSet<ArrayWrapper> set;
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

		arr = new String[operList.size()];
		sel = new String[numOfSeq-1];
		result = new String[numOfSeq-1];
		visited = new boolean[numOfSeq-1];
		set = new HashSet<>();



		for(int i = 0; i < operList.size(); ++i) {
			arr[i] = operList.get(i);
		}


		combination(0, 0);
		for (ArrayWrapper wrapper : set) {
           System.out.println(Arrays.toString(wrapper.getArray()));
        }

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

	static void combination(int idx, int s_idx) {
		if(sel.length == s_idx) {
			String[] tmp = sel.clone();
			System.out.println("=====>"+Arrays.toString(sel));
			if(!set.contains(new ArrayWrapper(tmp))) {
				//System.out.println("진입count");
				set.add(new ArrayWrapper(tmp));
				perm(0);
			}
			return;
		}
		if(arr.length == idx)
			return;

		sel[s_idx] = arr[idx];
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}

	static void perm(int depth) {
		if( depth == result.length ) {
			calc(result);
			return;
		}

		for(int i = 0; i < sel.length; i++) {

			if( !visited[i] ) {
				result[depth] = sel[i];
				visited[i] = true;

				perm(depth + 1);

				visited[i] = false;
				result[depth] = "";
			}
		}
	}

}
