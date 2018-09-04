package ye.guo.huang.pc.me;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private static int i = 1;
	private static int MAX = 1;
	// ��Ʒ������;�ﵽ������ͣ����,���ѵ�0�ȴ�����
	private static List<Product> list;
	static {
		list = new ArrayList<Product>();
	}

	/**
	 * ������Ʒ
	 */
	public synchronized void produ(int temp) {
//		System.out.println("================================="+temp);
		if (list.size() >= MAX) {
			try {
				System.out.println("--------------������Ʒ" + i + "ʱ,�ﵽ��������ͣ����-------");
				this.wait();// ��������
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				e = null;
			}
		} // ������Ʒ
		Product product = new Product();
		product.setName("��Ʒ" + i);
		list.add(product);
		System.out.println("��������Ʒ---->" + product.getName() );
		System.out.println("��������" + list.size());
		i++;
		super.notify();//���������߳�������

	}

	/**
	 * ���Ѳ�Ʒ
	 * 
	 * @return
	 */
	public synchronized void cousu(int temp) {
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+temp);
		if (list.size() == 0) {// ������ʱ,����
			System.out.println("+++++++++++++++++++++++��Ʒ��������.�ȴ�+++++++++++++++=");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				e = null;
			}
		}
		Product product = list.get(0);
		list.remove(0);
		System.out.println("�����˻������Ʒ-->" + product.getName());
		System.out.println("��������" + list.size());
		super.notify(); //�����ݲ�����ʱ��ͻ���һ�������߳�������

	}
}
