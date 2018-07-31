package priv.rsl.IO_1;
/*
演示MP3的复制，通过缓冲区。
BufferedOutputStream
BufferedInputStream
*/
import java.io.*;
class CopyMp3 
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();
		copy_2();
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"毫秒");
	}

	//通过自己定义的MyBufferedInputStream字节缓冲来完成复制
	public static void copy_2() throws IOException
	{
		BufferedOutputStream bufos = 
			new BufferedOutputStream(new FileOutputStream("C:\\Users\\78658\\Desktop\\晚晴-CopyByJava.mp3"));
		MyBufferedInputStream bufis= 
			new MyBufferedInputStream(new FileInputStream("C:\\Users\\78658\\Desktop\\晚晴.mp3"));
		
		//定义一个整型变量记录读取的结果
		int by = 0;

		//写一个循环，用来循环读与写
		while ((by=bufis.myRead())!=-1)
		{
			bufos.write(by);
		}

		//关闭流资源
		bufis.myClose();
		bufos.close();
	}


	//通过字节流的缓冲区完成复制
	public static void copy_1() throws IOException
	{
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\78658\\Desktop\\晚晴-CopyByJava.mp3"));
		BufferedInputStream bufis= new BufferedInputStream(new FileInputStream("C:\\Users\\78658\\Desktop\\晚晴.mp3"));
		
		//定义一个整型变量记录读取的结果
		int by = 0;

		//写一个循环，用来循环读与写
		while ((by=bufis.read())!=-1)
		{
			bufos.write(by);
		}

		//关闭流资源
		bufis.close();
		bufos.close();
	}
}
