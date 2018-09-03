package ye.guo.huang.api;

public class ThreadClassDemo {
	public static void main(String[] args) throws Exception {
		Runnable hello = new DisplayMessage("hello");
		Thread thread1 = new Thread(hello);
		//设置为守护线程
		thread1.setDaemon(true);
		//线程名次
		thread1.setName("hello");
		System.out.println("下面开始hello线程");
		thread1.start();
		
		Runnable bye = new DisplayMessage("goodbye");
		Thread thread2 = new Thread(bye);
		//线程优先级的设置
		thread2.setPriority(Thread.MIN_PRIORITY);
		//守护线程
		thread2.setDaemon(true);
		System.out.println("下面开始goodbye线程");
		thread2.start();
		
		System.out.println("下面开始线程3");
		Thread thread3 = new GuessANumber(27);
		thread3.start();
		//等待该线程终止的时间最长为 millis 毫秒。本线程等待thread3先执行
		thread3.join();
		
		System.out.println("下面开始线程4");
		Thread thread4 = new GuessANumber(75);
		thread4.start();
		System.out.println("main() is ending...");
	}
}
