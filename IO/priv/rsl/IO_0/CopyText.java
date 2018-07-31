package priv.rsl.IO_0;

/*
��һ���ļ������ݸ��Ƶ�����һ���ļ��У�

���裺
1������Ŀ���ļ�
2�������ȡ���ͽ�Ҫ���Ƶ��ļ������
3��ͨ�����ϵĶ�д������ݵĴ洢��
4���ر���Դ

*/
import java.io.*;

class CopyText {
    public static void main(String[] args) throws IOException {
	//
	copy_2();
    }

    // ����һ��һ��һ���Ķ���д
    public static void copy_1() throws IOException {
	// ����Ŀ�ĵ�
	FileWriter fw = new FileWriter("RuntimeDemo_copy.txt");

	// ���Ѿ��е��ļ������
	FileReader fr = new FileReader("RuntimeDemo.java");

	int ch = 0;

	while ((ch = fr.read()) != -1) {
	    fw.write(ch);
	}

	fw.close();
	fr.close();
    }

    // �������������ַ�������,���쳣������
    public static void copy_2() {
	// ���ⲿ��������
	FileWriter fw = null;
	FileReader fr = null;
	try {
	    fw = new FileWriter("SystemDemo_copy.txt");
	    fr = new FileReader("SystemDemo.java");

	    // ��������
	    char[] buf = new char[1024];

	    int len = 0;

	    while ((len = fr.read(buf)) != -1) {
		fw.write(buf, 0, len);
	    }
	} catch (IOException e) {
	    throw new RuntimeException("��дʧ�ܣ�");
	}

	finally {
	    if (fr != null)
		try {
		    fr.close();
		} catch (IOException e) {
		    System.out.println(e.toString());
		}

	    if (fw != null)
		try {
		    fw.close();
		} catch (IOException e) {
		    System.out.println(e.toString());
		}
	}

    }
}
