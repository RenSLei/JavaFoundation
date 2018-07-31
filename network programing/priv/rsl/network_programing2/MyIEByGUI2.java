package priv.rsl.network_programing2;

/*

用图形化界面做一个简单的浏览器(客户端)

与之前的区别就是利用类URL以及抽象类URLConnection
不用我们自己去拆分url地址，代码简单
此浏览器能够访问tomcat服务器

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class MyIEByGUI2
{
	//首先建立组件的引用
	private Frame f; 
	private TextField tf; 
	private Button but;
	private TextArea ta;

	//构造函数
	MyIEByGUI2()
	{
		init();
	}
	//初始化设置
	public void init()
	{
		f = new Frame("my window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		tf = new TextField(60);
		but = new Button("转到");
		ta = new TextArea(25,70);

		//加载组件
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		//加载事件
		myEvent();

		//显示窗体
		f.setVisible(true);

	}

	public void myEvent()
	{
		//注册窗口监听器,事件源是窗口
		f.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});

		//注册按钮监听器，事件源是按钮
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					getReceInfo();
				}
				catch (Exception ex)
				{
					 throw new RuntimeException("获取服务端数据失败！");
				}
				
				
			}
		});

		//注册一个键盘监听器，事件源是文本框tf
		tf.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				try
				{
					getReceInfo();
				}
				catch (Exception ex)
				{
					 throw new RuntimeException("获取服务端数据失败！");
				}
				
			}
		
		
		});

	}        
	private void getReceInfo()throws Exception
	{
		//成功一次就调用一次
		ta.setText("");
		//在按钮活动（鼠标点击或是键盘）的时候，拆分文本框中的网址:
		//比如:http://192.168.43.53:8080/myWeb/Demo.html  
		
		//首先获取网址
		String url_str = tf.getText();

		URL url = new URL(url_str);
		
		//建立一个URLConnection：openconnection()返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
		URLConnection conn = url.openConnection();

		/*
			//拆分成ip和资源路径：
			int index1 = url.indexOf("//")+2;
			int index2 = url.indexOf("/",index1);

			String str = url.substring(index1,index2);
			String[] arr = str.split(":");
			String host = arr[0];
			int port = Integer.parseInt(arr[1]);
			
			String path = url.substring(index2);

			Socket s = new Socket(host,port);

			//给服务器发送请求：
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);

			out.println("GET "+path+" HTTP/1.1");//请求数据
			*/
			//out.println("Accept:*/*");
			//out.println("Accept-Language:zh-cn");
			//out.println("Host:"+host+":"+port);
			//out.println("Connection: closed");
			
			//******一定要写空行******
			//out.println();
			//out.println();
		//*/
		
		//获取该连接的coon的输入流，以获取服务器返回的数据
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(conn.getInputStream()));
		//读取服务器返回的数据，其实就是tomcat服务器的自定义的myWeb/Demo.html文件内容
		String line = null;

		while((line=bufr.readLine())!=null)
		{
			ta.append(line+"\r\n");
		}
		
		bufr.close();
	}
	
	public static void main(String[] args) 
	{
		new MyIEByGUI2();
	}

}

/*
注意：现在走了传输层和应用层，当数据到达应用层时，根据相关协议，自动拆包，只保留数据主体部分
所以没有返回数据头,只有内容主体


*/
