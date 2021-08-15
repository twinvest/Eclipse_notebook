package BinarySearchTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class 듣보잡_map {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeMap<String, Integer> d = new TreeMap<>();
        while (n-- > 0) {
            String name = sc.next();
            Integer val = d.get(name);
            if (val == null) {
                val = 0;
            }
            d.put(name, val | 1);
        }

        while (m-- > 0) {
            String name = sc.next();
            Integer val = d.get(name);
            if (val == null) {
                val = 0;
            }
            d.put(name, val | 2);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> x : d.entrySet()) {
            if (x.getValue() == 3) {
                ans.add(x.getKey());
            }
        }
        System.out.println(ans.size());
        for (String s : ans) {
            System.out.println(s);
        }
    }
}