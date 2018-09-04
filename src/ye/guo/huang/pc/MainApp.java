package ye.guo.huang.pc;

/**
 * Java�еĶ��̻߳��漰���̼߳�ͨ�ţ��������߳�ͨ�ŷ�ʽ�����繲��������ܵ����ȣ�
 * ��������Ҫʵ��������������ģʽ��Ҳ��Ҫ�漰���߳�ͨ�ţ��������������õ���java�е� wait()��notify()������
 * wait()�������ٽ������߳������е�һ���ֺ󣬷��ֽ��к���������������Դ��û��׼����֣�
 * ���Ե���wait()���������߳��������ȴ���Դ��ͬʱ�ͷ��ٽ�����������ʱ�̵߳�״̬Ҳ��RUNNABLE״̬��ΪWAITING״̬��
 * notify()��׼����Դ���߳���׼������Դ�󣬵���notify()����֪ͨ��Ҫʹ����Դ���̣߳� ͬʱ�ͷ��ٽ������������ٽ�����������ʹ����Դ���̡߳�
 * wait()��notify()������������������Ҫ���ٽ����е��ã�������synchronizedͬ�����е��ã�
 * ��Ȼ���׳�IllegalMonitorStateException���쳣��
 * 
 */

public class MainApp {
	public static void main(String[] args) {
		//һ���ֿ�
		Storage storage = new Storage();

		Producer producer1 = new Producer(storage, "Producer-1");
		Producer producer2 = new Producer(storage, "Producer-2");
		Producer producer3 = new Producer(storage, "Producer-3");
		Producer producer4 = new Producer(storage, "Producer-4");

		Consumer consumer1 = new Consumer(storage, "Consumer-1");
		Consumer consumer2 = new Consumer(storage, "Consumer-2");

		producer1.start();
		producer2.start();
//		producer3.start();
//		producer4.start();

//		consumer1.start();
		consumer2.start();
	}
}
