package priv.rsl.IO_2File;
/*
InputStream的一个子类：
SequenceInputStream

用于SequenceInputStream 表示其他输入流的逻辑串联。

演示：将三个文件写入到一个文件中：以当前目录下的三个TXT文档作为演示

*/

import java.util.*;
import java.io.*;
class SequenceDemo 
{
	public static void main(String[] args) throws IOException
	{
		/*构造函数之一：
		  SequenceInputStream(Enumeration<? extends InputStream> e) 
          通过记住参数来初始化新创建的 SequenceInputStream，
		  该参数必须是生成运行时类型为 InputStream 对象的 Enumeration
		*/
		
		
		//只有集合Vector里面才有Enumeration
		Vector<FileInputStream> v = new Vector<FileInputStream>();

		v.add(new FileInputStream("1.txt"));
		v.add(new FileInputStream("2.txt"));
		v.add(new FileInputStream("3.txt"));

		Enumeration<FileInputStream> en = v.elements();

		//创建对象:
		SequenceInputStream sis = new SequenceInputStream(en);

		//创建目的：
		FileOutputStream fos = new FileOutputStream("4.txt");

		//建立一个缓冲区
		byte[] buf = new byte[1024];

		int len = 0;
		while ((len= sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();

	}
}
