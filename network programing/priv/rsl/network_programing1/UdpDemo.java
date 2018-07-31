package priv.rsl.network_programing1;

/*
为了演示方便，将本应该写成两个应用程序的代码写到一个.java文件中、

演示将从键盘输入数据来发送信息

UDP发送端：
需求：通过udp传输方式，将一段文字数据发送出去

思路：
1，创建UDP服务，通过DatagramSocket对象
2,键盘录入
2，确定数据，并封装成数据包
DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
3，利用udp服务，将数据发送出去，通过send方法
4，关闭资源

*/

import java.net.*;
import java.io.*;

class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		//创建udp服务,将指定的端口号绑定到此发送应用程序
		DatagramSocket ds = new DatagramSocket();
		
		//键盘录入
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		
		//读取数据
		String line = null;
		while((line = bufr.readLine())!=null)
		{
			if("886".equals(line))
			break;

			//如果不是字符串：886那么建立数据包对象
			byte[] bt = new byte[1024];
			bt = line.getBytes();
			DatagramPacket dp = 
				new DatagramPacket(bt,bt.length,InetAddress.getByName("192.168.0.107"),1013);//ip地址最后如果为255，表示该ip段的广播地址

			//发送数据包
			ds.send(dp);

		}
		
		//关闭资源
		ds.close();

	}

}





/*
Udp接受端：

需求，定义一个接受udp协议传输的数据应用程序

思路：
1，建立udpsocket服务，即DatagramSocket对象,通常会监听一个端口，就是给这个应用程序定义一个端口标识
2，建立空数据包，用于存放接收到的数据，因为DatagramPacket数据包对象里面有丰富的提取数据的方法
3,利用udpsocket服务的receive()接受数据并存入数据包对象中
4，利用对象特有功能提取信息并打印在控制台上
5，关闭资源

*/

class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		//建立udp服务,指定端口号
		DatagramSocket ds = new DatagramSocket(1013);
		
		while(true)
		{

			//数据包
			byte[]  buf= new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			//receive
			ds.receive(dp);//阻塞式方法,所以用while(true)不会死循环

			//提取打印
			String ip = dp.getAddress().getHostAddress();

			String data = new String(dp.getData(),0,dp.getLength());
	
				System.out.println("发送端端口号："+dp.getPort());
				System.out.println("IP:"+ip);
				System.out.println("data:"+data);
		}
			//接收端一般不关闭资源
	}

}
