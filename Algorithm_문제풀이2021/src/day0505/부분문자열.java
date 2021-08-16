package day0505;

import java.util.ArrayList;
import java.util.Scanner;

public class 부분문자열 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
        String String = sc.nextLine();            // 원본 string
		String Pattern = sc.nextLine();           // 찾을 pattern

		KMP(String, Pattern);
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

	public static int[] getPi(String pattern) {  // 접두사와 접미사 매칭 Count
		int LenOfPattern = pattern.length();     // 찾을 Pattern's Length
		int []pi = new int[LenOfPattern];        // pi[] 할당
		int j = 0;                               // 패턴을 탐색할 인덱스

		for(int i=1; i<LenOfPattern; i++) {      // i = 1부터
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) { // KMP알고리즘, 매칭되는 것 건너뛴다
				j = 0;//pi[j-1];                                         // j를 재할당 (건너 뜀)
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {            // 접두사랑 접미사가 같다면
				pi[i] = ++j;                                          // 해당 인덱스 카운트  (길이)
			}
		}
		return pi;     // pi[] 반환
	}

	public static int[] getPi2(String pattern) {  // 접두사와 접미사 매칭 Count
		int LenOfPattern = pattern.length();     // 찾을 Pattern's Length
		int []pi = new int[LenOfPattern];        // pi[] 할당
		int j = 0;                               // 패턴을 탐색할 인덱스

		for(int i=1; i<LenOfPattern; i++) {      // i = 1부터
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) { // KMP알고리즘, 매칭되는 것 건너뛴다
				j = 0;//pi[j-1];  j를 0이라 하면될것을 후.. pi[j-1]이라 하는지 모르겠네;; // j를 재할당 (건너 뜀)
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {            // 접두사랑 접미사가 같다면
				pi[i] = ++j;                                          // 해당 인덱스 카운트  (길이)
			}
		}
		return pi;     // pi[] 반환
	}

	public static int[] getPi3(String pattern) {  // 접두사와 접미사 매칭 Count
		int m = pattern.length();     // 찾을 Pattern's Length
		int []pi = new int[m];        // pi[] 할당

		for(int begin = 1; begin < m; ++begin) {
			for(int i = 0; i + begin < m; ++i) {
				if(pattern.charAt(begin + i) != pattern.charAt(i))
					break;
				pi[begin + i] = Math.max(pi[begin+i], i+1);
			}
		}
		return pi;     // pi[] 반환
	}

	static boolean flag = false;
	public static void KMP(String str, String pattern) {  // 매칭되는 str을 ArrayList에 저장

		ArrayList<Integer> list = new ArrayList<>();      // 매칭된 str을 저장할 ArrayList
		int [] pi = getPi(pattern);                       // 찾을 패턴의 접두사와 접미사가 카운트된 배열 불러온다
		int n = str.length();
		int m = pattern.length();
		int begin = 0, matched = 0;
		while(begin <= n - m) {
	        // 탐색할 문자열과 원본 문자열에서 현재 위치의 문자가 동일한 경우
	        if (matched < m && str.charAt(begin + matched) == pattern.charAt(matched)){
	            ++matched;
	            // 문자열이 모두 일치하는 경우
	            if (matched == m) {
	            	flag = true;
	            	break;
	            }
	        }
	        else{
	            //  일치하는 부분이 없는 경우, 다음 위치의 문자 부터 탐색
	            if(matched == 0)
	                ++begin;
	            // 문자열이 불일치 하므로 접두사, 접미사 의 길이 만큼 건너 뜀!
	            else{
	                // 현재 불일치가 발생한 위치는 begin + matched
	                // 여기서 접두, 접미사의 길이인 pi[matched - 1] 을 빼주면 다음 탐색 시작 위치
	                begin += matched - pi[matched - 1];
	                matched = pi[matched - 1];
	            }
	        }
	    }                                      // 매칭된 패턴이 저장된 list 반환
	}
}