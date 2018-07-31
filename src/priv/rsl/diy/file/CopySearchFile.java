package priv.rsl.diy.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import priv.rsl.diy.file.tool.GetInputstr;
import priv.rsl.diy.file.tool.operateFile;

/** 
* @ClassName: FindJavaFile 
* @Description: TODO 将一个文件夹下的所有指定类型的文件找出来并复制到另外一个文件夹中  
* 需求分析：输入想要查找的目录，将文件夹下指定类型文件找出并复制到另一个文件夹中
分析：
1、操作的是文本文档用writer或reader
2、涉及源和目的，因此将用到io以及File对象
3、因为要涉及临时存储，因此涉及集合
4、涉及一层一层的查找，用到递归的思想

思路：
1、将要找的文件夹的路径先封装成一个File对象
2、建立list集合
3、递归调用，将符合规则的文件添加到list集合中

达到的效果：
给出目录parentDirectory，
以子目录Directory名分别建立文件夹将里面（不管是否还有文件夹）的所有指定类型的文件写入到该对应的文件夹中
原：parentDirectory
     *            |---Directory1
     *            			|---file or Folder...
     *            |---Directory2
     *            			|---file or Folder...
     *            |---Directory3
     *            			|---file or Folder...
     *            
终：目标文件夹
	|---Directory1
		|---Directory1下所有指定类型的文件
        |---Directory2
        	|---Directory2下所有指定类型的文件
        ...
        
* @author rsl
* @date 2018年1月29日 下午4:32:23 
*  
*/
public class CopySearchFile {
    
    private static int n;
    
    public static void main(String[] args) {
	//建立用于获取键盘输入的对象
	GetInputstr gi=new GetInputstr();
	
	//创建读写文件的工具类
	operateFile opf=new operateFile();
	
	//读取键盘录入的源文件夹：
	File parentDir = gi.getDir("请输入被搜索的文件夹路径:",false);
	
	//获取想要搜索的文件类型
	String fileType= gi.getFileType("请输入想要查找的文件类型(如:.txt):");
	
	System.out.println("你想搜索的文件夹路径为："+parentDir+"\r\n"+"搜索文件类型为："+fileType);
	
	//读取键盘录入的源文件夹：
	File desFolder = gi.getDir("请输入目标文件夹路径：",true);
	
	//子目录集合
	List<File> subDirs = new ArrayList<File>();
	
	// 获取subDirs
	subDirs = gi.getSubDirs(parentDir);
	
	for (File subDir : subDirs) {
	    
	    List<File> filesList = new ArrayList<File>();
	    try {
		
		opf.fileToList(subDir, filesList,fileType);
		
	    } catch (IOException e) {
		
		e.printStackTrace();
	    }
	    
	    //获取目标文件夹的名称
	    File eachDesFolder=new File(desFolder,subDir.getName());
	    if(eachDesFolder.mkdirs()) {
		System.out.println("create the folder"+subDir.getName()+" in "+desFolder+"   successful");
	    }
	    try {
		n+=opf.copyFileToFolder(filesList, eachDesFolder);
		
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	System.out.println("操作的文件数："+n);
    }
}

