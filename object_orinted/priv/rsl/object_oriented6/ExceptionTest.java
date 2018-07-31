package priv.rsl.object_oriented6;
/*
事件：毕老师用电脑上课

分析：
1、建立老师类，属性有姓名，在主函数中建立毕老师对象，对象里有讲课的方法
2、建立电脑类，有运行和重启两个方法
3、建立蓝屏类异常，构造函数里调用父类方法
4、建立冒烟类异常，构造函数里调用父类方法

异常：
电脑有蓝屏和冒烟两个异常
*/


class LanPingException extends Exception//因为异常可以进行处理，所以继承Exception
{
	LanPingException(String message)
	{
		super(message);
	}
}

class MaoYanException extends Exception//冒烟本身是不能处理的，但可以转化，也可以继承Exception
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
	 int state=-1;//表示电脑状态正常
	//建立运行方法
	public void run()throws MaoYanException,LanPingException
	{
		if(state==0)
			throw new LanPingException("蓝屏了");
		if(state==-1)
			throw new MaoYanException("冒烟了");

			System.out.println("电脑运行");
	}
	//建立重启方法
	public void reSet()
	{
		System.out.println("电脑重启");
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
	
	public void jiangKe()throws StopClassException//处理冒烟的办法：抛出这个异常给调用jiangKe的语句进行处理。
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
			throw new StopClassException("无法正常上课");
		}
		System.out.println("正常上课");
	}
	public void Test()
	{
		System.out.println("做练习");
	}
}

class ExceptionTest 
{
	public static void main(String[] args) 
	{
		Teacher t = new Teacher("毕老师");
		try
		{
			t.jiangKe();
		}
		catch (StopClassException e)
		{
			System.out.println("Because of "+e.getMessage()+"\n"+"换电脑");
		}
		
	}
}
