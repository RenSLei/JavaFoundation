package priv.rsl.IO_3;
/*
管道流：
需要用到多线程技术：

*/
//一个是写的线程：
import java.io.*;
class Read implements Runnable
{
	//初始化就有一个管道流进来：
	private PipedInputStream in;

	//构造函数：
	Read(PipedInputStream in)
	{
		this.in=in;
	}

	//覆盖run方法：
	public void run()
	{
		try
		{
			//读数据
			byte[] buf = new byte[1024];
			
			//读取前没有数据
			System.out.println("读取前，，，，没有数据，阻塞");
			int len = in.read(buf);
            System.out.println("读到数据：阻塞结束");

			String s= new String (buf,0,len);

			System.out.println(s);

			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("管道读取流失败");
		}
	}
}

//写的线程：
class Write implements Runnable
{
	//初始化就有一个管道流进来：
	private PipedOutputStream out;

	//构造函数：
	Write(PipedOutputStream out)
	{
		this.out=out;
	}

	//覆盖run方法：
	public void run()
	{
		try
		{
			System.out.println("开始写入数据，等待5秒后：");
			//在写之前停5秒：
			Thread.sleep(5000);
			out.write("piped lai le".getBytes());
		}
		catch (Exception e )
		{
			throw new RuntimeException("管道输出流失败");
		}
		
	}
}

class PipedStreamDemo   
{
	public static void main(String[] args) throws IOException
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		//将这两个管道连接起来：
		in.connect(out);

		Read r = new Read(in);
		Write w = new Write(out);

		//开启线程：
		new Thread(r).start();
		new Thread(w).start();
	}
}
