package priv.rsl.IO_1;
/*
ͨ���ոյ����ӣ�ͨ������¼��һ���ٴ�ӡһ�еĴ��룬���־���һ�ζ�һ�еķ���
Ҳ����readLine����

�ܲ���ֱ��ʹ��readLine�����أ�

readLine�������ַ���BufferedReader���еķ���

������¼���read�������ֽ���InputStream�ķ���

��ô���ܲ��ܽ��ֽ���ת���ַ�����ʹ�û�������readLine������

*/

import java.io.*;
class TransStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		/*
		//��ȡ����¼�����
		InputStream in = System.in;

		//�� �ֽ��� ����ת�� �ַ��� ����ʹ�� InputStreamReader ת����,����¼����󴫽���
		InputStreamReader isr = new InputStreamReader(in);
		
		//���Ч�ʣ����ַ������л�����������Ч������������ BufferedReader �ڰ�װ InputStreamReader
		BufferedReader bufr = new BufferedReader(isr);
		*/

		//�������仰д��һ�仰��***_____*****�ص㣺��
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));//����¼�����д��
		
		

		/*
		//ͬ����ʾ�ַ���תΪ�ֽ�����OutputStreamWriter
		OutputStream out = System.out;

		//�� �ַ��� ����ת�� �ֽ��� ����ʹ�� OutputStreamWriter ת����,����¼����󴫽���
		OutputStreamWriter osw = new OutputStreamWriter(out);
		
		//���Ч�ʣ����ַ������л�����������Ч������������ BufferedWriter �ڰ�װ OutputStreamWriter
		BufferedWriter bufw = new BufferedWriter(osw);

		*/
		//д��һ�仰��
		BufferedWriter bufw =
			new BufferedWriter(new OutputStreamWriter(System.out));
		
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

/*
���н����
dfhdfhadh
DFHDFHADH
hfdhadfh
HFDHADFH
abfkja
ABFKJA
sdag
SDAG
ga
GA
*/
