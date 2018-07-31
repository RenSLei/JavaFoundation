package priv.rsl.IO_1;
/*
�ַ�����
FileReader
FileWriter

BufferedReader
BufferedWriter

�ֽ�����
InputStream   OutputStream

������Ҫ����ͼƬ���ݡ���ʱ��Ҫ�õ��ֽ�����

���ĵ�д��4������������һ��д���ֽ����ļ���3�����ֽ����ļ��ķ���
*/


import java.io.*;
class  FileStream
{
	public static void main(String[] args) throws IOException
	{
		//writeFile();
		//readFile_1();
		//readFile_2();
		readFile_3();

	}
	
	//���ļ�3,�ֽ������еķ�����
	public static void readFile_3() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] buf = new byte[fis.available()];//����һ���ոպã���С�����ļ����ֽ������Ļ�������������ѭ����
		
		fis.read(buf);

			System.out.println(new String (buf));

		fis.close();
		
		//�����abcde

		//ע�⣺�ô˷���Ҫ���ã�����ᷢ���ڴ����
	}

	//���ļ�2
	public static void readFile_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			System.out.println(new String (buf,0,len));
		}
		fis.close();
		
		//�����abcde
	}

	//���ļ�1
	public static void readFile_1() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		int ch = 0;
		while((ch=fis.read())!=-1)
		{
			System.out.println((char)ch);
		}
		fis.close();
		
	}

	//д���ֽ����ļ�
	public static void writeFile() throws IOException
	{
		//������ֻ��Ҫ�ҵ���ֱ������Ϳ��Դ���������
		//����һ��д�ֽ����Ķ���
		FileOutputStream fos = new FileOutputStream("fos.txt");
		
		//���ܴ��ַ��������ַ�����Ϊ�ֽ��ļ�
		fos.write("abcde".getBytes());

		//�ر�����Դ��ע�����ַ�����һ������û��ˢ�µĶ�����������
		fos.close();

		//���еĽ���ǣ��ڵ�ǰĿ¼�´���һ����Ϊfos.txt���ĵ�����д�����ַ���abcde
	}
}
