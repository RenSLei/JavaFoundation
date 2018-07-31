package priv.rsl.IO_1;
/*
写一个自己的MyBufferedInputStream

*/

import java.io.*;
class MyBufferedInputStream 
{
	//私有化要传递进来的对象
	private InputStream in;

	//定义一个字节型的数组，用来临时存放读取到的字节
	private byte[] buf= new byte[1024];
	
	//定义指针和计数器
	private int pos= 0,count = 0;

	//构造函数
	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	//一次读一个字节，从缓冲区（字节数组）获取
	public int myRead() throws IOException
	{
		//通过in对象读取硬盘上的数据，并存储到buf中。
		if(count==0)
		{
			count = in.read(buf);
			
			//读到结尾处返回的是-1
			if(count<0)
				return -1;
			//每次重新从硬盘中读取数据到缓冲数组中都要将指针置为0
			pos= 0;

			//从0脚标取走
			byte b =buf[pos];
			count--;//取一次减一次
			pos++;//指针移动
			return b&0xff;//保留b字节的后八位二进制位
		}
		else if(count>0)
		{
			byte b =buf[pos];
			count--;
			pos++;
			return b&0xff;
		}
		return -1;
	}
	public void myClose() throws IOException
	{
		in.close();
	}
}
