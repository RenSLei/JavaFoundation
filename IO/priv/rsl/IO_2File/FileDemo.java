package priv.rsl.IO_2File;
/*
day20-02-io-File对象的功能-创建和删除

File类常见的方法：
1、创建
	boolean createNewFile():在指定的位置上创建文件，如果该文件已经存在，则不创建，返回false。
							和输出流不一样，输出流一建立创建文件，而且文件已经存在，会覆盖。

	boolean mkdir()创建文件夹
	boolean mkdirs()创建多级文件夹
2、删除
	boolean delete();删除失败返回false.
	void deleteOnExit();在程序退出时删除指定文件。

3、判断
	用的最多的：boolean exists()
	判断是否是文件：isFile()
	判断是否是路径：isDirectory()
	判断抽象路径表示的文件是否是隐藏的文件：isHidden()
	测试此抽象路径名是否为绝对路径名:isAbsolute() 

4、获取信息
	getName():
	getPath():
	getAbsolutePath():
	getParent()：

	long lastModified() 返回此抽象路径名表示的文件最后一次被修改的时间。
	length()

*/


import java.io.*;
class FileDemo 
{
	public static void main(String[] args)  throws IOException
	{
		Method_4();
	}
	public static void Method_1() throws IOException//演示创建和删除
	{
		File f =new File("file.txt");

		//若是创建的文件想要在最后删除，比如临时文件，则可以用：
		//f.deleteOnExit();//不管在该文件或目录操作过程中出现何种状况(异常)，最后都会删除
		
		//创建文件：
		sop("create:"+f.createNewFile());
		
		//创建文件夹（路径）：
		File dir =new File("文件夹1\\文件夹2\\文件夹3");//默认的是当前路径
		sop("mkdir:"+dir.mkdirs());

		//sop("delete:"+f.delete());
	}

	public static void Method_2()throws IOException//演示判断
	{
		//判断里有很多，如文件是否可执行、可读、可写、是否存在该路径或文件
		File f1 = new File("FileDemo.java");

		//最常用的方法：exists()
		sop("exists:"+f1.exists());//是存在的true

		File f2 = new File("file.txt");


		if(f1.exists())//先判断
			sop("f1:isFile:"+f1.isFile());  //是文件:true
		else sop("f1不存在");
		
		if(f2.exists())//先判断
		{
			sop("f2:isFile:"+f2.isFile());

			sop("f2:isDirectory:"+f2.isDirectory());
		}
		else sop("f2不存在");
		//^-^在判断文件对象是否是文件或者路径时，必须要用exists()先判断文件对象封装的内容是否存在

		File f3 = new File("C:\\Users\\78658\\OneDrive\\java\\day20_IO_File");
		sop(f3.isAbsolute());//带着盘符号就视为是true
		
	}

	public static void Method_3()
	{
		File f = new File("a.txt");	//文件实际不存在
		sop("path:"+f.getPath());//封装的是什么路径就是什么路径，与文件是否存在无关
		sop("Abspath:"+f.getAbsolutePath());//绝对路径，与文件是否存在无关
		sop("parent:"+f.getParent());//返回的是绝对路径中的文件父目录，如果获取的是相对路径，则返回的是null
		//如果相对路径中有上一级目录，那么就返回此目录

	}
	
	public static void Method_4()
	{
		File f1 = new File("Test.java");	
		File f2 = new File("haha.java");	

		sop("rename:"+f1.renameTo(f2));//将Test.java名字改为haha.java
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
运行结果：
exists:true
f1:isFile:true
f2:isFile:false
f2:isDirectory:true

*/
