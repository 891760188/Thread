package ye.guo.huang.bank;

public class MainTest {
	public static void main(String[] args) {
		Bank bank = new Bank();
		PersonA pA = new PersonA(bank);
		PersonB pB = new PersonB(bank);
		// �����˿�ʼȡǮ
		pA.start();
		pB.start();
		  
	}
}
