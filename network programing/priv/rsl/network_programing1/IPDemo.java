package priv.rsl.network_programing1;
/*
获取主机名称以及IP地址：

java.net.*

InetAddress类
*/


import java.net.*;

class IPDemo 
{
	public static void main(String[] args) throws Exception
	{
		//获取主机的名称以及IP
		InetAddress i = InetAddress.getLocalHost();

		//System.out.println(i.toString());

		System.out.println("本机主机名："+i.getHostName());
		System.out.println("本机IP地址："+i.getHostAddress());
		
		//获取任意一台主机的IP
		InetAddress[] ias = InetAddress.getAllByName("bbs.aiyuke.com");
		int n = 1;
		for (InetAddress ia:ias)
		{
			//System.out.println(ia.toString());
			System.out.println("主机名"+"----"+ia.getHostName());
			System.out.println("IP地址"+n+"----"+ia.getHostAddress());
			n++;
		}
	}

}

