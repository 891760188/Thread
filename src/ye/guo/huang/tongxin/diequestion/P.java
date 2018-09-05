package ye.guo.huang.tongxin.diequestion;

public class P {
	private String lock;

    public P(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 "+ Thread.currentThread().getName() + " WAITING了★");
                    lock.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName()+ " RUNNABLE了");
                String value = System.currentTimeMillis() + "_"+ System.nanoTime();
                ValueObject.value = value;
//                lock.notify();
                	lock.notifyAll();//不只是通知同类线程，也包括异类线程，这样就不会出现假死的状态了，程序就会一直运行下去。
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
