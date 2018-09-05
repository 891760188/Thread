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
            synchronized (lock) {//����һ���߳���ͬһ�����������˴��������this��ô������һ���߳̾Ͳ���ͬһ���������ˣ���û�취����ͨ����
                System.out.println("��ʼ     wait time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("����      wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}