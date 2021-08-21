package 문자열;

/*
 * 복습
 * KMP : 문자열 S가 있을 때 패턴 P를 찾는 알고리즘
 * Trie : 문자열 N개가 있을 때, 문자열 S를 찾는 자료구조
 * 아호코라식 : 문자열 N개가 있을 때, 패턴 P를 찾는 알고리즘. 즉, Trie와 KMP를 합친 방법이다.
 *          따라서, 실행도 Trie를 만들고 KMP를 수행한다.
 *
 * 출석부에서 내이름(FullName)찾기가 Trie라면,
 * 출석부에서 나랑 성이 같은 사람, 이름이 같은사람을 찾는것은 Aho-corasick이다.
 *
 * 즉, 아호코라식을 이용하면 출석부에 김태우가 있다고 했을 시 '김', '김태', '태' 등을 찾을 수 있다.
 * 해당 코드는 boj의 문자열 집합 판별이라는 문제를 푼것임.
 *
 * */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node {
    int valid;
    int[] children;
    int pi;
    ArrayList<Integer> indexes;
    Node() {
        valid = -1;
        children = new int[26];
        for (int i=0; i<26; i++) {
            children[i] = -1;
        }
        pi = -1;
        indexes = new ArrayList<Integer>();
    }
}
public class 아호코라식_연습 {
	//////////////////Trie////////////////////
    static ArrayList<Node> trie = new ArrayList<>();
    static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index, int string_index) {
        if (index == s.length()) {
            trie.get(node).valid = string_index;
            return;
        }
        int c = s.charAt(index) - 'a';
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1, string_index);
    }
    //////////////////Trie////////////////////

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int root = init();
        int n = sc.nextInt();
        String[] a = new String[n];
        //trie에 추가.
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
            add(root, a[i], 0, i);
        }

        //여기서부터 아호코라식 코드
        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i=0; i<26; i++) {
                int next = trie.get(cur).children[i];
                if (next == -1)
                	continue;
                //길이가 1인 prefix
                if (cur == root) {
                    trie.get(next).pi = root; //root로 연결
                }

                else {
                	//완벽하게 KMP와 동일. 단, 인덱스(j)가 아니라 pi를 이용한다는 점이 다름
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
                trie.get(next).indexes = new ArrayList<>(trie.get(pi).indexes);
                if (trie.get(next).valid != -1) {
                    trie.get(next).indexes.add(trie.get(next).valid);
                }
                q.add(next);
            }
        }
        int m = sc.nextInt();
        while (m-- > 0) {
            String s = sc.next();
            int node = root;
            boolean ok = false;
            //KMP와 동일
            for (int i=0; i<s.length(); i++) {
                int c = s.charAt(i) - 'a';
                while (node != root && trie.get(node).children[c] == -1) {
                    node = trie.get(node).pi;
                }
                if (trie.get(node).children[c] != -1) {
                    node = trie.get(node).children[c];
                }
                if (trie.get(node).indexes.size() > 0) {
                    ok = true;
                }
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}