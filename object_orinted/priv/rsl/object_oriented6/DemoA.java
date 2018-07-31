package priv.rsl.object_oriented6;

public class DemoA extends priv.rsl.object_oriented6.DemoB//注意，包与包之间要进行访问,对于被访问的包来讲，类和成员必须要加public修饰符
{
	public void show()//类公有后，其成员也要公有才有足够大的权限。
	{
		System.out.println("demo show run");
		method();//注意只有其子类才可以访问method;
		
	}
}
