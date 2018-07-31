package priv.rsl.network_programing2;
/*
做的自己的服务端：


通过浏览器访问该服务端，且查看浏览器在访问服务端时的请求是什么？

通过查看请求是什么，可以自己做一个浏览器去访问tomcat服务器

*/

import java.net.*;
import java.io.*;

class ServerDemo 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(8888);

		Socket s = ss.accept();
		
		//拿到客户端的ip地址
		System.out.println(s.getInetAddress().getHostAddress());

		//获取socket服务的输入流，看看浏览器客户端的请求是什么？
		InputStream in = s.getInputStream();
		
		//读取信息并打印：
		byte[] buf = new byte[1024];

		int len=in.read(buf);

		System.out.println("客户端请求："+new String(buf,0,len));
	
		//输出流
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);

		out.println("<font color = 'red'size='4'>浏览器客户端你好</font>");

		s.close();
		ss.close();
	}

}

/*
从浏览器客户端发过来的请求消息头：
GET / HTTP/1.1(----版本号)
Accept: text/html, application/xhtml+xml, image/jxr, (支持什么请求)
Accept-Language: zh-CN(语言)
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299
Accept-Encoding: gzip, deflate(支持压缩，提高传输效率)
Host: 192.168.43.53:8888(要访问的主机的ip以及端口)
Connection: Keep-Alive(保持存活)

*/
