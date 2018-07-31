package priv.rsl.network_programing2;

/*
演示一个多线程并发来访问服务器上传图片

只演示了本机给本机上传

*/


import java.net.*;
import java.io.*;

class PicClient
{
	public static void main(String[] args) throws Exception
	{
		//在客户端用args[]传递参数

		//只允许java xxx   xxx是一个字符串，有且只有一个，否则不执行后续代码
		if(args.length!=1)
		{
			System.out.println("请选择一个.jpg格式的文件");
			return;
		}

		File file = new File(args[0]);
		//字符串参数必须是以.jpg结尾的
		
		if(!(file.getName().endsWith(".jpg")))
		{
			System.out.println("图片格式错误！");
			return;
		}

		//限制大小：
		if(file.length()>1024*1024*5)
		{
			System.out.println("文件大于5M，请重新选择");
			return;
		}

		//建立服务，如果是多个客户端并发上传，则这里改为服务端的ip
		Socket s = new Socket(InetAddress.getLocalHost(),50001);
		
		//建立一个读取字节流
		FileInputStream fis = new FileInputStream(file);

		//获取socket的输出流
		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024*64];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			out.write(buf,0,len);
		}

		//通知服务器，上传数据结束
		s.shutdownOutput();

		//获取socket服务的输入流，获取服务器返回的信息
		InputStream is = s.getInputStream();
		byte[] bufIn = new byte[1024*64];

		int num = 0;
		while((num=is.read(bufIn))!=-1)
		{
			System.out.println(new String(bufIn,0,num));
		}

		fis.close();
		s.close();
	}

}


/*
服务端：
这个服务端明显缺点就是一次只能有一个客户端与之相连接并进行数据的传输

而在实际的访问服务端的过程中，需要同时访问

所以要利用多线程技术
将需要执行的代码放在run方法中

*/

//建立一个开启线程的类
class PicThread implements Runnable
{
	//封装一个服务
	private Socket s;

	PicThread(Socket s)
	{
		this.s=s;
	}

	//覆盖run方法
	public void run()
	{	
		String ip = s.getInetAddress().getHostAddress();
		try
		{
			int count = 1;
			System.out.println(ip+".....connected");

			//获取socket的输入流
			InputStream isIn = s.getInputStream();

			//将要上传的文件用ip地址命名，所以得封装对象
			File file = new File(ip+"("+count+").jpg");

			//想要让多个客户端上传的图片不被覆盖
			//如果文件存在，则让文件名带一个()
			while(file.exists())
				file = new File(ip+"("+(count++)+").jpg");

			//写到一个文件中去，所以要建立输出流
			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024*64];

			int len = 0;
			while((len=isIn.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}

			//获取输出流，用于反馈信息
			OutputStream osOut = s.getOutputStream();

			osOut.write("上传图片成功！".getBytes());

			//关闭资
			s.close();
			fos.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+"上传失败！");
		}
		
	}
}



class PicServer
{
	public static void main(String[] args) throws Exception
	{
		//建立服务，监听
		ServerSocket ss = new ServerSocket(50001);

		while(true)
		{
			//获取socket
			Socket s = ss.accept();

			//开启线程，循环开启线程
			new Thread(new PicThread(s)).start();
		}
	}

}

/*
单独玩的结果：

C:\Users\78658\OneDrive\java\day24_网络编程2\24天-02-网络编程(TCP-客户端并发上传图片)>java PicClient C:\Users\78658\Desktop\视频.jpg
文件大于5M，请重新选择

C:\Users\78658\OneDrive\java\day24_网络编程2\24天-02-网络编程(TCP-客户端并发上传图片)>java PicClient fsdfsad
图片格式错误！

C:\Users\78658\OneDrive\java\day24_网络编程2\24天-02-网络编程(TCP-客户端并发上传图片)>java PicClient sfjkhjk
图片格式错误！

C:\Users\78658\OneDrive\java\day24_网络编程2\24天-02-网络编程(TCP-客户端并发上传图片)>java PicClient sfjkhjk sdaga
请选择一个.jpg格式的文件

C:\Users\78658\OneDrive\java\day24_网络编程2\24天-02-网络编程(TCP-客户端并发上传图片)>java PicClient C:\Users\78658\Desktop\视频.jpg
文件大于5M，请重新选择

C:\Users\78658\OneDrive\java\day24_网络编程2\24天-02-网络编程(TCP-客户端并发上传图片)>java PicClient C:\Users\78658\Desktop\java学习流程.jpg
上传图片成功！


*/
