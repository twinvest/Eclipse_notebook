package 기하알고리즘;
/*
 * CCW : Counter Clockwise의 줄임말.
 * 세 개의 점이 있을때 어떤방향인지 알아내는 알고리즘이다.
 *
 * P1(x1, y1) P2(x2, y2) P3(x3, y3)
 * 즉, P1 -> P2 -> P3가 어떤 방향인지 알아낼 수 있다.
 * 1 : 반시계방향
 * 0 : 일직선
 * -1 : 시계방향
 *
 *
 *         P3                          P3
 *                          P3                  P2
 *     P2                P2
 *         P1         P1                  P1
 *      시계방향 -1       일직선 0           반시계방향 1
 *
 *
 * 두 벡터 P1P2, P1P3의 벡터곱의 부호와 같은 의미를 갖는다.
 * (x1 * y2) + (x2 * y3) + (x3 * y1) - (y1 * x2) - (y2 * x3) - (y3 * x1)
 *
 * x1 x2 x3 x1
 * y1 y2 y3 y1
 *
 *
 * */

import java.util.Scanner;
public class CCW {
    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int temp = x1*y2+x2*y3+x3*y1;
        temp = temp - y1*x2-y2*x3-y3*x1;
        if (temp > 0) return 1;
        else if (temp < 0) return -1;
        else return 0;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        System.out.println(ccw(x1, y1, x2, y2, x3, y3));
    }
}
