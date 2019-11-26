import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.mymain();
	}
	
	public void mymain() {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		int[][] arr = new int[testcase][2];
		for(int i =0; i<testcase; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j]=scan.nextInt();	
			}
			int sum = arr[i][0] + arr[i][1];
			System.out.println(sum);
		}
	}
	
}