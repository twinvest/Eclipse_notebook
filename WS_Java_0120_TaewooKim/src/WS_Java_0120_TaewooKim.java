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
		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 골라주세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요");
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
			System.out.print("가위바위보중 하나 입력 : ");
			String mychoicestring = scan.next();
			if(mychoicestring.equals("가위"))
				mychoice = 1;
			else if(mychoicestring.equals("바위"))
				mychoice = 2;
			else if(mychoicestring.equals("보"))
				mychoice = 3;
			if(mychoice < computerChoice)
			{
				System.out.println("나 : " +mychoice+ " 컴퓨터 : "+computerChoice);
				if(computerChoice == 3 && mychoice == 1)
				{
					System.out.println("내가이김");
					break;
				}
				System.out.println("컴퓨터가 이김");
				
			}
			else if(mychoice == computerChoice)
			{
				System.out.println("나 : " +mychoice+ " 컴퓨터 : "+computerChoice);
				System.out.println("비김");
			}
			else
			{
				System.out.println("나 : " +mychoice+ " 컴퓨터 : "+computerChoice);
				if(mychoice == 3 && computerChoice == 1)
				{
					System.out.println("컴퓨터가이김");
					break;
				}
				System.out.println("내가 이김");
				
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