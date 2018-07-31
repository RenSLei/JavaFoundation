package priv.rsl.IO_2File;
/*
演示将一个图片切割成几个碎片文件
再讲这个碎片文件合成一个新的图片
*/

import java.io.*;
import java.util.*;
class  SplitDemo
{
	public static void main(String[] args) throws IOException
	{
		//splitFile();
		merge();
	}

	//将一个图片切割成三个碎片文件
	public static void splitFile() throws IOException
	{
		//源是一个图片，将字节读取流和图片关联
		FileInputStream fis = new FileInputStream("E:\\1.jpg");
		
		//在外部建立字节写入流的引用；
		FileOutputStream fos = null;

		//建立一个缓冲区
		byte[] buf = new byte[1024*1024];//一M的缓冲区

		int len = 0;
		
		int count = 1;

		//循环读取和写入流
		while ((len=fis.read(buf))!=-1)
		{
			//表示此时往缓冲区里面存入了1M的数据
			//建立目的
			fos = new FileOutputStream("E:\\splitfiles\\"+(count++)+".part");

			//写入流
			fos.write(buf,0,len);
			
			//关流
			fos.close();
		}

	}

	//合成图片
	/*
	分析：1.	因为SequenceInputStream串联流的时候的要求参数是Enumeration，而且是被
				生成运行时类型为 InputStream 对象的 Enumeration
		2.而且读取流是很多个，所以想到用集合，ArrayList<FileInputStream>(效率高)
		3.然后又因为ArrayList里面没有Enumeration，所以想到迭代器iterator

		

	*/
	public static void merge()throws IOException
	{
		//第一步：建立ArrayList数组
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		//添加元素
		for (int x = 1;x<3 ;x++ )
		{
			al.add(new FileInputStream("E:\\splitfiles\\"+x+".part"));
		}

		//使用迭代器,且因为是匿名内部类使用final 修饰
		final Iterator<FileInputStream> it = al.iterator();

		//建立Enumeration,使用匿名内部类
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>()
		{
			//覆盖接口的两个方法：
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}

			public FileInputStream nextElement()
			{
				return it.next();
			}
		};

		//将en传递进SequenceInputStream
		SequenceInputStream sis = new SequenceInputStream(en);

		//建立目的：
		FileOutputStream fos = new FileOutputStream("E:\\splitfiles\\0.jpg");

		byte[] buf =new byte[1024];

		int len = 0 ;

		while ((len = sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
		}

		fos.close();
		sis.close();


	}
}
