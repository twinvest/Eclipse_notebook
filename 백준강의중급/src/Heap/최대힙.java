package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대힙 {
    static class Compare implements Comparator<Integer> {
        @Override
		public int compare(Integer one, Integer two) {
            return two.compareTo(one);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Compare cmp = new Compare();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, cmp);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.offer(x);
            }
        }
    }
}