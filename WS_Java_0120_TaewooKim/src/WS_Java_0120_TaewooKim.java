import java.util.Scanner;
public class WS_Java_0120_TaewooKim {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WS_Java_0120_TaewooKim tw = new WS_Java_0120_TaewooKim();
		tw.rihgt_method();
		tw.reverse_method();	
		tw.mymain();
	}
	public void mymain()
	{
		System.out.println(">>���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ����ּ���.");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		System.out.print("��ȣ�� �Է��ϼ���");
		int mynum = scan.nextInt();
		if(mynum == 1)
			gawibawibo(5);
		else if(mynum == 2)
			gawibawibo(3);
		else if(mynum == 3)
			gawibawibo(1);
	}
	
	public void gawibawibo(int play)
	{
		while(true)
		{
			if(play==0) break;
			int computerChoice = (int) (Math.random() * 3) +1;
			int mychoice = 0;
			play--;
			System.out.print("������������ �ϳ� �Է� : ");
			String mychoicestring = scan.next();
			if(mychoicestring.equals("����"))
				mychoice = 1;
			else if(mychoicestring.equals("����"))
				mychoice = 2;
			else if(mychoicestring.equals("��"))
				mychoice = 3;
			if(mychoice < computerChoice)
			{
				System.out.println("�� : " +mychoice+ " ��ǻ�� : "+computerChoice);
				if(computerChoice == 3 && mychoice == 1)
				{
					System.out.println("�����̱�");
					break;
				}
				System.out.println("��ǻ�Ͱ� �̱�");
				
			}
			else if(mychoice == computerChoice)
			{
				System.out.println("�� : " +mychoice+ " ��ǻ�� : "+computerChoice);
				System.out.println("���");
			}
			else
			{
				System.out.println("�� : " +mychoice+ " ��ǻ�� : "+computerChoice);
				if(mychoice == 3 && computerChoice == 1)
				{
					System.out.println("��ǻ�Ͱ��̱�");
					break;
				}
				System.out.println("���� �̱�");
				
			}
		}
	}
	
	public void reverse_method()
	{
		char alpha = 65;
		for(int i = 0; i<5; ++i)
		{
			for(int j = 0; j<5; ++j)
			{
				if(i+j>=4) System.out.print(alpha++);	
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void rihgt_method()
	{
		char alpha = 65;
		for(int i = 0; i<5; ++i)
		{
			for(int j = 0; j<=i; ++j)
			{
				System.out.print(alpha++);
			}
			System.out.println();
		}
		System.out.println();
		
	}
}