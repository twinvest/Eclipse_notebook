package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class 듣보잡_set {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<String> s = new TreeSet<>();
        while (n-- > 0) {
            String name = sc.next();
            s.add(name);
        }
        ArrayList<String> ans = new ArrayList<>();
        while (m-- > 0) {
            String name = sc.next();
            if (s.contains(name)) {
                ans.add(name);
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for (String x : ans) {
            System.out.println(x);
        }
    }
}