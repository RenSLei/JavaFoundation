package priv.rsl.IO_2File;
/*
练习：提取指定类型的文件路径
将一个指定目录下的Java文件的绝对路径，存储到一个文本文件中。
建立一个Java文件列表文件。


思路：
1，对指定的目录进行递归
2，获取递归过程中所有的Java文件的路径
3，将这些路径存储到集合中。
4.将集合中的数据写入一个文件中。



*/

import java.util.*;
import java.io.*;
class  JavaFileList
{
	public static void main(String[] args) throws IOException
	{
		File dir = new File("C:\\Users\\78658\\OneDrive\\java");
		
		List<File> list = new ArrayList<File>();
		fileToList(dir,list);

		//创建目标文件，传递参数
		File file = new File(dir,"javalist.txt");
		writeToFile(list,file.toString());


		
	}

	//将文件存储到list集合中，需要路径和集合作为参数
	public static void fileToList(File dir,List<File> list) throws IOException
	{
		File[] files = dir.listFiles();

		for(File file : files)
		{
			if(file.isDirectory())
				fileToList(file,list);
			else
				{
					if(file.getName().endsWith(".java"))
						list.add(file);
				}
		}
	}

	//完成第4步，将集合中的数据写入文件中；
	public static void writeToFile(List<File> list,String javaListFile) throws IOException
	{
	{
		//注意要操作的是目的，源是再集合中，使用高效缓冲器
		BufferedWriter bufw=null;
		//处理异常
		try
		{
			bufw= new BufferedWriter(new FileWriter(javaListFile));
			
			//遍历列表：
			for (File f: list )
			{
				//获取路径
				String path = f.getAbsolutePath();

				//将路径写入缓冲区
				bufw.write(path);

				//换行
				bufw.newLine();

				//刷新一次
				bufw.flush();
			}
			
		}
		catch (IOException e)
		{
			throw e;
		}

		finally
		{
			try
			{
				if(bufw!=null)
					bufw.close();
			}
			catch (IOException e)
			{
				throw e;
			}
		}
	}
}
}
