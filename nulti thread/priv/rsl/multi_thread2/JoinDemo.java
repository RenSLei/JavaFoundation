package priv.rsl.multi_thread2;
/*
join:
当A线程执行到了B线程的join方法时，A就会等待。等B线程都执行完，A才会执行。
join可以用来临时加入线程执行。

*/
class Demo implements Runnable
{
	public void run()
	{
		for(int x=0;x<70;x++)
		{
			System.out.println(Thread.currentThread().getName()+"......"+x);
		}
	}
}

class JoinDemo
{
	public static void main(String[] args)throws Exception
	{
		Demo d = new Demo();

		Thread t0 = new Thread(d);
		Thread t1 = new Thread(d);
		
		t0.start();

		//t0.join();/*若join方法放在这里。意思是向CPU申请执行权，即主线程等待t0线程执行完才开始执行*/

		t1.start();

		t0.join();/*主线程读取到这里，释放执行资格，而这时候有两个线程都活着，所以两个线程交替执行，主线程只等待t0线程结束后就立即运行，不管t1线程，*/

		for(int x=0;x<=80;x++)
		{
			System.out.println("main....."+x);
		}
	}
}
