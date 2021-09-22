package 문자열;

/*
 * 두 바이너리 문자열 A와 B가 주어짐.
 * A와 XOR했을 때, 0이 나오는 B의 순환순열의 개수를 구하는 문제
 *
 * A와 B의 길이는 같음.
 * 길이는 10^5, 100000보다 작거나 같음.
 *
 * XOR연산
 * 0 XOR 0 = 0
 * 0 XOR 1 = 1
 * 1 XOR 0 = 1
 * 1 XOR 1 = 0
 *
 * 즉, 0이 나온다는 것은 A와 B가 같다는것이다. ==> 같은지 판단하는데 O(N)
 * 그러나, 순환순열임을 고려해야한다.
 * 순환순열의 예시를 보면,
 *
 * 1 2 3 4
 * 2 3 4 1
 * 3 4 1 2
 * 4 1 2 3
 *
 * 총 길이가 N이면 N가지 순환순열이 나온다. ==> O(N)걸리는걸 N번하면 되니 O(N^2)이다. 그러나, 100000^2는 시간초과남.
 *
 * 따라서 단순 비교가 아닌 다른 방법을 생각해야하는데, 주어진 길이가 N인 문자열을 2N으로 늘려준다. 이렇게 말이다. "12341234" (더욱 정밀하게하면 2N-1길이의 문자열을 만들어준다. "1234123")
 * 그러면, 여기서 길이가 N인 부분문자열을 모두 찾으면 그것이 바로 순환순열이다.
 * 즉, 정리하면 B+B에서 A가 몇 개 나오는지 찾는 문제이다.(B+B에서 마지막 글자는 제외해야함.)
 *
 * */

import java.util.ArrayList;
import java.util.Scanner;
public class 순환순열_KMP {

	static int[] preprocessing(String p) {
        int m = p.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for (int i=1; i<m; i++) {
            while (j>0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = j+1;
                j += 1;
            } else {
                pi[i] = 0;
            }
        }
        return pi;
    }

    static ArrayList<Integer> kmp(String s, String p) {
        int[] pi = preprocessing(p);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = s.length();
        int m = p.length();
        int j = 0;
        for(int i=0; i<n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == m-1) {
                    ans.add(i-m+1);
                    j = pi[j];
                } else {
                    j += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        b = b + b;  //b를 두배로 만들어주기.
        b = b.substring(0, b.length()-1); //마지막 글자 제거
        ArrayList<Integer> ans = kmp(b, a); //b에서 a가 몇번 등장하는지.
        System.out.println(ans.size());
    }
}