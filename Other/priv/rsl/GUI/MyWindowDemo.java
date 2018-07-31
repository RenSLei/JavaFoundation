package priv.rsl.GUI;
/*
Dialog:对话框
是一个带标题和边界的顶层窗口，边界一般用于从用户处获得某种形式的输入。

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyWindowDemo 
{
	//首先建立组件的引用
	private Frame f; 
	private TextField tf; 
	private Button but;
	private TextArea ta;

	//这里为了演示将对话框引用建立在外部
	private Dialog d;
	//组件里面不能直接添加文本，需要封装成lable对象
	private Label lab;
	private Button okBut;


	//构造函数
	MyWindowDemo()
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

		//初始化对话框，按理说 是不应该在这里初始化
		d= new Dialog(f,"提示信息-self",true);//ture 的意义是如果不操作此窗口就操作不了其他窗体
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("确定");

		d.add(lab);
		d.add(okBut);


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
				showDir();
			}
		});

		//注册键盘监听器，事件源是文本框
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					showDir();
				}

			}
			
		});

		//注册对话框窗体监听器
		d.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
			
		});
			
		//注册对话框按钮监听器
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);
			}
		});

		//为了使用户按enter键也能执行按钮活动监听器的内容，注册键盘监听到按钮上
		okBut.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					d.setVisible(false);
				}	
			}
		});

	}

	
	//将一个  "显示目录文件（也可能是弹出对话框"  的功能封装成私有方法
	private void showDir()
	{
		//在按钮活动（鼠标点击或是键盘）的时候，获取文本框的内容并显示到文本area中去
			String dirPath = tf.getText();
			File dir = new File(dirPath);//封装成文件对象
			if(dir.exists() &&dir.isDirectory())
			{
				//如果是就清空TextArea的文本
				ta.setText("");

				String[] names = dir.list();
				for(String name:names)
				{
					//将每一个名称添加到TextArea中,想要不覆盖的添加,就用append方法
					ta.append(name+"\r\n");
				}

			}
			else
			{
				//输入提示信息
				String info_1 = "您输入的："+dirPath+"是错误的！请重新输入";
				lab.setText(info_1);
				d.setVisible(true);
			}
			

			//点击转到后清空原来输入的文本
			tf.setText("");
	}
	
	
	public static void main(String[] args) 
	{
		new MyWindowDemo();
	}

}
