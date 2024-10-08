package 브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 등차수열변환_구글링 {
    static int N, answer = Integer.MAX_VALUE;
    static int[] A;		//A 수열 정보 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = new int[N];
        //A수열에 대한 정보 저장
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());
        if(N==1)		//N==1일 때는 항상 등차수열 성립!
            bw.write("0");
        else{		//N>1일 때 처음 시작하는 9가지 경우로 모든 경우 탐색
            search(2, A[1] - A[0], 0, A[1]);
            search(2, A[1] - (A[0]-1), 1, A[1]);
            search(2, A[1] - (A[0]+1), 1, A[1]);

            search(2, (A[1]-1) - A[0], 1, A[1]-1);
            search(2, (A[1]-1) - (A[0]-1), 2, A[1]-1);
            search(2, (A[1]-1) - (A[0]+1), 2, A[1]-1);

            search(2, (A[1]+1) - A[0], 1, A[1]+1);
            search(2, (A[1]+1) - (A[0]-1), 2, A[1]+1);
            search(2, (A[1]+1) - (A[0]+1), 2, A[1]+1);

            if(answer == Integer.MAX_VALUE)		//등차 수열 성립하는 것이 없을 때
                bw.write("-1");
            else		//등차 수열 성립시 최소 연산 횟수 BufferedWriter 저장
                bw.write(answer + "");
        }

        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //첫 시작하는 경우를 기준으로 등차 수열이 되는지 모든 경우를 탐색
    static void search(int depth, int dif, int count, int previousNum){
        if(depth == N){		//등차 수열 완성시
            answer = Math.min(answer, count);
            return;
        }
        //등차수열 되는지 탐색
        if(dif == A[depth] - previousNum)	//+0
            search(depth+1, dif, count, A[depth]);
        if(dif == (A[depth]-1) - previousNum)	//-1
            search(depth+1, dif, count+1, A[depth]-1);
        if(dif == (A[depth]+1) - previousNum)	//+1
            search(depth+1, dif, count+1, A[depth]+1);
    }
}