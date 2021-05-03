package day0503;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N과M3 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] sel, arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		//arr = new int[N];
		sel = new int[M];
		/*for(int i = 1; i<=N; ++i) {
			arr[i-1] = i;
		}*/
		rePerm(0);
		bw.flush();
	}

	static void rePerm(int idx) throws IOException {
		if( idx == sel.length ) {
			for(int i =0; i<sel.length; ++i) {
				bw.write(Integer.toString(sel[i]) + " ");
			}
			bw.newLine();
			return;
		}

		for(int i = 0; i < N; i++)
		{
			sel[idx] = i+1;
			rePerm(idx + 1);
			sel[idx] = 0;
		}
	}
}
