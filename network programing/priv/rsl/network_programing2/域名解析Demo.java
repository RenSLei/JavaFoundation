package priv.rsl.network_programing2;

class 域名解析Demo 
{
	public static void main(String[] args) throws Exception
	{
		
	}

}


/*
浏览器在输入地址后，如：www.sina.com.cn，
如果本机没有配置该域名的ip的话(一般情况不会去配置，一般只绑定了本机127.0.0.1为localhost)，
就会走DNS域名解析服务器，得到解析后的ip地址，再向该ip对应的主机请求

所以有的收费软件一启动会访问它的指定的网址，校验注册码是否是正常的，否则会禁止使用软件
所以可以将它要访问的网址配置到本机的回环地址127.0.0.1,这样就屏蔽掉了它访问固定页面

*/
