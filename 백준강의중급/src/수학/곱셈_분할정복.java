package 수학;


import java.util.*;
public class 곱셈_분할정복 {
    static long go(long a, long b, long c) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a%c;
        } else if (b%2 == 0) {
            long temp = go(a, b/2, c);
            return (temp * temp) % c;
        } else {
            return (a * go(a, b-1, c)) % c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(go(a,b,c));
    }
}