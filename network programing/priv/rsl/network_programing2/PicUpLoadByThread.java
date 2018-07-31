package priv.rsl.network_programing2;

/*
��ʾһ�����̲߳��������ʷ������ϴ�ͼƬ

ֻ��ʾ�˱����������ϴ�

*/


import java.net.*;
import java.io.*;

class PicClient
{
	public static void main(String[] args) throws Exception
	{
		//�ڿͻ�����args[]���ݲ���

		//ֻ����java xxx   xxx��һ���ַ���������ֻ��һ��������ִ�к�������
		if(args.length!=1)
		{
			System.out.println("��ѡ��һ��.jpg��ʽ���ļ�");
			return;
		}

		File file = new File(args[0]);
		//�ַ���������������.jpg��β��
		
		if(!(file.getName().endsWith(".jpg")))
		{
			System.out.println("ͼƬ��ʽ����");
			return;
		}

		//���ƴ�С��
		if(file.length()>1024*1024*5)
		{
			System.out.println("�ļ�����5M��������ѡ��");
			return;
		}

		//������������Ƕ���ͻ��˲����ϴ����������Ϊ����˵�ip
		Socket s = new Socket(InetAddress.getLocalHost(),50001);
		
		//����һ����ȡ�ֽ���
		FileInputStream fis = new FileInputStream(file);

		//��ȡsocket�������
		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024*64];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			out.write(buf,0,len);
		}

		//֪ͨ���������ϴ����ݽ���
		s.shutdownOutput();

		//��ȡsocket���������������ȡ���������ص���Ϣ
		InputStream is = s.getInputStream();
		byte[] bufIn = new byte[1024*64];

		int num = 0;
		while((num=is.read(bufIn))!=-1)
		{
			System.out.println(new String(bufIn,0,num));
		}

		fis.close();
		s.close();
	}

}


/*
����ˣ�
������������ȱ�����һ��ֻ����һ���ͻ�����֮�����Ӳ��������ݵĴ���

����ʵ�ʵķ��ʷ���˵Ĺ����У���Ҫͬʱ����

����Ҫ���ö��̼߳���
����Ҫִ�еĴ������run������

*/

//����һ�������̵߳���
class PicThread implements Runnable
{
	//��װһ������
	private Socket s;

	PicThread(Socket s)
	{
		this.s=s;
	}

	//����run����
	public void run()
	{	
		String ip = s.getInetAddress().getHostAddress();
		try
		{
			int count = 1;
			System.out.println(ip+".....connected");

			//��ȡsocket��������
			InputStream isIn = s.getInputStream();

			//��Ҫ�ϴ����ļ���ip��ַ���������Ե÷�װ����
			File file = new File(ip+"("+count+").jpg");

			//��Ҫ�ö���ͻ����ϴ���ͼƬ��������
			//����ļ����ڣ������ļ�����һ��()
			while(file.exists())
				file = new File(ip+"("+(count++)+").jpg");

			//д��һ���ļ���ȥ������Ҫ���������
			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024*64];

			int len = 0;
			while((len=isIn.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}

			//��ȡ����������ڷ�����Ϣ
			OutputStream osOut = s.getOutputStream();

			osOut.write("�ϴ�ͼƬ�ɹ���".getBytes());

			//�ر���
			s.close();
			fos.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+"�ϴ�ʧ�ܣ�");
		}
		
	}
}



class PicServer
{
	public static void main(String[] args) throws Exception
	{
		//�������񣬼���
		ServerSocket ss = new ServerSocket(50001);

		while(true)
		{
			//��ȡsocket
			Socket s = ss.accept();

			//�����̣߳�ѭ�������߳�
			new Thread(new PicThread(s)).start();
		}
	}

}

/*
������Ľ����

C:\Users\78658\OneDrive\java\day24_������2\24��-02-������(TCP-�ͻ��˲����ϴ�ͼƬ)>java PicClient C:\Users\78658\Desktop\��Ƶ.jpg
�ļ�����5M��������ѡ��

C:\Users\78658\OneDrive\java\day24_������2\24��-02-������(TCP-�ͻ��˲����ϴ�ͼƬ)>java PicClient fsdfsad
ͼƬ��ʽ����

C:\Users\78658\OneDrive\java\day24_������2\24��-02-������(TCP-�ͻ��˲����ϴ�ͼƬ)>java PicClient sfjkhjk
ͼƬ��ʽ����

C:\Users\78658\OneDrive\java\day24_������2\24��-02-������(TCP-�ͻ��˲����ϴ�ͼƬ)>java PicClient sfjkhjk sdaga
��ѡ��һ��.jpg��ʽ���ļ�

C:\Users\78658\OneDrive\java\day24_������2\24��-02-������(TCP-�ͻ��˲����ϴ�ͼƬ)>java PicClient C:\Users\78658\Desktop\��Ƶ.jpg
�ļ�����5M��������ѡ��

C:\Users\78658\OneDrive\java\day24_������2\24��-02-������(TCP-�ͻ��˲����ϴ�ͼƬ)>java PicClient C:\Users\78658\Desktop\javaѧϰ����.jpg
�ϴ�ͼƬ�ɹ���


*/
