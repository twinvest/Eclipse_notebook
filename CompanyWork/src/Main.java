//최단거리

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static ArrayList<Node> box = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int a;
        int b;
        int c = 0;
        int d = 0;
        int result = 0;

        a = sc.nextInt();

        for (int i = 0; i < a; i++) {
            Node node = new Node(i);
            box.add(node);
        }

        b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            c = sc.nextInt();
            d = sc.nextInt();
            box.get(c).getNodes().add(box.get(d));
            box.get(d).getNodes().add(box.get(c));
        }

        int start = sc.nextInt();
        int goal = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();

        Node st = box.get(start);
        queue.offer(st);
        st.setHeight(0);
        st.setChecked(true);

        bigWhile:
        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int i = 0; i < node.getNodes().size(); i++) {

                Node offer = node.getNodes().get(i);

                if (offer.getData() == goal) {
                    result = offer.getHeight();
                    break bigWhile;
                }

                if (!offer.isChecked()) {
                    offer.setHeight(node.getHeight() + 1);

                    queue.offer(offer);
                    offer.setChecked(true);
                }

            }

        }

        System.out.println(result);

    }


}


class Node {

    private boolean isChecked;
    private int data;
    private int height;
    private ArrayList<Node> nodes;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Node(int data) {
        this.setChecked(false);
        this.data = data;
        nodes = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}
