package priv.rsl.GUI;
/*
ͼ�λ����棺
���ڵĽ����Լ��������������ã�
Frame �Ǵ��б���ͱ߿�Ķ��㴰�ڡ�

�������裺
1.����frame����
2.���ô��壺��С��λ�ã�����
3.�������
4.�����ͨ�������add������ӵ�������
5.�ô�����ʾ��ͨ��setVisible(true);


�¼��������Ƶ��ص㣺
1���¼�Դ
2���¼�
3��������
4���¼�����

�¼�Դ��awt������swing���е���Щͼ�ν��������

�¼���ÿһ���¼�Դ�����Լ����еĶ�Ӧ�¼��͹����¼���

�������������Դ���ĳһ���¼��Ķ�������ֻ��һ�����������Ѿ���װ���˼�������

����������java�ж��Ѿ��������
ֱ�ӻ�ȡ��������þͿ�����

�����������飺�Բ����������д���


*/

import java.awt.*;
import java.awt.event.*;
class AwtDemo 
{
	public static void main(String[] args) 
	{
		//����һ���µġ�������ɼ��ġ�����ָ������� Frame ����:
		
		Frame f = new Frame("my awt");

		//���ô����С��
		f.setSize(500,400);//����500������400

		//����λ�ã�
		f.setLocation(300,200);//�������ϽǶ��������ߣ������ϱ�

		//���ò���ģʽ������Ϊ��ʽ����
		f.setLayout(new FlowLayout());

		//���һ�����
		Button b = new Button("����һ����ť");

		//�������ӵ�������ȥ��
		f.add(b);//Ĭ�ϵĲ����Ǳ߽�ʽ���֣����û�����ò���ģʽ����ӵ�����������䴰��
		
		

		//����ע�������
		/*˵����
			������Window�ࣨFrame�ĸ��ࣩ��һ������
		��������Ĳ�����һ���ӿڣ��ҷ�����7��������Ҫֱ��ʹ�����е�һ�����������븲�����еķ���
		���ֽӿ�WindowListener������WindowAdapter�Ѿ���д�������з������ҷ���ȫ��Ϊ�գ�����ֻ��Ҫ
		��Թ��ĵ��¼����巽��������ĳ������Ƿ��㴴������������

		ע�⣺�� WindowAdapter������java.awt.event ������һ��Ҫ��������

		*/
		//f.addWindowListener(new MyWin());
		//�����Ͼ䣬дһ�������ڲ��ࣺ
		f.addWindowListener(new WindowAdapter()
		{
			//��д���������ڹرն����Ĵ���ʽ
			public void windowClosing(WindowEvent e)
			{
			System.out.println("�ر�");
			System.exit(0);
			}

			//Activated��ֻҪ���ڴ���ǰ��ʱִ��
			public void windowActivated(WindowEvent e)
			{
				System.out.println("�ұ�ǰ����");
			}

			//����һ���򿪾�ִ��
			public void windowOpened(WindowEvent e) 
			{
				System.out.println("�ұ�����");
			}


		});
		//��������ʾ������
		f.setVisible(true);//ע��һ��������ͻῪ��һ���µ��߳�

		
	}
}

	//дһ������̳�WindowAdapter������������Ҫ�ķ����Ϳ�����
	class MyWin extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			//д�����������ǵ���رմ��ڰ�ťʱ����Ļ������window closing
			//System.out.println("window closing");
			//��ȷ��������
			System.exit(0);
		}
	}
