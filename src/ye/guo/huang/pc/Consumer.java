package ye.guo.huang.pc;

/**
 * ������
 */

public class Consumer extends Thread{

    private Storage storage;//�ֿ�
    
    private String name="";
    
    public Consumer(Storage storage, String name) {
        this.storage = storage;
        this.name = name;
    }
    public void run(){
//        while(true){
//            synchronized(storage){
//                //������ȥ�ֿ�����Ϣ��ʱ��������ֲֿ�����Ϊ�գ���ȴ�
//                String data = storage.get(name);
//                if(data != null){
//                    
//                    System.out.println(name +"-------------"+ data);
//                    
//                }
//            }
//        }
    	
    	
    	for (int i = 0; i < 20; i++) {
    		String data = storage.get(name);
    		if(data != null)
    			System.out.println(name +"-------------"+ data);
		}
    	
    }
}
