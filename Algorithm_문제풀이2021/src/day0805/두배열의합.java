package day0805;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class 두배열의합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        //a의 모든 부분배열의 합
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += a[j];
                first.add(sum);
            }
        }
        //b의 모든 부분배열의 합
        for (int i=0; i<m; i++) {
            int sum = 0;
            for (int j=i; j<m; j++) {
                sum += b[j];
                second.add(sum);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : second) {
            if (map.containsKey(x)) {
                int temp = map.get(x);
                map.put(x, temp+1);
            } else {
                map.put(x, 1);
            }
        }
        long ans = 0;
        for (int num : first) {
            if (map.containsKey(t-num)) {
                ans += map.get(t-num);
            }
        }
        System.out.println(ans);
    }
}