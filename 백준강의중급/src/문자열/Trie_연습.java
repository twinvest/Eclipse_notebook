package 문자열;

import java.util.ArrayList;

/*
 * 숫자비교는 O(1)이지만 문자열의 비교는 최대 O(문자열길이)만큼 시간이 걸린다.
 * 문자열 N개를 담고 있는 BST(BinarySearchTree)에서 검색하는데 걸리는 시간은 O(logN)이 아니고 O(logN * 길이)이다.
 *
 * 트리가 기반임.
 * 트라이의 한 노드는 어떤 문자열의 접두사(prefix)를 나타낸다.
 * 따라서, Trie는 Prefix Tree라고도 한다.
 *
 *
 * */
public class Trie_연습 {
	static class Node{
		int[] children = new int[26];
		boolean valid;
		Node(){
			for(int i =0; i<26; ++i) {
				children[i] = -1;
			}
			valid = false;
		}
	}

	static ArrayList<Node> trie = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int root;

	}

	static int init() {
		Node x = new Node();
		trie.add(x);
		return trie.size()-1;
	}

	//node : 현재 탐색하고 있는 노드의 인덱스.
	//s : 추가하려고 하는 문자열
	//index : s의 몇번째 index를 추가하고 있는지.
	static void add(int node, String s, int index) {
		//문자열의 마지막 인덱스까지 다 추가했다면
		if(index == s.length()) {
			trie.get(node).valid = true;
			return;
		}
		//c는 자식의 인덱스를 조회하기 위해서
		int c = s.charAt(index) - 'a';
		if (trie.get(node).children[c] == -1) {
			int next = init();
			trie.get(node).children[c] = next;
		}

		int child = trie.get(node).children[c];
		add(child, s, index +1);
	}

	static boolean search(int node, String s, int index) {
		if(node == -1) return false; //없는 경우.

		//밑에부터는 노드는 있는경우
		//가장 마지막까지 검사했을때
		if(index == s.length())
			return trie.get(node).valid; //true면 우리가 추가한것. false는 중간과정에서 만들어진것.

		int c = s.charAt(index) - 'a';
		int child = trie.get(node).children[c];
		return search(child, s, index+1);
	}


}
