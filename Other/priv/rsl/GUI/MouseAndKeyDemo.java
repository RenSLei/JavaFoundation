package priv.rsl.GUI;
/*
�����¼���
���⣺
TextField�ı����������Ȼ��������������������ȴ�������뺺�֣����������˲���ɾ��
*/

import java.awt.*;
import java.awt.event.*;

class MouseAndKeyDemo 
{
	//�����ͼ������������������
	private Frame f;//��Ӵ���
	private Button but;//��Ӱ�ť
	private TextField tf;//TextField ����������༭�����ı����ı����


	//һ��new FrameDemo�ͳ���һ�����л��������Ĵ���
	MouseAndKeyDemo()
	{
		init();
	}

	//��ʼ��
	public void init()
	{
		f= new Frame("my frame");

		f.setBounds(300,100,600,500);

		f.setLayout(new FlowLayout());

		but = new Button("��¼��ť");
		
		tf = new TextField(20);


		f.add(tf);

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
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("��ť�");
			}

		});

		//ע����̼��������԰�ťbuttonΪ�¼�Դ
		but.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				//��ȡ���µļ���String���ͣ���Ϊ��shift���Ͳ���һ���ַ�
				System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"-----"+e.getKeyCode());

				//������ʾ��ϼ�
				if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_ENTER)//���ֶ�
				System.out.println("Alt+Enter is run");

			}
			
		});

		//ע����̼����������ı���Ϊ�¼�Դ
		tf.addKeyListener(new KeyAdapter()
		{
			//������ֻ�����ı����������֣������ַ���������
			public void keyPressed(KeyEvent e)
			{
				//�ж���������ǲ�������,������Ǿ�ȡ��������
				int code = e.getKeyCode();
				if(!(code>=KeyEvent.VK_0 &&code<=KeyEvent.VK_9))
				{
					System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"�ǷǷ��ģ�");
					e.consume();
				}
				
				/*
				ע��consume()��KeyEvent����InputEvent��һ������
				ʹ�ô��¼����Ա㲻�ᰴ��Ĭ�ϵķ�ʽ�ɲ������¼���Դ������������¼���
				*/

			}
		});


	}


	public static void main(String[] args) 
	{
		new MouseAndKeyDemo();
	}

}
