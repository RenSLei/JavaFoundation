package priv.rsl.multi_thread;
/*
���󣺼򵥵���Ʊ����
�������ͬʱ��Ʊ��


ע�⣬ͨ��ʹ��try---catch�����۲⵽�˶��̵߳İ�ȫ���⡣

ԭ��	����������ڲ���ͬһ���̹߳�������ʱ��һ���̶߳Զ������ִֵ����һ���֣���û��ִ���꣬
		��һ���߳̾Ͳ������ִ�У����¹������ݵĴ���

����취��
	�Զ��������������ݵ���䣬ֻ����һ���߳�ȫ��ִ���ꡣ��ִ�й����У������̲߳����Բ��������

java���ڶ��̵߳İ�ȫ�����ṩ��רҵ�Ľ����ʽ��

synchronized(����)
{
	��Ҫͬ���Ĵ��루��Щ������ص����ڲ����������ݣ�
}


������ͬ�������������߳̿�����ͬ����ִ�С�
û�г��������̼߳�ʹ���CPUִ��Ȩ��Ҳ����ȥ����Ϊû�л�ȡ����

ͬ����ǰ�᣺
1������Ҫ�����������������ϵ��̡߳�

2�������Ƕ���߳�ʹ��ͬһ������

���뱣֤ͬ����ֻ����һ���߳������С�

�ô�������˶��̵߳İ�ȫ����

�׶ˣ�����̶߳���Ҫ�ж�������Ϊ������Դ


*/


class Ticket6 implements Runnable
{
	private int tick = 100;
	Object obj = new Object();
	public void run()
	{
		while(true)
		{
			synchronized(obj)
			{
				if(tick>0)
				{
					try{Thread.sleep(90);}catch(Exception e){}//ע�⣬�����������Thread�еľ�̬sleep������ǿ��˯��10���룬������÷����׳����ж��쳣���۲���߳���ʵ��Ӧ�������׳��ֵİ�ȫ���⣺���ڱ�������������Ʊ��
					System.out.println(Thread.currentThread().getName()+"sale :"+ tick--);
				}
			}
		}

	}
}

class  TicketDemo3
{
	public static void main(String[] args) 
	
	{
		Ticket6 t = new Ticket6(); //������һ��ʵ�ֽӿ�Runnable����Ķ���

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
