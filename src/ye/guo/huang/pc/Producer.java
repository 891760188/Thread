package ye.guo.huang.pc;

import java.util.UUID;

/**
 * ������
 */
public class Producer extends Thread{

    private Storage storage;//�����ֿ߲�
    private String name="";
    
    public Producer(Storage storage, String name) {
        this.storage = storage;
        this.name = name;
    }
    public void run(){
//        //������ÿ��1s����1~100��Ϣ
//        long oldTime = System.currentTimeMillis();
//        while(true){
//            synchronized(storage){
//                if (System.currentTimeMillis() - oldTime >= 1000) {
//                    oldTime = System.currentTimeMillis();
//                    String msg = UUID.randomUUID().toString();
//                    storage.put("-ID:" ,name);
//                }
//            }
//        }
    	
    	
    	for (int i = 0; i < 10; i++) {
    		storage.put(i+"-ID:" ,name);
		}
    	
    	
    }
}
