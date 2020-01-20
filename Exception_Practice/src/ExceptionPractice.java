//Exception 클래스를 상속하여 사용자 정의 예외 클래스를 정의함.
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
	
	//withdraw()메소드는 BadBankingException 예외가 발생할 수 있으므로 예외 처리를 throws 예약어로 넘긴다.
	public void withdraw(int money) throws BadBankingException {
		//현재 보유한 금액보다 많은 금액을 인출할 경우 강제적으로 BadBankingException 예외를 발생시킨 후 인출 로직이 수행되지 않도록 한다.
		if(currentMoney < money) {
			throw new BadBankingException("잔액이 부족합니다.");
		}
		currentMoney = currentMoney - money;
	}
	
	public String toString() {
		return "Account [ name =" + name + ", currentMoney=" +currentMoney+ "]";
	}
}

public class ExceptionPractice {

	public static void main(String[] args) {
		// withdraw()메소드 호출 시 발생된 BadBankingException예외를 처리함
		try {
			Account kimAccount = new Account("김재준", 100);
			kimAccount.withdraw(150);
			System.out.println(kimAccount.toString());
		}catch (BadBankingException e) {
			System.out.println(e.getMessage());
		}
	}

}
