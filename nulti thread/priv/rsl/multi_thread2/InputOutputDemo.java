package priv.rsl.multi_thread2;
/*
线程间通讯：
就是多个线程在操作同一个资源，但是操作的动作不同。

运行结果：
mike...man
mike...man
mike...man
丽丽...女女女
mike...man
丽丽...女女女
丽丽...女女女
丽丽...女女女
......
思考：怎么样才能使往里面存一个，往外面传一个?而不是一片一片打印出来?
设计：创建一个布尔型的变量用来在存于取之前的判断，初始化为false代表里面还没有存
数据，如果为false则执行Input,执行完后将其boolean赋值为true。接着强制使input
放弃执行权即wait，冻结掉input线程。接着同样的方法，如果boolean为true则执行output
在最后将input唤醒，再冻结output。

*/

class Res
{
	String name;
	String sex;
	boolean flag = false;
}


class Input implements Runnable
{
	private Res r;
	Input(Res r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			synchronized(r)/**/
			{
				if(r.flag)
					try{r.wait();}catch(Exception e){}/*wait方法是抛出一个异常，所以得try;而用r.wait是为了让wait的线程是持有r锁的线程（因为同步是可以嵌套的，必须标识出需要冻结的是哪个锁下的线程）*/
				if(x==0)
				{
					r.name = "mike";
					r.sex = "man";
				}
				else
				{
					r.name = "丽丽";
					r.sex = "女女女";
				}
				x = (x+1)%2;
				r.flag = true;
				r.notify();/*注意notify是唤醒线程池中的线程，即被wait的线程,用r.的目的与用wait的目的一样*/
			}
		}
	}
}

class Output implements Runnable
{
	private Res r;
	Output(Res r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)/**/
			{
				if(!r.flag)
					try{r.wait();}catch(Exception e){}
				System.out.println(r.name+"..."+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}

class  InputOutputDemo
{
	public static void main(String[] args) 
	{
		Res r = new Res();//有一个资源

		Input in = new Input(r);//做输入操作的线程1
		Output out = new Output(r);//做输出操作的线程2

		Thread t1 = new Thread(in);//新建Thread对象，接受一个Runnable类型的子类对象
		Thread t2 = new Thread(out);

		t1.start();//开启线程1
		t2.start();//开启线程2
	}
}

/*
运行结果：

mike...man
丽丽...女女女
mike...man
丽丽...女女女
mike...man
丽丽...女女女
......
*/
/*
总结：
wait();
notify();
notifyAll();
都使用在同步中，因为要对持有监视器（锁）的线程操作。
所以要使用在同步中，因为只有同步才具有锁。

为什么这些操作线程的方法要定义Object类中呢？
因为这些方法在操作同步中线程时，都必须要标识他们所操作线程持有的锁
只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
不可以对不同锁中的线程进行唤醒。
也就是说，等待和唤醒必须是同一个锁。

而锁可以是任意对象，所以，可以被任意对象调用的方法定义Object类中。
*/
