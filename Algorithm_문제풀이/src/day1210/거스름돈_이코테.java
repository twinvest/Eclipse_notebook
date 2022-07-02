package day1210;

public class 거스름돈_이코테 {
	public static void main(String[] args) {
		int n = 1260;
		int mok  = 0;
		int remain  = 0;
		int count = 0;
		int[] arr = {500, 100, 50, 10};

		for ( int i = 0; i<arr.length; ++i) {
			remain = n % arr[i];
			mok = n / arr[i];
			n = remain;
			count = count + mok;
		}
		System.out.println(count);

	}
}
