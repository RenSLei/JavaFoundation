package priv.rsl.IO_2File;


/*

列出指定目录下文件或者文件夹，包含子目录的内容
也就是列出指定目录下的所有内容

列出所有目录下所有内容，并带有层次


*/


import java.io.*;
class FileDemo4 
{
	public static void main(String[] args) 
	{
		File dir = new File ("C:\\Users\\78658\\OneDrive\\java\\day20_IO_File");
		showDir(dir,0);
	}
	
	//写一个方法，添加偏移符号的函数
	public static String getLevel(int level)
	{

		StringBuilder sb = new StringBuilder();
		for (int x=0; x<level;x++ )
		{
			sb.append("|---");
		}
		
		return sb.toString();

	}
	//打印下目录下的文件及目录名
	public static void showDir(File dir,int level)
	{
		//listFiles()返回的是File类的对象
		File[] files = dir.listFiles();
		
		sop(getLevel(level)+dir.getName()+"   "+"filesNum="+files.length+"\n");
		level++;

		for (int x=0;  x<files.length; x++)
		{
			//对于File数组中的每个成员判断是否是目录
			if(files[x].isDirectory())
				showDir(files[x],level);
			else
				sop(getLevel(level)+files[x]);
		}

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
