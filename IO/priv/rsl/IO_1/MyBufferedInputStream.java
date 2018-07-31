package priv.rsl.IO_1;
/*
дһ���Լ���MyBufferedInputStream

*/

import java.io.*;
class MyBufferedInputStream 
{
	//˽�л�Ҫ���ݽ����Ķ���
	private InputStream in;

	//����һ���ֽ��͵����飬������ʱ��Ŷ�ȡ�����ֽ�
	private byte[] buf= new byte[1024];
	
	//����ָ��ͼ�����
	private int pos= 0,count = 0;

	//���캯��
	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	//һ�ζ�һ���ֽڣ��ӻ��������ֽ����飩��ȡ
	public int myRead() throws IOException
	{
		//ͨ��in�����ȡӲ���ϵ����ݣ����洢��buf�С�
		if(count==0)
		{
			count = in.read(buf);
			
			//������β�����ص���-1
			if(count<0)
				return -1;
			//ÿ�����´�Ӳ���ж�ȡ���ݵ����������ж�Ҫ��ָ����Ϊ0
			pos= 0;

			//��0�ű�ȡ��
			byte b =buf[pos];
			count--;//ȡһ�μ�һ��
			pos++;//ָ���ƶ�
			return b&0xff;//����b�ֽڵĺ��λ������λ
		}
		else if(count>0)
		{
			byte b =buf[pos];
			count--;
			pos++;
			return b&0xff;
		}
		return -1;
	}
	public void myClose() throws IOException
	{
		in.close();
	}
}
