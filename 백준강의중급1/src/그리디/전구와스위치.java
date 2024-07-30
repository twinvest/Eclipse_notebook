package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전구와스위치 {
	static int N;
	static boolean[] now, want, nowA, nowB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		now = new boolean[N];
		want = new boolean[N];
		switchState(br.readLine(), now);
		switchState(br.readLine(), want);

		nowA = new boolean[N]; //1번 스위치 켠 상태
		nowB = new boolean[N]; //1번 스위치 끈 상태

		int switchA = 1, switchB = 0; //처음 1번 스위치에 대해 A는 킨 상황이므로 1로 시작

		//1번 스위치 켜고 끈 상태를 각각 nowA, nowB 배열에 저장
		for(int i =0; i<N; ++i) {
			if( i<=1 ) {
				nowA[i] = !now[i];
				nowB[i] = now[i];
			}else {
				nowA[i] = now[i];
				nowB[i] = now[i];
			}

		}

		for(int i=1; i<N; ++i) {
			//이전 전구가 만들고자하는 상태와 같지 않다면 스위치를 켜준다
			if(nowA[i-1] != want[i-1] ) {
				switchOn(i, nowA);
				switchA++;
			}
			if(nowB[i-1] != want[i-1] ) {
				switchOn(i, nowB);
				switchB++;
			}

			//스위치를 켜고 나서 A, B 배열이 만들고자하는 상태와 같은지 비교하여 출력
			if(Arrays.equals(nowA, want)){
				//A, B가 둘 다 만들고자하는 상태와 같을 땐, 더 작은 횟수 출력
				if(Arrays.equals(nowA, now)) {
					System.out.println(Math.min(switchA, switchB));
					System.exit(0);
				}

				System.out.println(switchA);
				System.exit(0);
			}else if(Arrays.equals(nowB, want)) {
				System.out.println(switchB);
				System.exit(0);
			}
		}
		//끝까지 모두 탐색하였으나 불가능한 경우에는 -1 출력
		System.out.println(-1);
	}

	//스위치 켜는 함수
	static void switchOn(int i, boolean[] switchName) {
		switchName[i-1] = !switchName[i-1];
		switchName[i] = !switchName[i];
		//마지막 스위치는 다음 전구가 없으므로 조건을 걸어줌
		if(i<N-1) {
			switchName[i+1] = !switchName[i+1];
		}
	}

	//스위치 상태를 입력받는 함수
	static void switchState(String state, boolean[] switchName) {
		for(int i=0; i<N; ++i) {
			char n = state.charAt(i);
			if(n=='1')
				switchName[i]=true;
			else if(n=='0')
				switchName[i]=false;
		}
	}

}
