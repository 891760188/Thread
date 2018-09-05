package ye.guo.huang.tongxin;

public class Lock {
	public static void main(String[] args) throws Exception {
//		String lock = "lock";
//		synchronized (lock) {
//			System.out.println("wait����һ��");
//			lock.wait();
//			System.out.println("wait����һ��");
//		}
//		System.out.println("��lock");
		
		Lock lock = new Lock();
		lock.lock01();
		lock.lock02();
		
	}
	
	public synchronized void lock01() throws InterruptedException {
		System.out.println("wait����һ��1");
		this.wait();
		System.out.println("wait����һ��1");
	}
	public void lock02() throws InterruptedException {
		synchronized (this) {
			System.out.println("wait����һ��2");
			this.wait();
			System.out.println("wait����һ��2");
		}
		
	}
	
}
