package day0209;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 집배원한상덕_구글링1 {
    static int N, House, Min=999999;
    static Point start;
    static boolean visit[][];
    static char map[][];
    static int arr[][];
    static ArrayList<Integer> arrList = new ArrayList<>();
    static int moveX[] = {0,1,1,1,0,-1,-1,-1};
    static int moveY[] = {-1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                char ch = str.charAt(j);

                if(ch == 'P')
                    start = new Point(j,i);
                if(ch == 'K')
                    House++;

                map[i][j] = ch;
            }
        }
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                if(!arrList.contains(val))
                    arrList.add(val);
            }
        }
        Collections.sort(arrList);

        bfs();

    }
    public static void bfs() {
        int low=0, high=0;
        while(low<arrList.size()) {
            visit = new boolean[N][N];
            Queue<Point> queue = new LinkedList<Point>();
            int val = arr[start.y][start.x];
            if(arrList.get(low)<= val && val<=arrList.get(high)) {
                visit[start.y][start.x] = true;
                queue.add(new Point(start.x, start.y));

            }
            int count = 0;
            while(!queue.isEmpty()) {
                Point po = queue.poll();
                if(map[po.y][po.x] == 'K') {
                    count++;
                }

                for(int d=0; d<8; d++) {
                    int newY = po.y + moveY[d];
                    int newX = po.x + moveX[d];

                    if(0<=newY && newY<N && 0<=newX && newX<N && !visit[newY][newX]) {
                        int nextVal = arr[newY][newX];
                        if(arrList.get(low)<= nextVal && nextVal<=arrList.get(high)) {
                            visit[newY][newX] = true;
                            queue.add(new Point(newX,newY));
                        }

                    }
                }
            }
            if(House == count) {
                Min = Math.min(Min, arrList.get(high) - arrList.get(low));
                low++;
            }else if(high + 1 < arrList.size()) {
                high++;
            }else
                break;
        }

        System.out.println(Min);
    }
}