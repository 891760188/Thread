package ye.guo.huang.tongxin.wntest01;

public class Test {
	public static void main(String[] args) {
		try {
			
			//设置同一个对象锁
			Object lock = new Object();

			MyThread1 t1 = new MyThread1(lock);
			t1.start();

			Thread.sleep(3000);

			MyThread2 t2 = new MyThread2(lock);
			t2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}