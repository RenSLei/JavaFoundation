package priv.rsl.IO_1;
/*
��ϰ������һ��ͼƬ

˼·��
1�����ֽڶ�ȡ�������ͼƬ�����
2�����ֽ�д�������󴴽�һ��ͼƬ�ļ������ڴ洢��ȡ����ͼƬ���ݡ�
3��ͨ��ѭ����д��������ݵĴ洢
4���ر���Դ

*/

import java.io.*;
class CopyPic 
{
	public static void main(String[] args) 
	{
		FileOutputStream fos = null;
		FileInputStream fis = null;

		try
		{
			fos = new FileOutputStream("E:\\copy.jpg");
			fis = new FileInputStream("C:\\Users\\78658\\Desktop\\1.jpg");

			byte[] buf = new byte[1024];
			int len = 0;
			while((len=fis.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("�����ļ�ʧ�ܣ�");
		}

		finally
		{
			try
			{
				if(fis!=null)
					fis.close();	
			}
			catch (IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ�ܣ�");
			}

			try
			{
				if(fos!=null)
					fos.close();	
			}
			catch (IOException e)
			{
				throw new RuntimeException("д��ر�ʧ�ܣ�");
			}
			
		}
	}
}
