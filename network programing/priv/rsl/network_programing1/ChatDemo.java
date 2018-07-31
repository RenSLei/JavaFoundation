package priv.rsl.network_programing1;
/*
��дһ���������

�������ݵĲ��ֺͷ����ݵĲ��֣�����������Ҫͬʱ���У��Ǿ���Ҫ�����̣߳�
һ�����Ʒ�һ��������

��Ϊ�պͷ������ǲ�һ�µģ�����Ҫ��������run����
��������������Ҫ��װ����ͬ������

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
			throw new RuntimeException("���Ͷ�ʧ�ܣ�");
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
			throw new RuntimeException("���Ͷ�ʧ�ܣ�");
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
