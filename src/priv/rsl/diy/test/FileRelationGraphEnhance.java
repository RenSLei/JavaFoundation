package priv.rsl.diy.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* @ClassName: FileRelationGraph2 
* @Description: TODO 
*   描述：一个文件夹F下有n个子文件夹fn，每个fn下有n个文件或文件夹...
      需求：将FN中的Fn和其中的fn文件的映射关系做出来。
     如：获得一个文件夹，里面包含很多文本文件，内容如下：
     F1(文件名)
     |——f1 ----1.java ; 2.java ; 3.java		
     |——f2 ----1.java ; 2.java ; 3.java
      
     F2(文件名)
     |——f1 ----1.java ; 2.java ; 3.java		
     |——f2 ----1.java ; 2.java ; 3.java
      
      思路：
     1，将文件夹F中的文件夹列表f1....fn
      2，遍历F
      {将文件夹fn中.java文件对象存储到list集合中,
      将集合中的java文件名以及fn文件夹名写到F.txt文件中}
      
      步骤：
      1、获取键盘输入的目录：并封装成File对象
      2、获取目录下的子目录并存放在list集合中:定义一个函数，返回该list集合，用于下一步的遍历
      3、创建目标文件：
      	2)提示用户自己输入目标路径，在该路径下自己创建一个以F命名的txt文件：
      	异常处理：
      	try检查路径是否合法：{
      	3)检查输入是否为空，否则抛出异常提示
      	并重新进入要求用户输入的界面
      	4)抽象路径若存在，则在当前文件目录下创建一个以F命名的文件new File(对象.get)。
      	若路径不存在，则提示尝试创建该路径new File(F).mkdirs()，如果路径创建成功，则提示创建目标文件夹成功该路径，
      	如果创建失败，提示创建失败并抛出一个RuntimeException异常
      	}
      	5)catch 并打印此异常的信息：toString();并将标记置为true，继续循环提示用户输入路径。
      	}
      4、将2和3一起用一个函数实现：
      	使用参数"源文件"or"目标文件"、是否是要创建
      5、和基础需求不一样的是，将parent目录、day目录、sub目录三个层级进行循环查找写入
      	调用函数获取parent目录、objFolder.接着高级for循环，将遍历的每一个parent目录作为原来的parentFolder，在objFolder 下新建一个以
      	遍历元素命名的文件夹作为原来的objectFolder,将
* @author rsl
* @date 2018年2月5日 下午10:28:22 
*  
*/
public class FileRelationGraphEnhance {

    public static void main(String[] args) {
	Scanner in = null;
	// 获取源文件夹对象：
	System.out.println("please enter source folder：");
	in = new Scanner(System.in);
	File pparentFolder = folderByIn(false, in);
	System.out.println("please enter object folder：");
	// 获取目标文件夹对象：
	File objectFolder = folderByIn(true, in);
	in.close();
	List<File> parentFolders = getSubFolder(pparentFolder);
	for (File parentFolder : parentFolders) {
	    doubleDirHierarchy(parentFolder,objectFolder);
	}
    }
    
