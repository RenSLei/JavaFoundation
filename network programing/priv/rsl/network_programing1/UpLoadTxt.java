package priv.rsl.network_programing1;
/*

*/

import java.net.*;
import java.io.*;

class TcpClient1 
{
	public static void main(String[] args) throws Exception
	{
		//建立服务
		Socket s = new Socket(InetAddress.getLocalHost(),5000);
		
		//io的源与目的思想:
		//写源：
		BufferedReader bufr = 
			new BufferedReader(new FileReader("UpLoadTxt.java"));

		//目的：就用PrintWriter写输出流(操作文本)，自带刷新的功能
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

		//读与写
		String line = null;
		while((line = bufr.readLine())!=null)
		{
			pw.println(line);
		}

		//当把客户端的数据写完后，应该把此输入流的末尾标记
		s.shutdownOutput();

		//获取输入流，用于读取服务器返回的数据
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String rece_str = null;
		while((rece_str = bufIn.readLine())!=null)
		{
			System.out.println(rece_str);
		}
		
		//关闭资源
		s.close();
		bufr.close();
	
	}

}


//服务端：

class TcpServer1 
{
	public static void main(String[] args) throws Exception
	{
		//建立服务，监听端口
		ServerSocket ss = new ServerSocket(5000);
		
		//获取客户端的Socket服务
		Socket s = ss.accept();

		//习惯：获取ip
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		//获取网络输入流
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//建立目的，用printWriter的构造函数printWriter(Writer out , boolean autoFlush)
		PrintWriter ps = new PrintWriter(new FileWriter("server.txt"),true);

		//给客户端的回应
		PrintWriter Out = new PrintWriter(s.getOutputStream(),true);
		
		Out.println("开始上传");
		//读与写
		String line = null;
		
		//读客户端的输入流，并写到文件中
		while((line =bufIn.readLine())!=null)
		{
			ps.println(line);
		}
		
		//当复制完文件后，应该回应客户端
		
		Out.println("上传成功！");
		
		ps.close();
		ss.close();
		s.close();	
	}

}
