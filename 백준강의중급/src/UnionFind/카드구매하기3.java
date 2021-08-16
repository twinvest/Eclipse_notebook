package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair implements Comparable<Pair> {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
	public int compareTo(Pair that) {
        if (this.first < that.first) {
            return -1;
        } else if (this.first == that.first) {
            if (this.second < that.second) {
                return -1;
            } else if (this.second == that.second) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class 카드구매하기3 {
    static int[] parent = new int[1000001];
    static int[] rank = new int[1000001];
    static int[] size = new int[1000001];
    static int find(int x) {
        if (x == -1) {
            return -1;
        } else if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    static long union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y || x == -1 || y == -1) return 0;
        if (rank[x] < rank[y]) {
            int temp = x; x = y; y = temp;
        }
        parent[y] = x;
        if (rank[x] == rank[y]) {
            rank[x] = rank[y] + 1;
        }
        long cnt = 1L*size[x]*size[y];
        size[x] += size[y];
        return cnt;
    }
    static void init() {
        Arrays.fill(parent,-1);
        Arrays.fill(size, 0);
        Arrays.fill(rank, 0);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Pair[] a = new Pair[n];
        for (int i=0; i<n; i++) {
            a[i] = new Pair(Integer.parseInt(line[i]), i);
        }
        Arrays.sort(a);
        long ans = 0;
        init();
        for (int i=0; i<n; i++) {
            int num = a[i].first;
            int index = a[i].second;
            parent[index] = index;
            size[index] = 1;
            if (index+1 < n) {
                ans += 1L*num*union(index, index+1);
            }
            if (index-1 >= 0) {
                ans += 1L*num*union(index, index-1);
            }
        }
        init();
        for (int i=n-1; i>=0; i--) {
            int num = a[i].first;
            int index = a[i].second;
            parent[index] = index;
            size[index] = 1;
            if (index+1 < n) {
                ans -= 1L*num*union(index, index+1);
            }
            if (index-1 >= 0) {
                ans -= 1L*num*union(index, index-1);
            }
        }
        System.out.println(ans);
    }
}