package ye.guo.huang.bank;

public class MainTest {
	public static void main(String[] args) {
		Bank bank = new Bank();
		PersonA pA = new PersonA(bank);
		PersonB pB = new PersonB(bank);
		// 两个人开始取钱
		pA.start();
		pB.start();
		  
	}
}
