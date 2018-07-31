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
*   ������һ���ļ���F����n�����ļ���fn��ÿ��fn����n���ļ����ļ���...
      ���󣺽�FN�е�Fn�����е�fn�ļ���ӳ���ϵ��������
     �磺���һ���ļ��У���������ܶ��ı��ļ����������£�
     F1(�ļ���)
     |����f1 ----1.java ; 2.java ; 3.java		
     |����f2 ----1.java ; 2.java ; 3.java
      
     F2(�ļ���)
     |����f1 ----1.java ; 2.java ; 3.java		
     |����f2 ----1.java ; 2.java ; 3.java
      
      ˼·��
     1�����ļ���F�е��ļ����б�f1....fn
      2������F
      {���ļ���fn��.java�ļ�����洢��list������,
      �������е�java�ļ����Լ�fn�ļ�����д��F.txt�ļ���}
      
      ���裺
      1����ȡ���������Ŀ¼������װ��File����
      2����ȡĿ¼�µ���Ŀ¼�������list������:����һ�����������ظ�list���ϣ�������һ���ı���
      3������Ŀ���ļ���
      	2)��ʾ�û��Լ�����Ŀ��·�����ڸ�·�����Լ�����һ����F������txt�ļ���
      	�쳣����
      	try���·���Ƿ�Ϸ���{
      	3)��������Ƿ�Ϊ�գ������׳��쳣��ʾ
      	�����½���Ҫ���û�����Ľ���
      	4)����·�������ڣ����ڵ�ǰ�ļ�Ŀ¼�´���һ����F�������ļ�new File(����.get)��
      	��·�������ڣ�����ʾ���Դ�����·��new File(F).mkdirs()�����·�������ɹ�������ʾ����Ŀ���ļ��гɹ���·����
      	�������ʧ�ܣ���ʾ����ʧ�ܲ��׳�һ��RuntimeException�쳣
      	}
      	5)catch ����ӡ���쳣����Ϣ��toString();���������Ϊtrue������ѭ����ʾ�û�����·����
      	}
      4����2��3һ����һ������ʵ�֣�
      	ʹ�ò���"Դ�ļ�"or"Ŀ���ļ�"���Ƿ���Ҫ����
      5���ͻ�������һ�����ǣ���parentĿ¼��dayĿ¼��subĿ¼�����㼶����ѭ������д��
      	���ú�����ȡparentĿ¼��objFolder.���Ÿ߼�forѭ������������ÿһ��parentĿ¼��Ϊԭ����parentFolder����objFolder ���½�һ����
      	����Ԫ���������ļ�����Ϊԭ����objectFolder,��
* @author rsl
* @date 2018��2��5�� ����10:28:22 
*  
*/
public class FileRelationGraphEnhance {

    public static void main(String[] args) {
	Scanner in = null;
	// ��ȡԴ�ļ��ж���
	System.out.println("please enter source folder��");
	in = new Scanner(System.in);
	File pparentFolder = folderByIn(false, in);
	System.out.println("please enter object folder��");
	// ��ȡĿ���ļ��ж���
	File objectFolder = folderByIn(true, in);
	in.close();
	List<File> parentFolders = getSubFolder(pparentFolder);
	for (File parentFolder : parentFolders) {
	    doubleDirHierarchy(parentFolder,objectFolder);
	}
    }
    
