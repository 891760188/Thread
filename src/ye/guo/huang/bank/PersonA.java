package ye.guo.huang.bank;

public class PersonA extends Thread {
	// �������ж���
	Bank bank;

	// ͨ���������������ж���ȷ�������˽������һ������
	public PersonA(Bank bank) {
		this.bank = bank;
	}

	// ��дrun������������ʵ��ʹ�ù�̨ȡǮ
	@Override
	public void run() {
		while (Bank.money >= 1) {
			bank.Counter(1);// ÿ��ȡ100��
			try {
				sleep(100);// ȡ����Ϣ0.1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("һ��ȡǮ="+Bank.get);
	}
}