package ye.guo.huang.tongxin.zijieliu;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

public class MainTest {
	public static void main(String[] args) {
		PipedInputStream inputStream = new PipedInputStream();
		PipedOutputStream outputStream = new PipedOutputStream();
		
		PipedReader pipedReader = new PipedReader();
		PipedWriter pipedWriter = new PipedWriter();
		try {
			pipedWriter.connect(pipedReader);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//輸出輸入流产生连接
		try {
			outputStream.connect(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ReadData read = new ReadData();
		WriteData write = new WriteData();
//		
//		ThreadRead threadRead = new ThreadRead(read, inputStream);
//		ThreadWrite threadWrite = new ThreadWrite(write, outputStream);
		
		ThreadRead threadRead = new ThreadRead(read, pipedReader);
		ThreadWrite threadWrite = new ThreadWrite(write, pipedWriter);
		
		threadRead.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		threadWrite.start();
		
	}
}
