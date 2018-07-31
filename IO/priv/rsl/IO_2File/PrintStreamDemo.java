package priv.rsl.IO_2File;
/*

打印流：
该流提供了打印方法。可以将各种数据类型的数据都原样打印

字节打印流：
PrintStream
构造函数可以接受的参数类型：
1.file对象:File
2.字符串路径：String
3.字节输出流：OutputStream


字符打印流：
PrintWriter（更常用）
构造函数可以接受的参数类型：
1.file对象:File
2.字符串路径：String
3.字节输出流：OutputStream
4.字符输出流：Writer

记住：凡是能和文件对象直接相关的对象都是很重要的对象

*/


import java.io.*;
class PrintStreamDemo 
{
	public static void main(String[] args) throws IOException
	{
		//源：
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		//目的：
		PrintWriter out = new PrintWriter(System.out,true);//System.out就是字节输出流,如果是println就会自动刷新
		//注意：只有前面接受的是流对象才能写自动刷新，如果是文件则要封装成流才行，如：
		PrintWriter pw = new PrintWriter(new FileWriter("a.txt"),true);
		//读一行
		String line = null;
		while ((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			out.println(line.toUpperCase());
			//out.flush();不用自动刷新
		}

	}
}
