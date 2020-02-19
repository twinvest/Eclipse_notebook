package day0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 단순2진암호코드 {
	static String[] match = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111","0111011","0110111","0001011"};
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; ++t)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<String> list = new ArrayList<>();
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for(int i=0; i<y; ++i)
			{
				String tmp = br.readLine();
				list.add(tmp);
			}
			int[] ans = new int[8];
			int index = 0;
			int start = 0;
			boolean flag = false;
			out : for(int i=0; i<list.size(); ++i)
			{
				if(flag)
					break;
				String tmp = list.get(i);
				if(tmp.contains("1"))
				{
					for(int l = tmp.length()-1; l>=0; --l)
					{
						if(tmp.charAt(l) == '1')
						{
							start = l;
							break;
						}
					}
					for(int j=start+1; j>=0; j-=7)
					{
						String target = tmp.substring(j-7, j);
						for(int k=0; k<match.length; ++k)
						{
							if(target.equals(match[k]))
							{
								ans[index++] = k;
								flag = true;
								if(index == 8)
									break out;
							}
						}
					}
				}
			}
			int sum1 = 0;
			int sum2 = 0;
			int realsum = 0;
			for(int i=0; i<ans.length; ++i)
			{
				if(i % 2 ==1)
					sum1 += ans[i];
				if(i % 2 ==0)
					sum2 += ans[i];
			}
			sum1 = sum1 * 3;
			realsum = sum1 + sum2;
			int realans = 0;
			for(int i = 0; i<ans.length; ++i)
				realans += ans[i];
			if(realsum % 10 == 0)
				System.out.println("#"+t+" "+realans);
			else
				System.out.println("#"+t+" 0");
		}
	}
}