package priv.rsl.network_programing2;
/*
��ʾһ�����̲߳�����¼������


��һ�����ݿ⣺user.txt
��������˺���Ϣ

�ͻ��˵�¼�û�
�����У����û�

���̣�
1���ͻ��˽��û������������

2��	�������˵����ݿ��и��û�����
	���ظ��ͻ��ˣ�xxx����ӭ������
	�������ʾ��ip,�ѵ�¼

	�������˵����ݿ�û�и��û�����
	���ظ��ͻ��ˣ�xxxbu������
	����ˣ�xxx���Ե�¼

3��	����¼3��
*/


import java.net.*;
import java.io.*;

class LoginClient
{
	public static void main(String[] args) throws Exception
	{
		//������������Ƕ���ͻ��˲�����¼���������Ϊ����˵�ip
		Socket s = new Socket(InetAddress.getLocalHost(),50005);
		
		//����¼��
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		//��¼
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//��ȡsocket��������
			BufferedReader in = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		for (int x=0;x<3 ;x++)
		{	
			String line=bufr.readLine();
			
			//��������������null
			if(line==null)
				break;

			out.println(line);

			String str = in.readLine();
			
				
				System.out.println("����ˣ�"+str);
				
				//�������˷�������Ϣ�����"��ӭ"
				if(str.contains("��ӭ"))
					break;
		}

		bufr.close();
		s.close();
	}

}


/*
����ˣ�

Ҫ���ö��̼߳���
����Ҫִ�еĴ������run������

*/

//����һ�������̵߳���


class UserThread implements Runnable
{
	//��װһ������
	private Socket s;

	UserThread(Socket s)
	{
		this.s=s;
	}

	//����run����
	public void run()
	{	
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		try
		{
			for (int x=0;x<3 ;x++ )
			{
				BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));

				String name = bufIn.readLine();

				BufferedReader bufr = new BufferedReader(new FileReader("User.txt"));

				//��ȡsocket�������
				PrintWriter out = new PrintWriter(s.getOutputStream(),true);

				//�ж϶�һ�е��Ƿ��name���
				String line = null;

				//����һ����ǣ����ݱ����ִ�з������ͻ���Ҫ����ʲô����
				boolean flag = false;
				while((line=bufr.readLine())!=null)
				{
					if(line.equals(name))
					{
						flag = true;
						break;
					}
				}

				if(flag)
				{
					System.out.println(name+"�ѵ�¼");
					out.println(name+",��ӭ����");
					break;
				}
				else
				{
					System.out.println(name+"���Ե�¼");
					out.println(name+" �û�������");
				}
			}
			s.close();
		
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+"У��ʧ�ܣ�");
		}
		
	}
}



class LoginServer
{
	public static void main(String[] args) throws Exception
	{
		//�������񣬼���
		ServerSocket ss = new ServerSocket(50005);

		while(true)
		{
			//��ȡsocket
			Socket s = ss.accept();

			//�����̣߳�ѭ�������߳�
			new Thread(new UserThread(s)).start();
		}
	}

}


/*

*/
