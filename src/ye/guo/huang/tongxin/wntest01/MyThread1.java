package ye.guo.huang.tongxin.wntest01;

public class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {//和另一个线程用同一个对象锁，此处如果是用this那么和另外一个线程就不是同一个对象锁了，就没办法进行通信了
                System.out.println("开始     wait time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束      wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}