package 문자열;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair implements Comparable<Pair> {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
	public int compareTo(Pair that) {
        if (this.first < that.first) {
            return -1;
        } else if (this.first == that.first) {
            if (this.second < that.second) {
                return -1;
            } else if (this.second == that.second) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class 아스키거리_아호코라식 {
	static class Node {
	    int valid;
	    int[] children;
	    int pi;
	    int len;
	    Node() {
	        children = new int[26];
	        for (int i=0; i<26; i++) {
	            children[i] = -1;
	        }
	        pi = -1;
	        len = 0;
	    }
	}
    static ArrayList<Node> trie = new ArrayList<>();
    static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index, int string_index) {
        if (index == s.length()) {
            trie.get(node).len = index;
            return;
        }
        int c = s.charAt(index) - 'a';
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1, string_index);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int m = sc.nextInt();
        int root = init();
        for (int i=0; i<m; i++) {
            String temp = sc.next();
            add(root, temp, 0, i);
        }
        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i=0; i<26; i++) {
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
                trie.get(next).len = Math.max(trie.get(next).len, trie.get(pi).len);
                q.add(next);
            }
        }
        int node = root;
        boolean ok = false;
        ArrayList<Pair> matches = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a';
            while (node != root && trie.get(node).children[c] == -1) {
                node = trie.get(node).pi;
            }
            if (trie.get(node).children[c] != -1) {
                node = trie.get(node).children[c];
            }
            if (trie.get(node).len > 0) {
                matches.add(new Pair(i-trie.get(node).len+1, -1));
                matches.add(new Pair(i, 1));
            }
        }
        Collections.sort(matches);
        int ans = 0;
        int start = 0;
        int open = 0;
        for (Pair p : matches) {
            if (p.second == -1) {
                if (open == 0) start = p.first;
                open += 1;
            } else {
                open -= 1;
                if (open == 0) ans += p.first - start + 1;
            }
        }
        ans = n - ans;
        System.out.println(ans);
    }
}