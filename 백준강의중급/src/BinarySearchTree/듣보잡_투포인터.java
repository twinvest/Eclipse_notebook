package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class 듣보잡_투포인터 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] a = new String[n];
        String[] b = new String[m];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        for (int i=0; i<m; i++) {
            b[i] = sc.next();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<String> ans = new ArrayList<>();
        for (int i=0, j=0; i<a.length && j<b.length;) {
            if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else if (a[i].compareTo(b[j]) > 0) {
                j++;
            } else {
                ans.add(a[i]);
                i++;
                j++;
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for (String x : ans) {
            System.out.println(x);
        }
    }
}