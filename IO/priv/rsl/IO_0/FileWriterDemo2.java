package priv.rsl.IO_0;
/*
IO�쳣����ķ�ʽ��
����IOException�Ĵ���϶�Ҫtry catch

*/

import java.io.*;

class FileWriterDemo2 {
    public static void main(String[] args) {
	// ע���һ��try���洴�����ã��ڲ���ʼ����Ŀ�����ñ��������������ڶ���Ч�������������ط���û�ж���
	FileWriter fw = null;
	try {
	    // ��ʼ������fw,����������Դ�Լ������ļ�
	    fw = new FileWriter("demo.txt");

	    // writeҲҪ���쳣������ҲҪtry
	    fw.write("abcdef");
	} catch (IOException e) {
	    System.out.println("catch��" + e.toString());
	}

	// ����������Դû���쳣ʱ�����ǵ�д�ļ���ʱ������쳣ʱ����ʱ���Ҫ�ر�����Դ
	// ���Թر�����Դ�Ķ�������Ҫ�������Է���finally��
	finally {
	    // �ر�����ԴҲҪ�����쳣��
	    try {
		// ������������ʧ�ܺ󣬾�û�г�ʼ��fw,�˴�ҲҪ�����⣬����Ҫ���ж�
		if (fw != null)
		    fw.close();
	    } catch (IOException e) {
		System.out.println(e.toString());
	    }

	}
    }
}
