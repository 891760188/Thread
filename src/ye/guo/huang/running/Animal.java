package ye.guo.huang.running;

/**
 * �������ܣ�20��     //ֻҪΪ�˿���Ч�������о���������
 Ҫ��
1.����ÿ��0.5�׵��ٶȣ�ÿ��2����Ϣ10�룬
2.�ڹ�ÿ����0.1�ף�����Ϣ 
3.����һ���ܵ��յ����һ�������ˣ�
       �������˼·��
1.����һ��Animal�����࣬�̳�Thread����дһ��running���󷽷�����дrun��������running������run����������á�
2.����Rabbit�������Tortoise�ڹ��࣬�̳ж�����
3.����������дrunning����
4.����ĵ�3��Ҫ���漰���̻߳ص�����Ҫ�ڶ����ഴ��һ���ص��ӿڣ�����һ���ص�����
 * @author Administrator
 *
 */
public abstract class Animal extends Thread {

	public double length = 20;// �����ĳ���

	public abstract void runing();// ���󷽷���Ҫ����ʵ��

	// �ڸ�����дrun������������ֻҪ��дrunning�����Ϳ�����
	@Override
	public void run() {
		super.run();
		while (length > 0) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			runing();
		}
	}

	// ����Ҫ�ص����ݵĵط�������������Ҫ��������һ���ӿ�
	public static interface Calltoback {
		public void win();
	}

	// 2.�����ӿڶ���
	public Calltoback calltoback;

}