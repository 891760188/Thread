package ye.guo.huang.tongxin.zijieliu;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteData {
	
	public void writeMethod(PipedOutputStream outputStream) throws IOException {
		System.out.println("write :");
		for (int i = 0; i < 3000; i++) {
			String data = i + 1 + "";
			outputStream.write(data.getBytes());
			System.out.println("writedata="+data);
		}
		if(null != outputStream) {
			outputStream.close();
		}
		

	}
	
	public void writeMethod2(PipedWriter out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 100; i++) {
                String outData = "ÎÒ" + (i + 1);
                out.write(outData);
                System.out.println("readdata="+outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
