package day0711;
import java.util.ArrayList;

public class 행렬테두리회전하기 {

	public static void main(String[] args) {
		int[][] query = {
				{2, 2, 5, 4},
				{3, 3, 6, 6},
				{5, 1, 6, 3},

		};
		solution(6,6,query);
	}


	  static  public int[] solution(int rows, int columns, int[][] queries) {
	        int[][] map = new int[rows][columns];
	        int index = 0;
	        for(int i =0; i<rows; ++i){
	            for(int j =0; j<columns; ++j){
	                map[i][j] = ++index;
	            }
	        }

	        for(int k =0; k<queries.length; ++k){
	            int y1 = queries[k][0]-1;
	            int x1 = queries[k][1]-1;
	            int y2 = queries[k][2]-1;
	            int x2 = queries[k][3]-1;
	            ArrayList<Integer> list = new ArrayList<>();
	            for(int r = y1, c = x1+1; c<=x2; ++c){
	                list.add(map[r][c]);
	            }

	            for(int num : list){
	                System.out.println(num);
	            }

	            break;
	        }



	        int[] answer = {};
	        return answer;
	    }
	}
