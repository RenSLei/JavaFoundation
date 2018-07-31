package priv.rsl.IO_1;
/*
学习装饰类BufferedReader 的子类LineNUmberReader,它的出现增加了父类BufferedReader没有的
设置和获取行号的功能：

setLineNumber(起始行号)
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

		lnr.setLineNumber(100);//实际是从101行开始
		while((line=lnr.readLine())!=null)
		{
			System.out.println(lnr.getLineNumber()+":"+line);
		}

		lnr.close();
	}
}
