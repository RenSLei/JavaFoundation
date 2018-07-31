package priv.rsl.network_programing1;

/*
Ϊ����ʾ���㣬����Ӧ��д������Ӧ�ó���Ĵ���д��һ��.java�ļ��С�

��ʾ���Ӽ�������������������Ϣ

UDP���Ͷˣ�
����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ

˼·��
1������UDP����ͨ��DatagramSocket����
2,����¼��
2��ȷ�����ݣ�����װ�����ݰ�
DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
3������udp���񣬽����ݷ��ͳ�ȥ��ͨ��send����
4���ر���Դ

*/

import java.net.*;
import java.io.*;

class UdpSend
{
	public static void main(String[] args) throws Exception
	{
		//����udp����,��ָ���Ķ˿ںŰ󶨵��˷���Ӧ�ó���
		DatagramSocket ds = new DatagramSocket();
		
		//����¼��
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		
		//��ȡ����
		String line = null;
		while((line = bufr.readLine())!=null)
		{
			if("886".equals(line))
			break;

			//��������ַ�����886��ô�������ݰ�����
			byte[] bt = new byte[1024];
			bt = line.getBytes();
			DatagramPacket dp = 
				new DatagramPacket(bt,bt.length,InetAddress.getByName("192.168.0.107"),1013);//ip��ַ������Ϊ255����ʾ��ip�εĹ㲥��ַ

			//�������ݰ�
			ds.send(dp);

		}
		
		//�ر���Դ
		ds.close();

	}

}





/*
Udp���ܶˣ�

���󣬶���һ������udpЭ�鴫�������Ӧ�ó���

˼·��
1������udpsocket���񣬼�DatagramSocket����,ͨ�������һ���˿ڣ����Ǹ����Ӧ�ó�����һ���˿ڱ�ʶ
2�����������ݰ������ڴ�Ž��յ������ݣ���ΪDatagramPacket���ݰ����������зḻ����ȡ���ݵķ���
3,����udpsocket�����receive()�������ݲ��������ݰ�������
4�����ö������й�����ȡ��Ϣ����ӡ�ڿ���̨��
5���ر���Դ

*/

class UdpRece
{
	public static void main(String[] args) throws Exception
	{
		//����udp����,ָ���˿ں�
		DatagramSocket ds = new DatagramSocket(1013);
		
		while(true)
		{

			//���ݰ�
			byte[]  buf= new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			//receive
			ds.receive(dp);//����ʽ����,������while(true)������ѭ��

			//��ȡ��ӡ
			String ip = dp.getAddress().getHostAddress();

			String data = new String(dp.getData(),0,dp.getLength());
	
				System.out.println("���Ͷ˶˿ںţ�"+dp.getPort());
				System.out.println("IP:"+ip);
				System.out.println("data:"+data);
		}
			//���ն�һ�㲻�ر���Դ
	}

}
