import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			char[] chs = sc.next().toCharArray();
			char cur = '0';
			int count = 0;
			for(char ch: chs) {
				if( ch != cur ) {
					count++;
					cur = ch;
				}
			}
			System.out.format("#%d %d\n", tc, count);
		}
		sc.close();
	}
}