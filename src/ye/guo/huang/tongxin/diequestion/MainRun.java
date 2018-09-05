package ye.guo.huang.tongxin.diequestion;

public class MainRun {
	public static void main(String[] args) throws Exception {
		String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);
        
        ThreadP[] pThread = new ThreadP[2];
        ThreadC[] rThread = new ThreadC[2];
        
        for (int i = 0; i < 2; i++) {
            pThread[i] = new ThreadP(p);
            pThread[i].setName("������" + (i + 1));

            rThread[i] = new ThreadC(r);
            rThread[i].setName("������" + (i + 1));

            pThread[i].start();
            rThread[i].start();
        }
        
        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);

        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " "+ threadArray[i].getState());
        }
        
        
	}
}
