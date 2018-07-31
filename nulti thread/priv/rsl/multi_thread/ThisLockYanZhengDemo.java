package priv.rsl.multi_thread;
/*
验证同步函数的锁是this

使用两个线程来卖票
一个线程在同步代码块中
一个线程在同步函数中
都在执行卖票动作。

*/


class Ticket3 implements Runnable
{
	private int tick = 100;
	//Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(this)/*关键：括号里用this就是为了说明show方法（即show函数）使用的锁是this，若用obj则存在安全问题，原因是没有遵循同步函数的前提即多个线程必须是同一个锁*/
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
	public synchronized void show()/*同步函数的锁是this*/
	{
		if(tick>0)
			{
				try{Thread.sleep(10);}catch(Exception e){}/*注意，此语句是利用Thread中的静态sleep方法，强制睡眠10毫秒，并处理该方法抛出的中断异常。观察多线程在实际应用中容易出现的安全问题：即在本例中卖出负号票。*/
				System.out.println(Thread.currentThread().getName()+"...show... :"+ tick--);
			}
	}
}

class ThisLockYanZhengDemo
{
	public static void main(String[] args) 
	
	{
		Ticket t = new Ticket(); //创建了一个实现接口Runnable的类的对象。

		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}/*停主线程10毫秒，目的是防止主线程瞬间执行完。因为t1可能还没有来得及执行，主线程就瞬间执行完了。*/
		t.flag = false;
		t2.start();
		//Thread t3 = new Thread(t);//创建了一个线程
		//Thread t4 = new Thread(t);//创建了一个线程
		//t3.start();
		//t4.start();
	}
}
/*
使用obj锁时的运行情况：
Thread-0code :100
Thread-1...show... :99
......
Thread-0code :9
Thread-1...show... :8
Thread-0code :7
Thread-1...show... :6
Thread-0code :5
Thread-1...show... :4
Thread-0code :3
Thread-1...show... :2
Thread-0code :1
Thread-1...show... :0
使用this锁时的运行情况：
Thread-0...show... :100
......
Thread-1...show... :9
Thread-1...show... :8
Thread-1...show... :7
Thread-1...show... :6
Thread-1...show... :5
Thread-1...show... :4
Thread-1...show... :3
Thread-1...show... :2
Thread-1...show... :1
*/
