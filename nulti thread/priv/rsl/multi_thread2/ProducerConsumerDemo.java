package priv.rsl.multi_thread2;
/*
升级后有两大优点：
1、使用Lock接口的ReentrantLock子类实现来获取和释放锁
2、一个锁上可以支持多个Condition对象，Condition也是接口。
Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用，为每个对象提供多个等待 set（wait-set）。
其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。 


*/

import java.util.concurrent.locks.*;//软件包 java.util.concurrent.locks 为锁和等待条件提供一个框架的接口和类，它不同于内置同步和监视器。 

class ProducerConsumerDemo
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();

		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
/*
JDK1.5中提供了多线程升级解决方案。
将同步Synchronized替换成显式Lock操作。
将Object中的wait，notify notifyAll，替换成了Condition对象。
该对象可以Lock锁进行获取。
在该示例中，实现了本方只唤醒对方操作。

****关键****：
一个锁可以对应多个Condition对象。即一个锁可以有好几组wait 、notify。
原因是把那些方法封装成了Condition对象。

*/

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();

	private Condition condition_pro = lock.newCondition();//第二点：支持多个Conndition对象，此对象用于给生产者线程（即t1和t2）进行休眠和唤醒
	private Condition condition_con = lock.newCondition();//第二点：支持多个Conndition对象，此对象用于给消费者线程（即t1和t2）进行休眠和唤醒

	public void set(String name)throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				condition_pro.await();//代替了原来的try{this.wait();}catch(Exception e){}//且使用了特有的condition对象,这样在唤醒的时候就可以指定唤醒的线程了。
			this.name = name+"---"+count++;

			System.out.println(Thread.currentThread().getName()+".生产者."+this.name);
			flag = true;
			condition_con.signal();//代替了原来的this.notifyAll();//且唤醒的是指定的线程，即只能唤醒被condition_con所休眠的线程（即唤醒对方线程不是本方线程）
		}
		finally//因为await抛出异常可能使程序释放不了锁，必须让其执行unlock
		{
			lock.unlock();
		}
		
	}

	public void out()throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				condition_con.await();//同上

			System.out.println(Thread.currentThread().getName()+".....消费者....."+this.name);		
			flag = false;
			condition_pro.signal();//同上
		}
		finally//因为await抛出异常可能使程序释放不了锁，必须让其执行unlock
		{
			lock.unlock();
		}	
	}
}
class Producer implements Runnable
{
	private Resource res;
	Producer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.set("+商品+");
			}
			catch (InterruptedException e)
			{
			}
			
		}
	}
}

class Consumer implements Runnable
{
	private Resource res;
	Consumer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.out();
			}
			catch (InterruptedException e)
			{
			}
			
		}
	}
}



