package ye.guo.huang.running;

public class Tortoise extends Animal {

	public Tortoise() {
		setName("�ڹ�");// Thread�ķ��������̸߳�ֵ����
	}

	// ��дrunning��������д�ڹ�ı��ܲ���
	@Override
	public void runing() {
		// �ܵľ���
		double dis = 0.1;
		length -= dis;
		if (length <= 0) {
			length = 0;
			System.out.println("�ڹ�����ʤ��");
			// �����Ӳ�Ҫ������
			if (calltoback != null) {
				calltoback.win();
			}
		}
		System.out.println("�ڹ�����" + dis + "�ף������յ㻹��" + (int) length + "��");
		
	}
}