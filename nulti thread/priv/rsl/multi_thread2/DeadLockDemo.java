package priv.rsl.multi_thread2;
/*
������ͬ����Ƕ��ͬ����

*/


class Ticket implements Runnable
{
	private int tick = 1000;
	Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(obj)/*Ƕ������obj������this��*/
				{
					show();
				}
			}	
		}
		else 
			while(true)
				show();
	}
	public synchronized void show()/*Ƕ������this������obj��*/
	{
		synchronized(obj)
		{
			if(tick>0)
			{
				try{Thread.sleep(10);}catch(Exception e){}/**/
				System.out.println(Thread.currentThread().getName()+"code :"+ tick--);
			}
		}
	}
}

class DeadLockDemo
{
	public static void main(String[] args) 
	
	{
		Ticket t = new Ticket(); //������һ��ʵ�ֽӿ�Runnable����Ķ���

		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}/*ͣ���߳�10���룬Ŀ���Ƿ�ֹ���߳�˲��ִ���ꡣ��Ϊt1���ܻ�û�����ü�ִ�У����߳̾�˲��ִ�����ˡ�*/
		t.flag = false;
		t2.start();
	
	}
}
/*

*/
