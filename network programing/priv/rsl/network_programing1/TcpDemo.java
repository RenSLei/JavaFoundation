package priv.rsl.network_programing1;
/*
��ʾtcp�Ĵ���Ŀͻ��˵ķ���˵Ļ��á�

���󣺿ͻ��˸�����˷������ݣ�������յ��󣬸��ͻ��˷�����Ϣ��
���Կͻ���ҲҪ��ȡsocket��������InputStream

�ͻ��ˣ�
1������socket����ָ�����������Ͷ˿�
2����ȡsocket���е��������������д�������У�ͨ�����緢�͸������
3����ȡsocket���е���������������˷��������ݻ�ȡ��������ӡ��
4���رտͻ�����Դ
*/

import java.net.*;
import java.io.*;

class TcpClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket(InetAddress.getLocalHost(),1994);//2���ͷ�����1,���ӷ����
		
		OutputStream out = s.getOutputStream();
		
		out.write("��������".getBytes());//4:�ͷ�����3:д���ݽ������

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);//5:�������ȴ�д�����ݾ��������

		System.out.println(new String(buf,0,len));

		s.close();

	}

}

/*
����ˣ�
1������socket���񣬽��˿ڰ󶨵��������������ö˿�
2��ʹ��ServerSocket��accept()������������ֱ���пͻ������ӣ�
3����ȡ�ͻ���socket���е������������ͻ�����������ݻ�ȡ��,(ͨ����������read())
4����ȡ�ͻ���socket���е������������Ӧ����д��������(�������write())��ͨ�����緢�͸��ͻ���

5���ر�socket��Դ;�رշ�����(һ�㲻��)

*/

class TcpServer 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(1994);

		Socket s = ss.accept();//1���������ȴ����ȴ�����
		
		//ϰ�ߣ���ȡip

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"......connected");

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);//3���������ȴ�������Ǳ�д������

		System.out.println(new String(buf,0,len));

		OutputStream out = s.getOutputStream();
		
		out.write("�յ����ͻ��ˣ����".getBytes());//6�ͷ�����5��д�����ݽ������

		s.close();
		ss.close();


	}

}
