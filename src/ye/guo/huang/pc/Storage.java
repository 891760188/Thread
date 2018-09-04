package ye.guo.huang.pc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.jianshu.com/p/81d66dfac87b
 * ���ݴ洢�ֿ�Ͳ���
 * һ������������������������ƣ�����������
 * ��ʱ���������ǲ��ܽ���Ʒ���뵽����������ģ�
 * ��Ȼ�����������ǿյ�ʱ��������Ҳ���ܴ����ó�����Ʒ��
 * ����漰�����ڶ��߳��е������ж�
 * 
 */
public class Storage {
    
    private static volatile int goodNumber = 1;
    
    private final static int MAX_SIZE = 20;
    /**
     *  Queue����������
     *  add       ����һ��Ԫ��                 ������������� ���׳�һ��IIIegaISlabEepeplian�쳣
     *  remove    �Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ� ���׳�һ��NoSuchElementException�쳣
     *  element   ���ض���ͷ����Ԫ��           �������Ϊ�գ� ���׳�һ��NoSuchElementException�쳣
     *  offer     ���һ��Ԫ�ز�����true       ������������� �򷵻�false
     *  poll      �Ƴ������ʶ���ͷ����Ԫ��     �������Ϊ�գ� �򷵻�null
     *  peek      ���ض���ͷ����Ԫ��           �������Ϊ�գ� �򷵻�null
     *  put       ���һ��Ԫ��                 �����������   ������
     *  take      �Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ� ������
     *
     */
    Queue<String> storage;
    public Storage() {
        storage = new LinkedList<String>();
    }

    /**
     *
     * @param dataValue
     */
    public synchronized void put(String dataValue, String threadName){
    	System.out.println(">>>>>>>>>>>>putStar");
        if(storage.size() >= MAX_SIZE){
            try {
                goodNumber = 1;
                super.wait();  //���������˺��������̵߳ȴ�
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(dataValue + goodNumber++);
        System.out.println(threadName+ "=" + dataValue+ "=" + goodNumber);
        super.notify();  //ÿ�����һ�����ݾͻ���һ�����ѵȴ����߳�������
        System.out.println("<<<<<<<<<<<<<<<putEnd");
    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
    public synchronized String get(String threadName) {
    	System.out.println(">>>>>>>>>>>>getStar");
        if(storage.size() == 0){
            try {
                super.wait();  //����Ʒ�ֿ�Ϊ�յ�ʱ���������̵߳ȴ�
                System.out.println(threadName + "wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        super.notify();  //�����ݲ�Ϊ�յ�ʱ��ͻ���һ�������߳�������
        String value = storage.remove();
        System.out.println("<<<<<<<<<<<<<<<getEnd");
        return value;
    }

}
