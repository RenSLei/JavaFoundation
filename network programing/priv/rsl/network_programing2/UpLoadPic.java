package priv.rsl.network_programing2;
//
/*
客户端：
1，服务端点
2，读取客户端已有的图片数据
3，通过socket输出流将数据发给服务端
4，读取服务端反馈信息
5，关闭

*/

import java.net.*;
import java.io.*;

class PicClient1 {
    public static void main(String[] args) throws Exception {
	// 建立服务
	Socket s = new Socket(InetAddress.getLocalHost(), 50001);

	// 建立一个读取字节流
	FileInputStream fis = new FileInputStream("1.jpg");

	// 获取socket的输出流
	OutputStream out = s.getOutputStream();

	byte[] buf = new byte[1024 * 64];
	int len = 0;
	while ((len = fis.read(buf)) != -1) {
	    out.write(buf, 0, len);
	}

	// 通知服务器，上传数据结束
	s.shutdownOutput();

	// 获取socket服务的输入流，获取服务器返回的信息
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
 * 服务端：
 * 
 * 
 */
class PicServer1 {
    public static void main(String[] args) throws Exception {
	// 建立服务，监听
	ServerSocket ss = new ServerSocket(50001);

	// 获取socket
	Socket s = ss.accept();

	String ip = s.getInetAddress().getHostAddress();
	System.out.println(ip + ".....connected");

	// 获取socket的输入流
	InputStream isIn = s.getInputStream();

	// 写到一个文件中去，所以要建立输出流
	FileOutputStream fos = new FileOutputStream("server.jpg");

	byte[] buf = new byte[1024 * 64];

	int len = 0;
	while ((len = isIn.read(buf)) != -1) {
	    fos.write(buf, 0, len);
	}

	// 获取输出流，用于反馈信息
	OutputStream osOut = s.getOutputStream();

	osOut.write("上传图片成功！".getBytes());

	// 关闭资源
	ss.close();
	s.close();
	fos.close();
    }

}
