package day0219;

import java.util.Scanner;

public class 최대상금 {

	static int numOfChange;
	static int max;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			String s = scan.next();
			numOfChange = scan.nextInt();
			max = -987654321;
			perm(0, 0, s);
			System.out.println("#"+t+" "+max);
		}
	}

	static void perm(int idx, int limit, String s)
	{
		if(limit == numOfChange)
		{
			if(max < Integer.parseInt(s))
				max = Integer.parseInt(s);
			//System.out.println(s+","+limit);
			return;
		}
		for(int i = idx; i < s.length(); ++i)
		{
			for(int j=i+1; j<s.length(); ++j)
			{
				if(Integer.parseInt(s.charAt(i)+"") <= Integer.parseInt(s.charAt(j)+""))
				{
					s = swap(i, j, s);
					perm(i, limit+1, s);
					s = swap(i, j, s);
				}
			}
		}
	}
	static String swap(int a, int b, String s) {
		StringBuilder builder = new StringBuilder(s);
		char tmp = s.charAt(a);
		builder.setCharAt(a, s.charAt(b));
		builder.setCharAt(b, tmp);
		return builder.toString();
	}
}