package ye.guo.huang.build;

import java.util.Random;

public class Test02 extends Thread{
	@Override
	public void run() {

		try {
			for (int i = 0; i < 4; i++) {
				if(this.isAlive()) {
					Thread.sleep(productNum());
//					Thread.dumpStack();
					System.out.println("i="+i+"		threadName="+this.getName());
					if("t1".equals(this.getName())) {
//						this.interrupt();//ÖĞ¶ÏÏß³Ì
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		Test02 t1 = new Test02();
		t1.setName("t1");
		t1.start();
		
		Test02 t2 = new Test02();
		t2.setName("t2");
		t2.start();
	}
}
