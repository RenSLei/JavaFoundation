package priv.rsl.IO_2File;
/*
��ʾ��һ��ͼƬ�и�ɼ�����Ƭ�ļ�
�ٽ������Ƭ�ļ��ϳ�һ���µ�ͼƬ
*/

import java.io.*;
import java.util.*;
class  SplitDemo
{
	public static void main(String[] args) throws IOException
	{
		//splitFile();
		merge();
	}

	//��һ��ͼƬ�и��������Ƭ�ļ�
	public static void splitFile() throws IOException
	{
		//Դ��һ��ͼƬ�����ֽڶ�ȡ����ͼƬ����
		FileInputStream fis = new FileInputStream("E:\\1.jpg");
		
		//���ⲿ�����ֽ�д���������ã�
		FileOutputStream fos = null;

		//����һ��������
		byte[] buf = new byte[1024*1024];//һM�Ļ�����

		int len = 0;
		
		int count = 1;

		//ѭ����ȡ��д����
		while ((len=fis.read(buf))!=-1)
		{
			//��ʾ��ʱ�����������������1M������
			//����Ŀ��
			fos = new FileOutputStream("E:\\splitfiles\\"+(count++)+".part");

			//д����
			fos.write(buf,0,len);
			
			//����
			fos.close();
		}

	}

	//�ϳ�ͼƬ
	/*
	������1.	��ΪSequenceInputStream��������ʱ���Ҫ�������Enumeration�������Ǳ�
				��������ʱ����Ϊ InputStream ����� Enumeration
		2.���Ҷ�ȡ���Ǻܶ���������뵽�ü��ϣ�ArrayList<FileInputStream>(Ч�ʸ�)
		3.Ȼ������ΪArrayList����û��Enumeration�������뵽������iterator

		

	*/
	public static void merge()throws IOException
	{
		//��һ��������ArrayList����
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		//���Ԫ��
		for (int x = 1;x<3 ;x++ )
		{
			al.add(new FileInputStream("E:\\splitfiles\\"+x+".part"));
		}

		//ʹ�õ�����,����Ϊ�������ڲ���ʹ��final ����
		final Iterator<FileInputStream> it = al.iterator();

		//����Enumeration,ʹ�������ڲ���
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>()
		{
			//���ǽӿڵ�����������
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}

			public FileInputStream nextElement()
			{
				return it.next();
			}
		};

		//��en���ݽ�SequenceInputStream
		SequenceInputStream sis = new SequenceInputStream(en);

		//����Ŀ�ģ�
		FileOutputStream fos = new FileOutputStream("E:\\splitfiles\\0.jpg");

		byte[] buf =new byte[1024];

		int len = 0 ;

		while ((len = sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}

		fos.close();
		sis.close();


	}
}
