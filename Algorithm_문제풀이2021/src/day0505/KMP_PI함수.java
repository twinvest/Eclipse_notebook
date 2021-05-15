package day0505;

import java.util.Arrays;

public class KMP_PI함수 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getPi2("ACCA")));
	}
	public static int[] getPi(String pattern) {  // 접두사와 접미사 매칭 Count
		int m = pattern.length();     // 찾을 Pattern's Length
		int []pi = new int[m];        // pi[] 할당
		int j = 0;                               // 패턴을 탐색할 인덱스

		for(int begin = 1; begin < m; ++begin) {
			for(int i = 0; i + begin < m; ++i) {
				if(pattern.charAt(begin + i) != pattern.charAt(i))
					break;
				pi[begin + i] = Math.max(pi[begin+i], i+1);
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
				j = 0;//pi[j-1];  ㅁㅊㄴ들이 개같이 pi[j-1]이라 하는지 모르겠네;; // j를 재할당 (건너 뜀)
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {            // 접두사랑 접미사가 같다면
				pi[i] = ++j;                                          // 해당 인덱스 카운트  (길이)
			}
		}
		return pi;     // pi[] 반환
	}
}