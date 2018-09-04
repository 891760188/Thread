package ye.guo.huang.pc;

/**
 * 消费者
 */

public class Consumer extends Thread{

    private Storage storage;//仓库
    
    private String name="";
    
    public Consumer(Storage storage, String name) {
        this.storage = storage;
        this.name = name;
    }
    public void run(){
//        while(true){
//            synchronized(storage){
//                //消费者去仓库拿消息的时候，如果发现仓库数据为空，则等待
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
