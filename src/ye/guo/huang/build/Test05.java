package ye.guo.huang.build;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test05 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Object> callable = new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				for (int i = 0; i < 1000; i++) {
		            System.out.println("�Զ����߳�������ִ��"+i);
		        }
		        return "xc";
			}
		};
		//�����������̵߳��̳߳�
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(callable);
		 //�ٻ�ȡһ��
		Future f =service.submit(callable);
		f.get();//���صĽ��
        //�ر��̳߳�
        service.shutdown();
	}
}
