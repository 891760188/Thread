package ye.guo.huang.running;

public class Rabbit extends Animal {

	public Rabbit() {
		setName("����");// Thread�ķ��������̸߳�ֵ����
	}

	// ��дrunning��������д���ӵı��ܲ���
	@Override
	public void runing() {
		// �ܵľ���
		double dis = 0.5;
		length -= dis;// �����������
		if (length <= 0) {
			length = 0;
			System.out.println("���ӻ����ʤ��");
			// ���ص�����ֵ�����ڹ겻Ҫ������
			if (calltoback != null) {
				calltoback.win();
			}
		}
		System.out.println("��������" + dis + "�ף������յ㻹��" + (int) length + "��");

		if (length % 2 == 0) {// ������Ϣһ��
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}