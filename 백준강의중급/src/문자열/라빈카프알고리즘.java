package 문자열;

import java.util.Scanner;
public class 라빈카프알고리즘 {
    static int mod = 127;   //소수 127
    static int base = 256;  //진법 256


    //직접만든 해시함수
    static int h(String s) {
        int ans = 0;
        for (char ch : s.toCharArray()) {
            ans = (ans * base + ch) % mod;
        }
        return ans;
    }


    static int match(String s, String p) {
        int n = s.length(); //원본문자열 길이
        int m = p.length(); //패턴의 길이
        if (n < m) return 0;
        int hash_p = h(p);                  //p의 해시값을 계산
        int hash_s = h(s.substring(0, m));  //s의 해시값을 계산

        int first = 1;
        for (int i=0; i<m-1; i++) {
            first = (first * base) % mod;   //first = (base ^ m-1) % mod
        }

        for (int i=0; i<=n-m; i++) {
            if (hash_p == hash_s) {
                if (s.substring(i, i+m).equals(p))
                	return 1;
            }

            if (i+m < n) {
                hash_s = hash_s - (s.charAt(i)*first)%mod; //첫글자 빼기
                //hash_s = (hash_s + mod) % mod;             //윗라인에서 첫글자를 빼면서 음수가 나올수도 있기 떄문에 음수를 지우기위해 mod를 한번더 해주는거임. 근데, 사실 mod 전부 지워도 상관없긴함. 왜냐하면 스택오버플로가 나도 똑같은 값으로 깨지기 때문에
                hash_s = ((hash_s * base)%mod + s.charAt(i+m)) % mod; //256곱해주고 마지막 글자 더해주기
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); //원본
        String p = sc.next(); //찾고자하는 패턴
        System.out.println(match(s, p));
    }
}
