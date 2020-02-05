package day0205;

import java.util.LinkedList;
import java.util.Queue;

class Person{
	int id;
	int numOfMychew;
	Person(int id, int numOfMychew)
	{
		this.id = id;
		this.numOfMychew = numOfMychew;
	}
}
public class ∏∂¿Ã¬È {

	public static void main(String[] args) {
		Queue<Person> q = new LinkedList<>();
		int sum = 20;
		int id = 0;
		while(true)
		{
			q.add(new Person(++id, 1));
			Person p = q.poll();
			sum = sum - p.numOfMychew;
			if(sum<=0) {
				System.out.println(p.id);
				break;
			}
			p.numOfMychew++;
			q.add(p);
		}
	}
}
