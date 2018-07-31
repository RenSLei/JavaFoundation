package priv.rsl.object_oriented6;
/*
�¼�������ʦ�õ����Ͽ�

������
1��������ʦ�࣬���������������������н�������ʦ���󣬶������н��εķ���
2�����������࣬�����к�������������
3�������������쳣�����캯������ø��෽��
4������ð�����쳣�����캯������ø��෽��

�쳣��
������������ð�������쳣
*/


class LanPingException extends Exception//��Ϊ�쳣���Խ��д������Լ̳�Exception
{
	LanPingException(String message)
	{
		super(message);
	}
}

class MaoYanException extends Exception//ð�̱����ǲ��ܴ���ģ�������ת����Ҳ���Լ̳�Exception
{
	MaoYanException(String message)
	{
		super(message);
	}
}

class StopClassException extends Exception 
{
	StopClassException(String msg)
	{
		super(msg);
	}
}

class Computer
{
	 int state=-1;//��ʾ����״̬����
	//�������з���
	public void run()throws MaoYanException,LanPingException
	{
		if(state==0)
			throw new LanPingException("������");
		if(state==-1)
			throw new MaoYanException("ð����");

			System.out.println("��������");
	}
	//������������
	public void reSet()
	{
		System.out.println("��������");
		state = 1;
	}
}

class Teacher
{
	private String name;
	private Computer cmpt;
	Teacher(String name)
	{
		this.name = name;
		cmpt = new Computer();
	}
	
	public void jiangKe()throws StopClassException//����ð�̵İ취���׳�����쳣������jiangKe�������д���
	{
		try
		{
			cmpt.run();
		}
		catch (LanPingException e)
		{
			System.out.println("Because of "+e.getMessage());
	
			cmpt.reSet();
			
		}
		catch (MaoYanException e)
		{
			Test();
			throw new StopClassException("�޷������Ͽ�");
		}
		System.out.println("�����Ͽ�");
	}
	public void Test()
	{
		System.out.println("����ϰ");
	}
}

class ExceptionTest 
{
	public static void main(String[] args) 
	{
		Teacher t = new Teacher("����ʦ");
		try
		{
			t.jiangKe();
		}
		catch (StopClassException e)
		{
			System.out.println("Because of "+e.getMessage()+"\n"+"������");
		}
		
	}
}
