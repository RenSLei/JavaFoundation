package priv.rsl.network_programing2;
/*
ͨ���ոյ�ͼ�λ������ʾ�����Կ���������ַ�����Ƚϸ��ӣ�����
java��net���з�װ�������ڴ����ַ���࣬���Ի�ȡЭ�顢host(����)��port(�˿�)
Query(����)

����һ�����캯����
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
          ��ȡ�� URL ��Э�����ơ�

 String	getHost() 
          ��ȡ�� URL ����������������ã���

 int	getPort() 
          ��ȡ�� URL �Ķ˿ںš�

 String	getPath() 
          ��ȡ�� URL ��·�����֡�

 String	getFile() 
          ��ȡ�� URL ���ļ�����

 String	getQuery() 
          ��ȡ�� URL �Ĳ�ѯ���֡�

*/


/*
Protocol:https
Host:www.jd.com
Port:-1              (���û���򷵻�-1)
Path:/
File:/?vip_frm=super_nav_vip
Query:vip_frm=super_nav_vip

*/
