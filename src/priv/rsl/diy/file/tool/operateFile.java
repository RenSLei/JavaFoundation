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
     * @Description TODO  ��ָ��Ŀ¼�µ�����ָ�����ļ�����д��ָ����List<file>������
     * @param dir һ��Ŀ¼
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
     * @Description TODO ��list�е��ļ���������Ӧ���ļ����ľ���·��д��ָ�����ļ���  
     * @param list 
     * @param txtFile Ŀ���ļ���·��
     * @throws IOException      
     * @Return int �������ļ�����      
     */
    public int writePathToFile(List<File> list, String txtFile) throws IOException {
	
	    // ע��Ҫ��������Ŀ�ģ�Դ���ټ����У�ʹ�ø�Ч������
	    BufferedWriter bufw = null;
	    // �����쳣
	    try {
		bufw = new BufferedWriter(new FileWriter(txtFile));
		//д���ļ�����
		bufw.write("�ļ�������"+list.size());		     
		bufw.newLine();	
		bufw.flush();
		// �����б�
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
     * @Description: TODO �˷�����list�����е��ļ������ʾ���ļ����Ƶ��µ��ļ���ȥ 1���µ��ļ�����Դ���ļ���
     *               2���µ��ļ�������ΪĿ�ģ�Դ����list�������ļ������ʾ���ļ� 3��ʹ�ø�Ч����,���и����ļ��Ĳ����� 4���ر���Դ
     * @param list
     *            �����java�����ļ�����ļ���
     * @param javaListFile
     *            ��Ŀ���ļ���
     * @throws IOException
     *             ��
     * @return int �������ļ�����
     *
     */
    public int copyFileToFolder(List<File> list, File DestinationFolder) throws IOException {
	//���ڴ�����Ҫ��д���Ŀ���ļ����ļ�����
	File tempFile = null;
	// ע��Ҫ��������Ŀ�ģ�Դ���ټ����У�ʹ�ø�Ч������
	BufferedReader bufr = null;
	BufferedWriter bufw = null;
	// �����쳣
	try {
	    for (File f : list) {
		// �����µ��ļ�����,��Ŀ���ļ���Ϊ��Ŀ¼��������ļ�������Ϊ�ļ���
		tempFile = new File(DestinationFolder, f.getName());
		if (f.getName() == null) {
		    throw new IllegalArgumentException("�ļ����ղ����쳣");
		}
//		// ��File�������µ��ļ�������Ϊ��
		if (tempFile.createNewFile())
		    System.out.println("create empty file:" + f.getName() + " successful!");
		
		//�ø�Ч������
		//��ȡ������
		bufr = new BufferedReader(new FileReader(f));
		//д�뻺����
		bufw = new BufferedWriter(new FileWriter(tempFile.toString()));
		// ��д�ļ�
		System.out.println("start copying file: " + tempFile.getName() + " ������>" + DestinationFolder.getName());
		String Line = null;
		//һ��һ�еĶ�ȡ��д���ݣ�֪����ȡ����һ��û������λ��
		while ((Line = bufr.readLine()) != null) {
		    //����ȡ����һ������д�뻺������
		    bufw.write(Line);
		    //����
		    bufw.newLine();
		    // ���������е�����д���ļ���
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
     *4������ÿһ��Ŀ¼���г���ǰĿ¼���ļ��б������ָ�����ļ�����ô�����ļ����Լ���ǰ��Ŀ¼��д��Ŀ���ļ��У�
     *	1)�õݹ鷨�����ļ�
     * 	2)ע����ƿո������Ĳ����ı仯���Լ��÷������߼�����Ҫ�ú����
     * 		����ÿһ���ļ��ж��ԣ����Ƚ������ļ��г�����ÿһ�����ļ���
     * 			1)������飺
     * 				��Ŀ¼�����������
     * 					n���ո�|---Ŀ¼��
     * 					���е���
     * 					��Ϊ��Ŀ¼������������������֮ǰ��n+5��ͻ���㼶��ϵ
     * 					...
     * 					���û�����ʱ�򣬽���ǰ��n-5�ص���ǰĿ¼�ո�������������֤����
     * 				���ļ������������
     * 					n���ո�---�ļ���
     * 					     ---�ļ���
     * 					 ���е���
     * 			2)bufw����Ϊ
     * 
     *	3)������ֻ��Ҫ����д�룬��ΪԴ���ļ���������ƣ����漰������˿���ʹ��BufferedWriter��װFileWriter
     * 	4)�漰д�ķ�ʽ��append��Write�����Ĳ�ͬ��append���ص��Ǵ��������write��ֱ��д���ļ���
     *  	5)ʹ��FileWriter�еĹ��췽����FileWriter(String fileName, boolean append) ��������Ϊtrue 
     * @param folder-��Ҫ�������ļ���
     * @param bufw-һ����װ��FileWriter��BufferedWriter������������д���Ч��
     * @return void 
     * @throws IOException
     */ 
     
     public void writeToFile(File folder, BufferedWriter bufw,String type) throws IOException {
 	//����ÿһ��Ŀ¼���ԣ�Ĭ��������û��Java�ļ��ģ�
// 	boolean flag = false;
 	// ����ÿһ���ļ�
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
 	    bufw.write("���ļ���Ϊ��");
 	    bufw.newLine();
 	}
     }
}
