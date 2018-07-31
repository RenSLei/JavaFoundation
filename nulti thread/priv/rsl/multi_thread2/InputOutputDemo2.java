package priv.rsl.multi_thread2;
/*
�����Ż���
1������Դ���Գ�Ա˽�л��������ṩ�������ʼ��ɡ�
2�����������еĴ����̼߳������߳���һ�仰����ʾ��
*/
class Res2
{
	private String name;//����˽�л�
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name,String sex)//�����ṩ���������������Ա�
	{
		if(flag)
		try{this.wait();}catch(Exception e){}/*��ʱ��������this*/
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();/*��ʱ��������this*/
	}

	public synchronized void out()//�����ṩ��������������Ա�
	{
		if(!flag)
		try{this.wait();}catch(Exception e){}/*��ʱ��������this*/

		System.out.println(name+"...."+sex);
		flag = false;
		this.notify();/*��ʱ��������this*/
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
				r.set("����","ŮŮŮ");
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

