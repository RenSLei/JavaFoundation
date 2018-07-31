package priv.rsl.object_oriented6;

public class DemoB
{
	protected/*保护*/ void method()
	{
		System.out.println("demoB method run");
	}
}

/*关键字
protected:
protected修饰的成员可以在其所在类中、同一个包中、子类中（无论子类是否在同一个包中）被直接访问
但不能被位于不同包的非子类中直接访问。

特别说明：
在位于不同包的子类中，必须是子类的对象才可以直接访问其父类的protected成员，而父类自身的对象反而不能
访问其所在类中声明protected成员。

给父类成员加proteced，只有其子类才能访问，若不加的话，其他包中也可以访问其成员*/
