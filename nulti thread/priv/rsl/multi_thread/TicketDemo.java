package priv.rsl.multi_thread;
/*
���󣺼򵥵���Ʊ����
�������ͬʱ��Ʊ��


*/


class Ticket4 extends Thread
{
	private static int tick = 100;//��һ���ļ�����ʾ�õڶ��ַ��������߳�ʵ�ִ˹��ܣ�������static
	public void run()
	{
		while(true)
		{
			if(tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"sale :"+ tick--);
			}
		}

	}
}

class  TicketDemo
{
	public static void main(String[] args) 
	{
		Ticket4 t1 = new Ticket4();
		Ticket4 t2 = new Ticket4();
		Ticket4 t3 = new Ticket4();
		Ticket4 t4 = new Ticket4();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
