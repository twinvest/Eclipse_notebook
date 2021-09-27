package 기하알고리즘;
import java.util.Scanner;
/*
 *
 *       P2
 *    P3
 * P1
 *         P4
 *
 * 위의 케이스는 P1 P2 P3이 일직선에 있는것이다. 이때도, 교차한다고 볼 수 있다. 따라서 80라인에 등호를 추가해줬다.
 * 그럼 이렇게 한다고 반례가 없을까? 아니다 반례가 또 있다.
 * 다음과 같이 점이 위치해 있다고 해보자.
 *
 *
 *
 *
 *  P1      P2      P3        P4
 *
 *
 * 두 선분이 교차하는가? 그렇지 않다. 그런데,
 * CCW(P1,P2,P3) * CCW(P1,P2,P4) = 0
 * CCW(P3,P4,P1) * CCW(P3,P4,P2) = 0 이다.
 *
 * 따라서 모두 0 일때는 확인해 주어야할것이 있다.(71라인에 추가)
 * ㄱ. P1 <= P4
 * ㄴ. P3 <= P2
 *
 * 즉, P1     P3    P2     P4  와 같아야 한다.
 *
 * */


class Point {
    long x, y;
    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point that) {
        if (this.x < that.x) {
            return -1;
        } else if (this.x == that.x) {
            if (this.y < that.y) return -1;
            if (this.y > that.y) return 1;
            return 0;
        } else {
            return 1;
        }
    }
}
class Line {
    Point first, second;
    Line(Point first, Point second) {
        this.first = first;
        this.second = second;
    }
}

public class 선분교차2 {
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

        if (l1l2 == 0 && l2l1 == 0) { //선분교차1과 다른점.
            if (l1.first.compareTo(l1.second) == 1) {
                Point temp = l1.first; l1.first = l1.second; l1.second = temp;
            }
            if (l2.first.compareTo(l2.second) == 1) {
                Point temp = l2.first; l2.first = l2.second; l2.second = temp;
            }
            return l2.first.compareTo(l1.second) != 1 && l1.first.compareTo(l2.second) != 1;
        }

        return l1l2 <= 0 && l2l1 <= 0; //선분교차1과 다른점.
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
