package day0207;

import java.util.PriorityQueue;
import java.util.Scanner;

class Process implements Comparable<Process>
{
	int id;
	int time;
	Process(int id, int time)
	{
		this.id = id;
		this.time = time;
	}
	@Override
	public int compareTo(Process target) {
		return this.time <= target.time ? -1:1;
	}
}

public class ATM {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Size = scan.nextInt();
		PriorityQueue<Process> pq = new PriorityQueue<>();
		int[] arr = new int[Size];
		for(int i=0; i<Size; ++i)
		{
			int time = scan.nextInt();
			pq.offer(new Process(i, time));
		}
		for(int i=0; i<Size; ++i)
			arr[i] = pq.poll().time;
		int sum = 0;
		for(int i =1; i<=Size; ++i)
			for(int j=0; j<i; ++j)
				sum += arr[j];
		System.out.println(sum);
	}
}