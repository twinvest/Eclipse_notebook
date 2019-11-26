import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    int[] arr = new int[11];
	    int T, n;
	    Scanner scanner = new Scanner(System.in);
	     
	    arr[0] = 0; // 정수가 0일 때 방법(경우)의 수
	    arr[1] = 1; // 정수가 1일 때 경우의 수, 1 => 1개
	    arr[2] = 2; // 정수가 2일 때 경우의 수, 1+1, 2 => 2개
	    arr[3] = 4; // 정수가 3일 때 경우의 수, 1+1+1, 1+2, 2+1, 3 => 4개
	    T = scanner.nextInt();
	    for(int i = 0; i < T; i++) {
	      n = scanner.nextInt();
	      for(int j = 4; j <= n; j++){
	        arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
	      }
	      System.out.println(arr[n]);
	    }
	    scanner.close();
	  }

}