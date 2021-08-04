package day0803;

import java.util.ArrayList;
import java.util.Scanner;
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class 사다리조작 {
    static int[][] garo = new int[100][100];
    static int w, h;
    static int start(int c) {
        int r = 1;
        while (r <= h) {
            //왼쪽 끝이면
        	if (garo[r][c] == 1) {
                c += 1; //오른쪽으로 이동
            }
        	//오른쪽 끝이면
        	else if (garo[r][c] == 2) {
                c -= 1; //왼쪽으로 이동
            }
            r += 1; //행은 1씩 증가.
        }
        return c;
    }

    static boolean go() {
    	//모든 세로선의 결과를 확인
        for (int i=1; i<=w; i++) {
            int res = start(i);
            //한번이라도 다르면 바로 false 리턴
            if (res != i) return false;
        }
        //for문을 통과하면 true리턴
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        w = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            garo[x][y] = 1;
            garo[x][y+1] = 2;
        }

        //놓을 수 있는 모든 위치를 temp에 추가.
        ArrayList<Pair> temp = new ArrayList<>();
        for (int i=1; i<=h; i++) {
            for (int j=1; j<=w-1; j++) {
                if (garo[i][j] != 0)
                	continue;
                if (garo[i][j+1] != 0)
                	continue;
                //왼쪽끝 좌표를 넣어준다.
                temp.add(new Pair(i,j));
            }
        }
        Pair[] a = temp.toArray(new Pair[temp.size()]);
        int ans = -1;

        //go함수는 i번 가로줄이 i번 결과가 나오는지 구하는 함수.
        //가로선을 한번도 추가하지 않고 원하는 결과가 나올 수 있으니 제일 먼저 체크해준다.
        if (go()) {
            System.out.println(0);
            return;
        }

        int len = a.length;
        for (int i=0; i<len; i++) {
            int x1 = a[i].first;
            int y1 = a[i].second;
            //놓을 수 있는지 검사
            if (garo[x1][y1] != 0 || garo[x1][y1+1] != 0)
            	continue;
            //가로선 1개 추가.
            garo[x1][y1] = 1;
            garo[x1][y1+1] = 2;
            if (go()) {
                if (ans == -1 || ans > 1) {
                    ans = 1; //가능하면 정답을 1로 만들어준다.
                }
            }

            //2번 가로선 놓기
            for (int j=i+1; j<len; j++) {
                int x2 = a[j].first;
                int y2 = a[j].second;
                if (garo[x2][y2] != 0 || garo[x2][y2+1] != 0)
                	continue;
                garo[x2][y2] = 1;
                garo[x2][y2+1] = 2;
                if (go()) {
                    if (ans == -1 || ans > 2) {
                        ans = 2;
                    }
                }

                //3번 가로선 놓기
                for (int k=j+1; k<len; k++) {
                    int x3 = a[k].first;
                    int y3 = a[k].second;
                    if (garo[x3][y3] != 0 || garo[x3][y3+1] != 0)
                    	continue;
                    garo[x3][y3] = 1;
                    garo[x3][y3+1] = 2;
                    if (go()) {
                        if (ans == -1 || ans > 3) {
                            ans = 3;
                        }
                    }
                    //3번 가로선 철회
                    garo[x3][y3] = 0;
                    garo[x3][y3+1] = 0;
                }

                //2번 가로선 철회
                garo[x2][y2] = 0;
                garo[x2][y2+1] = 0;
            }

            //1번 가로선 철회
            garo[x1][y1] = 0;
            garo[x1][y1+1] = 0;
        }
        System.out.println(ans);
    }
}