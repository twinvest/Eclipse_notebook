package day1214;

import java.util.Arrays;
import java.util.Scanner;

public class 모험가길드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i =0; i<N; ++i) {
			arr[i] = scan.nextInt();
		}
		int ans = 0;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] == 1) {
				++ans;
				continue;
			}
			//끝의 값이 범위를 초과하지 않는지 체크하고 해당인덱스의 시작값과 끝값이 같다면
			if(i + arr[i]-1 < arr.length && arr[i+arr[i]-1] == arr[i]) {
				//길드를 만들고
				++ans;
				//해당인덱스로 점프한다.
				i = i + arr[i]-1;
			}
		}
		System.out.println(ans);
	}
}
