package ye.guo.huang.build;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test03{
	
	public static void main(String[] args) throws Exception {
		Callable<Integer> callable = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				int i = 0 ;
				for (i = 0; i < 500000; i++) {
					System.out.println(Thread.currentThread().getName()+"==="+i);
				}
				return i;
			}
		};
		
		FutureTask<Integer> task = new FutureTask<Integer>(callable);
		for (int i = 0; i < 15; i++) {
			System.out.println("====="+Thread.currentThread().getName()+" ��ѭ������i��ֵ"+i);
			if(i == 3) {
				Thread t = new Thread(task,"�з���ֵ���߳�");
				t.start();
				 System.out.println("���̵߳ķ���ֵ��"+task.get());  

			}
		}
		
	}
	

}

























