package Heap;

import java.util.Scanner;

/*
 * 힙은 이진트리이다.
 * 최대힙 : 부모 노드는 자식 노드에 들어있는 값보다 크다.
 * 최소힙 : 부모 노드는 자식 노드에 들어있는 값보다 작다.
 *
 * N개가 힙에 들어가 있으면 높이는 logN이다.
 *
 * 힙에는 두 가지 연산이 있다.
 * ㄱ. 수를 추가하기
 * ㄴ. 최소 / 최대값을 찾기
 * ㄷ. 수를 삭제하기(최소값과 최대값만 가능)
 *
 * C++은 priority_queue, Java는 PriorityQueue를 사용할 수 있다.
 * C++은 최대힙, Java는 최소힙이다.
 *
 * 다음 소스는 백준 11279번(최대 힙) 이다. 직접구현한ver.
 *
 * */

public class Heap_연습 {

	public static int[] heap = new int[100001];
    public static int hn;
    public static void push(int x) {
        heap[++hn] = x;
        for (int i=hn; i>1; i/=2) {
            if (heap[i/2] < heap[i]) {
                int temp = heap[i/2];
                heap[i/2] = heap[i];
                heap[i] = temp;
            } else {
                break;
            }
        }
    }

    public static int pop() {
        int ans = heap[1];
        heap[1] = heap[hn];
        heap[hn--] = 0;
        for (int i=1; i*2 <= hn;) {
            if (heap[i] > heap[i*2] && heap[i] > heap[i*2+1]) {
                break;
            } else if (heap[i*2] > heap[i*2+1]) {
                int temp = heap[i];
                heap[i] = heap[i*2];
                heap[i*2] = temp;
                i = i*2;
            } else {
                int temp = heap[i];
                heap[i] = heap[i*2+1];
                heap[i*2+1] = temp;
                i = i*2+1;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (hn == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(pop());
                }
            } else {
                push(x);
            }
        }
    }
}
