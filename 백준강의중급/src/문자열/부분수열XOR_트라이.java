package 문자열;

/*
 * 수열 A의 연속된 부분 수열 중에서 XOR합이 K보다 작은것의 개수를 세는 문제.
 *
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class 부분수열XOR_트라이 {
	static class Trie {
	    class Node {
	        int[] children;
	        int[] cnt;
	        boolean valid;
	        Node() {
	            children = new int[2];
	            cnt = new int[2];
	            for (int i = 0; i<2; i++) {
	                children[i] = -1;
	                cnt[0] = 0;
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
	        trie.get(node).cnt[c] += 1;
	        add(trie.get(node).children[c], num, bit-1);
	    }
	    void add(int num) {
	        add(root, num, 20);
	    }
	    int query(int node, int num, int k, int bit) {
	        if (bit == -1) return 0;
	        int c1 = (k >> bit) & 1;
	        int c2 = (num >> bit) & 1;
	        int ans = 0;
	        if (c1 == 1) {
	            ans += trie.get(node).cnt[c2];
	            c2 = 1-c2;
	        }
	        if (trie.get(node).children[c2] == -1) return ans;
	        ans += query(trie.get(node).children[c2], num, k, bit-1);
	        return ans;
	    }
	    int query(int num, int k) {
	        return query(root, num, k, 20);
	    }
	}

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans = 0;
        Trie trie = new Trie();
        int prefix = 0;
        trie.add(0);
        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            prefix ^= num;
            ans += trie.query(prefix, k);
            trie.add(prefix);
        }
        System.out.println(ans);
    }
}