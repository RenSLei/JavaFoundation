package priv.rsl.diy.file.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInputstr {

	//建立获取键盘输入的引用
	GetScannerStr gs = null;
	    /**   
	     * @Title getFileType   
	     * @Description TODO  获取用户从键盘输入的文件类型 
	     * @return      
	     * @Return String 文件类型，如：.txt     
	     */
	public String getFileType(String mesg) {
	    
	    	//实例化一个获取键盘输入的对象
	    	gs = new GetScannerStr(mesg);
	    
	    	//获取键盘输入
	    	String fileType= gs.getScanner();
		
		//用正则表达式检查是否合法
		String pattern = "\\.[a-z]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(fileType);
		if(!(m.matches())){
		    System.out.println("输入的文件类型不合法，请重新输入：");
		    getFileType(mesg);
		}
		return fileType;
		
	    }

	    /**   
	     * @Title getName   
	     * @Description TODO 从键盘获取用户输入的文件名 
	     * @return      
	     * @Return String  用户键盘输入的信息    
	     */
	 public String setName(String mesg) {
	     	//实例化一个获取键盘输入的对象
	    	gs = new GetScannerStr(mesg);
	
		return gs.getScanner();
		
	    }
	
	 /**   
	 * @Title getDir   
	 * @Description TODO   
	 * @param mesg
	 * @param flag
	 * @return File 
	 *
	 *       
	 */
	
	public File getDir(String mesg,Boolean flag) {
	    
	     	//实例化一个获取键盘输入的对象
	    	gs = new GetScannerStr(mesg);
		
		File dir = new File(gs.getScanner());
	  
		if(!(dir.exists())&&flag)
		{
		    System.out.println("输入目录不存在！正在创建该目录......");
		    if(dir.mkdirs()) {
			System.out.println("输入目录不存在，已创建输入目录！");
		    }
		    else {
			System.out.println("请按目录格式输入！如：c:\name1\name2...");
			getDir(mesg,true);
		    }
		}
		else if(!(dir.exists())){
		    System.out.println("路径不存在，请重新输入");
		    getDir(mesg,false);
		}
		return dir;
	    }
	    
	    
	    /**
	     * @throws IOException
	     * @Title: getSourceFolder
	     * @Description: TODO —根据传入的父目录，得到一个子目录list集合。
	     * @param parentDir
	     *            接收一个父目录字符串
	     *            如：parentDirectory
	     *            		|---Directory1
	     *            				|---file...
	     *            		|---Directory2
	     *            				|---file...
	     *            		|---Directory3
	     *            				|---file...
	     * @return List 返回一个存放了多个源文件夹对象的list集合，即要访问的文件夹对象
	     * 			如List<File>=={Directory1,Directory2,Directory3...}
	     */
	    public List<File> getSubDirs(File parentDir) {
		//建立List引用
		List<File> subDirs =new ArrayList<File>();	
		
		//判断合法性
		if (!(parentDir.exists())) {
		    
		    System.out.println("目录不存在！请重新检查目录！");
		    System.exit(0);
		}
		
		//构造新的File数组，存放目录下的文件夹
		File[] files = parentDir.listFiles();
		//遍历
		for (File file : files) {
		    //这个是关键，若不加这个判断，则若父目录中有文件，则会出现空指针异常
		    if(file.isDirectory())
			subDirs.add(file);
		}
		    return subDirs;
		}
}
