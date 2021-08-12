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
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> c = new Stack<Integer>();
        long ans = 0;
        for (int i=0; i<n; i++) {
            int h = a[i];
            int cnt = 1;
            while (!s.empty()) {
                if (s.peek() <= a[i]) {
                    ans += (long)c.peek();
                    if (s.peek() == a[i]) {
                        cnt += c.peek();
                    }
                    s.pop();
                    c.pop();
                } else {
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