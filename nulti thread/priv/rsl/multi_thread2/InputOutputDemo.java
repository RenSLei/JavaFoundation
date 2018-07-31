package priv.rsl.multi_thread2;
/*
�̼߳�ͨѶ��
���Ƕ���߳��ڲ���ͬһ����Դ�����ǲ����Ķ�����ͬ��

���н����
mike...man
mike...man
mike...man
����...ŮŮŮ
mike...man
����...ŮŮŮ
����...ŮŮŮ
����...ŮŮŮ
......
˼������ô������ʹ�������һ���������洫һ��?������һƬһƬ��ӡ����?
��ƣ�����һ�������͵ı��������ڴ���ȡ֮ǰ���жϣ���ʼ��Ϊfalse�������滹û�д�
���ݣ����Ϊfalse��ִ��Input,ִ�������boolean��ֵΪtrue������ǿ��ʹinput
����ִ��Ȩ��wait�������input�̡߳�����ͬ���ķ��������booleanΪtrue��ִ��output
�����input���ѣ��ٶ���output��

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
					try{r.wait();}catch(Exception e){}/*wait�������׳�һ���쳣�����Ե�try;����r.wait��Ϊ����wait���߳��ǳ���r�����̣߳���Ϊͬ���ǿ���Ƕ�׵ģ������ʶ����Ҫ��������ĸ����µ��̣߳�*/
				if(x==0)
				{
					r.name = "mike";
					r.sex = "man";
				}
				else
				{
					r.name = "����";
					r.sex = "ŮŮŮ";
				}
				x = (x+1)%2;
				r.flag = true;
				r.notify();/*ע��notify�ǻ����̳߳��е��̣߳�����wait���߳�,��r.��Ŀ������wait��Ŀ��һ��*/
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
		Res r = new Res();//��һ����Դ

		Input in = new Input(r);//������������߳�1
		Output out = new Output(r);//������������߳�2

		Thread t1 = new Thread(in);//�½�Thread���󣬽���һ��Runnable���͵��������
		Thread t2 = new Thread(out);

		t1.start();//�����߳�1
		t2.start();//�����߳�2
	}
}

/*
���н����

mike...man
����...ŮŮŮ
mike...man
����...ŮŮŮ
mike...man
����...ŮŮŮ
......
*/
/*
�ܽ᣺
wait();
notify();
notifyAll();
��ʹ����ͬ���У���ΪҪ�Գ��м��������������̲߳�����
����Ҫʹ����ͬ���У���Ϊֻ��ͬ���ž�������

Ϊʲô��Щ�����̵߳ķ���Ҫ����Object�����أ�
��Ϊ��Щ�����ڲ���ͬ�����߳�ʱ��������Ҫ��ʶ�����������̳߳��е���
ֻ��ͬһ�����ϵı��ȴ��̣߳����Ա�ͬһ������notify���ѡ�
�����ԶԲ�ͬ���е��߳̽��л��ѡ�
Ҳ����˵���ȴ��ͻ��ѱ�����ͬһ������

��������������������ԣ����Ա����������õķ�������Object���С�
*/
