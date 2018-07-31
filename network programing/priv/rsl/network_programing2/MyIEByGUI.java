package priv.rsl.network_programing2;

/*


用图形化界面做一个简单的浏览器
此浏览器能够访问tomcat服务器

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class MyIEByGUI
{
	//首先建立组件的引用
	private Frame f; 
	private TextField tf; 
	private Button but;
	private TextArea ta;

	//构造函数
	MyIEByGUI()
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

				//自己拆分非常麻烦，而且对格式局限性很大
				try
				{
					//成功一次就调用一次
					ta.setText("");
					//在按钮活动（鼠标点击或是键盘）的时候，拆分文本框中的网址:
					//比如://192.168.43.53:8080/myWeb/Demo.html  
					
					//首先获取网址
					String url = tf.getText();
					
					//拆分成ip和资源路径：
					int index1 = url.indexOf("//")+2;
					int index2 = url.indexOf("/",index1);

					String str = url.substring(index1,index2);
					String[] arr = str.split(":");
					String host = arr[0];
					int port = Integer.parseInt(arr[1]);
					
					String path = url.substring(index2);
					System.out.println(host+port+path);

					Socket s = new Socket(host,port);

					//给服务器发送请求：
					PrintWriter out = new PrintWriter(s.getOutputStream(),true);

					out.println("GET "+path+" HTTP/1.1");//请求数据
					out.println("Accept:*/*");
					out.println("Accept-Language:zh-cn");
					out.println("Host:"+host+":"+port);
					out.println("Connection: closed");
					
					//******一定要写空行******
					out.println();
					out.println();
					
					//读取服务器返回的数据，其实就是tomcat服务器的自定义的myWeb/Demo.html文件内容
					BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

					String line = null;

					while((line=bufr.readLine())!=null)
					{
						ta.append(line+"\r\n");
					}

					s.close();
				}
				catch (Exception ex)
				{
					 throw new RuntimeException("异常");
				}
				
				
			}
		});

	}        
	
	
	public static void main(String[] args) 
	{
		new MyIEByGUI();
	}

}
