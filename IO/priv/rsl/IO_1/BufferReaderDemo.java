package priv.rsl.IO_1;
/*
�ַ���ȡ���Ļ�������
�������ṩ��һ��һ�ζ�һ�еķ��� readLine,������ı����ݵĻ�ȡ
��readLine()��������ֵΪnullʱ����ʾ�����ļ�ĩβ

*/
import java.io.*;
class BufferReaderDemo 
{
	public static void main(String[] args) throws IOException
	{
		//����һ����ȡ��������ļ��������
		FileReader fr = new FileReader("buf.txt");

		//Ϊ�����Ч�ʣ����뻺�������������ַ���ȡ��������Ϊ�������ݸ��������Ĺ��캯��
		BufferedReader bufr = new BufferedReader(fr);

		//����API����֪����readLine()�����ķ���ֵΪ�յ�ʱ�򣬱�ʾ��ȡ���ı���ĩβ
		//��������һ��������¼����ֵ��������ֵ���ǿյ�ʱ��ͼ�����
		String line = null;

		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}

		bufr.close();
	}
}
/*
abcd1
abcd2
abcd3
abcd4

*/
