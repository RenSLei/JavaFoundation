package priv.rsl.multi_thread2;
/*
join:
��A�߳�ִ�е���B�̵߳�join����ʱ��A�ͻ�ȴ�����B�̶߳�ִ���꣬A�Ż�ִ�С�
join����������ʱ�����߳�ִ�С�

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

		//t0.join();/*��join�������������˼����CPU����ִ��Ȩ�������̵߳ȴ�t0�߳�ִ����ſ�ʼִ��*/

		t1.start();

		t0.join();/*���̶߳�ȡ������ͷ�ִ���ʸ񣬶���ʱ���������̶߳����ţ����������߳̽���ִ�У����߳�ֻ�ȴ�t0�߳̽�������������У�����t1�̣߳�*/

		for(int x=0;x<=80;x++)
		{
			System.out.println("main....."+x);
		}
	}
}
