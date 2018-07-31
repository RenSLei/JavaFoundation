package priv.rsl.multi_thread;
/*
需求：简单的卖票程序。
多个窗口同时卖票。


*/


class Ticket4 extends Thread
{
	private static int tick = 100;//下一个文件将演示用第二种方法创建线程实现此功能，而不用static
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

class  TicketDemo
{
	public static void main(String[] args) 
	{
		Ticket4 t1 = new Ticket4();
		Ticket4 t2 = new Ticket4();
		Ticket4 t3 = new Ticket4();
		Ticket4 t4 = new Ticket4();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
