package priv.rsl.network_programing1;
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


import java.net.*;

class UdpRece2
{
	public static void main(String[] args) throws Exception
	{
		//建立udp服务,指定端口号
		DatagramSocket ds = new DatagramSocket(1000);
		
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
			System.out.println("发送端端口号："+dp.getPort()+"IP:"+ip+"data:"+data);
		}
	}

}

