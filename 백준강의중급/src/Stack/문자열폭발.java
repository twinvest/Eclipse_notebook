package Stack;

import java.util.Scanner;
import java.util.Stack;

public class 문자열폭발 {
	static class Pair {
	    int first, second;
	    Pair(int first, int second) {
	        this.first = first;
	        this.second = second;
	    }
	}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        boolean[] erased = new boolean[n]; //erased[i] : i번째가 true면 i번째 문자열이 지워졌음을 의미
        //폭발문자열의 길이가 1이면 그냥 바로 지움.
        if (m == 1) {
            for (int i=0; i<n; i++) {
                if (a.charAt(i) == b.charAt(0)) {
                    erased[i] = true;
                }
            }
        } else {
        	Stack<Pair> s = new Stack<Pair>(); //stack에는 a의 인덱스와 b의 인덱스를 함께 넣어준다.
            for (int i=0; i<n; i++) {
                //a의 i와 b의 0이 같다는것은 새로운 폭발 문자열의 시작을 의미.
            	if (a.charAt(i) == b.charAt(0)) {
                    s.push(new Pair(i, 0));
                } else {
                    if (!s.empty()) {
                        Pair p = s.peek();
                        //stack의 가장 위에 놓인 놈의 index+1이랑 현재 a의 i가 같은지 비교
                        if (a.charAt(i) == b.charAt(p.second+1)) {
                            s.push(new Pair(i, p.second+1));
                            //폭발문자열의 가장 마지막이라면
                            if (p.second+1 == m-1) {
                                for (int k=0; k<m; k++) {
                                    Pair top = s.pop();
                                    erased[top.first] = true;
                                }
                            }
                        }
                        //이 부분이 인해가 안감...
                        /* 주석처리하고 아래 케이스 돌려보면 이해가 갈거임.
                         * 123
						 * 13
                         * */
                        else {
                            while (!s.empty()) {
                                s.pop();
                            }
                        }
                    }
                }
            }
        }

        boolean printed = false;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (erased[i]) {
                continue;
            }
            sb.append(a.charAt(i));
            printed = true;
        }
        if (printed) {
            System.out.println(sb);

        } else {
            System.out.println("FRULA");
        }
    }
}