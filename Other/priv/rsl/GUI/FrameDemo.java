package priv.rsl.GUI;
/*

*/

import java.awt.*;
import java.awt.event.*;

class FrameDemo 
{
	//定义该图形中所需的组件的引用
	private Frame f;
	private Button but;

	//一旦new FrameDemo就出现一个具有基本参数的窗体
	FrameDemo()
	{
		init();
	}

	//初始化
	public void init()
	{
		f= new Frame("my frame");

		//对frame进行基本设置
		//f.setSize();f.setLocation();
		f.setBounds(300,100,600,500);//是父类Component的方法，可以设置大小以及位置
		/*
		public void setBounds(int x,int y,int width,int height)
		移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
		*/

		f.setLayout(new FlowLayout());

		but = new Button("my button");

		//将组件添加到Frame中
		f.add(but);

		//显示窗体之前加载窗体事件
		myEvent();

		//显示窗体
		f.setVisible(true);
	}

	//将事件和窗体设置分离开
	private void myEvent()
	{
		//注册窗体监听器
		f.addWindowListener(new WindowAdapter()
		{
			//覆盖方法
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//注册按钮监听器
		/*
		让按钮具备退出程序的功能：
		思想：
		按钮就是事件源，那么该添加什么监听器呢？
		通过关闭窗体示例了解到，想要知道哪个组件具备什么样的特有监听器，
		需要查看该组件对象的功能
		通过查看该组件对象的功能

		通过查阅button的描述，发现按钮支持一个特有的监听器：addActionListener

		注意：addActionListener没有像addWindowListener的适配器WindowAdapter，因为
		addActionListener里只有一个方法，但是这种监听器很少，一般的都有适配器，因为适配器的出现是为了
		方便注册监听器，它覆盖了监听器的方法但是方法体内容为空。
		*/

		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("按钮退出");
				System.exit(0);
			}

		});
	}



	public static void main(String[] args) 
	{
		new FrameDemo();
	}
}
