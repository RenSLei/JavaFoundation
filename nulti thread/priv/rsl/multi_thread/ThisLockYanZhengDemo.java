package priv.rsl.multi_thread;
/*
��֤ͬ������������this

ʹ�������߳�����Ʊ
һ���߳���ͬ���������
һ���߳���ͬ��������
����ִ����Ʊ������

*/


class Ticket3 implements Runnable
{
	private int tick = 100;
	//Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(this)/*�ؼ�����������this����Ϊ��˵��show��������show������ʹ�õ�����this������obj����ڰ�ȫ���⣬ԭ����û����ѭͬ��������ǰ�ἴ����̱߳�����ͬһ����*/
				{
					if(tick>0)
					{
						try{Thread.sleep(10);}catch(Exception e){}/*ע�⣬�����������Thread�еľ�̬sleep������ǿ��˯��10���룬������÷����׳����ж��쳣���۲���߳���ʵ��Ӧ�������׳��ֵİ�ȫ���⣺���ڱ�������������Ʊ��*/
						System.out.println(Thread.currentThread().getName()+"code :"+ tick--);
					}
				}
			}	
		}
		else 
			while(true)
				show();
	}
	public synchronized void show()/*ͬ������������this*/
	{
		if(tick>0)
			{
				try{Thread.sleep(10);}catch(Exception e){}/*ע�⣬�����������Thread�еľ�̬sleep������ǿ��˯��10���룬������÷����׳����ж��쳣���۲���߳���ʵ��Ӧ�������׳��ֵİ�ȫ���⣺���ڱ�������������Ʊ��*/
				System.out.println(Thread.currentThread().getName()+"...show... :"+ tick--);
			}
	}
}

class ThisLockYanZhengDemo
{
	public static void main(String[] args) 
	
	{
		Ticket t = new Ticket(); //������һ��ʵ�ֽӿ�Runnable����Ķ���

		Thread t1 = new Thread(t);//������һ���߳�
		Thread t2 = new Thread(t);//������һ���߳�
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}/*ͣ���߳�10���룬Ŀ���Ƿ�ֹ���߳�˲��ִ���ꡣ��Ϊt1���ܻ�û�����ü�ִ�У����߳̾�˲��ִ�����ˡ�*/
		t.flag = false;
		t2.start();
		//Thread t3 = new Thread(t);//������һ���߳�
		//Thread t4 = new Thread(t);//������һ���߳�
		//t3.start();
		//t4.start();
	}
}
/*
ʹ��obj��ʱ�����������
Thread-0code :100
Thread-1...show... :99
......
Thread-0code :9
Thread-1...show... :8
Thread-0code :7
Thread-1...show... :6
Thread-0code :5
Thread-1...show... :4
Thread-0code :3
Thread-1...show... :2
Thread-0code :1
Thread-1...show... :0
ʹ��this��ʱ�����������
Thread-0...show... :100
......
Thread-1...show... :9
Thread-1...show... :8
Thread-1...show... :7
Thread-1...show... :6
Thread-1...show... :5
Thread-1...show... :4
Thread-1...show... :3
Thread-1...show... :2
Thread-1...show... :1
*/
