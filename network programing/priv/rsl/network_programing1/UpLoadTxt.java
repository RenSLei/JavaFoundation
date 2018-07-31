package priv.rsl.network_programing1;
/*

*/

import java.net.*;
import java.io.*;

class TcpClient1 
{
	public static void main(String[] args) throws Exception
	{
		//��������
		Socket s = new Socket(InetAddress.getLocalHost(),5000);
		
		//io��Դ��Ŀ��˼��:
		//дԴ��
		BufferedReader bufr = 
			new BufferedReader(new FileReader("UpLoadTxt.java"));

		//Ŀ�ģ�����PrintWriterд�����(�����ı�)���Դ�ˢ�µĹ���
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

		//����д
		String line = null;
		while((line = bufr.readLine())!=null)
		{
			pw.println(line);
		}

		//���ѿͻ��˵�����д���Ӧ�ðѴ���������ĩβ���
		s.shutdownOutput();

		//��ȡ�����������ڶ�ȡ���������ص�����
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String rece_str = null;
		while((rece_str = bufIn.readLine())!=null)
		{
			System.out.println(rece_str);
		}
		
		//�ر���Դ
		s.close();
		bufr.close();
	
	}

}


//����ˣ�

class TcpServer1 
{
	public static void main(String[] args) throws Exception
	{
		//�������񣬼����˿�
		ServerSocket ss = new ServerSocket(5000);
		
		//��ȡ�ͻ��˵�Socket����
		Socket s = ss.accept();

		//ϰ�ߣ���ȡip
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		//��ȡ����������
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//����Ŀ�ģ���printWriter�Ĺ��캯��printWriter(Writer out , boolean autoFlush)
		PrintWriter ps = new PrintWriter(new FileWriter("server.txt"),true);

		//���ͻ��˵Ļ�Ӧ
		PrintWriter Out = new PrintWriter(s.getOutputStream(),true);
		
		Out.println("��ʼ�ϴ�");
		//����д
		String line = null;
		
		//���ͻ��˵�����������д���ļ���
		while((line =bufIn.readLine())!=null)
		{
			ps.println(line);
		}
		
		//���������ļ���Ӧ�û�Ӧ�ͻ���
		
		Out.println("�ϴ��ɹ���");
		
		ps.close();
		ss.close();
		s.close();	
	}

}
