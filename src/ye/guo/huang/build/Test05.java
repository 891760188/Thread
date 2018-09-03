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
		            System.out.println("自定义线程任务在执行"+i);
		        }
		        return "xc";
			}
		};
		//创建有三个线程的线程池
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(callable);
		 //再获取一个
		Future f =service.submit(callable);
		f.get();//返回的结果
        //关闭线程池
        service.shutdown();
	}
}
