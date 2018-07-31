package priv.rsl.IO_1;
/*
���⻺������
�������ĳ�����Ϊ��������Ĳ���Ч�ʶ����ֵġ�

�����ڴ���������֮ǰ����������������

�û������ṩ��һ����ƽ̨�Ļ��з�newLine()
ע������ ���������� ������newLine()
*/

import java.io.*;

class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
	// ����һ���ַ�д��������ע��˶���һnew�ͻ���Ĭ��Ŀ¼����һ����ΪString���ļ�
	FileWriter fw = new FileWriter("buf.txt");

	// Ϊ������ַ�д������Ч�ʡ������˻��弼��
	// ֻҪ����Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯�����ɡ�
	BufferedWriter bufw = new BufferedWriter(fw);

	for (int x = 1; x < 5; x++) {
	    // ���ø����write(String s)����д���ݵ�������
	    bufw.write("abcd" + x);

	    // �û������ṩ��һ����ƽ̨�Ļ��з�newLine()
	    bufw.newLine();

	    // д��һ�ε���������ˢ�¸���һ��,��ס�õ���������Ҫ�ǵ�ˢ��
	    bufw.flush();
	}

	// �رջ��������ǹر��˻�������Ӧ��������
	bufw.close();
    }
}

/*
 * abcd1 abcd2 abcd3 abcd4
 * 
 */
