package day0803;

import java.util.Scanner;
public class 십자가2개놓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][];
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }
        int ans = 0;
        for (int x1=0; x1<n; x1++) {     //십자가1의 x좌표
            for (int y1=0; y1<m; y1++) { //십자가1의 y좌표
                for (int s1=0;; s1++) {  //십자가1의 크기
                    if (x1-s1 < 0 || x1+s1 >= n) break; //범위 벗어나는지 check
                    if (y1-s1 < 0 || y1+s1 >= m) break; //범위 벗어나는지 check
                    if (a[x1-s1][y1] != '#' || a[x1+s1][y1] != '#') break; //문제조건인 #에만 둘 수 있다.
                    if (a[x1][y1-s1] != '#' || a[x1][y1+s1] != '#') break; //문제조건인 #에만 둘 수 있다.

                    //십자가 1을 놓은 곳을 의미
                    a[x1-s1][y1] = '*'; a[x1+s1][y1] = '*';
                    a[x1][y1-s1] = '*'; a[x1][y1+s1] = '*';

                    for (int x2=0; x2<n; x2++) {     //십자가2의 x좌표
                        for (int y2=0; y2<m; y2++) { //십자가2의 y좌표
                            for (int s2=0;; s2++) {  //십자가2의 크기
                                if (x2-s2 < 0 || x2+s2 >= n) break;
                                if (y2-s2 < 0 || y2+s2 >= m) break;
                                if (a[x2-s2][y2] != '#' || a[x2+s2][y2] != '#') break;
                                if (a[x2][y2-s2] != '#' || a[x2][y2+s2] != '#') break;
                                int area = (4*s1+1)*(4*s2+1); //십자가 1의 면적과 십자가 2의 면적을 곱해준다.
                                if (ans < area) ans = area;
                            }
                        }
                    }
                }

                //맵을 원복해준다.
                for (int s1=0;; s1++) {
                    if (x1-s1 < 0 || x1+s1 >= n) break;
                    if (y1-s1 < 0 || y1+s1 >= m) break;
                    if (a[x1-s1][y1] != '*' || a[x1+s1][y1] != '*') break;
                    if (a[x1][y1-s1] != '*' || a[x1][y1+s1] != '*') break;
                    a[x1-s1][y1] = '#'; a[x1+s1][y1] = '#';
                    a[x1][y1-s1] = '#'; a[x1][y1+s1] = '#';
                }
            }
        }
        System.out.println(ans);
    }
}