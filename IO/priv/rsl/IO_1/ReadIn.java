package priv.rsl.IO_1;
/*
��ȡ���̵�¼��
System.out:��Ӧ���Ǳ�׼������豸������̨
System.in:��Ӧ���Ǳ�׼�������豸������

����
ͨ������¼������
��¼��һ�����ݺ󣬾ͽ��������ݽ��д�ӡ
���¼���������over����ôֹͣ¼��

*/

import java.io.*;
class ReadIn 
{
	public static void main(String[] args) throws IOException
	{
		//��ȡ����¼�����
		InputStream in = System.in;
		//����һ����������,���ڴ��һ�е�����
		StringBuilder sb = new StringBuilder();
		//дѭ��
		while(true)
		{
			int ch = in.read();
			//�����������'\r',�����
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				//�������е�����ת�����ַ���
				String s = sb.toString();
				//����ַ�����over�����ѭ��
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());
				//ÿ��ӡһ��Ӧ�ý����������
				sb.delete(0,sb.length());
			}
			else
				sb.append((char)ch);
		}

	}
}
