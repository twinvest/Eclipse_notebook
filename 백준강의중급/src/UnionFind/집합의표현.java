package UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 집합의표현 {
    static int[] parent = new int[1000001];
    static int[] rank = new int[1000001];
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) {
            int temp = x; x = y; y = temp;
        }
        parent[y] = x;
        if (rank[x] == rank[y]) {
            rank[x] = rank[y] + 1;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        for (int i=0; i<=n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (m-- > 0) {
            String[] temp = br.readLine().split(" ");
            int w = Integer.parseInt(temp[0]);
            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);
            if (w == 0) {
                union(x, y);
            } else {
                x = find(x);
                y = find(y);
                if (x == y) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
    }
}