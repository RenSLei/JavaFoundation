package priv.rsl.IO_1;
/*
�ı��׼��������豸��С������������

*/

import java.io.*;
class TransStreamDemo2
{
	public static void main(String[] args) throws IOException
	{
		//���ļ���Դ��
		System.setIn(new FileInputStream("BufferedWriterDemo.java"));

		//��������豸��
		System.setOut(new PrintStream("zz.txt"));

		//����ͬʱ���ľ��Ǹ����ļ�����BufferedWriterDemo.java���Ƶ�zz.txt

		//��ȡ����¼����󣬼���¼�����д��
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//д�ļ�(�ַ�ת��Ϊ�ֽ�)
		BufferedWriter bufw =
			new BufferedWriter(new OutputStreamWriter(System.out));//�����ļ���д���Ŀ��
		
		String line = null;
		while((line=bufr.readLine())!=null)//BufferedReader��readLine����
		{
			if("over".equals(line))
				break;
			//д�ķ���Ҫˢ��
			bufw.write(line.toUpperCase());
			//���Ҫ���ƽ̨�Ļ��з�����Ҫ��BufferedWriter���������newLine()����
			bufw.newLine();
			//flush
			bufw.flush();
		}
		bufr.close();
	}
}
