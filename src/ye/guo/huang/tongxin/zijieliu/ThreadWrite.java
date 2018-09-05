package ye.guo.huang.tongxin.zijieliu;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class ThreadWrite extends Thread {
	private WriteData write;
	private PipedOutputStream out;
	private PipedWriter pipedWriter;

	public ThreadWrite(WriteData write, PipedOutputStream out) {
		super();
		this.write = write;
		this.out = out;
	}
	
	public ThreadWrite(WriteData write, PipedWriter pipedWriter) {
		super();
		this.write = write;
		this.pipedWriter = pipedWriter;
	}

	@Override
	public void run() {
		try {
//			write.writeMethod(out);
			write.writeMethod2(pipedWriter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
