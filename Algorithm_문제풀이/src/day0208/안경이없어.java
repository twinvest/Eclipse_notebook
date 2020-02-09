package day0208;

import java.util.Scanner;
public class 안경이없어 {
	static String match1 = "CEFGHIJKLMNSTUVWXYZ";
	static String match2 ="ADOPQR";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			boolean flag = true;
			String str1= scan.next();
			String str2 = scan.next();

			if(str1.length() != str2.length())
				flag = false;
			else
			{
				for(int i =0; i<str1.length(); ++i)
				{
					int mat1=0, mat2=0, mat3=0;
					if(match1.contains(str1.charAt(i)+"")) ++mat1;
					else if(match2.contains(str1.charAt(i)+"")) ++mat2;
					else ++mat3;

					if(match1.contains(str2.charAt(i)+"")) ++mat1;
					else if(match2.contains(str2.charAt(i)+"")) ++mat2;
					else ++mat3;

					if(mat1 == 2) flag = true;
					else if(mat2 == 2) flag = true;
					else if(mat3 ==2) flag = true;
					else
					{
						flag = false;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+(flag ? "SAME" : "DIFF"));
		}
	}
}