package priv.rsl.network_programing2;
/*
�����Լ��ķ���ˣ�


ͨ����������ʸ÷���ˣ��Ҳ鿴������ڷ��ʷ����ʱ��������ʲô��

ͨ���鿴������ʲô�������Լ���һ�������ȥ����tomcat������

*/

import java.net.*;
import java.io.*;

class ServerDemo 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(8888);

		Socket s = ss.accept();
		
		//�õ��ͻ��˵�ip��ַ
		System.out.println(s.getInetAddress().getHostAddress());

		//��ȡsocket�����������������������ͻ��˵�������ʲô��
		InputStream in = s.getInputStream();
		
		//��ȡ��Ϣ����ӡ��
		byte[] buf = new byte[1024];

		int len=in.read(buf);

		System.out.println("�ͻ�������"+new String(buf,0,len));
	
		//�����
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("<font color = 'red'size='4'>������ͻ������</font>");

		s.close();
		ss.close();
	}

}

/*
��������ͻ��˷�������������Ϣͷ��
GET / HTTP/1.1(----�汾��)
Accept: text/html, application/xhtml+xml, image/jxr, (֧��ʲô����)
Accept-Language: zh-CN(����)
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299
Accept-Encoding: gzip, deflate(֧��ѹ������ߴ���Ч��)
Host: 192.168.43.53:8888(Ҫ���ʵ�������ip�Լ��˿�)
Connection: Keep-Alive(���ִ��)

*/
