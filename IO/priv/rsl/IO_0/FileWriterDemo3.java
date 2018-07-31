package priv.rsl.IO_0;
/*
��ʾ�������ļ���������д��
*/

import java.io.*;

class FileWriterDemo3 {
    public static void main(String[] args) {

	FileWriter fw = null;

	try {
	    // ����һ��true�����������������е��ļ������������ļ���ĩβ�������
	    fw = new FileWriter("demo.txt", true);

	    // ��ʾ��δ�����з���
	    fw.write("\r\n123");

	} catch (IOException e) {
	    System.out.println(e.toString());
	}

	finally {
	    try {
		if (fw != null)
		    fw.close();
	    } catch (IOException e) {
		System.out.println(e.toString());
	    }

	}
    }
}
