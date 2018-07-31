package priv.rsl.IO_2File;
/*

演示文件列表list等一系列方法

*/


import java.io.*;
class FileDemo2 
{
	public static void main(String[] args) 
	{
		listFilesDemo();
	}

	public static void listFilesDemo()
	{
		File dir = new File ("C:\\Users\\78658\\OneDrive");

		//返回的是File对象,可以调用一系列方法，应用较广
		File[] files =dir.listFiles();

		for (File f : files)
		{
			sop("name:"+f.getName()+"------>len:"+f.length());
		}
	}
	
	//list(FilenameFilter Filter):返回一个字符串数组
	//这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。
	public static void listDemo2()
	{
		File dir = new File("C:\\Users\\78658\\OneDrive");
		
		//list重载方法里接受的是一个接口：FilenameFilter，该接口只有一个方法，所以可以直接使用匿名内部类
		String[] someNames = dir.list(new FilenameFilter()
		{
			//覆盖掉其中的方法：accept()
			//dir指的是File对象，name就是需要过滤的文件名
			public boolean accept(File dir,String name)
			{
				//需求是当文件名是以.jpg结束的时候返回true
				return name.endsWith(".jpg");

			}
		});
		for (String name :someNames)
		{
			sop(name);
		}

		/*
		结果：	2017-2018校历.jpg
				QQ图片20171105231537.jpg
		*/
	}



	//list():返回的是一个String类的数组，内容是抽象路径名下的文件名和目录名
	public static void listDemo()
	{
		File f = new File("c:\\");

		String[] names = f.list();//调用list方法的file对象必须是封装了一个目录，该目录还必须存在。
		for (String name :names)
		{
			sop(name);
		}
	}



	//listRoots():直接用File.listRoots()，获取本机盘符
	public static void listRootsDemo()
	{
		File[] files  = File.listRoots();//获取本机的盘符

		for (File f : files)
		{
			sop(f);
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
