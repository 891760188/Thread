package ye.guo.huang.build;

import java.util.Random;

public class Test01 implements Runnable{
	
	private Thread t ;
	private String threadName ;

	
	public Test01(String threadName) {
		this.threadName = threadName ;
		System.out.println("create thread ="+threadName);
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 4; i++) {
				Thread.sleep(productNum());
				System.out.println("i="+i+"		threadName="+threadName);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void begin() {
		if(null == t) {
			t = new Thread(this,this.threadName);
		}
		t.start();
	}
	
	public int productNum() {
		int max=1000;
		int min=100;
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1) + min;
//		System.out.println("s="+s);
		return s ;
	} 
	
	
	public static void main(String[] args) {
		Test01 t1 = new Test01("xc01");
		t1.begin();
		
		Test01 t2 = new Test01("xc02");
		t2.begin();
	}
	
}
