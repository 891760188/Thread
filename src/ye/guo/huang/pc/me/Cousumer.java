package ye.guo.huang.pc.me;

import ye.guo.huang.build.Test02;

public class Cousumer implements Runnable{
	private Shop shop;// Ҫȥ���ѵ��̵�

	public Cousumer(Shop shop) {
		this.shop = shop;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {// ����100��
			
			try {
				Thread.sleep(Test02.productNumPub());
				shop.cousu(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Cousumer====================="+i);
		}
	}

}
