package priv.rsl.multi_thread2;
/*
守护线程：通常的理解：后台线程。即当剩下的线程全部是守护线程时，jvm退出，程序结束。
使用方法：线程名.setDaemon(true);
API说明：
public final void setDaemon(boolean on)将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。 
该方法必须在启动线程前调用。 

*/

class StopThread implements Runnable
{
	private boolean flag = true;
	public void run()
	{
		while(flag)
		{
			System.out.println(Thread.currentThread().getName()+"...run");
		}
	}
	public void changeFlag()//向外提供切换标记的功能
	{
		flag = false;
	}
}

class ShouHuThreadDemo
{
	public static void main(String[] args) 
	{
		StopThread2 st = new StopThread2();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		//下面使用守护线程功能，让t1和t2成为守护线程。
		t1.setDaemon(true);
		t2.setDaemon(true);

		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
				//原有功能是可以在此处写停止线程，目的是让休眠的线程恢复到运行的状态。读取到切换标记。从而达到结束程序的目的。

				break;
			}
			System.out.println(Thread.currentThread().getName()+"....."+num);
		}
		System.out.println("main code run over");	
	}
}
/*
运行结果：
......
main.....59
Thread-1...run
Thread-0...run
Thread-1...run
main.....60
Thread-1...run
Thread-0...run
Thread-1...run
main code run over
Thread-1...run
E:\Step1\day12_多线程\09守护线程>

分析：
主线程和线程1、线程2一起运行，抢占CPU执行权，当主线程执行完毕后，另外两个线程成为了守护线程，所以jvm退出
程序停止。
*/
