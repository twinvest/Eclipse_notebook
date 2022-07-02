package day0422;

import java.util.Scanner;

public class 종이접기_1802 {
	static String str = "";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		for(int t=0; t<testCase; ++t) {
			str = scan.next();
			boolean flag = false;
			if(str.length() % 2 == 0) {
				System.out.println("NO");
				continue;
			} else {
				flag = checkSymmetry(0, str.length()-1);
			}

			if(flag) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
	//가운데를 기준으로 대칭인지 확인한다.
	static boolean checkSymmetry(int start, int end) {
		//start가 커지면 갈때까지 재귀를 탄거임. 탈출한다. 여기까지 오기까지 true가 한 번도 발견되지 않았다는 것이니 false를 뱉어준다.
		if(start >= end) {
			return false;
		}

		boolean flag = false;
		int mid = (start + end) / 2;
		int index = 0;
		for(int i = mid; i>0; --i ) {
			++index;
			if(mid+index <= end && mid-index>=0 &&str.charAt(mid+index) == str.charAt(mid-index)) {
				flag = true;
				break;
			}
		}
		//왼쪽, 오른쪽으로 재귀를 한번씩 조져준다. 만약, 한번이라도 true가 뜨면 재귀를 안탄다.
		return flag || checkSymmetry(start, mid-1) || checkSymmetry(mid+1, end);
	}
}
