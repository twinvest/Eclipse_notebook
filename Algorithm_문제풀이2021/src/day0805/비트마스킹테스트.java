package day0805;

public class 비트마스킹테스트 {

	public static void main(String[] args) {
		int n = 3;
		int[] a = {-7, -3, -2};
		//앞에서 만들 수 있는 모든 부분수열의 합을 만들어서 first에 저장
        int[] first = new int[1<<n];
        for (int i=0; i<(1<<n); i++) {
            for (int k=0; k<n; k++) {

                if ((i&(1<<k)) == (1<<k)) {

                	first[i] += a[k];
                }
                System.out.println();
            }
        }


        for(int i =0; i<first.length; ++i) {
        	System.out.print(first[i]+" ");
        }



	}

}
