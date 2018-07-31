package priv.rsl.multi_thread2;
/*
stop 方法已经过时。

如何停止线程？
只有一种原理：run方法结束。
开启多线程运行，运行代码通常是循环结构。

只要控制住循环，就可以让run 方法结束，也就是线程结束。

*/

class StopThread2 implements Runnable
{
	private boolean flag = true;
	public synchronized void run()
	{
		while(flag)
		{
			try
			{
				wait();//两个线程不论啥时候进来都挂在这里。只有当醒来才能读取到标记flag。
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName()+"....Exception");
				flag = false;/*此句重要，表示一旦有强制使线程恢复运行时，就将标记记为false*/
			}
			System.out.println(Thread.currentThread().getName()+"...run");
		}
	}
	public void changeFlag()//没用处了，或者说可以不需要了。
	{
		flag = false;
	}
}

class StopThreadDemo
{
	public static void main(String[] args) 
	{
		StopThread st = new StopThread();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
				/*
				当没有指定的方式让冻结的线程恢复到运行状态时，这时候需要对冻结状态进行清除
				强制让线程恢复到运行状态。这样就可以操作标记让线程结束。
				Thread类提供该方法 interrupt()
				*/
				t1.interrupt();
				t2.interrupt();
				//st.changeFlag();/*虽然主线程读取到了此函数，改变了标记flag值，但两个线程已经读取不到标记了，因为两个线程已经wait了。此时程序就不能结束。*/
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
main.....56
main.....57
main.....58
main.....59
main.....60
main code run over
Thread-0....Exception
Thread-0...run
Thread-1....Exception
Thread-1...run

E:\Step1\day12_多线程\08停止线程>
*/
