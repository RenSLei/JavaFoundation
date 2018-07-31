package priv.rsl.diy.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import priv.rsl.diy.file.tool.GetInputstr;
import priv.rsl.diy.file.tool.operateFile;

/*
练习：提取指定目录下的指定类型的文件路径
将一个指定目录下的所有Java文件的绝对路径，存储到一个文本文件中。
建立一个Java文件列表文件。

思路：
1，对指定的目录进行递归
2，获取递归过程中所有的Java文件的路径
3，将这些路径存储到集合中。
4.将集合中的数据写入一个文件中。

*/

class SearchFilesPath {
    public static void main(String[] args) throws IOException {
	
	//创建从键盘获取信息的工具类对象
	GetInputstr gi= new GetInputstr();
	
	//创建读写文件的工具类
	operateFile opf=new operateFile();
	
	//获取想要搜索的文件夹路径，封装成file对象
	File dir=gi.getDir("请输入要搜索的文件夹路径：",false);
	
	//获取想要搜索的文件类型
	String fileType= gi.getFileType("请输入想要查找的文件类型(如.txt):");
	
	//创建list用于存储指定文件目录下的指定文件的file对象
	List<File> list = new ArrayList<File>();
	
	//调用fileToList方法，将返回结果赋给list
	opf.fileToList(dir, list,fileType);

	// 从键盘获取用户输入的目标文件名字
	String s= gi.setName("请输入想要命名的文件名:");
	
	//封装目标文件为file对象，默认文件路径在用户想要查找的文件夹里
	File txtFile = new File(dir,s+".txt");
	
	//将list里的文件路径写入目标文件中，返回写入的文件数量
	int n = opf.writePathToFile(list,txtFile.toString());
	System.out.println("操作完成,文件数量："+n);

    }
   

}

