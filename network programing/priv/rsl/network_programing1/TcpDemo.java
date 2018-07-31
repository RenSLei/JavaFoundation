package priv.rsl.network_programing1;
/*
演示tcp的传输的客户端的服务端的互访。

需求：客户端给服务端发送数据，服务端收到后，给客户端反馈信息，
所以客户端也要获取socket的输入流InputStream

客户端：
1，建立socket服务，指定连接主机和端口
2，获取socket流中的输出流，将数据写到该流中，通过网络发送给服务端
3，获取socket流中的输入流，将服务端反馈的数据获取到，并打印。
4，关闭客户端资源
*/

import java.net.*;
import java.io.*;

class TcpClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket(InetAddress.getLocalHost(),1994);//2：释放阻塞1,连接服务端
		
		OutputStream out = s.getOutputStream();
		
		out.write("服务端你好".getBytes());//4:释放阻塞3:写数据进输出流

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);//5:阻塞：等待写入数据经进输出流

		System.out.println(new String(buf,0,len));

		s.close();

	}

}

/*
服务端：
1，建立socket服务，将端口绑定到本机，即监听该端口
2，使用ServerSocket的accept()的阻塞方法，直到有客户端连接；
3，获取客户端socket流中的输入流，将客户端请求的数据获取到,(通过输入流，read())
4，获取客户端socket流中的输出流，将回应数据写到该流中(输出流，write())，通过网络发送给客户端

5，关闭socket资源;关闭服务器(一般不关)

*/

class TcpServer 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(1994);

		Socket s = ss.accept();//1：阻塞，等待：等待连接
		
		//习惯：获取ip

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);//3：阻塞：等待服务端那边写入数据

		System.out.println(new String(buf,0,len));

		OutputStream out = s.getOutputStream();
		
		out.write("收到，客户端，你好".getBytes());//6释放阻塞5，写入数据进输出流

		s.close();
		ss.close();


	}

}
