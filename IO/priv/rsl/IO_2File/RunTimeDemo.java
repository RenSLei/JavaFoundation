package priv.rsl.IO_2File;

/*
���ڼ�¼Ӧ�ó������д�����
���ʹ�ô����ѵ�����ô����ע����ʾ��

�뵽���Ǽ�������
���Ǹü����������ڳ����У����ų�������ж����ڴ��д��ڣ�����������
���ų�����˳����ü�����Ҳ���ڴ�����ʧ

��һ���������ó���ʱ�������¿�ʼ��0����
��������������Ҫ��

����ʹ�������ü�������ֵҲ����
�´γ������𶯻��ȼ��ظü�������ֵ����һ�����´洢����

����Ҫ����һ�������ļ������ڼ�¼�������ʹ�ô���

�������ļ�ʹ�ü�ֵ�Ե���ʽ���������Ķ����ݺͲ�������

��ֵ��������map����
���������ļ���ʽ�洢��ʹ��io����
��ôio+map--->properties

�����ļ�����ʵ��Ӧ�ó������ݵĹ���
*/

import java.util.*;
import java.io.*;
class  RunTimeDemo
{
	public static void main(String[] args) throws IOException
	{
		//����properties����
		Properties prop = new Properties();

		//��Ҫ�������ļ������ɶ���
		//�ڵ�ǰĿ¼����һ����Ҫ�������ı��ļ�
		File file = new File("RunTime.ini");

		//��Ҫ��prop������������������뵽FileInputStream
		//�����ڹ����ļ���ʱ�������ȷ�����ļ�
		if (!file.exists())
		{
			file.createNewFile();
		}

		//�����ļ�

		FileInputStream fis = new FileInputStream(file);
		
		//����ȡ�����ݵ�load������
		prop.load(fis);
		
		//����һ��������
		int count = 0;
		
		String value = prop.getProperty("time");

		//��ȡһ��ָ���ļ���ֵ
		if(value!=null)
		{
			//��ֵ����count
			count = Integer.parseInt(value);

			//�ж�һ��count������
			if (count>=5)
			{
				sop("����ʹ�ô����Ѿ����꣡��ע�ᣡ");
				return;
			}
			
		}

		count++;

		prop.setProperty("time",count+"");

		//ʹ��store��������������Ϣ���浽�ļ���

		FileOutputStream fos = new FileOutputStream(file);

		prop.store(fos,"");


		//�ر�����Դ
		fos.close();
		fis.close();




	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
