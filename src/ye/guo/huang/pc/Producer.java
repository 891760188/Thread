package ye.guo.huang.pc;

import java.util.UUID;

/**
 * 生产者
 */
public class Producer extends Thread{

    private Storage storage;//生产者仓库
    private String name="";
    
    public Producer(Storage storage, String name) {
        this.storage = storage;
        this.name = name;
    }
    public void run(){
//        //生产者每隔1s生产1~100消息
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
