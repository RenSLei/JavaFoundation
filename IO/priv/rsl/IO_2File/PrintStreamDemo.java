package priv.rsl.IO_2File;
/*

��ӡ����
�����ṩ�˴�ӡ���������Խ������������͵����ݶ�ԭ����ӡ

�ֽڴ�ӡ����
PrintStream
���캯�����Խ��ܵĲ������ͣ�
1.file����:File
2.�ַ���·����String
3.�ֽ��������OutputStream


�ַ���ӡ����
PrintWriter�������ã�
���캯�����Խ��ܵĲ������ͣ�
1.file����:File
2.�ַ���·����String
3.�ֽ��������OutputStream
4.�ַ��������Writer

��ס�������ܺ��ļ�����ֱ����صĶ����Ǻ���Ҫ�Ķ���

*/


import java.io.*;
class PrintStreamDemo 
{
	public static void main(String[] args) throws IOException
	{
		//Դ��
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		//Ŀ�ģ�
		PrintWriter out = new PrintWriter(System.out,true);//System.out�����ֽ������,�����println�ͻ��Զ�ˢ��
		//ע�⣺ֻ��ǰ����ܵ������������д�Զ�ˢ�£�������ļ���Ҫ��װ�������У��磺
		PrintWriter pw = new PrintWriter(new FileWriter("a.txt"),true);
		//��һ��
		String line = null;
		while ((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			out.println(line.toUpperCase());
			//out.flush();�����Զ�ˢ��
		}

	}
}
