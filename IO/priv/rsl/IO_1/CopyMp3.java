package priv.rsl.IO_1;
/*
��ʾMP3�ĸ��ƣ�ͨ����������
BufferedOutputStream
BufferedInputStream
*/
import java.io.*;
class CopyMp3 
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		copy_2();
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"����");
	}

	//ͨ���Լ������MyBufferedInputStream�ֽڻ�������ɸ���
	public static void copy_2() throws IOException
	{
		BufferedOutputStream bufos = 
			new BufferedOutputStream(new FileOutputStream("C:\\Users\\78658\\Desktop\\����-CopyByJava.mp3"));
		MyBufferedInputStream bufis= 
			new MyBufferedInputStream(new FileInputStream("C:\\Users\\78658\\Desktop\\����.mp3"));
		
		//����һ�����ͱ�����¼��ȡ�Ľ��
		int by = 0;

		//дһ��ѭ��������ѭ������д
		while ((by=bufis.myRead())!=-1)
		{
			bufos.write(by);
		}

		//�ر�����Դ
		bufis.myClose();
		bufos.close();
	}


	//ͨ���ֽ����Ļ�������ɸ���
	public static void copy_1() throws IOException
	{
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\78658\\Desktop\\����-CopyByJava.mp3"));
		BufferedInputStream bufis= new BufferedInputStream(new FileInputStream("C:\\Users\\78658\\Desktop\\����.mp3"));
		
		//����һ�����ͱ�����¼��ȡ�Ľ��
		int by = 0;

		//дһ��ѭ��������ѭ������д
		while ((by=bufis.read())!=-1)
		{
			bufos.write(by);
		}

		//�ر�����Դ
		bufis.close();
		bufos.close();
	}
}
