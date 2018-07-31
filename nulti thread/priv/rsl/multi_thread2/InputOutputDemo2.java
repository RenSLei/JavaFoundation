package priv.rsl.multi_thread2;
/*
代码优化：
1、将资源属性成员私有化，向外提供方法访问即可。
2、将主函数中的创建线程即开启线程用一句话来表示。
*/
class Res2
{
	private String name;//将其私有化
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name,String sex)//对外提供方法输入姓名和性别
	{
		if(flag)
		try{this.wait();}catch(Exception e){}/*此时的锁就是this*/
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();/*此时的锁就是this*/
	}

	public synchronized void out()//对外提供方法输出姓名和性别
	{
		if(!flag)
		try{this.wait();}catch(Exception e){}/*此时的锁就是this*/

		System.out.println(name+"...."+sex);
		flag = false;
		this.notify();/*此时的锁就是this*/
	}

}


class Input2 implements Runnable
{
	private Res2 r;
	Input2(Res2 r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			if(x==0)
				r.set("mike","man");
			else
				r.set("丽丽","女女女");
			x = (x+1)%2;
		}
	}
}

class Output2 implements Runnable
{
	private Res2 r;
	Output2(Res2 r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}

class  InputOutputDemo2
{
	public static void main(String[] args) 
	{
		Res2 r = new Res2();
		new Thread(new Input2(r)).start();
		new Thread(new Output2(r)).start();
		/*
		Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
		*/
	}
}

