package priv.rsl.IO_3;
/*
RandomAccessFile:应用：数据的分段写入，即多线程同时下载文件

该类不算是IO体系中的子类直接继承Object
但是他是IO包中的成员，因为它具备读取和写入功能

内部封装了一个数组，而且通过指针对数组的元素进行操作
可以通过getFilePointer获取指针位置
同时也可以通过seek改变指针的位置

其实完成读和写的原理就是内部封装了字节输出和输入流

通过构造函数可以发现：该类只能操作文件
而且操作文件还有模式:只读，r   读写：rw

如果模式为只读的r，不会创建文件，会去读取一个已经存在的文件，如果该文件不存在，则会出现异常
如果模式为rw，操作的文件不存在会自动创建，如果存在则不会覆盖。

*/

//
import java.io.*;
class RandomAccessFileDemo 
{
	public static void main(String[] args) throws IOException
	{
		//writeFile();	
		//readFile();
		writeFile_2();
	}

	public static void readFile()throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");

		//调整指针：-----重点：
		//raf.seek(8);//将指针位置移到第9个字节处
		//结果就是：name=张三age=99

		//跳过指定的字节数：只能往后跳
		raf.skipBytes(8);

		byte[] buf = new byte[4];//建立一个4个字节的缓冲数组

		raf.read(buf);

		String name = new String(buf);

		int age = raf.readInt();//一次读完一个4个字节后，指针到了指向年龄的地方，此时再读刚好能读到指针

		System.out.println("name="+name+"age="+age);
	}
	

	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("李四".getBytes());

		//raf.write(258);//注意：write是写的最低8位（两个字节），这样引起了数据的丢失

		raf.writeInt(97);//按照四个字节写入

		raf.write("张三".getBytes());

		raf.writeInt(99);

		raf.close();
	}

	public static void writeFile_2() throws IOException//随机写
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		
		//在指定的位置写数据：假如想在第4个8位写数据
		raf.seek(8*3);

		raf.write("周七".getBytes());//而且可以随机位置的写入，不会覆盖数据

		raf.writeInt(103);
		
		//写完之后的ran.txt的内容：李四   a张三   c        周七   g
	}
}
