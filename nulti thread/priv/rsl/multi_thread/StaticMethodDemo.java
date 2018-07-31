package priv.rsl.multi_thread;
/*
���ͬ����������̬���κ�ʹ�õ�����ʲô�أ�
ͨ����֤�����ֲ���this����Ϊ��̬������Ҳ�����Զ���this��

��̬���ڴ�ʱ���ڴ���û�б�����󣬵���һ���и����Ӧ���ֽ����ļ�����
����.class   �ö����ǵ�������Class

��̬��ͬ��������ʹ�õ���ʱ�÷�����������ֽ����ļ�����Ticket.class
*/


class Ticket implements Runnable
{
	private static int tick = 100;
	//Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(Ticket3.class)/*�ؼ�����������Ticket.class����Ϊ��˵��show��������show������ʹ�õ�����Ticket.class*/
				{
					if(tick>0)
					{
						try{Thread.sleep(10);}catch(Exception e){}/*ע�⣬�����������Thread�еľ�̬sleep������ǿ��˯��10���룬������÷����׳����ж��쳣���۲���߳���ʵ��Ӧ�������׳��ֵİ�ȫ���⣺���ڱ�������������Ʊ��*/
						System.out.println(Thread.currentThread().getName()+"code :"+ tick--);
					}
				}
			}	
		}
		else 
			while(true)
				show();
	}
	public static synchronized void show()/*ͬ������������this*/
	{
		if(tick>0)
			{
				try{Thread.sleep(10);}catch(Exception e){}/**/
				System.out.println(Thread.currentThread().getName()+"...show... :"+ tick--);
			}
	}
}

class StaticMethodDemo
{
	public static void main(String[] args) 
	
	{
		Ticket3 t = new Ticket3(); //������һ��ʵ�ֽӿ�Runnable����Ķ���

		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}/**/
		t.flag = false;
		t2.start();
		//Thread t3 = new Thread(t);//������һ���߳�
		//Thread t4 = new Thread(t);//������һ���߳�
		//t3.start();
		//t4.start();
	}
}
/*

*/
