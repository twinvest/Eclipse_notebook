package BinarySearchTree;

import java.util.HashSet;
import java.util.Scanner;

public class CeilingFunction {

	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    Node() {
	        val = 0;
	        left = null;
	        right = null;
	    }
	}

    static String preorder(Node root) {
        String ans = "";
        ans += "V";
        if (root.left != null) {
            ans += "L";
            ans += preorder(root.left);
            ans += "l";
        }
        if (root.right != null) {
            ans += "R";
            ans += preorder(root.right);
            ans += "r";
        }
        ans += "v";
        return ans;
    }
    static void remove(Node root) {
        if (root.left != null) {
            remove(root.left);
        }
        if (root.right != null) {
            remove(root.right);
        }
        root = null;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<String> s = new HashSet<String>();
        for (int k=0; k<n; k++) {
            int[] a = new int[m];
            for (int i=0; i<m; i++) {
                a[i] = sc.nextInt();
            }
            Node root = new Node();
            root.val = a[0];
            for (int i=1; i<m; i++) {
                Node cur = root;
                while (true) {
                    if (cur.val > a[i]) {
                        if (cur.left == null) {
                            cur.left = new Node();
                            cur.left.val = a[i];
                            break;
                        } else {
                            cur = cur.left;
                        }
                    } else if (cur.val < a[i]) {
                        if (cur.right == null) {
                            cur.right = new Node();
                            cur.right.val = a[i];
                            break;
                        } else {
                            cur = cur.right;
                        }
                    } else {
                        break;
                    }
                }
            }
            s.add(preorder(root));
            remove(root);
        }
        System.out.println(s.size());
    }
}