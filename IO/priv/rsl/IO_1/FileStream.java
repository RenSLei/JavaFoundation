package priv.rsl.IO_1;
/*
字符流：
FileReader
FileWriter

BufferedReader
BufferedWriter

字节流：
InputStream   OutputStream

需求：想要操作图片数据。这时就要用到字节流。

本文档写了4个方法，其中一个写入字节流文件，3个读字节流文件的方法
*/


import java.io.*;
class  FileStream
{
	public static void main(String[] args) throws IOException
	{
		//writeFile();
		//readFile_1();
		//readFile_2();
		readFile_3();

	}
	
	//读文件3,字节流特有的方法：
	public static void readFile_3() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] buf = new byte[fis.available()];//定义一个刚刚好（大小就是文件的字节数）的缓冲区，不用再循环了
		
		fis.read(buf);

			System.out.println(new String (buf));

		fis.close();
		
		//结果：abcde

		//注意：用此方法要慎用，否则会发生内存溢出
	}

	//读文件2
	public static void readFile_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			System.out.println(new String (buf,0,len));
		}
		fis.close();
		
		//结果：abcde
	}

	//读文件1
	public static void readFile_1() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");

		int ch = 0;
		while((ch=fis.read())!=-1)
		{
			System.out.println((char)ch);
		}
		fis.close();
		
	}

	//写入字节流文件
	public static void writeFile() throws IOException
	{
		//抽象类只需要找到其直接子类就可以创建对象了
		//创建一个写字节流的对象
		FileOutputStream fos = new FileOutputStream("fos.txt");
		
		//不能存字符串，则将字符串变为字节文件
		fos.write("abcde".getBytes());

		//关闭流资源，注意与字符流不一样的是没有刷新的动作。。。。
		fos.close();

		//运行的结果是：在当前目录下创建一个名为fos.txt的文档，并写入了字符串abcde
	}
}
