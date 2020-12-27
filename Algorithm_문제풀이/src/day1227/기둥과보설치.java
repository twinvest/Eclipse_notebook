package day1227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 기둥과보설치 {
	class Pos implements Comparable<Pos> {
		int x;
		int y;
		int flag; //flag가 0이면 기둥 1이면 보
		Pos ( int x, int y, int flag ) {
			this.x = x;
			this.y =y;
			this.flag = flag;
		}


		@Override
		public int compareTo(Pos o) {
			if(this.x == o.x && this.y == o.y) {
				return Integer.compare(this.flag, o.flag);
			}

			if(this.x == o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}

		@Override
		public boolean equals(Object o){
			boolean isT = false;
			Pos comp = (Pos)o;
			if(this.y == comp.y && this.x == comp.x && this.flag == comp.flag){
				isT = true;
			}
			return isT;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		기둥과보설치 main = new 기둥과보설치();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] build_frame = {
				{0,0,0,1},
				{2,0,0,1},
				{4,0,0,1},
				{0,1,1,1},
				{1,1,1,1},
				{2,1,1,1},
				{3,1,1,1},
				{2,0,0,0},
				{1,1,1,0},
				{2,2,0,1}
		};

		int[][] ans = main.solution(n, build_frame);
		for(int i = 0; i<ans.length; ++i) {
			System.out.println(Arrays.toString(ans[i]));
		}

		/*
		System.out.println();
		int[][] tw = {
				{1,0,0,1},
				{1,1,1,1},
				{2,1,0,1},
				{2,2,1,1},
				{5,0,0,1},
				{5,1,0,1},
				{4,2,1,1},
				{3,2,1,1}
		};
		build_frame = tw;
		int[][] ans = main.solution(n, build_frame);
		for(int i = 0; i<ans.length; ++i) {
			System.out.println(Arrays.toString(ans[i]));
		}
		*/
	}
	boolean existPillar(ArrayList<Pos> list, int x, int y){
		if(!list.contains(new Pos(x,y,0))){
			return false;
		}
		return true;
	}

	boolean existBeam(ArrayList<Pos> list, int x, int y){
		if(!list.contains(new Pos(x,y,1))){
			return false;
		}
		return true;
	}


	//기둥을 설치할 수 있는지 check
	public boolean check1(ArrayList<Pos> list, int x, int y, int n) {
		if((y >= 0 && y < n) && (x >= 0 && x <= n)) {
			//바닥에 설치하는 경우
			if(y == 0) {
				return true;
			}
			//지어놓은 구조물위에 쌓을 수 있는지 확인
			for(Pos pos : list) {
				//설치해놓은 구조물 중 기둥이 있는데
				if(pos.flag == 0) {
					//기둥은 기둥위에 설치가능
					if(pos.x == x && pos.y == y-1)
						return true;
				}
				//설치해놓은 구조물 중 보가 있는데
				if(pos.flag == 1) {
					//기둥은 보의 끝의 있는 경우 설치가능
					if((pos.y == y) && (pos.x == x-1)) {
						return true;
					}
					if((pos.y == y) && (pos.x == x)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	//보를 설치할 수 있는지 check
	public boolean check2(ArrayList<Pos> list, int x, int y, int n) {
		if((y > 0 && y <= n) && (x >= 0 && x < n)) {
			for(Pos pos : list) {
				//설치해놓은 구조물 중 기둥이 있는데
				if(pos.flag == 0) {
					//한쪽 끝부분이 기둥위에 있는경우
					if((pos.y == y-1) && (pos.x == x+1)) {
						return true;
					}
					if((pos.y == y-1) && pos.x == x) {
						return true;
					}
				}
				//설치해놓은 구조물 중 보가 있는데
				if(pos.flag == 1) {
					//양쪽 끝부분이 다른 보와 동시에 연결되어있는지
					if(list.contains(new Pos(x-1,y,1)) && list.contains(new Pos(x+1,y,1))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	//기둥삭제체크. 삭제가능하면 true반환.
	public boolean check3(ArrayList<Pos> list, int x, int y, int n) {
		if((existPillar(list, x, y+1) && !check1(list, x, y+1, n))
			|| (existBeam(list, x, y+1) && !check2(list, x, y+1, n))
			|| (existBeam(list, x-1, y+1) && !check2(list, x-1, y+1, n)) ) {
			return false;
		}
		return true;
	}

	public boolean check4(ArrayList<Pos> list, int x, int y, int n) {
		if(existPillar(list, x, y) && !check1(list, x, y, n)
				|| existPillar(list, x+1, y) && !check1(list, x+1, y, n)
				|| existBeam(list, x+1, y) && !check2(list, x+1, y, n)
				|| existBeam(list, x-1, y) && !check2(list, x-1, y, n)) {
				return false;
			}
			return true;
	}

	public int[][] solution(int n, int[][] build_frame) {
		ArrayList<Pos> structure = new ArrayList<>();

		for(int i = 0; i<build_frame.length; ++i) {
			//설치하는 경우
			if(build_frame[i][3] == 1) {
				//기둥을 설치하는 경우. check1이 true를 반환하면 기둥을 설치할수있다는거임.
				if(build_frame[i][2] == 0 && check1(structure, build_frame[i][0], build_frame[i][1], n)) {
					structure.add(new Pos(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
				}
				//보를 설치하는 경우. check2가 true를 반환하면 보를 설치할수있다는거임.
				if(build_frame[i][2] == 1 && check2(structure, build_frame[i][0], build_frame[i][1], n)) {
					structure.add(new Pos(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
				}
			}
			//삭제하는 경우
			if(build_frame[i][3] == 0) {

				//기둥을 삭제하는 경우. check3이 true를 반환하면 기둥을 삭제할수있다는거임.
				if(build_frame[i][2] == 0) {
					//일단 하나를 삭제한다.
					structure.remove(new Pos(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
					//check3을 통해 삭제가 가능한지 알아본다. 만약 삭제가가능하면 true를 삭제가 불가능하면 false를 뱉는다.
					if(!check3(structure,build_frame[i][1], build_frame[i][2], n)) {
						structure.add(new Pos(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
					}
				}
				//보를 삭제하는 경우. check4가 true를 반환하면 보를 삭제할수있다는거임.
				if(build_frame[i][2] == 1) {
					//일단 하나를 삭제한다.
					structure.remove(new Pos(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
					//check3을 통해 삭제가 가능한지 알아본다. 만약 삭제가가능하면 true를 삭제가 불가능하면 false를 뱉는다.
					if(!check4(structure,build_frame[i][1], build_frame[i][2], n)) {
						structure.add(new Pos(build_frame[i][0], build_frame[i][1], build_frame[i][2]));
					}
				}
			}
		}
		Collections.sort(structure);
		int[][] ans = new int[structure.size()][3];
		for(int i = 0; i<ans.length; ++i) {
			Pos pos = structure.get(i);
			ans[i][0] = pos.x;
			ans[i][1] = pos.y;
			ans[i][2] = pos.flag;
		}
		return ans;
	}
}