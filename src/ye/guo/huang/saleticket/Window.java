package ye.guo.huang.saleticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 三个售票窗口同时出售20张票;
 * @author Administrator
 * 为保证不会出现卖出同一个票数，要java多线程同步锁。
 * 1.创建一个买票窗口类，继承Thread，重写run方法，在run方法里面执行售票操作！售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
 *
 */

public class Window extends Thread{
	
	public Window(String name) {
		super(name);
	}
	
	public static int NUM = 100 ;
	
	//创建一个静态钥匙
	public static Object KEY = "key";
	
	
	public static Set<Integer> logs = new HashSet<Integer>();
	
	@Override
	public void run() {
		while (NUM > 0) {
			//this关键字代表类的一个对象，所以其内存锁是针对相同对象的互斥操作，
			//而static成员属于类专有，其内存空间为该类所有成员共有，
			//这就导致synchronized()对static成员加锁，相当于对类加锁，
			//也就是在该类的所有成员间实现互斥，在同一时间只有一个线程可访问该类的实例
			synchronized (KEY) {
				if(NUM > 0) {
					System.out.println(getName() + "卖出了第" + NUM + "张票");
					logs.add(NUM);
					NUM--;
				}else {
					System.out.println("=============票卖完了==============" + logs.size());
				}
			}
			try {
				sleep(productNum());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//休息一秒
		}
	}
	
	public int productNum() {
		int max=1000;
		int min=100;
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1) + min;
//		System.out.println("s="+s);
		return s ;
	} 
	
	public static void main(String[] args) {
		Window w1 = new Window("窗口1");
		w1.start();
		Window w2 = new Window("窗口2");
		w2.start();
		Window w3 = new Window("窗口3");
		w3.start();
	}
	
}
