package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 물통 {

	static class Pair implements Comparable<Pair> {
		final int first;
		final int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair pair) {
			if (this.first < pair.first) {
				return -1;
			}
			if (this.first > pair.first) {
				return 1;
			}
			if (this.second < pair.second) {
				return -1;
			}
			if (this.second > pair.second) {
				return 1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object object) {
			if (object instanceof Pair) {
				Pair pair = (Pair)object;
				return this.first == pair.first && this.second == pair.second;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int n = 3;
			n = 19 * n + this.first;
			n = 19 * n + this.second;
			return n;
		}
	}

    public static final int[] from = {0, 0, 1, 1, 2, 2};
    public static final int[] to = {1, 2, 0, 2, 0, 1};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] cap = new int[3];
        for (int i=0; i<3; i++) {
            cap[i] = sc.nextInt();
        }
        int sum = cap[2]; //처음에는 C에만 들어있으니
        boolean[][] check = new boolean[201][201];
        boolean[] ans = new boolean[201]; //A가 비어있을때 C에 물이 i만큼 들어가는 것이 가능하면 True, 불가능하면 False.
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0)); //A와 B의 물의양을 각각 PAIR에 넣어준다. C는 sum변수를 이용해 구할거임.
        check[0][0] = true;
        ans[cap[2]] = true; //처음에는 무조건 A가 비어있으니 바로 true로 바꿔준다.
        while (!q.isEmpty()) {
            int[] cur = new int[3];
            Pair p = q.peek();
            cur[0] = p.first;    //0번 물통의 현재양
            cur[1] = p.second;   //1번 물통의 현재양
            cur[2] = sum - cur[0] - cur[1]; //2번 물통의 현재양
            q.remove();
            //from에서 to로 물을 붓는과정
            for (int k=0; k<6; k++) {
                int[] next = {cur[0], cur[1], cur[2]};
                next[to[k]] += next[from[k]]; //일단 from것을 to에 전부 부어본다.
                next[from[k]] = 0;            //그럼 from은 0이 된다.

                //만약 물이 용량을 넘었다면
                if (next[to[k]] >= cap[to[k]]) {
                    next[from[k]] = next[to[k]] - cap[to[k]]; //다시 from에다가 to에 용량보다 넘친만큼을 넣어준다.
                    next[to[k]] = cap[to[k]]; //그리고 to에다가는 용량을 꽉 채워준다.
                }

                //0번물통과 1번물통의 해당 양을 만든적이 없다면
                if (!check[next[0]][next[1]]) {
                    check[next[0]][next[1]] = true; //만들었다고 표시해주고
                    q.add(new Pair(next[0], next[1])); //큐에 넣어준다.

                    //이때 0번 물통이 비어있으면
                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }

        //마지막에 기록해놨던 C물통을 모두 출력해준다.
        for (int i=0; i<=cap[2]; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}