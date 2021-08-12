package Stack;

import java.util.Scanner;
import java.util.Stack;

public class 오아시스재결합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        // A  ... B  (B뒤로는 A를 볼 수 없음.)
        //150    170
        //즉, stack에 들어간다는 것은 뒤에서도 볼 수 있는 사람이다.
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> c = new Stack<Integer>();
        long ans = 0;
        for (int i=0; i<n; i++) {
            int h = a[i];
            int cnt = 1;
            while (!s.empty()) {
            	//스택에 제일 위에 있는 사람보다 키가 크면
                if (s.peek() <= a[i]) {
                    ans += (long)c.peek(); //정답을 +1 추가하고
                    if (s.peek() == a[i]) {
                        cnt += c.peek();
                    }
                    //스택의 가장위를 하나 제거해준다.
                    s.pop();
                    c.pop();
                }
                //키가 더 작으면
                else {
                    break;
                }
            }
            if (!s.empty()) {
                ans += 1L;
            }
            s.push(h);
            c.push(cnt);
        }
        System.out.println(ans);
    }
}