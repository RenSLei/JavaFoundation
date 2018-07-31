package priv.rsl.network_programing1;

import java.net.*;
import java.io.*;

class TransClient1 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket(InetAddress.getLocalHost(),10003);
		
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		
		//PrintWriter(OutputStream out, boolean autoFlush) 通过现有的 OutputStream 创建新的 PrintWriter。
		//改进之后，不需要flush()，不需要输入换行
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		BufferedReader bufIn =
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))break;

			out.println(line);

			String str = bufIn.readLine();

			System.out.println("server:"+str);

		}
		
		bufr.close();
		s.close();

	}
}

class TransServer1
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss = new ServerSocket(10003);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".....connected");

		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));

		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line = bufIn.readLine())!=null)
		{
			System.out.println(ip+"发来数据："+line);
			out.println(line.toUpperCase());
		}
		s.close();
		ss.close();
	}
}
