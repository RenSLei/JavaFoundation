package priv.rsl.IO_3;
/*
ת�������ַ����룺

*/

import java.io.*;
class EncodeStream 
{
	public static void main(String[] args) throws IOException
	{
		//writeText();
		readText();
	}

	public static void writeText() throws IOException
	{
		//��gbk������ʽд���ļ���2���ֽ�һ���ַ�����UTF-8д���ļ���3���ֽ�
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");

		osw.write("���");

		osw.close();

	}

	public static void readText() throws IOException
	{
		//��gbk��utf-8������д���ļ�ȥ��utf-8��gbk���ı���������:
		//1,InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"UTF-8");
		//2,InputStreamReader isr = new InputStreamReader(new FileInputStream("utf.txt"),"gbk");

		//�����룺
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"gbk");
		char[] buf = new char[10];

		int len=isr.read(buf);

		String str = new String(buf,0,len);

		System.out.println(str);
		
		/*
		1,��gbk����д���ļ�ȥ��utf-8�ı��������룺
			你好

		2,��utf-8����д���ļ�ȥ��gbk�ı��������룺
			??
		*/


	}
}
