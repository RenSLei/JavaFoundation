package priv.rsl.network_programing2;
/*
通过刚刚的图形化界面的示例可以看出，将地址解析比较复杂，所以
java在net包中封装好了用于处理地址的类，可以获取协议、host(主机)、port(端口)
Query(参数)

其中一个构造函数：
URL(String protocol, String host, int port, String file) 
*/

import java.net.URL;

class URLDemo 
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("https://www.jd.com/?vip_frm=super_nav_vip");
		System.out.println("Protocol:"+url.getProtocol());
		System.out.println("Host:"+url.getHost());
		System.out.println("Port:"+url.getPort());
		System.out.println("Path:"+url.getPath());
		System.out.println("File:"+url.getFile());
		System.out.println("Query:"+url.getQuery());
	}

}

/*
 String	getProtocol() 
          获取此 URL 的协议名称。

 String	getHost() 
          获取此 URL 的主机名（如果适用）。

 int	getPort() 
          获取此 URL 的端口号。

 String	getPath() 
          获取此 URL 的路径部分。

 String	getFile() 
          获取此 URL 的文件名。

 String	getQuery() 
          获取此 URL 的查询部分。

*/


/*
Protocol:https
Host:www.jd.com
Port:-1              (如果没有则返回-1)
Path:/
File:/?vip_frm=super_nav_vip
Query:vip_frm=super_nav_vip

*/
