package ye.guo.huang.pc.me;

public class MainTest {
	public static void main(String[] args) {
		Shop shop = new Shop();// ил╣Й
		
		Producer pro = new Producer(shop);
		Cousumer cou = new Cousumer(shop);
		
		new Thread(pro, "pro").start();
		
		new Thread(cou,"cou").start();
		

	}
}
