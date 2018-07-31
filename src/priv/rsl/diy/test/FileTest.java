package priv.rsl.diy.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    public static void main(String[] args) {
	
	List<File> listf=new ArrayList<>();
	File f = new File("F:\\java\\一、javaSE\\day04_数组\\ArrayTest1.java");
	File ff = new File("F:\\java\\一、javaSE\\day04_数组\\");
	
	listf.add(f);
	File f2=new File("F:\\java");
	try {
	    copyFileToFolder(listf,f2);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
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
    public static int copyFileToFolder(List<File> list, File DestinationFolder) throws IOException {
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
		System.out.println(tempFile.getAbsoluteFile());
		if (f.getName() == null) {
		    throw new IllegalArgumentException("文件名空参数异常");
		}
		// 用File对象构造新的文件，内容为空
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


}
