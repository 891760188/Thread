package ye.guo.huang.tongxin.zijieliu;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

public class ReadData {
	
	public void readMethod(PipedInputStream inputStream) throws IOException {
		System.out.println("read :");
		byte [] byteArray = new byte[20];
		int readLength = inputStream.read(byteArray);//检测到流的末尾返回-1  没有检测到末尾，没有异常抛出则会阻塞线程
		while (-1 != readLength) {
			String data = new String(byteArray,0,readLength);
			System.out.println("--------------------------------readdata="+data);
			readLength = inputStream.read(byteArray);
		}
		System.out.println("++++++++++++++++++++");
		System.out.println("++++++++++++++++++++");
		System.out.println("++++++++++++++++++++");
		System.out.println("++++++++++++++++++++");
		if(null != inputStream) {
			inputStream.close();
		}
	}
	
	public void readMethod2(PipedReader input) {
        try {
            System.out.println("read  :");
            char[] byteArray = new char[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.println("--------------------------------readdata="+newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
