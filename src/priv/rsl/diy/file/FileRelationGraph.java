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
* ����������һ���ļ��У�����Ŀ¼�µ��ļ�����ָ�����͵��ļ�������ӳ���ϵ�����ü��±�����������
     ���󣺽�F�е��ļ��к��ļ���ӳ���ϵ��������
     ��:
     Fn(�ļ���)
     	|---f1(�ļ���)
     		|---java�ļ�......
     	|---f2(�ļ���)
     		|---java�ļ�......
     	|---f3(�ļ���)
     		|---java�ļ�......
    ��Ҫ�ĵ��Ľ����Fn.txt
	���ݣ�	f1���ļ�����
			|---file1.java,file2.java...
		f2���ļ�����
			|---file1.java,file2.java...
     			...
    			
      ˼·��
     1����ȡҪ�������ļ��ж���
     2����ȡҪ�������ļ�����
     3����ȡ����ļ���·��
     4����ָ��·�������ļ��ж���������һ��txt�ļ�
     5�������������txt�ļ����
     6���ݹ�����ļ��У����������Ϣͨ�������д��txt
     
  ע��ֻ�漰д�������ַ�������BufferedWriter��װFileWriter(File file)����
          �ݹ����ע��ո��������㼶�Ĺ�ϵ���㷨�Ƚ���Ҫ
  
* @author rsl
* @date 2018��2��2�� ����1:41:03 
*  
*/
public class FileRelationGraph {
    
    public static void main(String[] args) {
	//�������ڻ�ȡ������Ϣ�Ĺ��������
	GetInputstr gs = new GetInputstr();
	//��ȡ�����ļ��ж���
	File parentFolder =gs.getDir("������Ҫ�������ļ���·����", false);
	
	String type = gs.getFileType("�������ļ�����(��  .txt):");
	// ��ȡĿ���ļ��ж���
	File objectFolder = gs.getDir("������Ŀ���ļ��У�", true);
	
	//���������ļ��������
	operateFile opf = new operateFile();
	//���ó�ʼ�ո���Ϊ5
	operateFile.setN(5);
	
	// ����Ŀ���ļ�����
	File objectFile = new File(objectFolder, parentFolder.getName() + ".txt");
	
	try {
	    //����Ŀ���ļ�
	    objectFile.createNewFile();
	} catch (IOException e2) {
	    e2.printStackTrace();
	}
	
	//��ѭ�����ⲿ��������
	BufferedWriter bufw = null;
	try {
	    //����������
	    bufw = new BufferedWriter(new FileWriter(objectFile, true));
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
		
	try {
	    //д���ַ�����Ŀ���ļ�
	    opf.writeToFile(parentFolder,bufw,type);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	
	//�ر���bufw
	try {
	    if(bufw!=null)
		bufw.close();
	} catch (IOException e) {
	    System.out.println("�ر���ʧ�ܣ�");
	    e.printStackTrace();
	}
    }
    
}

