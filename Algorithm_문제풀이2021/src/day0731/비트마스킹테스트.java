package day0731;

public class 비트마스킹테스트 {

	public static void main(String[] args) {
		int m = 4;
        int cnt = 0;
        int cnt2 = 0;
        System.out.println(1<<m);
        for (int i=0; i<(1<<m); i++) { //방법을 모두 만들어본다.
        	for (int j=0; j<m; j++) {
                ++cnt;
                if ((i&(1<<j)) > 0 && (i&(1<<(j+1))) > 0) { //j번째와 j+1번째가 모두 0이 아니라 1이라면. 즉, 연산자가 연속하는 경우를 의미
                	++cnt2;
        			System.out.println(i+","+j);
                }
                /*if ((i&(1<<j)) > 0) {
                	++cnt2;
        			System.out.println(i+","+j);
                }*/
        	}
        }
        System.out.println(cnt);
        System.out.println(cnt2);
	}
}
