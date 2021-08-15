package BinarySearchTree;
import java.util.*;

/*
 *  이진검색트리(BST)
 *  현재 노드의 왼쪽 서브트리에는 항상 현재노드의 값보다 작은 값이 들어있다.
 *  현재 노드의 오른쪽 서브트리에는 항상 현재노드의 값보다 큰 값이 들어있다.
 *
 *  균형이 맞춰져 있는 BST는
 *  ㄱ. AVL-Tree
 *  ㄴ. Red-Black Tree
 *  ㄷ. Splay Tree
 *  ㄹ. Treap 등이 있다.
 *
 *  그러나, 위에 4개는 말할것도 없고 이 이진검색트리를 구현한다는건 쉽지 않은 일이다.
 *  따라서, C++의 경우에는 set, map을 사용하고 Java에서는 TreeSet이나 TreeMap을 이용한다.
 *  정렬된 상태가 필요없다면
 *  C++은 unordered_set, unordered_map Java는 HashSet, HashMap등을 이용한다.
 *
 * */


class Node {
    int data;
    Node left;
    Node right;
    Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BST {
    Node root;
    BST() {
        this.root = null;
    }
    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = this.insert(node.left, data);
        } else {
            node.right = this.insert(node.right, data);
        }
        return node;
    }
    void insert(int data) {
        this.root = this.insert(this.root, data);
    }
    void inorder(Node node) {
        if (node == null) {
            return;
        }
        this.inorder(node.left);
        System.out.print(node.data + " ");
        this.inorder(node.right);
    }
    void inorder() {
        this.inorder(this.root);
        System.out.println();
    }
    Node inorder_successor(Node node) {
        Node p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
    Node remove(Node node, int data) {
        if (node == null) {
            return node;
        }

        if (data < node.data) {
            node.left = this.remove(node.left, data);
        } else if (data > node.data) {
            node.right = this.remove(node.right, data);
        } else {
            if (node.left == null) {
                Node temp = node.right;
                node = null;
                return temp;
            } else if (node.right == null) {
                Node temp = node.left;
                node = null;
                return temp;
            }

            Node temp = this.inorder_successor(node.right);
            node.data = temp.data;
            node.right = this.remove(node.right, temp.data);
        }
        return node;
    }
    void remove(int data) {
        this.root = this.remove(this.root, data);
    }
}
public class 이진검색트리_연습 {
    public static void main(String args[]) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(4);
        bst.insert(1);
        bst.insert(6);
        bst.insert(9);

        bst.inorder();

        bst.remove(2);
        bst.inorder();

        bst.remove(5);
        bst.inorder();
    }
}