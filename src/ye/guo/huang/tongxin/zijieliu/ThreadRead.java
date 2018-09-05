package ye.guo.huang.tongxin.zijieliu;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

public class ThreadRead extends Thread{
	
	private ReadData read ;
	private PipedInputStream inputStream ;
	private PipedReader pipedReader;
	
	 public ThreadRead(ReadData read, PipedInputStream input) {
	        super();
	        this.read = read;
	        this.inputStream = input;
	    }
	 
	 public ThreadRead(ReadData read, PipedReader pipedReader) {
		 super();
		 this.read = read;
		 this.pipedReader = pipedReader;
	 }
	
	@Override
	public void run() {
		try {
//			read.readMethod(inputStream);
			read.readMethod2(pipedReader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
