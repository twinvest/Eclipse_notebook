package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Scanner;

class Position
{
	int y;
	int x;
	Position(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}

public class Solution13 {
	static int[][] dir = {
			{0,1},  //오른쪽
			{0,-1}, //왼쪽
			{1,0},  //아래
			{-1,0}, //위
			{-1,-1},//11시
			{-1,1}, //1시
			{1,-1}, //7시
			{1,1}  //5시
			};

	static boolean inside(int y, int x, int N)
	{
		return (y>=0 && y<N) && (x>=0 && x<N); 
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase;
		testcase = scan.nextInt();
		for(int t=1; t<=testcase; ++t)
		{
			ArrayList<Position> list = new ArrayList<Position>();
			int N = scan.nextInt();
			String[][] arr = new String[N][N];
			//입력
			for(int i = 0; i<N; ++i)
				for(int j=0; j<N; ++j)
					arr[i][j] = scan.next();
			
			for(int i=0; i<N; ++i)
			{
				for(int j=0; j<N; ++j)
				{
					if(arr[i][j].equals("G"))
						continue;
					
					boolean flag = false;
					for(int k = 0; k<8; ++k)
					{	
						if(k==7)
						{
							flag = true;
							break;
						}
						int nexty = i + dir[k][0];
						int nextx = j + dir[k][1];
						if(!inside(nexty, nextx, N))
							continue;
						if(arr[nexty][nextx].equals("G"))
							break;
					}
					if(flag)
						list.add(new Position(i, j));
				}
			}
			
			int max = 0;
			for(int i=0; i<list.size(); ++i)
			{
				int count = 0;
				for(int k =0; k<N; ++k)
				{
					if(arr[list.get(i).y][k].equals("B"))
						++count;
				}
				for(int k=0; k<N; ++k)
				{
					if(arr[k][list.get(i).x].equals("B"))
						++count;
				}
				if(count > max)
					max = count;
			}
			System.out.println(max-1);
		}
	}
}