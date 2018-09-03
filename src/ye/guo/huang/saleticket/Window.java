package ye.guo.huang.saleticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * ������Ʊ����ͬʱ����20��Ʊ;
 * @author Administrator
 * Ϊ��֤�����������ͬһ��Ʊ����Ҫjava���߳�ͬ������
 * 1.����һ����Ʊ�����࣬�̳�Thread����дrun��������run��������ִ����Ʊ��������ƱҪʹ��ͬ����������һ��վ̨������Ʊʱ������վ̨Ҫ������Ʊ���꣡
 *
 */

public class Window extends Thread{
	
	public Window(String name) {
		super(name);
	}
	
	public static int NUM = 100 ;
	
	//����һ����̬Կ��
	public static Object KEY = "key";
	
	
	public static Set<Integer> logs = new HashSet<Integer>();
	
	@Override
	public void run() {
		while (NUM > 0) {
			//this�ؼ��ִ������һ�������������ڴ����������ͬ����Ļ��������
			//��static��Ա������ר�У����ڴ�ռ�Ϊ�������г�Ա���У�
			//��͵���synchronized()��static��Ա�������൱�ڶ��������
			//Ҳ�����ڸ�������г�Ա��ʵ�ֻ��⣬��ͬһʱ��ֻ��һ���߳̿ɷ��ʸ����ʵ��
			synchronized (KEY) {
				if(NUM > 0) {
					System.out.println(getName() + "�����˵�" + NUM + "��Ʊ");
					logs.add(NUM);
					NUM--;
				}else {
					System.out.println("=============Ʊ������==============" + logs.size());
				}
			}
			try {
				sleep(productNum());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//��Ϣһ��
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
		Window w1 = new Window("����1");
		w1.start();
		Window w2 = new Window("����2");
		w2.start();
		Window w3 = new Window("����3");
		w3.start();
	}
	
}
