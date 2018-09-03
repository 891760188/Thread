package ye.guo.huang.build;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test04 {
	public static void main(String[] args) {
		//创建线程人物对象
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				 for (int i = 0; i < 10; i++) {
			            System.out.println("自定义线程任务在执行"+i);
			     }
			}
		};
		//创建线程池    5个线程的线程池
		ExecutorService service = Executors.newFixedThreadPool(5);
		//从线程池中获取线程
		Future f1 = service.submit(task);
		Future f2 = service.submit(task);
		service.shutdown();
	}
}