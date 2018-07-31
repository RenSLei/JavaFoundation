package priv.rsl.GUI;
/*
菜单栏：

*/


import java.awt.*;
import java.awt.event.*;
class MyMenuDemo 
{
	//首先建立组件的引用
	private Frame f; 
	private MenuBar mb; 
	private Menu m1,m2,m3;
	private MenuItem closeItem,subItem1,subItem2;

	MyMenuDemo()
	{
		init();
	}

	public void init()
	{
		//初始化
		f = new Frame("MyMenuWindow");
		f.setBounds(300,100,500,600);
		f.setLayout(new FlowLayout());

		mb = new MenuBar();
		m1 =new Menu("文件");
		m2 =new Menu("子菜单1");
		m3 =new Menu("子菜单2");
		subItem1 = new MenuItem("子条目1");
		subItem2 = new MenuItem("子条目2");

		closeItem = new MenuItem("退出");
		
		//菜单条里面添加菜单
		mb.add(m1);
		//菜单里面添加菜单
		m1.add(m2);
		//菜单里添加条目
		m2.add(subItem1);

		m1.add(m3);
		m3.add(subItem2);
		m1.add(closeItem);

		/*
		效果：
			文件
			子菜单1-->子条目1
			子菜单2-->子条目2
			退出
		*/

		//将菜单条添加到窗体中去
		f.setMenuBar(mb);

		myEvent();

		f.setVisible(true);

	}

	public void myEvent()
	{
		//现在的需求是当点击退出的时候程序结束
		//添加监听，查阅api发现MenuItem支持活动监听
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		//添加窗口监听器
		f.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});

		//添加

	}


	public static void main(String[] args) 
	{
		new MyMenuDemo();
	}

}

