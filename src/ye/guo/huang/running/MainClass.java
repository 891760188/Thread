package ye.guo.huang.running;

public class MainClass {
	/**
	 * �������ܣ�20��
	 * */
	public static void main(String[] args) {
		// ʵ�����ڹ������
		Tortoise tortoise = new Tortoise();
		Rabbit rabbit = new Rabbit();
		// �ص�������ʹ�ã�˭�ȵ���calltoback��������һ���Ͳ�����
		LetOneStop letOneStop1 = new LetOneStop(tortoise);
		rabbit.calltoback = letOneStop1;// �����ӵĻص�������������ڹ�����ֵ�����԰��ڹ�stop
		LetOneStop letOneStop2 = new LetOneStop(rabbit);
		tortoise.calltoback = letOneStop2;// ���ڹ�Ļص���������������Ӷ����ֵ�����԰�����stop
		// ��ʼ��
		tortoise.start();
		rabbit.start();

	}

}