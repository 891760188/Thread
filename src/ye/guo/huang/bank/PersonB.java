package ye.guo.huang.bank;

public class PersonB extends Thread {
	// �������ж���
	Bank bank;

	// ͨ���������������ж���ȷ�������˽������һ������
	public PersonB(Bank bank) {
		this.bank = bank;
	}

	// ��дrun������������ʵ��ʹ�ù�̨ȡǮ
	@Override
	public void run() {
		while (Bank.money >= 2) {
			bank.ATM(2);// ÿ��ȡ200��
			try {
				sleep(100);// ȡ����Ϣ0.1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("һ��ȡǮ="+Bank.get);
	}
}