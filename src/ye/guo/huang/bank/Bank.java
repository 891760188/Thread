package ye.guo.huang.bank;

public class Bank {

	// ����һ���˻���1000��Ǯ
	static int money = 1000;
	static int get = 0;

	// ��̨CounterȡǮ�ķ���
	public synchronized void Counter(int money) {// ������ÿ��ȡ�ߵ�Ǯ
		Bank.money -= money;// ȡǮ����������
		get+=money;
		System.out.println("Aȡ����" + money + "��ʣ��" + (Bank.money));
	}

	// ATMȡǮ�ķ���
	public synchronized void ATM(int money) {// ������ÿ��ȡ�ߵ�Ǯ
		Bank.money -= money;// ȡǮ����������
		get+=money;
		System.out.println("Bȡ����" + money + "��ʣ��" + (Bank.money));
	}

}