package priv.rsl.diy.file.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInputstr {

	//������ȡ�������������
	GetScannerStr gs = null;
	    /**   
	     * @Title getFileType   
	     * @Description TODO  ��ȡ�û��Ӽ���������ļ����� 
	     * @return      
	     * @Return String �ļ����ͣ��磺.txt     
	     */
	public String getFileType(String mesg) {
	    
	    	//ʵ����һ����ȡ��������Ķ���
	    	gs = new GetScannerStr(mesg);
	    
	    	//��ȡ��������
	    	String fileType= gs.getScanner();
		
		//��������ʽ����Ƿ�Ϸ�
		String pattern = "\\.[a-z]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(fileType);
		if(!(m.matches())){
		    System.out.println("������ļ����Ͳ��Ϸ������������룺");
		    getFileType(mesg);
		}
		return fileType;
		
	    }

	    /**   
	     * @Title getName   
	     * @Description TODO �Ӽ��̻�ȡ�û�������ļ��� 
	     * @return      
	     * @Return String  �û������������Ϣ    
	     */
	 public String setName(String mesg) {
	     	//ʵ����һ����ȡ��������Ķ���
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
	    
	     	//ʵ����һ����ȡ��������Ķ���
	    	gs = new GetScannerStr(mesg);
		
		File dir = new File(gs.getScanner());
	  
		if(!(dir.exists())&&flag)
		{
		    System.out.println("����Ŀ¼�����ڣ����ڴ�����Ŀ¼......");
		    if(dir.mkdirs()) {
			System.out.println("����Ŀ¼�����ڣ��Ѵ�������Ŀ¼��");
		    }
		    else {
			System.out.println("�밴Ŀ¼��ʽ���룡�磺c:\name1\name2...");
			getDir(mesg,true);
		    }
		}
		else if(!(dir.exists())){
		    System.out.println("·�������ڣ�����������");
		    getDir(mesg,false);
		}
		return dir;
	    }
	    
	    
	    /**
	     * @throws IOException
	     * @Title: getSourceFolder
	     * @Description: TODO �����ݴ���ĸ�Ŀ¼���õ�һ����Ŀ¼list���ϡ�
	     * @param parentDir
	     *            ����һ����Ŀ¼�ַ���
	     *            �磺parentDirectory
	     *            		|---Directory1
	     *            				|---file...
	     *            		|---Directory2
	     *            				|---file...
	     *            		|---Directory3
	     *            				|---file...
	     * @return List ����һ������˶��Դ�ļ��ж����list���ϣ���Ҫ���ʵ��ļ��ж���
	     * 			��List<File>=={Directory1,Directory2,Directory3...}
	     */
	    public List<File> getSubDirs(File parentDir) {
		//����List����
		List<File> subDirs =new ArrayList<File>();	
		
		//�жϺϷ���
		if (!(parentDir.exists())) {
		    
		    System.out.println("Ŀ¼�����ڣ������¼��Ŀ¼��");
		    System.exit(0);
		}
		
		//�����µ�File���飬���Ŀ¼�µ��ļ���
		File[] files = parentDir.listFiles();
		//����
		for (File file : files) {
		    //����ǹؼ�������������жϣ�������Ŀ¼�����ļ��������ֿ�ָ���쳣
		    if(file.isDirectory())
			subDirs.add(file);
		}
		    return subDirs;
		}
}
