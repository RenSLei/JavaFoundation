package priv.rsl.GUI;
/*
Dialog:�Ի���
��һ��������ͱ߽�Ķ��㴰�ڣ��߽�һ�����ڴ��û������ĳ����ʽ�����롣

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyWindowDemo 
{
	//���Ƚ������������
	private Frame f; 
	private TextField tf; 
	private Button but;
	private TextArea ta;

	//����Ϊ����ʾ���Ի������ý������ⲿ
	private Dialog d;
	//������治��ֱ������ı�����Ҫ��װ��lable����
	private Label lab;
	private Button okBut;


	//���캯��
	MyWindowDemo()
	{
		init();
	}
	//��ʼ������
	public void init()
	{
		f = new Frame("my window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		tf = new TextField(60);
		but = new Button("ת��");
		ta = new TextArea(25,70);

		//��ʼ���Ի��򣬰���˵ �ǲ�Ӧ���������ʼ��
		d= new Dialog(f,"��ʾ��Ϣ-self",true);//ture ������������������˴��ھͲ���������������
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("ȷ��");

		d.add(lab);
		d.add(okBut);


		//�������
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		//�����¼�
		myEvent();

		//��ʾ����
		f.setVisible(true);

	}

	public void myEvent()
	{
		//ע�ᴰ�ڼ�����,�¼�Դ�Ǵ���
		f.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
		});

		//ע�ᰴť���������¼�Դ�ǰ�ť
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showDir();
			}
		});

		//ע����̼��������¼�Դ���ı���
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

		//ע��Ի����������
		d.addWindowListener(new WindowAdapter()
		{
			
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
			
		});
			
		//ע��Ի���ť������
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);
			}
		});

		//Ϊ��ʹ�û���enter��Ҳ��ִ�а�ť������������ݣ�ע����̼�������ť��
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

	
	//��һ��  "��ʾĿ¼�ļ���Ҳ�����ǵ����Ի���"  �Ĺ��ܷ�װ��˽�з���
	private void showDir()
	{
		//�ڰ�ť�����������Ǽ��̣���ʱ�򣬻�ȡ�ı�������ݲ���ʾ���ı�area��ȥ
			String dirPath = tf.getText();
			File dir = new File(dirPath);//��װ���ļ�����
			if(dir.exists() &&dir.isDirectory())
			{
				//����Ǿ����TextArea���ı�
				ta.setText("");

				String[] names = dir.list();
				for(String name:names)
				{
					//��ÿһ��������ӵ�TextArea��,��Ҫ�����ǵ����,����append����
					ta.append(name+"\r\n");
				}

			}
			else
			{
				//������ʾ��Ϣ
				String info_1 = "������ģ�"+dirPath+"�Ǵ���ģ�����������";
				lab.setText(info_1);
				d.setVisible(true);
			}
			

			//���ת�������ԭ��������ı�
			tf.setText("");
	}
	
	
	public static void main(String[] args) 
	{
		new MyWindowDemo();
	}

}
