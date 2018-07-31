package priv.rsl.network_programing1;
/*
UDP发送端：

UDP：
	类 DatagramSocket 此类表示用来发送和接收数据报包的套接字。
	类 DatagramPacket 此类表示数据报包。UDP是将数据打包发送

需求：通过udp传输方式，将一段文字数据发送出去

思路：
1，创建UDP服务，通过DatagramSocket对象

2，确定数据，并封装成数据包
DatagramPacket(byte[] buf, int length, InetAddress address, int port) 

3，利用udp服务，将数据发送出去，通过send方法

4，关闭资源


*/

import java.net.*;
import java.io.*;

class UdpSend2
{
	public static void main(String[] args) throws Exception
	{
		//创建udp服务,将指定的端口号绑定到此发送应用程序
		DatagramSocket ds = new DatagramSocket(8888);

		//确定数据并打包
		System.out.println("请输入消息：");
		byte[] buf = new byte[100];

		int len = System.in.read(buf);

		DatagramPacket dp = 
			new DatagramPacket(buf,len,InetAddress.getByName("192.168.0.107"),1000);//发送到该主机
		
		//发送数据包
		ds.send(dp);

		//关闭资源
		ds.close();

	}

}

