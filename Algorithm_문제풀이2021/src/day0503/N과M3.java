package day0503;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 * 중복순열은 방문체크를 하지 않는다.
 * */
public class N과M3 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] sel, arr;
	static int N, M;
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		sel = new int[M];

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
