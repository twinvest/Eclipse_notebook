package 브루트포스;

public class 비트마스킹연습 {

	public static void main(String[] args) {
		int n = 3;

		for (int i=0; i<(1<<n); i++) {
            for (int k=0; k<n; k++) {

                if ((i&(1<<k)) == (1<<k)) { //(i&(1<<k))>0과 같은 표현
                	System.out.println(i+","+(1<<k));
                	System.out.println("===>"+Integer.toBinaryString(1<<k));

                }
            }
        }
	}

}
