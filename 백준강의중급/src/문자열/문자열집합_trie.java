package 문자열;

import java.util.ArrayList;
import java.util.Scanner;
class Trie {
    class Node {
        int[] children;
        boolean valid;
        Node() {
            children = new int[26];
            for (int i=0; i<26; i++) {
                children[i] = -1;
            }
            valid = false;
        }
    }
    ArrayList<Node> trie;
    int root;
    int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size() - 1;
    }
    Trie() {
        trie = new ArrayList<Node>();
        root = init();
    }
    void add(int node, String s, int index) {
        if (index == s.length()) {
            trie.get(node).valid = true;
            return;
        }
        int c = s.charAt(index) - 'a';
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        int child = trie.get(node).children[c];
        add(child, s, index + 1);
    }
    void add(String s) {
        add(root, s, 0);
    }
    boolean search(int node, String s, int index) {
        if (node == -1) return false;
        if (index == s.length()) return trie.get(node).valid;
        int c = s.charAt(index)-'a';
        int child = trie.get(node).children[c];
        return search(child, s, index+1);
    }
    boolean search(String s) {
        return search(root, s, 0);
    }
}
public class 문자열집합_trie {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Trie trie = new Trie();
        while (n-- > 0) {
            trie.add(sc.next());
        }
        int ans = 0;
        while (m-- > 0) {
            if (trie.search(sc.next())) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}