package ye.guo.huang.pc.me;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private static int i = 1;
	private static int MAX = 1;
	// 产品的容器;达到容器暂停生产,消费到0等待生产
	private static List<Product> list;
	static {
		list = new ArrayList<Product>();
	}

	/**
	 * 生产产品
	 */
	public synchronized void produ(int temp) {
//		System.out.println("================================="+temp);
		if (list.size() >= MAX) {
			try {
				System.out.println("--------------生产商品" + i + "时,达到了总数暂停生产-------");
				this.wait();// 进入休眠
			} catch (InterruptedException e) {
				System.out.println(e.toString());
				e = null;
			}
		} // 生产商品
		Product product = new Product();
		product.setName("商品" + i);
		list.add(product);
		System.out.println("生产了商品---->" + product.getName() );
		System.out.println("容器容量" + list.size());
		i++;
		super.notify();//唤出消费者出来消费

	}

	/**
	 * 消费产品
	 * 
	 * @return
	 */
	public synchronized void cousu(int temp) {
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+temp);
		if (list.size() == 0) {// 消费完时,挂起
			System.out.println("+++++++++++++++++++++++商品消费完了.等待+++++++++++++++=");
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
		System.out.println("消费了获得了商品-->" + product.getName());
		System.out.println("容器容量" + list.size());
		super.notify(); //当数据不满的时候就唤醒一个生产线程来生产

	}
}
