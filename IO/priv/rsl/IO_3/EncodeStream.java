package priv.rsl.IO_3;
/*
转换流的字符编码：

*/

import java.io.*;
class EncodeStream 
{
	public static void main(String[] args) throws IOException
	{
		//writeText();
		readText();
	}

	public static void writeText() throws IOException
	{
		//用gbk编码形式写的文件是2个字节一个字符，用UTF-8写的文件是3个字节
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");

		osw.write("你好");

		osw.close();

	}

	public static void readText() throws IOException
	{
		//用gbk（utf-8）编码写的文件去查utf-8（gbk）的编码表会乱码:
		//1,InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"UTF-8");
		//2,InputStreamReader isr = new InputStreamReader(new FileInputStream("utf.txt"),"gbk");

		//不乱码：
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"gbk");
		char[] buf = new char[10];

		int len=isr.read(buf);

		String str = new String(buf,0,len);

		System.out.println(str);
		
		/*
		1,用gbk编码写的文件去查utf-8的编码表会乱码：
			浣犲ソ

		2,用utf-8编码写的文件去查gbk的编码表会乱码：
			??
		*/


	}
}
