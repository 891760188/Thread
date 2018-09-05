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
                    System.out.println("������ "+ Thread.currentThread().getName() + " WAITING�ˡ�");
                    lock.wait();
                }
                System.out.println("������ " + Thread.currentThread().getName()+ " RUNNABLE��");
                String value = System.currentTimeMillis() + "_"+ System.nanoTime();
                ValueObject.value = value;
//                lock.notify();
                	lock.notifyAll();//��ֻ��֪ͨͬ���̣߳�Ҳ���������̣߳������Ͳ�����ּ�����״̬�ˣ�����ͻ�һֱ������ȥ��
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}