package priv.rsl.multi_thread;
/*
需求：简单的卖票程序。
多个窗口同时卖票。


创建线程的第二种方式：实现Runnable接口

步骤：
1、定义实现Runnable接口

2、覆盖Runnable接口中的run方法。
	将该线程所需要运行的代码存放在该run方法中。

3、通过Thread类建立线程对象。

4、将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数。
因为，自定义的run方法所属的对象是Runnable接口的子类对象。
所以要让线程去执行指定对象的run方法。就必须明确该run方法所属的对象。

5、调用Thread类的start方法开启线程并调用Runnable接口子类的run方法。


实现方式和继承方式有什么区别？

实现方式好处：避免了单继承的局限性。
在定义线程时，建议使用实现的方式。

继承Thread：线程代码存放在Thread子类的run方法中。
继承Runnable：线程代码存放在接口Runnable的子类的run方法中。


*/


class Ticket5 implements Runnable// extends Thread
{
	private int tick = 100;//此程序将演示用第二种方法创建线程实现此功能，而不用static
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
		Ticket5 t = new Ticket5(); //创建了一个实现接口Runnable的类的对象。

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
