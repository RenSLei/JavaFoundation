package priv.rsl.object_oriented4;
/*
对DuoTaiDemo2中的进行类似优化:即将主函数中的功能抽取出来形成一个工具类，
在主函数中建立该类的对象来调用该类的功能即可
*/

/*
基础班：学习，睡觉
高级班：学习，睡觉
但学习内容不同
*/

abstract class  Student
{
	public abstract void study();
	public void sleep()
	{
		System.out.println("躺着睡");
	}
}

/*将主函数中的功能抽取出来形成一个工具类*/
class DoSome
{
	public void doSome(Student stu)//注意是父类，相当于:父类 s = new 子类();向上转型；
	{
		stu.study();
		stu.sleep();
	}
}
//---------------------------------------------------------------以上就是整个程序主体，下面是具体实现它的类
class BaseStudent extends Student
{
	public void study()
	{
		System.out.println("base study");
	}
	public void sleep()
	{
		System.out.println("坐着睡");
	}
}

class AdvStudent extends Student
{
	public void study()
	{
		System.out.println("adv study");
	}
}

//--主函数建立工具类的对象，调用其功能就行了，传递参数是新建的具体类的对象
class  DuoTaiDemo3
{
	public static void main(String[] args) 
	{
		DoSome s = new DoSome();
		s.doSome(new BaseStudent());
		s.doSome(new AdvStudent());
	}
}

//总结：对类型进行抽取，导致了多态的产生，操作同一个大类型（如Student），对大类型中的所有小类型都能进行操作。这样就提高了扩展性。
