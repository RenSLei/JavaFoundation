package priv.rsl.IO_1;
/*
�Զ���װ���ࣺ

����BufferedReader��readLine()ԭ���
�Լ�ʵ��һ������ͬ���Ĺ��ܵ�MyBufferedReader

��ôMyBufferedReader����һ��װ������

���������װ��һ���ָࣨ����һ������FileReader��?

���������캯���ﴫ�ݸ��ࣺ��FileReader �ĸ���Reader
		�������װ�����Ϊ�����һ�����ࣺextends ����


*/

import java.io.*;

class MyBufferedReader extends Reader//�̳г������Ҫ��д���󷽷���
{
	//���캯�����ݵĲ�����Ϊ���ࣺReader r
	private Reader r;
	MyBufferedReader(Reader r)
	{
		this.r = r;
	}

	//дһ��һ�ζ�һ�еķ�����
	public String MyReadLine() throws IOException
	{
		//��һ�з��ص����ַ���������һ���ַ�����������ʱ�洢��ȡ��һ������
		//Ϊ�˱�����ʾ�����ﴴ��StringBuilder����
		StringBuilder sb = new StringBuilder();

		//ԭreadLine�������ڵ���read()��ȡһ���ַ��ķ���������ͬ�����
		//����һ��int�ͱ�����¼read�ķ���ֵ��Ϊѭ������
		int ch = 0;
		while((ch=r.read())!=-1)
		{
			//�����ַ���'\r'��ʱ��Ͳ��棬����ѭ��
			if(ch=='\r')
				continue;

			//�����ַ���'\n'��ʱ��ͷ��ش�ʱ�����е��ַ���
			if(ch=='\n')
				return sb.toString();

			//����������ַ��������ַ���ӵ������У�������
			else
			sb.append((char)ch);
		}

		//����һ�е�ĩβ��������û�л��з���ʱ��ĩβ����������
		if(sb.length()!=0)
			return sb.toString();

		//������ĩ���ͷ���null
		return null;
	}
	//�̳��˳������Ҫ��д���еĳ��󷽷���
	public void close() throws IOException
	{
		r.close();
	}

	//��д����
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		return r.read(cbuf, off, len);
	}

	//�����ҵ��Լ��ر�����Դ�ķ�����
	public void MyClose() throws IOException
	{
		r.close();
	}
}


class MyBufferedReaderDemo 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		//�ⲿ���建����������
		MyBufferedReader bufr = null;
		try
		{
			//��������������ָ���ļ�
			bufr = new MyBufferedReader(new FileReader("MyBufferedReaderDemo.java"));
			
			//readLine()�������ص���һ�������Ч�ַ����������ػس���
			//���ⲿ�������ã�while��Ϊѭ����
			String line = null;
			
			//��line����null��ʱ�򣬾�û�е�ĩβ
			while ((line = bufr.MyReadLine())!=null)
			{
				System.out.println(line);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��ȡʧ�ܣ�");
		}

		//�ر�����Դ���رջ����������Ϳ�����
		finally 
		{
			try
			{
				//�ж��µ�Ŀ����ȷ���������ɹ��˲���ִ�йرղ���
				if(bufr!=null)
					bufr.MyClose();
			}
			catch (IOException e)
			{
				throw new RuntimeException("�رն�ȡ��ʧ�ܣ�");
			}

		}
	}
}
