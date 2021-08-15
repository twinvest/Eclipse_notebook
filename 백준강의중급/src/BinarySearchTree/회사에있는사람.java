package BinarySearchTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class 회사에있는사람 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> s = new HashSet<String>();
        while (n-- > 0) {
            String name = sc.next();
            String what = sc.next();
            if (what.equals("enter")) {
                s.add(name);
            } else {
                s.remove(name);
            }
        }
        String[] a = s.toArray(new String[s.size()]);
        Arrays.sort(a);
        for (int i=a.length-1; i>=0; i--) {
            System.out.println(a[i]);
        }
    }
}