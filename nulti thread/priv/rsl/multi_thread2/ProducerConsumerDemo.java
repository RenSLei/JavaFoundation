package priv.rsl.multi_thread2;
/*
�������������ŵ㣺
1��ʹ��Lock�ӿڵ�ReentrantLock����ʵ������ȡ���ͷ���
2��һ�����Ͽ���֧�ֶ��Condition����ConditionҲ�ǽӿڡ�
Condition �� Object ������������wait��notify �� notifyAll���ֽ�ɽ�Ȼ��ͬ�Ķ����Ա�ͨ������Щ���������� Lock ʵ�����ʹ�ã�Ϊÿ�������ṩ����ȴ� set��wait-set����
���У�Lock ����� synchronized ����������ʹ�ã�Condition ����� Object ������������ʹ�á� 


*/

import java.util.concurrent.locks.*;//����� java.util.concurrent.locks Ϊ���͵ȴ������ṩһ����ܵĽӿں��࣬����ͬ������ͬ���ͼ������� 

class ProducerConsumerDemo
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();

		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
/*
JDK1.5���ṩ�˶��߳��������������
��ͬ��Synchronized�滻����ʽLock������
��Object�е�wait��notify notifyAll���滻����Condition����
�ö������Lock�����л�ȡ��
�ڸ�ʾ���У�ʵ���˱���ֻ���ѶԷ�������

****�ؼ�****��
һ�������Զ�Ӧ���Condition���󡣼�һ���������кü���wait ��notify��
ԭ���ǰ���Щ������װ����Condition����

*/

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();

	private Condition condition_pro = lock.newCondition();//�ڶ��㣺֧�ֶ��Conndition���󣬴˶������ڸ��������̣߳���t1��t2���������ߺͻ���
	private Condition condition_con = lock.newCondition();//�ڶ��㣺֧�ֶ��Conndition���󣬴˶������ڸ��������̣߳���t1��t2���������ߺͻ���

	public void set(String name)throws InterruptedException
	{
		lock.lock();
		try
		{
			while(flag)
				condition_pro.await();//������ԭ����try{this.wait();}catch(Exception e){}//��ʹ�������е�condition����,�����ڻ��ѵ�ʱ��Ϳ���ָ�����ѵ��߳��ˡ�
			this.name = name+"---"+count++;

			System.out.println(Thread.currentThread().getName()+".������."+this.name);
			flag = true;
			condition_con.signal();//������ԭ����this.notifyAll();//�һ��ѵ���ָ�����̣߳���ֻ�ܻ��ѱ�condition_con�����ߵ��̣߳������ѶԷ��̲߳��Ǳ����̣߳�
		}
		finally//��Ϊawait�׳��쳣����ʹ�����ͷŲ���������������ִ��unlock
		{
			lock.unlock();
		}
		
	}

	public void out()throws InterruptedException
	{
		lock.lock();
		try
		{
			while(!flag)
				condition_con.await();//ͬ��

			System.out.println(Thread.currentThread().getName()+".....������....."+this.name);		
			flag = false;
			condition_pro.signal();//ͬ��
		}
		finally//��Ϊawait�׳��쳣����ʹ�����ͷŲ���������������ִ��unlock
		{
			lock.unlock();
		}	
	}
}
class Producer implements Runnable
{
	private Resource res;
	Producer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.set("+��Ʒ+");
			}
			catch (InterruptedException e)
			{
			}
			
		}
	}
}

class Consumer implements Runnable
{
	private Resource res;
	Consumer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.out();
			}
			catch (InterruptedException e)
			{
			}
			
		}
	}
}



