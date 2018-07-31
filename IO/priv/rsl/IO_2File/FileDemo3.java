package priv.rsl.IO_2File;
/*

列出指定目录下文件或者文件夹，包含子目录的内容
也就是列出指定目录下的所有内容

因为目录中还有目录，只要用同一个列出目录功能的函数即可
在列出过程中出现的还是目录的话，还可以再次调用本功能
也就是函数自身调用自身
这种表现形式或者编程手法叫做递归。

递归要注意的：
1.限定条件
2.注意递归的次数，避免内存溢出

*/


import java.io.*;
class FileDemo3 
{
	public static void main(String[] args) 
	{
		File dir = new File ("C:\\Users\\78658\\OneDrive");
		showDir(dir);
	}

	//打印下目录下的文件及目录名
	public static void showDir(File dir)
	{
		//listFiles()返回的是File类的对象
		File[] files = dir.listFiles();
		
		sop("\n目录："+dir.getName()+"   "+"filesNum="+files.length+"\n");
		for (int x=0;  x<files.length; x++)
		{
			//过滤掉一些文件目录
			String name =files[x].getName();
			if(name.endsWith("重要文件")||name.endsWith("主要任务")||name.endsWith("api"))
				continue;
			else
			//对于File数组中的每个成员判断是否是目录
			if(files[x].isDirectory())
				showDir(files[x]);
			else
				sop(files[x]);
		}

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
