package priv.rsl.object_oriented2;
/*
静态代码块：
格式:
static
{
	静态代码块中的执行语句。
}

特点：随着类的加载而执行，只执行一次,并优先于主函数执行。
用于给类进行初始化的。

*/
class StaticCode2
{
	int num=9;//类属性，非静态，初始化对象的属性的
	/*构造函数一，是初始化对象的，因为没有创建过与之对应的对象,所以不会打印b*/
	StaticCode2()
	{
		System.out.println("b");
	}
	/*静态代码块，是初始化类的，因为创建了一个匿名对象,所以类会加载，所以会打印a*/
	static
	{
		System.out.println("a");
		//System.out.println("a"+num);//此语句会报错，原因是静态只能访问静态，不能访问非静态；
	}
	/*构造代码块，是初始化对象的，因为创建了一个匿名对象,所以类会加载，所以会打印c,且可以访问num*/
	{
		System.out.println("c"+num);
	}
	/*构造函数二，是构造函数一的重载，是初始化对象的，因为创建了一个与之对应的匿名对象,所以类会加载，所以会打印d*/
	StaticCode2(int x)
	{
		System.out.println("d");
	}
	/*静态方法,注意：属于方法。可以通过类名直接调用，也可以用建立的对象调用（因为静态是被所有对象共享），因为没有被调用，所以不会被执行*/
	public static void show()
	{
		System.out.println("show run");
	}
}

class StaticCodeDemo2
{
	/*静态代码块，是初始化类的，在执行java StaticCodeDemo2时，该类就被加载了，所以会优先打印e*/
	static
	{
		System.out.println("e");
	}
	public static void main(String[] args) 
	{
		new StaticCode2(4);
	}
	
}

