package ye.guo.huang.pc.me;

public class MainTest {
	public static void main(String[] args) {
		Shop shop = new Shop();// �̵�
		
		Producer pro = new Producer(shop);
		Cousumer cou = new Cousumer(shop);
		
		new Thread(pro, "pro").start();
		
		new Thread(cou,"cou").start();
		

	}
}
