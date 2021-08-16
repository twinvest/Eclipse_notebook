package Stack;

/*
 * 하 코드 이해가 안됨...
 *
 * 모든 위치 i에 대해서
 * 그 위치가 (최댓값이 되는 구간의 개수 * A[i]) - (최솟값이 되는 구간의 개수 * A[i])
 *
 * 아래와 같은 경우에서 3번째 수가 최댓값으로 포함된 경우를 모두 구해보자.
 *  i    1 2 3 4 5 6
 * A[i]  3 1 4 2 5 1
 *
 * 3번을 최댓값으로 갖는 위치는 1, 2, 3, 4번째 수이다.
 * 총 4개의 수가 포함되어 있기 때문에, 구간의 개수는 4 * (4 + 1) / 2 = 10개 이다.
 *
 *  1 2 -
	1 3
	1 4
	2 3
	2 4
	3 4
	1 1 -
	2 2 -
	3 3
	4 4 -

 *  그러나, 왼쪽에서 시작해서 왼쪽에서 끝나는 경우 2 * ( 2 + 1 ) / 2
 *        오른쪽에서 시작해서 오른쪽에서 끝나는 경우 1 * ( 1 + 1 ) / 2
 *  를 빼야한다. 따라서 총 6개이다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class 카드구매하기3 {
    static long calc(long n) {
        return n*(n+1)/2;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n+1];
        int[] lg = new int[n+1]; // left greater  왼쪽으로 얼마나 큰지
        int[] rg = new int[n+1]; // right greater 오른쪽으로 얼마나 큰지
        int[] ls = new int[n+1]; // left smaller  왼쪽으로 얼마나 작은지
        int[] rs = new int[n+1]; // right smaller 오른쪽으로 얼마나 작은지
        String[] line = bf.readLine().split(" ");
        for (int i=1; i<=n; i++) {
            a[i] = Integer.parseInt(line[i-1]);
            lg[i] = ls[i] = 0;
            rg[i] = rs[i] = n+1;
        }

        //오른쪽으로 가면서 구하기. 최댓값과 최솟값 동시에 계산한다. rg, rs
        {
        	Stack<Pair> sg = new Stack<>(); // stack greater
            Stack<Pair> ss = new Stack<>(); // stack smaller
            sg.push(new Pair(1, a[1]));
            ss.push(new Pair(1, a[1]));

            for (int i=2; i<=n; i++) {
                //오른쪽으로가면서 최댓값 구하기
            	while (!sg.isEmpty() && a[i] >= sg.peek().second) {
                    rg[sg.peek().first] = i;
                    sg.pop();
                }
                sg.push(new Pair(i, a[i]));

                //왼쪽으로 가면서 최소값 구하기
                while (!ss.isEmpty() && a[i] <= ss.peek().second) {
                    rs[ss.peek().first] = i;
                    ss.pop();
                }
                ss.push(new Pair(i, a[i]));
            }
        }

        //왼쪽으로 가면서 구하기. 최댓값과 최솟값 동시에 계산한다. lg, ls
        {
            Stack<Pair> sg = new Stack<>(); // stack greater
            Stack<Pair> ss = new Stack<>(); // stack smaller
            sg.push(new Pair(n, a[n]));
            ss.push(new Pair(n, a[n]));
            for (int i=n-1; i>=1; i--) {
                while (!sg.isEmpty() && a[i] > sg.peek().second) {
                    lg[sg.peek().first] = i;
                    sg.pop();
                }
                sg.push(new Pair(i, a[i]));
                while (!ss.isEmpty() && a[i] < ss.peek().second) {
                    ls[ss.peek().first] = i;
                    ss.pop();
                }
                ss.push(new Pair(i, a[i]));
            }
        }


        long ans = 0;
        for (int i=1; i<=n; i++) {
            int l = Math.min(i, lg[i]+1);
            int r = Math.max(i, rg[i]-1);
            long len = r-l+1;
            ans += (calc(len) - calc(r-i) - calc(i-l)) * a[i];
        }
        for (int i=1; i<=n; i++) {
            int l = Math.min(i, ls[i]+1);
            int r = Math.max(i, rs[i]-1);
            long len = r-l+1;
            ans -= (calc(len) - calc(r-i) - calc(i-l)) * a[i];
        }
        System.out.println(ans);
    }
}