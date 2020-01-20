//Exception Ŭ������ ����Ͽ� ����� ���� ���� Ŭ������ ������.
class BadBankingException extends Exception {
	public BadBankingException(String s) {
		super(s);
	}
}

class Account {
	String name;
	int currentMoney;
	
	public Account(String name, int currentMoney) {
		this.name = name;
		this.currentMoney = currentMoney;
	}
	
	//withdraw()�޼ҵ�� BadBankingException ���ܰ� �߻��� �� �����Ƿ� ���� ó���� throws ������ �ѱ��.
	public void withdraw(int money) throws BadBankingException {
		//���� ������ �ݾ׺��� ���� �ݾ��� ������ ��� ���������� BadBankingException ���ܸ� �߻���Ų �� ���� ������ ������� �ʵ��� �Ѵ�.
		if(currentMoney < money) {
			throw new BadBankingException("�ܾ��� �����մϴ�.");
		}
		currentMoney = currentMoney - money;
	}
	
	public String toString() {
		return "Account [ name =" + name + ", currentMoney=" +currentMoney+ "]";
	}
}

public class ExceptionPractice {

	public static void main(String[] args) {
		// withdraw()�޼ҵ� ȣ�� �� �߻��� BadBankingException���ܸ� ó����
		try {
			Account kimAccount = new Account("������", 100);
			kimAccount.withdraw(150);
			System.out.println(kimAccount.toString());
		}catch (BadBankingException e) {
			System.out.println(e.getMessage());
		}
	}

}
