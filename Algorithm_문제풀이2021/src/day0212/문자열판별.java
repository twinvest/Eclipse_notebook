package day0212;

import java.util.Scanner;

public class 문자열판별 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String targetS = scan.next();
		int n = scan.nextInt();
		String[] arr = new String[n];
		for(int i =0; i<n; ++i) {
			arr[i] = scan.next();
		}

		for(int i =0; i<n; ++i) {
			if(targetS.contains(arr[i])) {
				int startIndex = -1;
				int endIndex = -1;
				for(int j=0; j<targetS.length(); ++j) {
					String temp = targetS.substring(j, targetS.length());
					if(temp.contains(arr[i])) {
						continue;
					} else {
						startIndex = j-1;
						break;
					}
				}

				for(int j=0; j<targetS.length(); ++j) {
					String temp = targetS.substring(0, targetS.length()-j);
					if(temp.contains(arr[i])) {
						continue;
					} else {
						endIndex = targetS.length()-j+1;
						break;
					}
				}

				char[] target = targetS.toCharArray();
				String temp ="";
				for(int j=0; j<target.length; ++j) {
					if(j>=startIndex && j<endIndex)
						continue;
					else
						temp += targetS.charAt(j)+"";
				}
				targetS = temp;
			}
		}
		if(targetS.equals("")) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

}
