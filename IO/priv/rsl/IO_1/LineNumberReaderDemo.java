package priv.rsl.IO_1;
/*
ѧϰװ����BufferedReader ������LineNUmberReader,���ĳ��������˸���BufferedReaderû�е�
���úͻ�ȡ�кŵĹ��ܣ�

setLineNumber(��ʼ�к�)
getLineNumber()

*/

import java.io.*;
class LineNumberReaderDemo 
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("LineNUmberReaderDemo.java");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;

		lnr.setLineNumber(100);//ʵ���Ǵ�101�п�ʼ
		while((line=lnr.readLine())!=null)
		{
			System.out.println(lnr.getLineNumber()+":"+line);
		}

		lnr.close();
	}
}
