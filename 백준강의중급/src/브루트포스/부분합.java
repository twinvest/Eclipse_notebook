package 브루트포스;

import java.util.Scanner;

public class 부분합 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int left=0;
        int right=0;
        int sum=a[0];
        int ans=n+1;
        while (left <= right && right < n) {
            if (sum < s) {
            	right += 1;
                sum += a[right];
            } else if (sum == s) {
                ans = Math.min(right-left+1,ans);
                right += 1;
                sum += a[right];
            } else if (sum > s) {
                ans = Math.min(right-left+1,ans);
                sum -= a[left];
                left++;
            }
        }

        if (ans > n) {
            ans = 0;
        }
        System.out.println(ans);
    }
}
