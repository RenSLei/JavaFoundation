package priv.rsl.network_programing1;
/*
��ȡ���������Լ�IP��ַ��

java.net.*

InetAddress��
*/


import java.net.*;

class IPDemo 
{
	public static void main(String[] args) throws Exception
	{
		//��ȡ�����������Լ�IP
		InetAddress i = InetAddress.getLocalHost();

		//System.out.println(i.toString());

		System.out.println("������������"+i.getHostName());
		System.out.println("����IP��ַ��"+i.getHostAddress());
		
		//��ȡ����һ̨������IP
		InetAddress[] ias = InetAddress.getAllByName("bbs.aiyuke.com");
		int n = 1;
		for (InetAddress ia:ias)
		{
			//System.out.println(ia.toString());
			System.out.println("������"+"----"+ia.getHostName());
			System.out.println("IP��ַ"+n+"----"+ia.getHostAddress());
			n++;
		}
	}

}

