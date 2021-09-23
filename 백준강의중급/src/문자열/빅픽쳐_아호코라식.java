package 문자열;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 빅픽쳐_아호코라식 {
	static class Node {
	    int valid;
	    int[] children;
	    int pi;
	    Node() {
	        valid = -1;
	        children = new int[2];
	        for (int i=0; i<2; i++) {
	            children[i] = -1;
	        }
	        pi = -1;
	    }
	}

    static ArrayList<Node> trie = new ArrayList<>();
    static int root;
    static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static int add(int node, char[] s, int index) {
        if (index == s.length) {
            trie.get(node).valid = node;
            return node;
        }
        int c = (s[index] == 'o' ? 1 : 0);
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        return add(trie.get(node).children[c], s, index+1);
    }
    static void make() {
        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i=0; i<2; i++) {
                int next = trie.get(cur).children[i];
                if (next == -1) continue;
                if (cur == root) {
                    trie.get(next).pi = root;
                } else {
                    int x = trie.get(cur).pi;
                    while (x != root && trie.get(x).children[i] == -1) {
                        x = trie.get(x).pi;
                    }
                    if (trie.get(x).children[i] != -1) {
                        x = trie.get(x).children[i];
                    }
                    trie.get(next).pi = x;
                }
                int pi = trie.get(next).pi;
                q.add(next);
            }
        }
    }
    static int[] search(char[] s) {
        int n = s.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int node = root;
        boolean ok = false;
        for (int i=0; i<n; i++) {
            int c = (s[i] == 'o' ? 1 : 0);
            while (node != root && trie.get(node).children[c] == -1) {
                node = trie.get(node).pi;
            }
            if (trie.get(node).children[c] != -1) {
                node = trie.get(node).children[c];
            }
            if (trie.get(node).valid != -1) {
                ans[i] = trie.get(node).valid;
            }
        }
        return ans;
    }
    static int[] preprocessing(int[] p) {
        int m = p.length;
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for (int i=1; i<m; i++) {
            while (j>0 && p[i] != p[j]) {
                j = pi[j-1];
            }
            if (p[i] == p[j]) {
                pi[i] = j+1;
                j += 1;
            } else {
                pi[i] = 0;
            }
        }
        return pi;
    }
    static int kmp(int[] s, int[] p, int[] pi) {
        int ans = 0;
        int n = s.length;
        int m = p.length;
        int j = 0;
        for(int i=0; i<n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = pi[j-1];
            }
            if (s[i] == p[j]) {
                if (j == m-1) {
                    ans += 1;
                    j = pi[j];
                } else {
                    j += 1;
                }
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int rs = sc.nextInt(); // row_small
        int cs = sc.nextInt(); // col_small
        int rb = sc.nextInt(); // row_big
        int cb = sc.nextInt(); // col_big

        root = init();

        char[][] small = new char[rs][];
        char[][] big = new char[rb][];

        int[] p = new int[rs];
        for (int i=0; i<rs; i++) {
            small[i] = sc.next().toCharArray();
            p[i] = add(root, small[i], 0);
        }
        for (int i=0; i<rb; i++) {
            big[i] = sc.next().toCharArray();
        }
        make();

        int[][] d = new int[rb][];

        for (int i=0; i<rb; i++) {
            d[i] = search(big[i]);
        }

        int[] pi = preprocessing(p);

        int ans = 0;
        for (int j=cs-1; j<cb; j++) {
            int[] s = new int[rb];
            for (int i=0; i<rb; i++) {
                s[i] = d[i][j];
            }
            ans += kmp(s, p, pi);
        }
        System.out.println(ans);
    }
}