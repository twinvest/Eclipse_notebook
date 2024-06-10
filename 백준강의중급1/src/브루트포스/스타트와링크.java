package 브루트포스;

import java.util.ArrayList;
import java.util.Scanner;

public class 스타트와링크 {
	static int[] arr;
	static int[] sel;
	static int[] selTeam = new int[2];
	static int numOfPeople;
	static int[][] abilityArray;
	static boolean[] visit;
	static ArrayList<Integer> teamA;
	static ArrayList<Integer> teamB;
	static int ans=987654321, ans2=987654321, ans3=987654321;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		numOfPeople = scan.nextInt();
		abilityArray = new int[numOfPeople][numOfPeople];
		for(int i =0; i<numOfPeople;++i) {
			for(int j=0;j<numOfPeople; ++j) {
				abilityArray[i][j] = scan.nextInt();
			}
		}
		arr = new int[numOfPeople];
		sel = new int[numOfPeople/2];
		for(int i=0; i<numOfPeople; ++i) {
			arr[i] = i+1;
		}

		combination(0, 0);
		System.out.println(ans);
	}

	static void makeTeam() {
		//System.out.println("======================");
		visit = new boolean[numOfPeople+1];
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();

		for(int i =0; i<sel.length; ++i) {
			teamA.add(sel[i]);
			visit[sel[i]] = true;
		}

		for(int i =1; i<=numOfPeople; ++i) {
			if(!visit[i]) {
				teamB.add(i);
			}
		}

		ans2 = 0;
		ans3 = 0;
		combination2(0,0);
		combination3(0,0);
		ans = Math.min(ans, Math.abs(ans2-ans3));
	}

	static void combination(int idx, int s_idx) {
		if( s_idx == sel.length )
		{
			makeTeam();
			return;
		}
		if( idx == arr.length )
			return;

		sel[s_idx] = arr[idx];
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
	}

	static void combination2(int idx, int s_idx) {
		if( s_idx == selTeam.length )
		{
			ans2 += abilityArray[selTeam[0]-1][selTeam[1]-1] + abilityArray[selTeam[1]-1][selTeam[0]-1];
//			System.out.print(Arrays.toString(selTeam) +"======>"+ ans2);
//			System.out.println();

			return;
		}
		if( idx == teamA.size() )
			return;

		selTeam[s_idx] = teamA.get(idx);
		combination2(idx+1, s_idx+1);
		combination2(idx+1, s_idx);
	}

	static void combination3(int idx, int s_idx) {
		if( s_idx == selTeam.length )
		{
			ans3 += abilityArray[selTeam[0]-1][selTeam[1]-1] + abilityArray[selTeam[1]-1][selTeam[0]-1];
			return;
		}
		if( idx == teamB.size() )
			return;

		selTeam[s_idx] = teamB.get(idx);
		combination3(idx+1, s_idx+1);
		combination3(idx+1, s_idx);
	}


}