package priv.rsl.network_programing2;
/*
演示一个多线程并发登录服务器


有一个数据库：user.txt
里面存着账号信息

客户端登录用户
服务端校验该用户

过程：
1，客户端将用户名发给服务端

2，	如果服务端的数据库有该用户名则
	返回给客户端：xxx，欢迎回来！
	服务端显示：ip,已登录

	如果服务端的数据库没有该用户名则
	返回给客户端：xxxbu不存在
	服务端：xxx尝试登录

3，	最多登录3次
*/


import java.net.*;
import java.io.*;

class LoginClient
{
	public static void main(String[] args) throws Exception
	{
		//建立服务，如果是多个客户端并发登录，则这里改为服务端的ip
		Socket s = new Socket(InetAddress.getLocalHost(),50005);
		
		//键盘录入
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));

		//登录
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//获取socket的输入流
			BufferedReader in = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		for (int x=0;x<3 ;x++)
		{	
			String line=bufr.readLine();
			
			//如果键盘输入的是null
			if(line==null)
				break;

			out.println(line);

			String str = in.readLine();
			
				
				System.out.println("服务端："+str);
				
				//如果服务端发来的信息里包含"欢迎"
				if(str.contains("欢迎"))
					break;
		}

		bufr.close();
		s.close();
	}

}


/*
服务端：

要利用多线程技术
将需要执行的代码放在run方法中

*/

//建立一个开启线程的类


class UserThread implements Runnable
{
	//封装一个服务
	private Socket s;

	UserThread(Socket s)
	{
		this.s=s;
	}

	//覆盖run方法
	public void run()
	{	
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		try
		{
			for (int x=0;x<3 ;x++ )
			{
				BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));

				String name = bufIn.readLine();

				BufferedReader bufr = new BufferedReader(new FileReader("User.txt"));

				//获取socket的输出流
				PrintWriter out = new PrintWriter(s.getOutputStream(),true);

				//判断读一行的是否和name相等
				String line = null;

				//定义一个标记，根据标记来执行服务端向客户端要发送什么数据
				boolean flag = false;
				while((line=bufr.readLine())!=null)
				{
					if(line.equals(name))
					{
						flag = true;
						break;
					}
				}

				if(flag)
				{
					System.out.println(name+"已登录");
					out.println(name+",欢迎回来");
					break;
				}
				else
				{
					System.out.println(name+"尝试登录");
					out.println(name+" 用户不存在");
				}
			}
			s.close();
		
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+"校验失败！");
		}
		
	}
}



class LoginServer
{
	public static void main(String[] args) throws Exception
	{
		//建立服务，监听
		ServerSocket ss = new ServerSocket(50005);

		while(true)
		{
			//获取socket
			Socket s = ss.accept();

			//开启线程，循环开启线程
			new Thread(new UserThread(s)).start();
		}
	}

}


/*

*/
