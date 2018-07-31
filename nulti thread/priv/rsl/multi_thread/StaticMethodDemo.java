package priv.rsl.multi_thread;
/*
如果同步函数被静态修饰后，使用的锁是什么呢？
通过验证，发现不是this。因为静态方法中也不可以定义this。

静态进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象。
类名.class   该对象是的类型是Class

静态的同步方法，使用的锁时该方法所在类的字节码文件对象即Ticket.class
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
				synchronized(Ticket3.class)/*关键：括号里用Ticket.class就是为了说明show方法（即show函数）使用的锁是Ticket.class*/
				{
					if(tick>0)
					{
						try{Thread.sleep(10);}catch(Exception e){}/*注意，此语句是利用Thread中的静态sleep方法，强制睡眠10毫秒，并处理该方法抛出的中断异常。观察多线程在实际应用中容易出现的安全问题：即在本例中卖出负号票。*/
						System.out.println(Thread.currentThread().getName()+"code :"+ tick--);
					}
				}
			}	
		}
		else 
			while(true)
				show();
	}
	public static synchronized void show()/*同步函数的锁是this*/
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
		Ticket3 t = new Ticket3(); //创建了一个实现接口Runnable的类的对象。

		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}/**/
		t.flag = false;
		t2.start();
		//Thread t3 = new Thread(t);//创建了一个线程
		//Thread t4 = new Thread(t);//创建了一个线程
		//t3.start();
		//t4.start();
	}
}
/*

*/
