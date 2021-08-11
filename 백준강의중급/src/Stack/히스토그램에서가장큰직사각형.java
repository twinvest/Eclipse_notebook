package Stack;
import java.util.Scanner;
import java.util.Stack;
public class 히스토그램에서가장큰직사각형 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            long[] a = new long[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextLong();
            }
            Stack<Integer> s = new Stack<>();
            long ans = 0;
            for (int i=0; i<n; i++) {
                int left = i;
                //스택이 비어있지 않고 스택의 제일 위에 있는것보다 높이가 작은걸 만나면
                while(!s.isEmpty() && a[s.peek()] > a[i]) {
                    long height = a[s.pop()]; // 현재 스택에 가장 위에 있는것의 높이로 직사각형을 만들거야.
                    long width = i;
                    if (!s.isEmpty()) {
                    	//왼쪽은 현재 제일 위에 있는놈. 즉, 나 자신이 스택에서 빠져나오고(20행) 그 전에 있던놈을 의미.
                    	//오른쪽은 고정됨. i-1로
                    	width = (i - 1 - s.peek() );
                    }
                    if (ans < width*height) {
                        ans = width*height;
                    }
                }
                s.push(i);
            }

			//오른쪽 끝까지 도달했는데 stack에 아직 남아 있을 때
            while(!s.isEmpty()) {
                long height = a[s.pop()];
                long width = n;
                if (!s.isEmpty()) {
                    width = n-1-s.peek();
                }
                if (ans < width*height) {
                    ans = width*height;
                }
            }
            System.out.println(ans);
        }
    }
}