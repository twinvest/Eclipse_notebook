package day0509;
/*
 * https://loosie.tistory.com/540 소스참고
 *
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long m = Long.parseLong(st.nextToken());
		long n = Long.parseLong(st.nextToken());

		StringBuilder sb = new StringBuilder();
		if(m>n) {
			sb.append(((n-1)*2+1)+"\n");
		}else {
			sb.append(((m-1)*2)+"\n");
		}

		if(m==n) {
			if(m%2==1) {
				sb.append((m/2+1)+" "+(n/2+1) +"\n");
			}else {
				sb.append((m/2+1)+" "+(n/2) +"\n");
			}
	 	}else if(m>n) {
	 		if(n%2==0) {
	 			sb.append((n/2+1) +" "+(n/2)+"\n");
	 		}else {
	 			sb.append((n/2+1+(m-n)) +" "+(n/2+1)+"\n");
	 		}
	 	}else {
	 		if(m%2==0) {
	 			sb.append((m/2+1) +" "+(m/2)+"\n");
	 		}else {
	 			sb.append((m/2+1)+" "+(m/2+1+(n-m))+"\n");
	 		}
	 	}
		System.out.println(sb.toString());
	}
}