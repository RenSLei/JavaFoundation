package priv.rsl.network_programing2;
/*
URL��Ϊǿ��Ҳ�Ǹ�Ϊ��Ҫ���ǳ�����URLConnection
ͨ����URL�ķ���openconnection()��URLConnection�ཨ������


������URLConnection:

������ URLConnection ��������ĳ��࣬������Ӧ�ó���� URL ֮���ͨ�����ӡ�
�����ʵ�������ڶ�ȡ��д��� URL ���õ���Դ��

*/

import java.net.*;
import java.io.*;

class URLConnectionDemo 
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("http://192.168.43.53:8080/myWeb/Demo.html");

		//����һ��URLConnection��openconnection()����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶�������ӡ�
		URLConnection conn = url.openConnection();

		//����api�ĵ�������URLConnection���Լ�������ַ��http://duanfei.iteye.com/blog/1719997
		
		//��ȡ�����ӵ�coon�����������Ի�ȡ���������ص�����
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(conn.getInputStream()));

		//��ȡ����
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}

		bufr.close();



	}

}

/*
ע�⣺Ϊʲô��ʱ���ص�����û�а�����������ݷ���ͷ��
��Ϊ�������˴�����Ӧ�ò㣬�����ݵ���Ӧ�ò�ʱ���������Э�飬�Զ������ֻ�����������岿��
����û�з�������ͷ,ֻ����������


*/
