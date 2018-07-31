package priv.rsl.network_programing1;
/*
Tcp练习：
需求：建立一个文本转换服务器

客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端
而且客户端可以不断的进行文本的转换。当客户端输入over时，转换结束

分析：
客户端：既然是操作设备上的数据。那么就可以使用io技术。并按照io的操作规律来思考。
源：键盘录入
目的：网络输出流
而且操作的是文本数据，可以选择字符流。

步骤：
1，建立服务
2，获取键盘录入
3，将数据发给服务端
4，获取服务端返回的大写数据
5，关闭资源

都是文本数据可以选择字符流进行操作，同时加入缓冲提高效率

*/

import java.net.*;
import java.io.*;

class TransClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket(InetAddress.getLocalHost(),10003);//发送到本地主机
		
		//定义读取键盘数据的流对象
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		
		//定义目的，将数据写入到socket输出流。发给服务端
		BufferedWriter bufOut= 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//定义socket读取流，读取服务端返回的大写信息
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			//将数据写入到缓冲区，所以需要flush()
			bufOut.write(line);
			bufOut.newLine();//********重要！！！****要加一个结束标记，让readLine()知道结束，以便返回数据
			bufOut.flush();
			String str = bufIn.readLine();

			System.out.println("server:"+str);

		}
		
		bufr.close();
		s.close();

	}

}

/*
源：socket输入流流
目的：socket输出流、
文本，用缓冲包装一下

*/

class TransServer
{
	public static void main(String[] args)throws Exception
	{
		//建立服务，绑定端口，监听客户端
		ServerSocket ss = new ServerSocket(10003);

		//获取客户端的服务
		Socket s = ss.accept();

		//获取ip信息
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");
		
		//获取客户端服务的输入流
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		//获取客户端的输出流，以返回要返回的数据
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//读取一行数据
		String line = null;
		while((line = bufIn.readLine())!=null)//注意readLine()方法是读到回车符即换行符才返回
		{
			System.out.println(ip+"发来数据："+line);
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}

		s.close();
		ss.close();
		//
	}
}

/*
该例子出现的问题
现象：
客户端和服务端都有莫名的等待
因为客户端和服务端都有阻塞式方法，这些方法没有读到结束标记。那么就会一直等
而导致两端都在等待

*/
