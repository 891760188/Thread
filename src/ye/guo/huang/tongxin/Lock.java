package ye.guo.huang.tongxin;

public class Lock {
	public static void main(String[] args) throws Exception {
//		String lock = "lock";
//		synchronized (lock) {
//			System.out.println("wait上面一行");
//			lock.wait();
//			System.out.println("wait后面一行");
//		}
//		System.out.println("出lock");
		
		Lock lock = new Lock();
		lock.lock01();
		lock.lock02();
		
	}
	
	public synchronized void lock01() throws InterruptedException {
		System.out.println("wait上面一行1");
		this.wait();
		System.out.println("wait后面一行1");
	}
	public void lock02() throws InterruptedException {
		synchronized (this) {
			System.out.println("wait上面一行2");
			this.wait();
			System.out.println("wait后面一行2");
		}
		
	}
	
}
