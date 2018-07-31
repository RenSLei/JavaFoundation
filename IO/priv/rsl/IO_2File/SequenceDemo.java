package priv.rsl.IO_2File;
/*
InputStream��һ�����ࣺ
SequenceInputStream

����SequenceInputStream ��ʾ�������������߼�������

��ʾ���������ļ�д�뵽һ���ļ��У��Ե�ǰĿ¼�µ�����TXT�ĵ���Ϊ��ʾ

*/

import java.util.*;
import java.io.*;
class SequenceDemo 
{
	public static void main(String[] args) throws IOException
	{
		/*���캯��֮һ��
		  SequenceInputStream(Enumeration<? extends InputStream> e) 
          ͨ����ס��������ʼ���´����� SequenceInputStream��
		  �ò�����������������ʱ����Ϊ InputStream ����� Enumeration
		*/
		
		
		//ֻ�м���Vector�������Enumeration
		Vector<FileInputStream> v = new Vector<FileInputStream>();

		v.add(new FileInputStream("1.txt"));
		v.add(new FileInputStream("2.txt"));
		v.add(new FileInputStream("3.txt"));

		Enumeration<FileInputStream> en = v.elements();

		//��������:
		SequenceInputStream sis = new SequenceInputStream(en);

		//����Ŀ�ģ�
		FileOutputStream fos = new FileOutputStream("4.txt");

		//����һ��������
		byte[] buf = new byte[1024];

		int len = 0;
		while ((len= sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();

	}
}
