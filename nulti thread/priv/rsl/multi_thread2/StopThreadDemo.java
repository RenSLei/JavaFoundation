package priv.rsl.multi_thread2;
/*
stop �����Ѿ���ʱ��

���ֹͣ�̣߳�
ֻ��һ��ԭ��run����������
�������߳����У����д���ͨ����ѭ���ṹ��

ֻҪ����סѭ�����Ϳ�����run ����������Ҳ�����߳̽�����

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
				wait();//�����̲߳���ɶʱ��������������ֻ�е��������ܶ�ȡ�����flag��
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName()+"....Exception");
				flag = false;/*�˾���Ҫ����ʾһ����ǿ��ʹ�ָ̻߳�����ʱ���ͽ���Ǽ�Ϊfalse*/
			}
			System.out.println(Thread.currentThread().getName()+"...run");
		}
	}
	public void changeFlag()//û�ô��ˣ�����˵���Բ���Ҫ�ˡ�
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
				��û��ָ���ķ�ʽ�ö�����ָ̻߳�������״̬ʱ����ʱ����Ҫ�Զ���״̬�������
				ǿ�����ָ̻߳�������״̬�������Ϳ��Բ���������߳̽�����
				Thread���ṩ�÷��� interrupt()
				*/
				t1.interrupt();
				t2.interrupt();
				//st.changeFlag();/*��Ȼ���̶߳�ȡ���˴˺������ı��˱��flagֵ���������߳��Ѿ���ȡ��������ˣ���Ϊ�����߳��Ѿ�wait�ˡ���ʱ����Ͳ��ܽ�����*/
				break;
			}
			System.out.println(Thread.currentThread().getName()+"....."+num);
		}
		System.out.println("main code run over");	
	}
}
/*
���н����
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

E:\Step1\day12_���߳�\08ֹͣ�߳�>
*/
