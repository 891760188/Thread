package ye.guo.huang.build;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test04 {
	public static void main(String[] args) {
		//�����߳��������
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				 for (int i = 0; i < 10; i++) {
			            System.out.println("�Զ����߳�������ִ��"+i);
			     }
			}
		};
		//�����̳߳�    5���̵߳��̳߳�
		ExecutorService service = Executors.newFixedThreadPool(5);
		//���̳߳��л�ȡ�߳�
		Future f1 = service.submit(task);
		Future f2 = service.submit(task);
		service.shutdown();
	}
}