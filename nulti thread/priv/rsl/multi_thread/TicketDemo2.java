package priv.rsl.multi_thread;
/*
���󣺼򵥵���Ʊ����
�������ͬʱ��Ʊ��


�����̵߳ĵڶ��ַ�ʽ��ʵ��Runnable�ӿ�

���裺
1������ʵ��Runnable�ӿ�

2������Runnable�ӿ��е�run������
	�����߳�����Ҫ���еĴ������ڸ�run�����С�

3��ͨ��Thread�ཨ���̶߳���

4����Runnable�ӿڵ����������Ϊʵ�ʲ������ݸ�Thread��Ĺ��캯����
��Ϊ���Զ����run���������Ķ�����Runnable�ӿڵ��������
����Ҫ���߳�ȥִ��ָ�������run�������ͱ�����ȷ��run���������Ķ���

5������Thread���start���������̲߳�����Runnable�ӿ������run������


ʵ�ַ�ʽ�ͼ̳з�ʽ��ʲô����

ʵ�ַ�ʽ�ô��������˵��̳еľ����ԡ�
�ڶ����߳�ʱ������ʹ��ʵ�ֵķ�ʽ��

�̳�Thread���̴߳�������Thread�����run�����С�
�̳�Runnable���̴߳������ڽӿ�Runnable�������run�����С�


*/


class Ticket5 implements Runnable// extends Thread
{
	private int tick = 100;//�˳�����ʾ�õڶ��ַ��������߳�ʵ�ִ˹��ܣ�������static
	public void run()
	{
		while(true)
		{
			if(tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"sale :"+ tick--);
			}
		}

	}
}

class  TicketDemo2
{
	public static void main(String[] args) 
	{
		Ticket5 t = new Ticket5(); //������һ��ʵ�ֽӿ�Runnable����Ķ���

		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		Thread t3 = new Thread(t);//������һ���߳�
		Thread t4 = new Thread(t);//������һ���߳�

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
