package priv.rsl.multi_thread;
/*
����
������һ����⡣
�����������ֱ��300Ԫ��ÿ�δ�100����3�Ρ�

Ŀ�ģ��ó����Ƿ��а�ȫ���⣬����У���ν����
��������⣺
1����ȷ��Щ�����Ƕ��߳����д��롣
2����ȷ�������ݡ�
3����ȷ���߳����д�������Щ����ǲ����������ݵġ�
*/
class Bank
{
	private int sum;/*sum�ǹ�������*/
	//Object obj = new Object();
	public synchronized void add(int n)/*��synchronized�����øú����߱�ͬ���Զ�����ʹ��ͬ�������*/
	{
		//synchronized(obj)/*ͬ������飬���Ƕ���obj*/
		//{
			sum+=n;
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println("sum="+sum);
			/*����������ֱ�Ӳ����������ݣ����ڰ�ȫ����*/
		//}
		
	}
}

class Cus implements Runnable
{
	private Bank b = new Bank();/*b�ǹ�������*/
	public void run()//�÷�������start�����̺߳��Զ�ִ�еĴ���飬���߳�Ҫִ�еĴ����
	{
		for(int x = 0;x<3;x++)
		{
			b.add(100);/*��Ӳ�����������*/
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
