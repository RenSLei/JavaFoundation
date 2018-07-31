package priv.rsl.multi_thread;
/*
需求：
银行有一个金库。
有两个储户分别存300元，每次存100。存3次。

目的：该程序是否有安全问题，如果有，如何解决？
如何找问题：
1、明确哪些代码是多线程运行代码。
2、明确共享数据。
3、明确多线程运行代码中哪些语句是操作共享数据的。
*/
class Bank
{
	private int sum;/*sum是共享数据*/
	//Object obj = new Object();
	public synchronized void add(int n)/*加synchronized就是让该函数具备同步性而不是使用同步代码块*/
	{
		//synchronized(obj)/*同步代码块，锁是对象obj*/
		//{
			sum+=n;
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println("sum="+sum);
			/*以上三句是直接操作共享数据，存在安全隐患*/
		//}
		
	}
}

class Cus implements Runnable
{
	private Bank b = new Bank();/*b是共享数据*/
	public void run()//该方法体是start开启线程后自动执行的代码块，即线程要执行的代码块
	{
		for(int x = 0;x<3;x++)
		{
			b.add(100);/*间接操作共享数据*/
		}
	}
}

class BankDemo 
{
	public static void main(String[] args) 
	{
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}
