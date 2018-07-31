package priv.rsl.treeSet_generic;
/*
泛型定义在方法上:
为什么需要定义在方法上？
因为
看如下代码演示：

class Demo<T>
{
	public void show(T t)
	{
		System.out.println("show"+t);
	}

	public void print(T t)
	{
		System.out.println("print"+t);
	}

}

class GenericDemo4
{
	public static void main(String[] args) 
	{
		Demo<String> d = new Demo<String>();

		d.show(new Integer(4));
		d.print("haha");
	}
}

结果是编译失败，因为泛型是定义在类上的，当类的方法操作的参数数据类型不同时就会出错。
这也是泛型类的局限性。


*/

//而我们得需求是对不同的方法可以任意传不同的参数:
class Demo//此时就不要使用泛型类
{
	//将泛型定义在方法上，称之为方法泛型
	//格式是放在返回值类型的前面，位置固定，别乱放
	public <T> void show(T t)
	{
		System.out.println("show："+t);
	}

	public <T> void print(T t)
	{
		System.out.println("print："+t);
	}

	/*注意，静态方法不可以访问类上定义的泛型(因为静态比类先加载)
	如果静态方法操作的数据类型不确定，可以将泛型定义在方法上*/
	public static <W> void method(W t)
	{
		System.out.println("method："+t);
	}


}

class GenericDemo4
{
	public static void main(String[] args) 
	{
		//好处是显而易见的。传什么就会是什么泛型。
		Demo d = new Demo();

		d.show(new Integer(4));
		d.print("haha");

		Demo.method("静态方法泛型01");
		Demo.method(2);

	}
}

/*
结果：
show：4
print：haha
method：静态方法泛型01
method：2


另外说明一点，若类Demo改为
class Demo <T>
{
	//将泛型定义在方法上，称之为方法泛型
	public void show(T t)
	{
		System.out.println("show："+t);
	}

	public <Q> void print(Q q)
	{
		System.out.println("print："+t);
	}

}

分析发现，show方法没有泛型，print方法有泛型，而类又有泛型
则此时泛型方法show是跟着泛型类Demo走的，而泛型方法print不受影响


*/
