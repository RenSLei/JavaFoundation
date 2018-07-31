package priv.rsl.network_programing2;
/*
小知识点：
1，Socket有一个空参数的构造函数，那么到底和哪个主机和端口连接？
	于是有一个方法：connect(SocketAddress sa)
	SocketAddress是抽象类，其子类InetSocketAddress里面封装的是ip地址和端口号

	而InetAddress是封装的ip地址

2，ServerSocket(int port, int backlog) 
          利用指定的 backlog 创建服务器套接字并将其绑定到指定的本地端口号。
	传入连接指示（对连接的请求）的最大队列长度被设置为 backlog 参数。

	即backlog指服务器最大连接的服务端数量
*/

class 小知识点Demo 
{
	public static void main(String[] args) throws Exception
	{
		
	}

}
