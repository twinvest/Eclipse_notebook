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
        //삽입하려고 봤는데 비어있는 경우 실제로 삽입해준다.
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next; //다음노드의 번호를 저장.
        }
        int child = trie.get(node).children[c]; //다음 노드의 번호를 불러온다.
        add(child, s, index + 1);
    }

    void add(String s) {
    	//root는 0임.
        add(root, s, 0);
    }

    boolean search(int node, String s, int index) {
        //노드가 없을 때 바로 false리턴.
    	if (node == -1)
        	return false;
        //찾고하는 문자열s의 끝에 도달했다면 해당 노드의 valid를 리턴.
    	if (index == s.length())
        	return trie.get(node).valid;

    	//위 두 경우가 아니라면 다시 타고 들어간다.
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