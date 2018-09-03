package ye.guo.huang.api;

public class ThreadClassDemo {
	public static void main(String[] args) throws Exception {
		Runnable hello = new DisplayMessage("hello");
		Thread thread1 = new Thread(hello);
		//����Ϊ�ػ��߳�
		thread1.setDaemon(true);
		//�߳�����
		thread1.setName("hello");
		System.out.println("���濪ʼhello�߳�");
		thread1.start();
		
		Runnable bye = new DisplayMessage("goodbye");
		Thread thread2 = new Thread(bye);
		//�߳����ȼ�������
		thread2.setPriority(Thread.MIN_PRIORITY);
		//�ػ��߳�
		thread2.setDaemon(true);
		System.out.println("���濪ʼgoodbye�߳�");
		thread2.start();
		
		System.out.println("���濪ʼ�߳�3");
		Thread thread3 = new GuessANumber(27);
		thread3.start();
		//�ȴ����߳���ֹ��ʱ���Ϊ millis ���롣���̵߳ȴ�thread3��ִ��
		thread3.join();
		
		System.out.println("���濪ʼ�߳�4");
		Thread thread4 = new GuessANumber(75);
		thread4.start();
		System.out.println("main() is ending...");
	}
}
