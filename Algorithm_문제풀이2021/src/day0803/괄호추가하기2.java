package day0803;

import java.util.ArrayList;
import java.util.Scanner;
class Term {
    int num, op;
    Term(int num, int op) {
        this.num = num;
        this.op = op; //0 : 숫자
                      //1 : +
        			  //2 : -
                      //3 : *
    }
}
public class 괄호추가하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Term[] a = new Term[n];
        //입력받은 s를 a배열에 집어넣는다.
        for (int i=0; i<n; i++) {
            if (i%2 == 0) {
                a[i] = new Term(s.charAt(i)-'0', 0); //숫자면 op에 0을 넣는다.
            } else {
                int op = 1;
                if (s.charAt(i) == '-') {
                    op = 2;
                } else if (s.charAt(i) == '*') {
                    op = 3;
                }
                a[i] = new Term(0, op);
            }
        }
        //연산자의 개수 m
        int m = (n-1)/2;
        int ans = -2147483648;
        for (int i=0; i<(1<<m); i++) { //괄호를 치는 모든 방법
            boolean ok = true;
            //연속(1.한 괄호안에 두 개 이상의 연산자, 2. 중첩하는 괄호를 의미)을 의미
            for (int j=0; j<m-1; j++) {
                if ((i&(1<<j)) > 0 && (i&(1<<(j+1))) > 0) {
                    ok = false;
                }
            }
            //연속되면 건너뛴다.
            if (!ok) continue;

            //b에다가 복사를 한다.
            Term[] b = new Term[n];
            for (int j=0; j<n; j++) {
                b[j] = new Term(a[j].num, a[j].op);
            }

            for (int j=0; j<m; j++) {
                if ((i&(1<<j)) > 0) { //0보다 크면 선택된 것을 의미.
                    int k = 2*j+1;
                    if (b[k].op == 1) {
                        b[k-1].num += b[k+1].num;
                        b[k].op = -1; // -1은 계산하지 말것을 의미
                        b[k+1].num = 0;
                    } else if (b[k].op == 2) {
                        b[k-1].num -= b[k+1].num;
                        b[k].op = -1; // -1은 계산하지 말것을 의미
                        b[k+1].num = 0;
                    } else if (b[k].op == 3) {
                        b[k-1].num *= b[k+1].num;
                        b[k].op = -1; // -1은 계산하지 말것을 의미
                        b[k+1].num = 0;
                    }
                }
            }

            ArrayList<Term> c = new ArrayList<>();
            for (int j=0; j<n; j++) {
            	//수면 그냥 c에 추가
            	if (j%2 == 0) {
                    c.add(b[j]);
                }
                //수가 아니면
                else {
                    //op가 -1이면 건너뛴다.
                	if (b[j].op == -1) {
                        j += 1;
                    }
                    else {
                        //앞에서 차례대로 보면서 곱하기면 지금 바로 계산해서 c에 넣는다.
                    	if (b[j].op == 3) {
                            int num = c.get(c.size()-1).num * b[j+1].num;
                            c.remove(c.size()-1);
                            c.add(new Term(num, 0));
                            j += 1;
                        } else {
                            c.add(b[j]);
                        }
                    }
                }
            }
            b = c.toArray(new Term[c.size()]);
            int m2 = (b.length-1)/2;
            int res = b[0].num;
            for (int j=0; j<m2; j++) {
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