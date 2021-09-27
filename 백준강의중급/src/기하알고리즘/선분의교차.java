package 기하알고리즘;
/*
 * CCW를 이용해 두 선분이 교차하는지 알 수 있다.
 * 아래와 같이 네 개의 점이 있다고 해보자.
 *
 *           P2
 *
 *  P3
 *
 *                 P4
 *
 *       P1
 *
 *
 * 이때, P1P2과 연결되어 있고, P3P4가 연결되어 있다고 해보자.
 * P1P2P3의 방향(반시계방향)과 P1P2P4(시계방향)의 방향이 반대이다. 선분이 교차할까? 다음 그림을 봐보자.
 *
 *
 *       P3
 *
 *                          P4
 *
 *              P2
 *
 *
 *
 *         P1
 *
 * 즉, 반대방향이라고 무조건 선분이 교차하는것은 아니다. 하나를 더 확인해 주어야한다.
 * ㄱ. P1P2P3의 방향과 P1P2P4의 방향이 반대
 * ㄴ. P3P4P1의 방향과 P3P4P1의 방향이 반대
 *
 * 이렇게 되면 선분이 교차한다.
 * 즉, CCW(P1,P2,P3) * CCW(P1,P2,P4) < 0
 *     CCW(P3,P4,P1) * CCW(P3,P4,P2) < 0
 *
 * BOJ의 '선분교차1'을 풀어보자.
 *
 * */

import java.util.Scanner;

class Point {
    long x, y;
    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
class Line {
    Point first, second;
    Line(Point first, Point second) {
        this.first = first;
        this.second = second;
    }
}
public class 선분의교차 {
    static int ccw(Point p1, Point p2, Point p3) {
        long temp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        temp -= p1.y * p2.x + p2.y * p3.x + p3.y * p1.x;
        if (temp > 0) return 1;
        if (temp < 0) return -1;
        return 0;
    }
    static boolean cross(Line l1, Line l2) {

        int l1l2 = ccw(l1.first, l1.second, l2.first) * ccw(l1.first, l1.second, l2.second);
        int l2l1 = ccw(l2.first, l2.second, l1.first) * ccw(l2.first, l2.second, l1.second);
        return l1l2 < 0 && l2l1 < 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        long x3 = sc.nextLong();
        long y3 = sc.nextLong();
        long x4 = sc.nextLong();
        long y4 = sc.nextLong();
        Line l1 = new Line(new Point(x1, y1), new Point(x2, y2));
        Line l2 = new Line(new Point(x3, y3), new Point(x4, y4));
        System.out.println(cross(l1, l2) ? 1 : 0);
    }
}
