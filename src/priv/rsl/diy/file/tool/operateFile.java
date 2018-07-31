package priv.rsl.diy.file.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class operateFile {
    static int n=5;

    public static void setN(int n) {
        operateFile.n = n;
    }


    /**   
     * @Title fileToList   
     * @Description TODO  将指定目录下的所有指定的文件对象写入指定的List<file>集合中
     * @param dir 一个目录
     * @param list 
     * @throws IOException      
     * @Return void      
     */
    public void fileToList(File dir, List<File> list,String type) throws IOException {
	File[] files = dir.listFiles();
	for (File file : files) {
	    if (file.isDirectory())
		fileToList(file,list,type);
	    else {
		if (file.getName().endsWith(type))
		    list.add(file);
	    }
	}
    }
    
    
    /**   
     * @Title writeToFile   
     * @Description TODO 将list中的文件对象所对应的文件名的绝对路径写入指定的文件中  
     * @param list 
     * @param txtFile 目标文件的路径
     * @throws IOException      
     * @Return int 操作的文件数量      
     */
    public int writePathToFile(List<File> list, String txtFile) throws IOException {
	
	    // 注意要操作的是目的，源是再集合中，使用高效缓冲器
	    BufferedWriter bufw = null;
	    // 处理异常
	    try {
		bufw = new BufferedWriter(new FileWriter(txtFile));
		//写入文件数量
		bufw.write("文件数量："+list.size());		     
		bufw.newLine();	
		bufw.flush();
		// 遍历列表：
		for (File f : list) {
		     System.out.println(f);	    
		     String path = f.getAbsolutePath();		     
		     bufw.write(path);		     
		     bufw.newLine();		     
		     bufw.flush();	     
		}	 
	    } catch (IOException e) {
		throw e;
	    }
	    finally {
		try {
		    if (bufw != null)
			bufw.close();
		} catch (IOException e) {
		    throw e;
		}
	    }
	    return list.size();
	}
    
    /**
     * @Title: writeToFile
     * @Description: TODO 此方法将list集合中的文件对象表示的文件复制到新的文件中去 1、新的文件名用源的文件名
     *               2、新的文件对象作为目的，源就是list集合中文件对象表示的文件 3、使用高效缓冲,进行复制文件的操作； 4、关闭资源
     * @param list
     *            —存放java具体文件对象的集合
     * @param javaListFile
     *            —目的文件夹
     * @throws IOException
     *             —
     * @return int 操作的文件数量
     *
     */
    public int copyFileToFolder(List<File> list, File DestinationFolder) throws IOException {
	//用于创建需要的写入的目标文件的文件对象
	File tempFile = null;
	// 注意要操作的是目的，源是再集合中，使用高效缓冲器
	BufferedReader bufr = null;
	BufferedWriter bufw = null;
	// 处理异常
	try {
	    for (File f : list) {
		// 构建新的文件对象,以目标文件夹为父目录，具体的文件名参数为文件名
		tempFile = new File(DestinationFolder, f.getName());
		if (f.getName() == null) {
		    throw new IllegalArgumentException("文件名空参数异常");
		}
//		// 用File对象构造新的文件，内容为空
		if (tempFile.createNewFile())
		    System.out.println("create empty file:" + f.getName() + " successful!");
		
		//用高效缓冲器
		//读取缓冲器
		bufr = new BufferedReader(new FileReader(f));
		//写入缓冲器
		bufw = new BufferedWriter(new FileWriter(tempFile.toString()));
		// 读写文件
		System.out.println("start copying file: " + tempFile.getName() + " ———>" + DestinationFolder.getName());
		String Line = null;
		//一行一行的读取并写数据，知道读取到下一行没有数据位置
		while ((Line = bufr.readLine()) != null) {
		    //将读取到的一行数据写入缓冲器中
		    bufw.write(Line);
		    //换行
		    bufw.newLine();
		    // 将缓冲器中的数据写入文件中
		    bufw.flush();
		}
		
		System.out.println("copy over!\n");
	    }
	  return list.size();
	    
	} catch (Exception e) {
	    throw e;
	} finally {
	    try {
		if (bufw != null)
		    bufw.close();
	    } catch (IOException e) {
		throw e;
	    }

	    try {
		if (bufr != null)
		    bufr.close();
	    } catch (IOException e) {
		throw e;
	    }
	}
    }
    
    /**
     * @Title: writeToFile 
     * @Description: TODO -
     *4、对于每一个目录：列出当前目录的文件列表，如果是指定的文件，那么将该文件名以及当前的目录名写入目标文件中：
     *	1)用递归法查找文件
     * 	2)注意控制空格数量的参数的变化，以及该方法的逻辑，需要好好理解
     * 		对于每一个文件夹而言，首先将其子文件列出，对每一个子文件：
     * 			1)类型审查：
     * 				是目录，该如何做？
     * 					n个空格|---目录名
     * 					换行到此
     * 					因为是目录，继续调用自身，调用之前将n+5，突出层级关系
     * 					...
     * 					调用回来的时候，将当前的n-5回到当前目录空格数的数量，保证对齐
     * 				是文件，该如何做？
     * 					n个空格---文件名
     * 					     ---文件名
     * 					 换行到此
     * 			2)bufw的行为
     * 
     *	3)在这里只需要关心写入，因为源是文件对象的名称，不涉及读。因此可以使用BufferedWriter包装FileWriter
     * 	4)涉及写的方式：append和Write方法的不同，append返回的是此输出流。write是直接写入文件。
     *  	5)使用FileWriter中的构造方法，FileWriter(String fileName, boolean append) 参数设置为true 
     * @param folder-需要操作的文件夹
     * @param bufw-一个包装了FileWriter的BufferedWriter流缓冲对象，提高写入的效率
     * @return void 
     * @throws IOException
     */ 
     
     public void writeToFile(File folder, BufferedWriter bufw,String type) throws IOException {
 	//对于每一层目录而言，默认里面是没有Java文件的，
// 	boolean flag = false;
 	// 遍历每一个文件
 	File[] files = folder.listFiles();
 	if(files.length!=0){
 	    for (File file : files) {
 		    if (file.isDirectory()) {
 			
 			for(int i=0;i<n;i++) {
 			    bufw.write("  ");
 			}
 			bufw.write("|--");
 			
 			bufw.write(file.getName()+"(folder)");
 			bufw.newLine();
 			n=(n+5);
 			writeToFile(file, bufw,type);
 			n=n-5;
 			
 		    } else if (file.getName().endsWith(type)) {
 			
 			for(int i=0;i<n;i++) {
 			    bufw.write("  ");
 			}
 			
 			bufw.write("---");
 			bufw.write(file.getName()+",");
 			bufw.newLine();
 			
 			
 			
// 			flag = true;
 		    }  
 		}
 	}
 	else {
 	    for(int i=0;i<n;i++) {
 		    bufw.write("  ");
 		}
 	    bufw.write("此文件夹为空");
 	    bufw.newLine();
 	}
     }
}
