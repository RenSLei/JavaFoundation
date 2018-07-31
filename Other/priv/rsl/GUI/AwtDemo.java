package priv.rsl.GUI;
/*
图形化界面：
窗口的建立以及基本参数的设置：
Frame 是带有标题和边框的顶层窗口。

基本步骤：
1.创建frame窗体
2.设置窗体：大小，位置，布局
3.定义组件
4.将组件通过窗体的add方法添加到窗体中
5.让窗体显示，通过setVisible(true);


事件监听机制的特点：
1，事件源
2，事件
3，监听器
4，事件处理

事件源：awt包或者swing包中的那些图形界面组件；

事件：每一个事件源都有自己特有的对应事件和共性事件；

监听器：将可以触发某一个事件的动作（不只是一个动作）都已经封装到了监听器中

以上三者在java中都已经定义好了
直接获取其对象来用就可以了

我们做的事情：对产生动作进行处理


*/

import java.awt.*;
import java.awt.event.*;
class AwtDemo 
{
	public static void main(String[] args) 
	{
		//构造一个新的、最初不可见的、具有指定标题的 Frame 对象:
		
		Frame f = new Frame("my awt");

		//设置窗体大小：
		f.setSize(500,400);//横向500，纵向400

		//设置位置：
		f.setLocation(300,200);//窗体左上角顶点距离左边，距离上边

		//设置布局模式：设置为流式布局
		f.setLayout(new FlowLayout());

		//添加一个组件
		Button b = new Button("我是一个按钮");

		//将组件添加到窗体中去：
		f.add(b);//默认的布局是边界式布局，如果没有设置布局模式，添加的组件会最大填充窗体
		
		

		//向窗体注册监听器
		/*说明：
			方法是Window类（Frame的父类）的一个方法
		但是里面的参数是一个接口，且方法有7个，所以要直接使用其中的一个方法，必须覆盖所有的方法
		发现接口WindowListener的子类WindowAdapter已经复写了其所有方法，且方法全部为空，我们只需要
		针对关心的事件定义方法，此类的出现正是方便创建侦听器对象

		注意：类 WindowAdapter是属于java.awt.event 包所以一般要导两个包

		*/
		//f.addWindowListener(new MyWin());
		//代替上句，写一个匿名内部类：
		f.addWindowListener(new WindowAdapter()
		{
			//复写方法，窗口关闭动作的处理方式
			public void windowClosing(WindowEvent e)
			{
			System.out.println("关闭");
			System.exit(0);
			}

			//Activated，只要窗口处于前置时执行
			public void windowActivated(WindowEvent e)
			{
				System.out.println("我被前置了");
			}

			//窗口一旦打开就执行
			public void windowOpened(WindowEvent e) 
			{
				System.out.println("我被打开了");
			}


		});
		//将窗体显示出来：
		f.setVisible(true);//注意一开启窗体就会开启一个新的线程

		
	}
}

	//写一个子类继承WindowAdapter，定义我们想要的方法就可以了
	class MyWin extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			//写动作：当我们点击关闭窗口按钮时，屏幕输出语句window closing
			//System.out.println("window closing");
			//正确处理动作：
			System.exit(0);
		}
	}
