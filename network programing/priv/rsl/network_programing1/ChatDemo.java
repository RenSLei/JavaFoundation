package priv.rsl.network_programing1;
/*
编写一个聊天程序：

有收数据的部分和发数据的部分，这两部分需要同时进行，那就需要两个线程，
一个控制发一个控制收

因为收和发动作是不一致的，所以要定义两个run方法
而且这两个方法要封装到不同的类中

*/

import java.net.*;
import java.io.*;

class Send implements Runnable
{
	private DatagramSocket ds;
	public Send(DatagramSocket ds)
	{
		this.ds = ds;
	}
	public void run()
	{
		try
		{
			BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));

			String line = null;

			while((line=bufr.readLine())!=null)
			{
				if("886".equals(line))
				break;

				byte[] buf = line.getBytes();

				DatagramPacket dp = 
					new DatagramPacket(buf,buf.length,InetAddress.getLocalHost(),1999);

				ds.send(dp);
			}

		}
		catch (Exception e)
		{
			throw new RuntimeException("发送端失败！");
		}

	}
}


class Rece implements Runnable
{
	private DatagramSocket ds;
	public Rece(DatagramSocket ds)
	{
		this.ds = ds;
	}
	public void run()
	{
		try
		{
			while(true)
			{
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);

				ds.receive(dp);

				String ip = dp.getAddress().getHostAddress();

				String data = new String(dp.getData(),0,dp.getLength());

				System.out.println(ip+"  :"+data);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("发送端失败！");
		}

	}
}



class ChatDemo 
{
	public static void main(String[] args)throws Exception 
	{
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(1999);

		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();
		
	}

}
