package day0731;

import java.util.Scanner;
class Term {
    int num, op;
    Term(int num, int op) {
        this.num = num;  //
        this.op = op;    //
    }
}
public class 괄호추가하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Term[] a = new Term[n];
        //a배열 세팅
        for (int i=0; i<n; i++) {
            //수인 경우
        	if (i%2 == 0) {
                a[i] = new Term(s.charAt(i)-'0', 0);
            }
            //연산자인 경우
            else {
                int op = 1; //+를 의미
                if (s.charAt(i) == '-') {
                    op = 2; //-를 의미
                } else if (s.charAt(i) == '*') {
                    op = 3; //*를 의미
                }
                a[i] = new Term(0, op);
            }
        }
        //연사자의 개수 m
        int m = (n-1)/2;
        int ans = -2147483648;
        for (int i=0; i<(1<<m); i++) { //방법을 모두 만들어본다.
            boolean ok = true;
            for (int j=0; j<m-1; j++) {
                if ((i&(1<<j)) > 0 && (i&(1<<(j+1))) > 0) { //j번째와 j+1번째가 모두 0이 아니라 1이라면. 즉, 연산자가 연속하는 경우를 의미. 즉 괄호가 중첩되는것을 의미. 또는 하나의 괄호안에 연산자가 여러개가 있음을 의미.
                    ok = false;
                }
            }
            //연산자가 연속하면 처리하지 않는다.
            if (!ok) continue;
            Term[] b = new Term[n];
            //b에다가 복사.
            for (int j=0; j<n; j++) {
                b[j] = new Term(a[j].num, a[j].op);
            }

            //식을 먼저 계산
            for (int j=0; j<m; j++) {
                if ((i&(1<<j)) > 0) {
                    int k = 2*j+1;
                    if (b[k].op == 1) {
                        b[k-1].num += b[k+1].num;
                        b[k+1].num = 0;
                    } else if (b[k].op == 2) {
                        b[k-1].num -= b[k+1].num;
                        b[k].op = 1;
                        b[k+1].num = 0;
                    } else if (b[k].op == 3) {
                        b[k-1].num *= b[k+1].num;
                        b[k].op = 1;
                        b[k+1].num = 0;
                    }
                }
            }

            //변경된 b식을 가지고 실제 계산.
            int res = b[0].num;
            for (int j=0; j<m; j++) {
                int k = 2*j+1;
                if (b[k].op == 1) {
                    res += b[k+1].num;
                } else if (b[k].op == 2) {
                    res -= b[k+1].num;
                } else if (b[k].op == 3) {
                    res *= b[k+1].num;
                }
            }
            if (ans < res) {
                ans = res;
            }
        }
        System.out.println(ans);
    }
}