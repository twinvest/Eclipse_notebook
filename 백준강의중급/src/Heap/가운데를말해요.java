package Heap;
/*
 * 간단하게 생각하면 수 한 번 추가하고 정렬 한 번 조지면 됨.
 * 그러나 이는 수를 n번 추가해야하고 정렬에 nlogn이 걸리니 시간복잡도가 O(n^2 * logn)이 된다.
 * n의 최대값이 10만이니 0.1초안에 통과할 수 없다.
 *
 * 접근법
 * ㄱ. 왼쪽과 오른쪽 그룹으로 나눌건데, 각각의 크기는 n/2, n/2가 된다. (단, 홀수일때는 왼쪽그룹size == 오른쪽그룹size+1)
 * ㄴ. 왼쪽그룹의 수 <= 오른쪽그룹의 수
 * ㄷ. 눈치 챘냐? 왼쪽그룹은 맥스힙, 오른쪽 그룹은 민힙이다.
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
public class 가운데를말해요 {
    static class Compare implements Comparator<Integer> {
        @Override
		public int compare(Integer one, Integer two) {
            return two.compareTo(one);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Compare cmp = new Compare();

        PriorityQueue<Integer> l = new PriorityQueue<Integer>(1, cmp); //최대힙
        PriorityQueue<Integer> r = new PriorityQueue<>();              //최소힙
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            //둘 다 비어있으면, 맨처음시작케이스임.
            if (l.isEmpty() || r.isEmpty()) {
                l.add(x);
            }  else {
            	//왼쪽과 오른쪽 중에 입력받은 x를 어디로 넣을지 결정해준다.
            	//최대힙의 가장위에 있는 최댓값보다 x가 작으면 왼쪽에 추가.
                if (x <= l.peek()) {
                    l.add(x);
                }
                //최소힙의 가장위에 있는 최솟값보다 x가 크면 오른쪽에 추가.
                else if (x >= r.peek()) {
                    r.add(x);
                }

                else {
                    l.add(x);
                }
            }

            //크기를 조정
            while (!(l.size() == r.size() || l.size() == r.size() + 1)) {
                if (l.size() > r.size()) {
                    r.add(l.peek());
                    l.poll();
                } else {
                    l.add(r.peek());
                    r.poll();
                }
            }

            bw.write(l.peek() + "\n");
        }
        bw.flush();
    }
}