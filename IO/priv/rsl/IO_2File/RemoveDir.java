package priv.rsl.IO_2File;
/*
删除一个带内容的目录
删除原理：
在windows中，删除目录从里面往外删除


从里面往外面删除就要用到递归的方法

*/


import java.io.*;
class  RemoveDir
{
	public static void main(String[] args) 
	{
		File dir = new File("E:\\day20-Io-删除文件及目录test");
		removeDir(dir);

	}

	public static void removeDir(File dir)
	{
		File[] files = dir.listFiles();

		for (int x= 0;x<files.length;x++ )
		{
			if(files[x].isDirectory())
				removeDir(files[x]);
			else 
				sop(files[x].toString()+"-file-"+files[x].delete());
		}

		//删除完一个文件夹里的文件后，就把这个文件夹删除
		sop(dir+"::dir::"+dir.delete());

	}

	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
