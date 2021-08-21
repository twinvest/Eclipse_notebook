package 문자열;

import java.util.ArrayList;
import java.util.Scanner;
public class 두수XOR_trie {
	static class Trie {
		class Node {
			int[] children;
			boolean valid;
			Node() {
				children = new int[2]; //자식이 두개만 있으면 됨. 0,1
				for (int i = 0; i<2; i++) {
					children[i] = -1;
				}
				valid = false;
			}
		};
		ArrayList<Node> trie = new ArrayList<>();
		int root;
		int init() {
			Node x = new Node();
			trie.add(x);
			return trie.size() - 1;
		}
		Trie() {
			root = init();
		}
		void add(int node, int num, int bit) {
			//전부 추가했다면 -1
			if (bit == -1) {
				trie.get(node).valid = true;
				return;
			}
			int c = (num >> bit) & 1;
			//없으면 추가.
			if (trie.get(node).children[c] == -1) {
				int next = init();
				trie.get(node).children[c] = next;
			}
			//있으면 다음으로 넘어감.
			add(trie.get(node).children[c], num, bit-1);
		}

		//총 32비트. 따라서 0~31. 31비트부터 검사.
		//31, ... , 0, -1
		void add(int num) {
			add(root, num, 31);
		}

		//마찬가지로 31부터 검사.
		int query(int node, int num, int bit) {
			//이렇게 구현하긴 했는데 이런 경우는 절대 없다고 말함.
			if (bit == -1)
				return 0;
			int c = (num >> bit) & 1;

			//XOR에서 큰 값이 나오기 위해서는 해당 비트와 다른 비트로 넘어가야함.
			c = 1-c;

			//만약에 존재하지 않으면
			if (trie.get(node).children[c] == -1) {
				//어쩔 수 없지만 그냥 있는 자식으로 간다.
				c = 1-c;
			}
			//이런 경우도 절대 없다고함. 혹시나해서 넣어뒀다는데...
			if (trie.get(node).children[c] == -1) {
				return 0;
			}

			int next = 0;
			if (c == 1)
				next = 1 << bit;
			return next | query(trie.get(node).children[c], num, bit-1);
		}

		int query(int num) {
			return query(root, num, 31);
		}
	}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        Trie trie = new Trie();
        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            trie.add(num);
            int temp = (trie.query(num) ^ num);
            if (ans < temp) ans = temp;
        }
        System.out.println(ans);
    }
}