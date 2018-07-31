package priv.rsl.IO_3;
/*
�ܵ�����
��Ҫ�õ����̼߳�����

*/
//һ����д���̣߳�
import java.io.*;
class Read implements Runnable
{
	//��ʼ������һ���ܵ���������
	private PipedInputStream in;

	//���캯����
	Read(PipedInputStream in)
	{
		this.in=in;
	}

	//����run������
	public void run()
	{
		try
		{
			//������
			byte[] buf = new byte[1024];
			
			//��ȡǰû������
			System.out.println("��ȡǰ��������û�����ݣ�����");
			int len = in.read(buf);
            System.out.println("�������ݣ���������");

			String s= new String (buf,0,len);

			System.out.println(s);

			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ܵ���ȡ��ʧ��");
		}
	}
}

//д���̣߳�
class Write implements Runnable
{
	//��ʼ������һ���ܵ���������
	private PipedOutputStream out;

	//���캯����
	Write(PipedOutputStream out)
	{
		this.out=out;
	}

	//����run������
	public void run()
	{
		try
		{
			System.out.println("��ʼд�����ݣ��ȴ�5���");
			//��д֮ǰͣ5�룺
			Thread.sleep(5000);
			out.write("piped lai le".getBytes());
		}
		catch (Exception e )
		{
			throw new RuntimeException("�ܵ������ʧ��");
		}
		
	}
}

class PipedStreamDemo   
{
	public static void main(String[] args) throws IOException
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		//���������ܵ�����������
		in.connect(out);

		Read r = new Read(in);
		Write w = new Write(out);

		//�����̣߳�
		new Thread(r).start();
		new Thread(w).start();
	}
}
