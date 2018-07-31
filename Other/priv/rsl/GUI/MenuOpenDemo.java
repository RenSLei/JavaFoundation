/*
将一个文件封装成jar包，而且双击它可以执行，不通过命令窗口来完成

1.带着包编译：javac -d <存放路径> 类名.java
生成一个文件夹,里面包含编译生成的class文件
2.切换到该存放路径：jar -cvf xxx.jar 包名
生成xxx.jar文件
3.如何双击这个jar包来执行里面的带有主函数的类呢？
1)先删除这个xxx.jar包，因为里面配置信息不够
2)新建一个txt文件，以1.txt为例（名字随便命名）
3)写入：Main-Class: 包名.类名(包含主函数的类) 回车
4）jar -cvfm xxx.jar 1.txt 包名
4.双击xxx.jar就可以运行该java文件了

*/

package priv.rsl.GUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MenuOpenDemo 
{
	//首先建立组件的引用
	private Frame f; 
	private MenuBar bar; 
	private Menu menu;
	private MenuItem closeItem,openItem,saveItem;
	private TextArea ta;
	private FileDialog openDia,saveDia;

	//将file文件定义在成员上来以便使用
	private File file;

	MenuOpenDemo()
	{
		init();
	}

	public void init()
	{
		//初始化
		f = new Frame("记事本_rsl");
		f.setBounds(300,100,650,600);

		//注意不想要布局是流式布局f.setLayout(new FlowLayout());
		//默认是边界布局就想要添加的组建自动填满窗体
		ta = new TextArea();
		bar = new MenuBar();
		menu =new Menu("文件");
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		closeItem = new MenuItem("退出");

		//初始化打开和保存对话框,查阅api
		openDia = new FileDialog(f,"打开文件",FileDialog.LOAD);
		saveDia = new FileDialog(f,"保存文件",FileDialog.SAVE);

		//菜单条里面添加菜单
		bar.add(menu);

		//菜单里添加打开保存退出条目
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(closeItem);
		
		/*
		效果：
			文件
			打开
			保存
			退出
		*/

		//将菜单条添加到窗体中去
		f.setMenuBar(bar);
		f.add(ta);

		myEvent();

		f.setVisible(true);

	}

	public void myEvent()
	{
		
		//添加需求：点击"打开条目"（属于菜单按钮的事件）会  "打开打开文件的对话框"（属于动作）
		//分析可得查阅menu的监听器方法，发现menuItem有添加监听的方法
		openItem.addActionListener(new ActionListener()//Action类的一般都是一个方法，所以没有Adapter
		{
			public void actionPerformed(ActionEvent e)
			{
				//动作：打开文件对话框出现，所以先需要定义对话框组件
				openDia.setVisible(true);

				//需求：选择某一个文件点击打开，文件的内容会显示在TextArea 里面
				//分析：查阅FileDialog 对象的api查阅功能，如何获取选择的文件：
	//String getDirectory() 获取此文件对话框的目录。String	getFile() 获取此文件对话框的选定文件。
				String dirPath = openDia.getDirectory();//获取文件的目录
				String fileName = openDia.getFile();//获取选取的文件名
				
				//如果没有选择文件，则什么都不操作
				if(dirPath==null || fileName==null)
					return;
				//将文本区域的文件清空
				ta.setText("");

				//将文件封装成文件对象
				file = new File(dirPath,fileName);

				//操作文件，源是获取到的封装好的文件对象，目的是TextArea
				try
				{
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while((line = bufr.readLine())!=null)
					{
						ta.append(line+"\r\n");
					}
					bufr.close();
				}
				catch (IOException ex)
				{
					throw new RuntimeException("读取文件失败！");
				}
	
			}
		});


		//添加需求：点击保存修改后的文件会保存
		saveItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent exx)
			{

				//保存的功能：当新写的文件（就是文件名为null）需要保存时，弹出Dialog
				//当文件存在的时候，不需要new 新的文件，直接将文本区域的数据写入文件
				if(file == null)
				{
					//如果文件不存在就让保存对话框出现
					saveDia.setVisible(true);

					//将选择的文件封装为对象
					String dirPath = saveDia.getDirectory();//获取文件的目录
					String fileName = saveDia.getFile();//获取选取的文件名

					//如果没有选择文件路径，也没有命名要保存为什么名字的文件，则什么都不操作
					if(dirPath==null || fileName==null)
					return;
					//将文件封装成文件对象
					file = new File(dirPath,fileName);
				}

				//开始操作数据
				try
				{
					//建立缓冲区
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					bufw.write(text);

					bufw.close();
				}
				catch (IOException ee)
				{
					throw new RuntimeException("写入文件失败！");
				}

			}
		});



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
	}
	public static void main(String[] args) 
	{
		new MenuOpenDemo();
	}

}

