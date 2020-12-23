package day1223;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		문자열압축 main = new 문자열압축();
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int ans = main.solution(str);
		System.out.println(ans);
	}

	  public int solution(String str) {

	        ArrayList<Integer> ansList = new ArrayList<>();
	        ArrayList<String> ansList2 = new ArrayList<>();
	        if(str.length() == 1) {
	            ansList.add(1);
	        }

	        //1부터 str의 length까지 1씩 올려보면서 짜른다.
	        for(int i = 1; i<str.length(); ++i) {

	            String before = "";
	            String cur = "";
	            String ans = "";
	            int recurCount = 1;

	            //i만큼 증가시키면서 for문을 돌리는데 이 때 크게 세 가지 경우의 수가 있음. 범위를 벗어난 경우. 범위가 딱 맞는 경우. 범위 벗어나지 않은 경우.
	            for(int j = 0; j < str.length(); j = j+i) {
	                //범위를 벗어난 경우의 처리
	                if(j+i > str.length()) {
	                    if(recurCount > 1)
	                        ans += recurCount;
	                    ans += before;
	                    ans += str.substring(j, str.length());
	                }
	                //범위가 아직 안인 경우
	                else {
	                    //처음인 경우
	                    if(before.isEmpty()) {
	                        before = str.substring(j, j+i);
	                        continue;
	                    }
	                    //다음 for문이 마지막인 경우이자 딱 맞는경우.
	                    if(j+i == str.length()) {
	                        cur = str.substring(j, j+i);
	                        if(before.equals(cur)) {
	                            ++recurCount;
	                            ans += recurCount + before;
	                        } else {
	                        	if(recurCount > 1)
	                        		ans += recurCount;
	                            ans += before + cur;
	                        }
	                    }
	                    //범위 안의 경우
	                    else {
	                        cur = str.substring(j, j+i);
	                        if(before.equals(cur)) {
	                            ++recurCount;
	                        } else {
	                            if(recurCount == 1) {
	                                ans += before;
	                            } else {
	                                ans += recurCount + before;
	                                recurCount = 1;
	                            }
	                        }
	                        before = cur;
	                    }
	                }
	            }
	            ansList.add(ans.length());
	            ansList2.add(ans);
	        }
	        for(String a : ansList2)
	        	System.out.println(a);

	        Collections.sort(ansList);
	        return ansList.get(0);
	    }

}
