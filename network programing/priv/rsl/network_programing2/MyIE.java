package priv.rsl.network_programing2;

/*
写一个自己的浏览器客户端:


*/

import java.net.*;
import java.io.*;

class MyIE {
    public static void main(String[] args) throws Exception {
	Socket s = new Socket("10.187.77.28", 8080);

	// 给服务器发送请求：
	PrintWriter out = new PrintWriter(s.getOutputStream(), true);

	out.println("GET /myWeb/Demo.html HTTP/1.1");// 请求数据
	out.println("Accept:*/*");
	out.println("Accept-Language:zh-cn");
	out.println("Host:10.187.77.28:8080");
	out.println("Connection:close");

	// ******一定要写空行******
	out.println();
	out.println();

	// 读取服务器返回的数据，其实就是tomcat服务器的自定义的myWeb/Demo.html文件内容
	BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

	String line = null;

	while ((line = bufr.readLine()) != null) {
	    System.out.println(line);
	}

	s.close();
    }

}

/*
 * 
 * 这是服务器回应数据头：
 * 
 * HTTP/1.1 200 (连接成功) Accept-Ranges: bytes () ETag: W/"228-1515384175199" ()
 * Last-Modified: Mon, 08 Jan 2018 04:02:55 GMT (修改时间) Content-Type: text/html
 * (发送的文件类型) Content-Length: 228 Date: Mon, 08 Jan 2018 06:10:07 GMT
 * 
 * <html> <body> <h1>这是我的主页</h1> <font size=5 color=read>欢迎光临</font> <div> 一首诗
 * 一首诗</br> 一首诗 一首诗</br> 一首诗 一首诗</br> 一首诗 一首诗</br> -----rsl <div> </body>
 * </html>
 * 
 * 
 */
