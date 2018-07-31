package priv.rsl.diy.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import priv.rsl.diy.file.tool.GetInputstr;
import priv.rsl.diy.file.tool.operateFile;

/*
��ϰ����ȡָ��Ŀ¼�µ�ָ�����͵��ļ�·��
��һ��ָ��Ŀ¼�µ�����Java�ļ��ľ���·�����洢��һ���ı��ļ��С�
����һ��Java�ļ��б��ļ���

˼·��
1����ָ����Ŀ¼���еݹ�
2����ȡ�ݹ���������е�Java�ļ���·��
3������Щ·���洢�������С�
4.�������е�����д��һ���ļ��С�

*/

class SearchFilesPath {
    public static void main(String[] args) throws IOException {
	
	//�����Ӽ��̻�ȡ��Ϣ�Ĺ��������
	GetInputstr gi= new GetInputstr();
	
	//������д�ļ��Ĺ�����
	operateFile opf=new operateFile();
	
	//��ȡ��Ҫ�������ļ���·������װ��file����
	File dir=gi.getDir("������Ҫ�������ļ���·����",false);
	
	//��ȡ��Ҫ�������ļ�����
	String fileType= gi.getFileType("��������Ҫ���ҵ��ļ�����(��.txt):");
	
	//����list���ڴ洢ָ���ļ�Ŀ¼�µ�ָ���ļ���file����
	List<File> list = new ArrayList<File>();
	
	//����fileToList�����������ؽ������list
	opf.fileToList(dir, list,fileType);

	// �Ӽ��̻�ȡ�û������Ŀ���ļ�����
	String s= gi.setName("��������Ҫ�������ļ���:");
	
	//��װĿ���ļ�Ϊfile����Ĭ���ļ�·�����û���Ҫ���ҵ��ļ�����
	File txtFile = new File(dir,s+".txt");
	
	//��list����ļ�·��д��Ŀ���ļ��У�����д����ļ�����
	int n = opf.writePathToFile(list,txtFile.toString());
	System.out.println("�������,�ļ�������"+n);

    }
   

}

