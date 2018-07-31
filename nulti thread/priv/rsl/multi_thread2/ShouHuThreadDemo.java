package priv.rsl.multi_thread2;
/*
�ػ��̣߳�ͨ������⣺��̨�̡߳�����ʣ�µ��߳�ȫ�����ػ��߳�ʱ��jvm�˳������������
ʹ�÷������߳���.setDaemon(true);
API˵����
public final void setDaemon(boolean on)�����̱߳��Ϊ�ػ��̻߳��û��̡߳����������е��̶߳����ػ��߳�ʱ��Java ������˳��� 
�÷��������������߳�ǰ���á� 

*/

class StopThread implements Runnable
{
	private boolean flag = true;
	public void run()
	{
		while(flag)
		{
			System.out.println(Thread.currentThread().getName()+"...run");
		}
	}
	public void changeFlag()//�����ṩ�л���ǵĹ���
	{
		flag = false;
	}
}

class ShouHuThreadDemo
{
	public static void main(String[] args) 
	{
		StopThread2 st = new StopThread2();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		//����ʹ���ػ��̹߳��ܣ���t1��t2��Ϊ�ػ��̡߳�
		t1.setDaemon(true);
		t2.setDaemon(true);

		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
				//ԭ�й����ǿ����ڴ˴�дֹͣ�̣߳�Ŀ���������ߵ��ָ̻߳������е�״̬����ȡ���л���ǡ��Ӷ��ﵽ���������Ŀ�ġ�

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
main.....59
Thread-1...run
Thread-0...run
Thread-1...run
main.....60
Thread-1...run
Thread-0...run
Thread-1...run
main code run over
Thread-1...run
E:\Step1\day12_���߳�\09�ػ��߳�>

������
���̺߳��߳�1���߳�2һ�����У���ռCPUִ��Ȩ�������߳�ִ����Ϻ����������̳߳�Ϊ���ػ��̣߳�����jvm�˳�
����ֹͣ��
*/
