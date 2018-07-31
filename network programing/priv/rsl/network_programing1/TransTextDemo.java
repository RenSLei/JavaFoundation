package priv.rsl.network_programing1;
/*
Tcp��ϰ��
���󣺽���һ���ı�ת��������

�ͻ��˸�����˷����ı�������˻Ὣ�ı�ת�ɴ�д�ڷ��ظ��ͻ���
���ҿͻ��˿��Բ��ϵĽ����ı���ת�������ͻ�������overʱ��ת������

������
�ͻ��ˣ���Ȼ�ǲ����豸�ϵ����ݡ���ô�Ϳ���ʹ��io������������io�Ĳ���������˼����
Դ������¼��
Ŀ�ģ����������
���Ҳ��������ı����ݣ�����ѡ���ַ�����

���裺
1����������
2����ȡ����¼��
3�������ݷ��������
4����ȡ����˷��صĴ�д����
5���ر���Դ

�����ı����ݿ���ѡ���ַ������в�����ͬʱ���뻺�����Ч��

*/

import java.net.*;
import java.io.*;

class TransClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket(InetAddress.getLocalHost(),10003);//���͵���������
		
		//�����ȡ�������ݵ�������
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		
		//����Ŀ�ģ�������д�뵽socket����������������
		BufferedWriter bufOut= 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//����socket��ȡ������ȡ����˷��صĴ�д��Ϣ
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;

			//������д�뵽��������������Ҫflush()
			bufOut.write(line);
			bufOut.newLine();//********��Ҫ������****Ҫ��һ��������ǣ���readLine()֪���������Ա㷵������
			bufOut.flush();
			String str = bufIn.readLine();

			System.out.println("server:"+str);

		}
		
		bufr.close();
		s.close();

	}

}

/*
Դ��socket��������
Ŀ�ģ�socket�������
�ı����û����װһ��

*/

class TransServer
{
	public static void main(String[] args)throws Exception
	{
		//�������񣬰󶨶˿ڣ������ͻ���
		ServerSocket ss = new ServerSocket(10003);

		//��ȡ�ͻ��˵ķ���
		Socket s = ss.accept();

		//��ȡip��Ϣ
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");
		
		//��ȡ�ͻ��˷����������
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		//��ȡ�ͻ��˵���������Է���Ҫ���ص�����
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//��ȡһ������
		String line = null;
		while((line = bufIn.readLine())!=null)//ע��readLine()�����Ƕ����س��������з��ŷ���
		{
			System.out.println(ip+"�������ݣ�"+line);
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}

		s.close();
		ss.close();
		//
	}
}

/*
�����ӳ��ֵ�����
����
�ͻ��˺ͷ���˶���Ī���ĵȴ�
��Ϊ�ͻ��˺ͷ���˶�������ʽ��������Щ����û�ж���������ǡ���ô�ͻ�һֱ��
���������˶��ڵȴ�

*/
