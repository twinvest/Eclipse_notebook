package 문자열;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class 돌연변이_아호코라식 {
	static class Node {
	    int[] children;
	    int pi;
	    int cnt;
	    Node() {
	        children = new int[4];
	        for (int i=0; i<4; i++) {
	            children[i] = -1;
	        }
	        pi = -1;
	        cnt = 0;
	    }
	}
	static ArrayList<Node> trie;
    static int to_node(char x) {
        if (x == 'A') return 0;
        else if (x == 'T') return 1;
        else if (x == 'G') return 2;
        else if (x == 'C') return 3;
        else return 4;
    }
    static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index) {
        if (index == s.length()) {
            trie.get(node).cnt = 1;
            return;
        }
        int c = to_node(s.charAt(index));
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            trie = new ArrayList<Node>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            String s = sc.next();
            String p = sc.next();
            int root = init();
            TreeSet<String> a = new TreeSet<>();
            for (int i=0; i<m; i++) {
                for (int j=i; j<m; j++) {
                    String p2 = new StringBuilder(p.substring(i, j+1)).reverse().toString();
                    a.add(p.substring(0, i) + p2 + p.substring(j+1));
                }
            }
            for (String x : a) {
                add(root, x, 0);
            }
            Queue<Integer> q = new LinkedList<>();
            trie.get(root).pi = root;
            q.add(root);
            while (!q.isEmpty()) {
                int cur = q.remove();
                for (int i=0; i<4; i++) {
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
                    trie.get(next).cnt += trie.get(pi).cnt;
                    q.add(next);
                }
            }
            int ans = 0;
            int node = root;
            for (int i=0; i<n; i++) {
                int c = to_node(s.charAt(i));
                while (node != root && trie.get(node).children[c] == -1) {
                    node = trie.get(node).pi;
                }
                if (trie.get(node).children[c] != -1) {
                    node = trie.get(node).children[c];
                }
                ans += trie.get(node).cnt;
            }
            System.out.println(ans);
        }
    }
}