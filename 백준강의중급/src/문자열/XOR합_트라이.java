package 문자열;

/*
 * 수열 A의 연속된 부분 수열 중에서 XOR합이 가장 큰 것을 찾는 문제
 * XOR합 : 수열에 포함된 원소를 모두 XOR한 값
 *
 * S[i] = A[1] XOR ... XOR A[i]라고 하자.
 *
 * A[i] XOR A[i+1] XOR ... XOR A[j-1] XOR A[j]를 구하기 위해서는
 * S[i-1] XOR S[j]을 구하면 된다.
 * 1 ... i-1이 지워진다. 1 ... i-1, i ... j
 *
 * XOR연산의 특성상 같은것은 0이 됨.
 *
 * 0 XOR 0 = 0
 * 0 XOR 1 = 1
 * 1 XOR 0 = 1
 * 1 XOR 1 = 0
 *
 * 수가 반대되는 것을 해야 커진다.
 *
 *
 *
 *
 * */


import java.util.ArrayList;
import java.util.Scanner;

public class XOR합_트라이 {
	static class Trie {
	    class Node {
	        int[] children;
	        boolean valid;
	        Node() {
	            children = new int[2];
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
	        if (bit == -1) {
	            trie.get(node).valid = true;
	            return;
	        }
	        int c = (num >> bit) & 1;
	        if (trie.get(node).children[c] == -1) {
	            int next = init();
	            trie.get(node).children[c] = next;
	        }
	        add(trie.get(node).children[c], num, bit-1);
	    }
	    void add(int num) {
	        add(root, num, 31);
	    }
	    int query(int node, int num, int bit) {
	        if (bit == -1) return 0;
	        int c = (num >> bit) & 1;
	        c = 1-c;
	        if (trie.get(node).children[c] == -1) {
	            c = 1-c;
	        }
	        if (trie.get(node).children[c] == -1) {
	            return 0;
	        }
	        int next = 0;
	        if (c == 1) next = 1 << bit;
	        return next | query(trie.get(node).children[c], num, bit-1);
	    }
	    int query(int num) {
	        return query(root, num, 31);
	    }
	}

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            Trie trie = new Trie();
            int prefix = 0; //i번째까지 XOR한 값
            trie.add(0);
            for (int i=0; i<n; i++) {
                int num = sc.nextInt();
                prefix ^= num; //prefix와 num을 XOR한다.
                trie.add(prefix);
                int temp = (trie.query(prefix) ^ prefix);
                if (ans < temp) ans = temp;
            }
            System.out.println(ans);
        }
    }
}