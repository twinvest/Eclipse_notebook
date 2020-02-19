package day0219;

import java.util.ArrayList;
import java.util.Scanner;

public class ½ÊÁø¼ö {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		String s = scan.next();
		for(int i=0; i<70; i+=7)
		{
			String tmp = s.substring(i, i+7);
			list.add(tmp);
		}
		for(String s3: list)
		{
			int sum = 0;
			for(int i=0; i<7; ++i)
			{
				if(Integer.parseInt(s3.charAt(i)+"") == 1)
					sum += Integer.parseInt(s3.charAt(i)+"") * (int)Math.pow(2, 6-i);
			}
			System.out.println(sum);
		}
	}
}
