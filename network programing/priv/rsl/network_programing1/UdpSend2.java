package priv.rsl.network_programing1;
/*
UDP���Ͷˣ�

UDP��
	�� DatagramSocket �����ʾ�������ͺͽ������ݱ������׽��֡�
	�� DatagramPacket �����ʾ���ݱ�����UDP�ǽ����ݴ������

����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ

˼·��
1������UDP����ͨ��DatagramSocket����

2��ȷ�����ݣ�����װ�����ݰ�
DatagramPacket(byte[] buf, int length, InetAddress address, int port) 

3������udp���񣬽����ݷ��ͳ�ȥ��ͨ��send����

4���ر���Դ


*/

import java.net.*;
import java.io.*;

class UdpSend2
{
	public static void main(String[] args) throws Exception
	{
		//����udp����,��ָ���Ķ˿ںŰ󶨵��˷���Ӧ�ó���
		DatagramSocket ds = new DatagramSocket(8888);

		//ȷ�����ݲ����
		System.out.println("��������Ϣ��");
		byte[] buf = new byte[100];

		int len = System.in.read(buf);

		DatagramPacket dp = 
			new DatagramPacket(buf,len,InetAddress.getByName("192.168.0.107"),1000);//���͵�������
		
		//�������ݰ�
		ds.send(dp);

		//�ر���Դ
		ds.close();

	}

}

