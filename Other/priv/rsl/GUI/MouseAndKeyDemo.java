package priv.rsl.GUI;
/*
键盘事件：
问题：
TextField文本组件里面虽然不能输入其他键，但是却可以输入汉字，而且输入了不能删除
*/

import java.awt.*;
import java.awt.event.*;

class MouseAndKeyDemo 
{
	//定义该图形中所需的组件的引用
	private Frame f;//添加窗体
	private Button but;//添加按钮
	private TextField tf;//TextField 对象是允许编辑单行文本的文本组件


	//一旦new FrameDemo就出现一个具有基本参数的窗体
	MouseAndKeyDemo()
	{
		init();
	}

	//初始化
	public void init()
	{
		f= new Frame("my frame");

		f.setBounds(300,100,600,500);

		f.setLayout(new FlowLayout());

		but = new Button("登录按钮");
		
		tf = new TextField(20);


		f.add(tf);

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
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("按钮活动");
			}

		});

		//注册键盘监听器，以按钮button为事件源
		but.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				//获取按下的键的String类型，因为像shift键就不是一个字符
				System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"-----"+e.getKeyCode());

				//可以显示组合键
				if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_ENTER)//用字段
				System.out.println("Alt+Enter is run");

			}
			
		});

		//注册键盘监听器，以文本框为事件源
		tf.addKeyListener(new KeyAdapter()
		{
			//需求是只想在文本内输入数字，其他字符不能输入
			public void keyPressed(KeyEvent e)
			{
				//判断下输入的是不是数字,如果不是就取消此输入
				int code = e.getKeyCode();
				if(!(code>=KeyEvent.VK_0 &&code<=KeyEvent.VK_9))
				{
					System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"是非法的！");
					e.consume();
				}
				
				/*
				注：consume()是KeyEvent父类InputEvent的一个方法
				使用此事件，以便不会按照默认的方式由产生此事件的源代码来处理此事件。
				*/

			}
		});


	}


	public static void main(String[] args) 
	{
		new MouseAndKeyDemo();
	}

}
