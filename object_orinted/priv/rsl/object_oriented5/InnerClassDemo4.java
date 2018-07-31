package priv.rsl.object_oriented5;
/*
匿名内部类：
1、匿名内部类其实就是内部类的简写格式。
2、定义匿名内部类前提：
	内部类必须继承一个类，或者实现接口。
3、匿名内部类的格式：new 父类或者接口(){定义子类的内容}
4、其实匿名内部类就是一个匿名子类对象，将定义类和建立对象封装为一体。而且这个对象有点胖。
   也可以理解为带内容的对象。
5、匿名内部类中定义的方法最好不要超过3个


*/

abstract class AbsDemo
{
	 abstract void show();
}

class Outer4
{
	int x = 3;
	/*
	class Inner extends AbsDemo
	{
		void show()
		{
			System.out.println("show:"+x);
		}
	}
	*/

	public void function()
	{
		//new Inner().show();
		/*下面使用匿名内部类将以上注释的部分同时完成*/
		/*注意，AbsDemo是抽象类，所以是不能建立对象的。原因是其里面全是抽象方法。
		当我们把抽象方法覆盖掉，就可以建立对象了，但此时的对象就叫做AbsDemo的子类匿名对象即匿名对象
		为什么是子类？因为我们知道，只有子类才能复写父类中的抽象功能。
		*/
		new AbsDemo()
		{
			void show()
			{
				System.out.println("x="+x);
			}
			void abc()
			{
				System.out.println("子类特有功能");
			}
		}.show();
		/*
		new AbsDemo()
		{
			void show()
			{
				System.out.println("x="+x);
			}
			void abc()
			{
				System.out.println("子类特有功能");
			}
		}是一个整体，是一个匿名子类对象，相当于new Inner()
		.show();是调用成员。


	局限：匿名内部类只能调用复写父类方法的那个方法，即使给匿名内部类起了名字，
			调用其他方法时编译失败
			如：
			AbsDemo d = new AbsDemo()
		{
			void show()
			{
				System.out.println("x="+x);
			}
			void abc()
			{
				System.out.println("子类特有功能");
			}
		};
		d.show();此编译成功
		d.abc();此编译失败

		*/

	}
} 

class InnerClassDemo4 
{
	public static void main(String[] args) 
	{
		new Outer4().function();
	}
}
