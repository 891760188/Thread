package ye.guo.huang.running;

import ye.guo.huang.running.Animal.Calltoback;

public class LetOneStop implements Calltoback {

	// �������
	Animal an;

	// ��ȡ������󣬿��Դ������ӻ��ڹ��ʵ��
	public LetOneStop(Animal an) {
		this.an = an;
	}

	// �ö�����߳�ֹͣ
	@Override
	public void win() {
		// �߳�ֹͣ
		an.stop();
	}

}