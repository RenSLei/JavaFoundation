package priv.rsl.GUI;
/*

*/

import java.awt.*;
import java.awt.event.*;

class FrameDemo 
{
	//�����ͼ������������������
	private Frame f;
	private Button but;

	//һ��new FrameDemo�ͳ���һ�����л��������Ĵ���
	FrameDemo()
	{
		init();
	}

	//��ʼ��
	public void init()
	{
		f= new Frame("my frame");

		//��frame���л�������
		//f.setSize();f.setLocation();
		f.setBounds(300,100,600,500);//�Ǹ���Component�ķ������������ô�С�Լ�λ��
		/*
		public void setBounds(int x,int y,int width,int height)
		�ƶ�������������С���� x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
		*/

		f.setLayout(new FlowLayout());

		but = new Button("my button");

		//�������ӵ�Frame��
		f.add(but);

		//��ʾ����֮ǰ���ش����¼�
		myEvent();

		//��ʾ����
		f.setVisible(true);
	}

	//���¼��ʹ������÷��뿪
	private void myEvent()
	{
		//ע�ᴰ�������
		f.addWindowListener(new WindowAdapter()
		{
			//���Ƿ���
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//ע�ᰴť������
		/*
		�ð�ť�߱��˳�����Ĺ��ܣ�
		˼�룺
		��ť�����¼�Դ����ô�����ʲô�������أ�
		ͨ���رմ���ʾ���˽⵽����Ҫ֪���ĸ�����߱�ʲô�������м�������
		��Ҫ�鿴���������Ĺ���
		ͨ���鿴���������Ĺ���

		ͨ������button�����������ְ�ť֧��һ�����еļ�������addActionListener

		ע�⣺addActionListenerû����addWindowListener��������WindowAdapter����Ϊ
		addActionListener��ֻ��һ���������������ּ��������٣�һ��Ķ�������������Ϊ�������ĳ�����Ϊ��
		����ע����������������˼������ķ������Ƿ���������Ϊ�ա�
		*/

		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("��ť�˳�");
				System.exit(0);
			}

		});
	}



	public static void main(String[] args) 
	{
		new FrameDemo();
	}
}