    //将基础功能用一个方法来说明,两个目录层级的遍历
    /** 
    * @Title: doubleDirHierarchy 
    * @Description: TODO -
    * 通过目录(文件的第二个父目录) 来获得关系：
  	对于每一个目录：列出当前目录的文件列表，如果是java文件，那么将该文件名以及当前的目录名写入目标文件中：
  	1)最好用递归法查找文件
  	2)如果有java文件，先将该目录名称追加到目标.txt中，再将java文件名追加到txt中
  	3)在这里只需要关心写入，因为源是文件对象的名称，不涉及读。因此使用FileWriter
  	4)涉及写的方式：append和Write方法的不同，append返回的是此输出流。write是直接写入文件。
  	使用FileWriter中的构造方法，FileWriter(String fileName, boolean append) 参数设置为true	
    * @param  parentFolder -文件的第二个父目录
    * @param  objectFolder -文件的目标存放位置文件夹
    * @return void
    * @throws 
    */
    public static void doubleDirHierarchy(File parentFolder,File objectFolder) {
	if (parentFolder.isDirectory()) {
	    // 获取子目录文件夹对象集合：
	    List<File> subFolderList = getSubFolder(parentFolder);
	    // 创建目标文件对象：
	    File objectFile = new File(objectFolder, parentFolder.getName() + ".txt");

	    // 在循环的外部定义引用
	    BufferedWriter bufw = null;
	    try {
		bufw = new BufferedWriter(new FileWriter(objectFile, true));
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }

	    // 遍历所有的二级目录：
	    for (File folder : subFolderList) {
		try {
		    if (folder.isFile() && folder.getName().endsWith(".java")) {
			bufw.write(folder.getName());
			bufw.newLine();
		    }

		    // 将java文件写入文本
		    if (folder.isDirectory()) {
			// 首先将文件夹的名称写入该文件
			bufw.write(folder.getName());
			writeToFile(folder, bufw);
		    }
		} catch (IOException e) {
		    System.out.println("写入数据失败！");
		    e.printStackTrace();
		}
	    }

	    // 关闭流bufw
	    try {
		if (bufw != null)
		    bufw.close();
	    } catch (IOException e) {
		System.out.println("关闭流失败！");
		e.printStackTrace();
	    }
	}

    }
    /**
    * @Title: writeToFile 
    * @Description: TODO -
    *4、对于每一个目录：列出当前目录的文件列表，如果是java文件，那么将该文件名以及当前的目录名写入目标文件中：
    *	1)最好用递归法查找文件
    * 	2)如果有java文件，先将该目录名称追加到目标.txt中，再将java文件名追加到txt中
    *	3)在这里只需要关心写入，因为源是文件对象的名称，不涉及读。因此可以使用BufferedWriter包装FileWriter
    * 	4)涉及写的方式：append和Write方法的不同，append返回的是此输出流。write是直接写入文件。
    *  	使用FileWriter中的构造方法，FileWriter(String fileName, boolean append) 参数设置为true 
    * @param folder-需要操作的文件夹
    * @param bufw-一个包装了FileWriter的BufferedWriter流缓冲对象，提高写入的效率
    * @return void 
    * @throws IOException
    */
    public static void writeToFile(File folder, BufferedWriter bufw) throws IOException {
	boolean flag = false;
	// 遍历每一个文件
	File[] files = folder.listFiles();
	for (File file : files) {
	    if (file.isDirectory()) {
		bufw.write(file.getName());
		writeToFile(file, bufw);
	    } else if (file.getName().endsWith(".java")) {
		bufw.write( "   ----"+file.getName() );
		flag = true;
	    }  
	}
	if(!(flag))
	    bufw.write( "   ----" );
	bufw.newLine();
	bufw.newLine();
	//bufw.close();
    }
    
    /**
     * @param in TODO 
    * @Title: folderByIn 
    * @Description: TODO -
    * 将用户输入的路径封装为File对象，可以选择是否创建新的抽象路径。判断此抽象路径是否存在且是一个目录：isDirectory()
    * 如果不存在,若参数为true,则创建文件对象。若参数为false,则重新调用该方法本身，再次提示获取正确的路径。
    * @param Info -源文件还是目标文件
    * @param create -用户是否要选择创建(若抽象路径不存在)
    * @return File -返回路径的文件对象
    * @throws 
    */
    public static File folderByIn(boolean create, Scanner in) {

	// 封装目录成为文件对象：
	File folder = new File(in.nextLine());

	// 若目录不存在或不是目录：
	if (!(folder.isDirectory())) {
	    System.out.println("Directory does not exist or it is not a Directory!");
	    if (create) {
		System.out.println("now try to create the new floder...");
		if (folder.mkdirs()) {
		    System.out.println("create object folder successful!");
		} else
		    throw new RuntimeException("create unsuccessful!");
	    } else {
		folderByIn(create, in);
	    }
	} else if(create) {
	    System.out.println("The folder is exist,your object file will be here:"+folder.toString());
	}else System.out.println("The access folder is valid.");    
	return folder;
    }
    
    /** 
    * @Title: getSubFloder 
    * @Description: TODO  
    * 该方法通过接受一个文件对象，将该对象下的文件以及文件夹对象存放在ArrayList集合中
    * @param file ——要操作的目录文件对象
    * @return List<File> ——包含文件以及文件夹的List<File>集合
    * @throws 
    */
    public static List<File> getSubFolder(File file) {
	List<File> subFolderList = new ArrayList<File>();
	File[] files = file.listFiles();
	for (File f : files) {
	    // 注意：此处是包含了文件夹以及文件
	    subFolderList.add(f);
	}
	return subFolderList;
    }

}
