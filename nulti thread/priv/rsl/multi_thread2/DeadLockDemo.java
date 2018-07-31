package priv.rsl.multi_thread2;
/*
死锁：同步中嵌套同步。

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
				synchronized(obj)/*嵌套锁：obj锁里有this锁*/
				{
					show();
				}
			}	
		}
		else 
			while(true)
				show();
	}
	public synchronized void show()/*嵌套锁：this锁里有obj锁*/
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
		Ticket t = new Ticket(); //创建了一个实现接口Runnable的类的对象。

		Thread t1 = new Thread(t);//创建了一个线程
		Thread t2 = new Thread(t);//创建了一个线程
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}/*停主线程10毫秒，目的是防止主线程瞬间执行完。因为t1可能还没有来得及执行，主线程就瞬间执行完了。*/
		t.flag = false;
		t2.start();
	
	}
}
/*

*/
