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
	File f = new File("F:\\java\\һ��javaSE\\day04_����\\ArrayTest1.java");
	File ff = new File("F:\\java\\һ��javaSE\\day04_����\\");
	
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
    public static int copyFileToFolder(List<File> list, File DestinationFolder) throws IOException {
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
		System.out.println(tempFile.getAbsoluteFile());
		if (f.getName() == null) {
		    throw new IllegalArgumentException("�ļ����ղ����쳣");
		}
		// ��File�������µ��ļ�������Ϊ��
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


}
