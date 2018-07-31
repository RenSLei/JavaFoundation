package priv.rsl.network_programing2;
/*
URL更为强大也是更为重要的是抽象类URLConnection
通过类URL的方法openconnection()与URLConnection类建立连接


抽象类URLConnection:

抽象类 URLConnection 是所有类的超类，它代表应用程序和 URL 之间的通信链接。
此类的实例可用于读取和写入此 URL 引用的资源。

*/

import java.net.*;
import java.io.*;

class URLConnectionDemo 
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("http://192.168.43.53:8080/myWeb/Demo.html");

		//建立一个URLConnection：openconnection()返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
		URLConnection conn = url.openConnection();

		//查阅api文档，查阅URLConnection类以及参阅网址：http://duanfei.iteye.com/blog/1719997
		
		//获取该连接的coon的输入流，以获取服务器返回的数据
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(conn.getInputStream()));

		//读取数据
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}

		bufr.close();



	}

}

/*
注意：为什么此时返回的数据没有包含服务端数据返回头？
因为现在走了传输层和应用层，当数据到达应用层时，根据相关协议，自动拆包，只保留数据主体部分
所以没有返回数据头,只有内容主体


*/
