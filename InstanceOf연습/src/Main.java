class Person
{
	boolean gender;
	int age;
	String name;
}

class Teacher extends Person
{
	String teachingskill;
}


public class Main {
	static public void main(String[] args)
	{
		Person p = new Teacher();
		if(p instanceof Teacher)
		{
			System.out.println("변환가능");
		}
		else
		{
			System.out.println("변환불가능");
		}
	}
}