    //������������һ��������˵��,����Ŀ¼�㼶�ı���
    /** 
    * @Title: doubleDirHierarchy 
    * @Description: TODO -
    * ͨ��Ŀ¼(�ļ��ĵڶ�����Ŀ¼) ����ù�ϵ��
  	����ÿһ��Ŀ¼���г���ǰĿ¼���ļ��б������java�ļ�����ô�����ļ����Լ���ǰ��Ŀ¼��д��Ŀ���ļ��У�
  	1)����õݹ鷨�����ļ�
  	2)�����java�ļ����Ƚ���Ŀ¼����׷�ӵ�Ŀ��.txt�У��ٽ�java�ļ���׷�ӵ�txt��
  	3)������ֻ��Ҫ����д�룬��ΪԴ���ļ���������ƣ����漰�������ʹ��FileWriter
  	4)�漰д�ķ�ʽ��append��Write�����Ĳ�ͬ��append���ص��Ǵ��������write��ֱ��д���ļ���
  	ʹ��FileWriter�еĹ��췽����FileWriter(String fileName, boolean append) ��������Ϊtrue	
    * @param  parentFolder -�ļ��ĵڶ�����Ŀ¼
    * @param  objectFolder -�ļ���Ŀ����λ���ļ���
    * @return void
    * @throws 
    */
    public static void doubleDirHierarchy(File parentFolder,File objectFolder) {
	if (parentFolder.isDirectory()) {
	    // ��ȡ��Ŀ¼�ļ��ж��󼯺ϣ�
	    List<File> subFolderList = getSubFolder(parentFolder);
	    // ����Ŀ���ļ�����
	    File objectFile = new File(objectFolder, parentFolder.getName() + ".txt");

	    // ��ѭ�����ⲿ��������
	    BufferedWriter bufw = null;
	    try {
		bufw = new BufferedWriter(new FileWriter(objectFile, true));
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }

	    // �������еĶ���Ŀ¼��
	    for (File folder : subFolderList) {
		try {
		    if (folder.isFile() && folder.getName().endsWith(".java")) {
			bufw.write(folder.getName());
			bufw.newLine();
		    }

		    // ��java�ļ�д���ı�
		    if (folder.isDirectory()) {
			// ���Ƚ��ļ��е�����д����ļ�
			bufw.write(folder.getName());
			writeToFile(folder, bufw);
		    }
		} catch (IOException e) {
		    System.out.println("д������ʧ�ܣ�");
		    e.printStackTrace();
		}
	    }

	    // �ر���bufw
	    try {
		if (bufw != null)
		    bufw.close();
	    } catch (IOException e) {
		System.out.println("�ر���ʧ�ܣ�");
		e.printStackTrace();
	    }
	}

    }
    /**
    * @Title: writeToFile 
    * @Description: TODO -
    *4������ÿһ��Ŀ¼���г���ǰĿ¼���ļ��б������java�ļ�����ô�����ļ����Լ���ǰ��Ŀ¼��д��Ŀ���ļ��У�
    *	1)����õݹ鷨�����ļ�
    * 	2)�����java�ļ����Ƚ���Ŀ¼����׷�ӵ�Ŀ��.txt�У��ٽ�java�ļ���׷�ӵ�txt��
    *	3)������ֻ��Ҫ����д�룬��ΪԴ���ļ���������ƣ����漰������˿���ʹ��BufferedWriter��װFileWriter
    * 	4)�漰д�ķ�ʽ��append��Write�����Ĳ�ͬ��append���ص��Ǵ��������write��ֱ��д���ļ���
    *  	ʹ��FileWriter�еĹ��췽����FileWriter(String fileName, boolean append) ��������Ϊtrue 
    * @param folder-��Ҫ�������ļ���
    * @param bufw-һ����װ��FileWriter��BufferedWriter������������д���Ч��
    * @return void 
    * @throws IOException
    */
    public static void writeToFile(File folder, BufferedWriter bufw) throws IOException {
	boolean flag = false;
	// ����ÿһ���ļ�
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
    * ���û������·����װΪFile���󣬿���ѡ���Ƿ񴴽��µĳ���·�����жϴ˳���·���Ƿ��������һ��Ŀ¼��isDirectory()
    * ���������,������Ϊtrue,�򴴽��ļ�����������Ϊfalse,�����µ��ø÷��������ٴ���ʾ��ȡ��ȷ��·����
    * @param Info -Դ�ļ�����Ŀ���ļ�
    * @param create -�û��Ƿ�Ҫѡ�񴴽�(������·��������)
    * @return File -����·�����ļ�����
    * @throws 
    */
    public static File folderByIn(boolean create, Scanner in) {

	// ��װĿ¼��Ϊ�ļ�����
	File folder = new File(in.nextLine());

	// ��Ŀ¼�����ڻ���Ŀ¼��
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
    * �÷���ͨ������һ���ļ����󣬽��ö����µ��ļ��Լ��ļ��ж�������ArrayList������
    * @param file ����Ҫ������Ŀ¼�ļ�����
    * @return List<File> ���������ļ��Լ��ļ��е�List<File>����
    * @throws 
    */
    public static List<File> getSubFolder(File file) {
	List<File> subFolderList = new ArrayList<File>();
	File[] files = file.listFiles();
	for (File f : files) {
	    // ע�⣺�˴��ǰ������ļ����Լ��ļ�
	    subFolderList.add(f);
	}
	return subFolderList;
    }

}
