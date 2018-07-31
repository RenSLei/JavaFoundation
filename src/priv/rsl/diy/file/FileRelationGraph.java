package priv.rsl.diy.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import priv.rsl.diy.file.tool.GetInputstr;
import priv.rsl.diy.file.tool.operateFile;

/** 
* @ClassName: FileRelationGraph 
* @Description: TODO     
* 描述：给定一个文件夹，将该目录下的文件夹与指定类型的文件的所有映射关系做到用记事本保存起来。
     需求：将F中的文件夹和文件的映射关系做出来。
     如:
     Fn(文件夹)
     	|---f1(文件夹)
     		|---java文件......
     	|---f2(文件夹)
     		|---java文件......
     	|---f3(文件夹)
     		|---java文件......
    想要的到的结果：Fn.txt
	内容：	f1的文件夹名
			|---file1.java,file2.java...
		f2的文件夹名
			|---file1.java,file2.java...
     			...
    			
      思路：
     1，获取要搜索的文件夹对象
     2，获取要搜索的文件类型
     3，获取结果文件的路径
     4，在指定路径下以文件夹对象名创建一个txt文件
     5，创建输出流与txt文件相关
     6，递归调用文件夹，并将相关信息通过输出流写入txt
     
  注：只涉及写，且是字符流，用BufferedWriter包装FileWriter(File file)即可
          递归调用注意空格数量及层级的关系，算法比较重要
  
* @author rsl
* @date 2018年2月2日 下午1:41:03 
*  
*/
public class FileRelationGraph {
    
    public static void main(String[] args) {
	//创建用于获取键盘信息的工具类对象
	GetInputstr gs = new GetInputstr();
	//获取操作文件夹对象
	File parentFolder =gs.getDir("请输入要操作的文件夹路径：", false);
	
	String type = gs.getFileType("请输入文件类型(如  .txt):");
	// 获取目标文件夹对象：
	File objectFolder = gs.getDir("请输入目标文件夹：", true);
	
	//创建操作文件的类对象
	operateFile opf = new operateFile();
	//设置初始空格数为5
	operateFile.setN(5);
	
	// 创建目标文件对象：
	File objectFile = new File(objectFolder, parentFolder.getName() + ".txt");
	
	try {
	    //创建目标文件
	    objectFile.createNewFile();
	} catch (IOException e2) {
	    e2.printStackTrace();
	}
	
	//在循环的外部定义引用
	BufferedWriter bufw = null;
	try {
	    //创建输入流
	    bufw = new BufferedWriter(new FileWriter(objectFile, true));
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
		
	try {
	    //写入字符流到目标文件
	    opf.writeToFile(parentFolder,bufw,type);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	
	//关闭流bufw
	try {
	    if(bufw!=null)
		bufw.close();
	} catch (IOException e) {
	    System.out.println("关闭流失败！");
	    e.printStackTrace();
	}
    }
    
}

