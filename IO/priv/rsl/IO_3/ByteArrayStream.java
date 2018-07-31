package priv.rsl.IO_3;
/*
用于操作字节数组的流对象:
特点：
ByteArrayInputStream:构造的时候需要接受一个字节数组源。
ByteArrayOutputStream:构造的时候不用定义数据目的，因为该对象中已经内部封装了可变长度的字节数组
这就是数据的目的

这两个流对象都是操作的数组没有使用系统资源。所以不用进行close关闭。


源：
	键盘：System.in 硬盘：FileStream 内存：ArrayStream
目的：
	控制台：System.out 硬盘：FileStream 内存：ArrayStream 


*/


import java.io.*;
class ByteArrayStream
{
	public static void main(String[] args)
	{
		//
		ByteArrayInputStream bis = new ByteArrayInputStream("JKHGFUIHR".getBytes());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		int by = 0;
		while((by=bis.read())!=-1)
		{
			bos.write(by);
		}

		System.out.println(bos.size());
		System.out.println(bos.toString());
	}
}
