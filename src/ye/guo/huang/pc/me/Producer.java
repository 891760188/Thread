package ye.guo.huang.pc.me;

import ye.guo.huang.build.Test02;

public class Producer implements Runnable {
	private Shop shop;// 要去送货的商店

	public Producer(Shop shop) {
		this.shop = shop;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(Test02.productNumPub());
				shop.produ(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Producer=++++++++++++++++++++++++++++++++++++++++++++++++++++++"+i);
		}
	}

}
