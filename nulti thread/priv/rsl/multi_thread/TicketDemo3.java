package priv.rsl.multi_thread;
/*
需求：简单的卖票程序。
多个窗口同时卖票。


注意，通过使用try---catch方法观测到了多线程的安全问题。

原因：	当多条语句在操作同一个线程共享数据时，一个线程对多条语句值执行了一部分，还没有执行完，
		另一个线程就参与进来执行，导致共享数据的错误。

解决办法：
	对多条操作共享数据的语句，只能让一个线程全部执行完。在执行过程中，其他线程不可以参与进来。

java对于多线程的安全问题提供了专业的解决方式：

synchronized(对象)
{
	需要同步的代码（这些代码的特点是在操作共享数据）
}


对象如同锁，持有锁的线程可以在同步中执行。
没有持有锁的线程即使获得CPU执行权，也进不去，因为没有获取锁。

同步的前提：
1、必须要有两个或者两个以上的线程。

2、必须是多个线程使用同一个锁。

必须保证同步中只能有一个线程在运行。

好处：解决了多线程的安全问题

弊端：多个线程都需要判断锁，较为消耗资源


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
					try{Thread.sleep(90);}catch(Exception e){}//注意，此语句是利用Thread中的静态sleep方法，强制睡眠10毫秒，并处理该方法抛出的中断异常。观察多线程在实际应用中容易出现的安全问题：即在本例中卖出负号票。
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
		Ticket6 t = new Ticket6(); //创建了一个实现接口Runnable的类的对象。

		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		Thread t3 = new Thread(t);//创建了一个线程
		Thread t4 = new Thread(t);//创建了一个线程

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
