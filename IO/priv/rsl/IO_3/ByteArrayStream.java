package priv.rsl.IO_3;
/*
���ڲ����ֽ������������:
�ص㣺
ByteArrayInputStream:�����ʱ����Ҫ����һ���ֽ�����Դ��
ByteArrayOutputStream:�����ʱ���ö�������Ŀ�ģ���Ϊ�ö������Ѿ��ڲ���װ�˿ɱ䳤�ȵ��ֽ�����
��������ݵ�Ŀ��

�������������ǲ���������û��ʹ��ϵͳ��Դ�����Բ��ý���close�رա�


Դ��
	���̣�System.in Ӳ�̣�FileStream �ڴ棺ArrayStream
Ŀ�ģ�
	����̨��System.out Ӳ�̣�FileStream �ڴ棺ArrayStream 


*/


import java.io.*;
class ByteArrayStream
{
	public static void main(String[] args)
	{
		//
		ByteArrayInputStream bis = new ByteArrayInputStream("JKHGFUIHR".getBytes());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		int by = 0;
		while((by=bis.read())!=-1)
		{
			bos.write(by);
		}

		System.out.println(bos.size());
		System.out.println(bos.toString());
	}
}
