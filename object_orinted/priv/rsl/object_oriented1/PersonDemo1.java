package priv.rsl.object_oriented1;
/*

*/

class Person1
{
	private String name;//类中属性一
	private int age;//类中属性二
/*
下面构造代码块：

作用：给对象进行初始化。
对象一建立就运行，而且优先于构造函数执行。

和构造函数的区别：构造代码块是给所有对象进行统一初始化，
而构造函数是给对应的对象初始化。
*/
	{
		System.out.println("person code run");
		cry();/*把所有对象的共性的初始化放在构造代码块中，
		        这样在每个新对象建立的时候首先运行一次这个构造代码块中的内容；*/
	}

	//下面定义构造函数
	Person1()//构造函数一
	{
		System.out.println("A:name="+name+",,age="+age+",,");
		//cry();
	}
	Person1(String n)//构造函数二（重载）
	{
		name = n;
		System.out.println("B:name="+name+",,age="+age+",,");
		//cry();
	}

	Person1(String n,int a)//构造函数三（重载）
	{
		name=n;
		age=a;
		System.out.println("C:name="+name+",,age="+age+",,");
		//cry();
	}
	//可以看到一个类中可以定义多个对象，而每个对象可以有不同的初始化值。
	/*
	当在后期想要改变对象中成员的初始化值的时候，怎么办？难道new Person("王五")？不行，这个是新建立一个叫王五的对象。
	如何改变原对象的成员值？函数是：setName：用于改值和getName：用于取值；
	*/
	public void setName(String n)
	{
		name=n;
	}
	public String getName()
	{
		return name;
	}
	//而想定义类的一般方法时，可以在定义方法（可以直接被对象引用，未封装）
	public void cry()//一般函数；
	{
        System.out.println("cry......");
	}
}




class PersonDemo1 
{
	public static void main(String[] args) 
	{
		new Person1();
		new Person1("李四");
		new Person1("张三",10);//对象建立，就只调用一次构造函数三。
		//p3.age=0;//此语句编译错误。为什么？因为age属性是有封装权限的，只能通过构造函数改变。
		//p1.cry();//但此语句可以，因为cry是public型。
		//p3.setName("王五");//重新给p3对象中成员定义
		//System.out.println(p3.getName());//获取改变后的值并打印
	}
}
