package priv.rsl.network_programing2;
//
/*
�ͻ��ˣ�
1������˵�
2����ȡ�ͻ������е�ͼƬ����
3��ͨ��socket����������ݷ��������
4����ȡ����˷�����Ϣ
5���ر�

*/

import java.net.*;
import java.io.*;

class PicClient1 {
    public static void main(String[] args) throws Exception {
	// ��������
	Socket s = new Socket(InetAddress.getLocalHost(), 50001);

	// ����һ����ȡ�ֽ���
	FileInputStream fis = new FileInputStream("1.jpg");

	// ��ȡsocket�������
	OutputStream out = s.getOutputStream();

	byte[] buf = new byte[1024 * 64];
	int len = 0;
	while ((len = fis.read(buf)) != -1) {
	    out.write(buf, 0, len);
	}

	// ֪ͨ���������ϴ����ݽ���
	s.shutdownOutput();

	// ��ȡsocket���������������ȡ���������ص���Ϣ
	InputStream is = s.getInputStream();
	byte[] bufIn = new byte[1024 * 64];

	int num = 0;
	while ((num = is.read(bufIn)) != -1) {
	    System.out.println(new String(bufIn, 0, num));
	}

	fis.close();
	s.close();
    }

}

/*
 * ����ˣ�
 * 
 * 
 */
class PicServer1 {
    public static void main(String[] args) throws Exception {
	// �������񣬼���
	ServerSocket ss = new ServerSocket(50001);

	// ��ȡsocket
	Socket s = ss.accept();

	String ip = s.getInetAddress().getHostAddress();
	System.out.println(ip + ".....connected");

	// ��ȡsocket��������
	InputStream isIn = s.getInputStream();

	// д��һ���ļ���ȥ������Ҫ���������
	FileOutputStream fos = new FileOutputStream("server.jpg");

	byte[] buf = new byte[1024 * 64];

	int len = 0;
	while ((len = isIn.read(buf)) != -1) {
	    fos.write(buf, 0, len);
	}

	// ��ȡ����������ڷ�����Ϣ
	OutputStream osOut = s.getOutputStream();

	osOut.write("�ϴ�ͼƬ�ɹ���".getBytes());

	// �ر���Դ
	ss.close();
	s.close();
	fos.close();
    }

}
