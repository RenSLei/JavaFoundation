package priv.rsl.IO_0;

import java.io.*;

/*
 * 
 * 
 * 
//�ļ��Ķ�ȡ��ʽ֮����
//
//ͨ���ַ�������ж�ȡ��
//public int read(char[] cbuf)
//         throws IOException
//���أ�
//��ȡ���ַ���������ѵ�������ĩβ���򷵻� -1
*/
class FileReaderDemo {
    public static void main(String[] args) throws IOException {
	// ����һ���ļ���ȡ�����󣬺�ָ�����Ƶ��ļ��������
	FileReader fr = new FileReader("demo.txt");

	// ����һ���ַ����顣���ڴ洢�����ַ�
	// read(char[])�����ص��Ƕ����ַ�����
	char[] buf = new char[1024];

	// ����һ��int�͵ı������ڼ�¼read�ķ�������
	int num = 0;

	// дѭ���������ǵ����ص�ֵ����-1ʱ��˵��û�е��ļ�ĩβ
	// ע��һ�ξͶ�һ�����鳤����ô�����������ô���Ļ���
	while ((num = fr.read(buf)) != -1) {
	    // ��һ�δ�ӡһ�Σ����ַ���С�����鳤��ʱ���ʹ�ӡ0��num���ַ������û���꣬���´�ѭ���������ʹ�ӡ
	    System.out.println(new String(buf, 0, num));
	}
	// �ر�����Դ
	fr.close();
    }
}
