package priv.rsl.GUI;
/*
�˵�����

*/


import java.awt.*;
import java.awt.event.*;
class MyMenuDemo 
{
	//���Ƚ������������
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
		//��ʼ��
		f = new Frame("MyMenuWindow");
		f.setBounds(300,100,500,600);
		f.setLayout(new FlowLayout());

		mb = new MenuBar();
		m1 =new Menu("�ļ�");
		m2 =new Menu("�Ӳ˵�1");
		m3 =new Menu("�Ӳ˵�2");
		subItem1 = new MenuItem("����Ŀ1");
		subItem2 = new MenuItem("����Ŀ2");

		closeItem = new MenuItem("�˳�");
		
		//�˵���������Ӳ˵�
		mb.add(m1);
		//�˵�������Ӳ˵�
		m1.add(m2);
		//�˵��������Ŀ
		m2.add(subItem1);

		m1.add(m3);
		m3.add(subItem2);
		m1.add(closeItem);

		/*
		Ч����
			�ļ�
			�Ӳ˵�1-->����Ŀ1
			�Ӳ˵�2-->����Ŀ2
			�˳�
		*/

		//���˵�����ӵ�������ȥ
		f.setMenuBar(mb);

		myEvent();

		f.setVisible(true);

	}

	public void myEvent()
	{
		//���ڵ������ǵ�����˳���ʱ��������
		//��Ӽ���������api����MenuItem֧�ֻ����
		closeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		//��Ӵ��ڼ�����
		f.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});

		//���

	}


	public static void main(String[] args) 
	{
		new MyMenuDemo();
	}

}

