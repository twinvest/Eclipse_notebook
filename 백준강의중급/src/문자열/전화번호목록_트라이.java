package 문자열;

/*
 * 한 번호가 다른 번호의 접두어이면 안된다.
 *
 *
 * */
import java.util.ArrayList;
import java.util.Scanner;


public class 전화번호목록_트라이 {

	static class Node {
	    boolean valid;
	    int[] children;
	    Node() {
	        valid = false;
	        children = new int[10]; //숫자니 0~9
	        for (int i=0; i<10; i++) {
	            children[i] = -1;
	        }
	    }
	}


    static ArrayList<Node> trie;
    static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index) {
        if (index == s.length()) {
            trie.get(node).valid = true;
            return;
        }
        int c = s.charAt(index) - '0';
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1);
    }


    static boolean check(int node) { //인자로 받는 node에 방문한거임
        //총 10개의 자식중에
    	for (int i=0; i<10; i++) {
            //-1이 아니라는건 자식이 존재한다는것
    		if (trie.get(node).children[i] != -1) {
                //valid가 true라는건 우리가 이미 기존에 추가했던 노드
    			if (trie.get(node).valid == true) {
                    return false;
                } else {
                    if (!check(trie.get(node).children[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            trie = new ArrayList<Node>();
            int root = init();

            for (int i=0; i<n; i++) {
                a[i] = sc.next();
                add(root, a[i], 0);
            }

            if (check(root)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}