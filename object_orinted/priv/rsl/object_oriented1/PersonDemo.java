package priv.rsl.object_oriented1;
/*
1、对象一建立就会调用与之对应的构造函数。

2、构造函数的作用：可以用于给对象进行初始化。

3、构造函数的小细节：
   当一个类中没有定义构造函数时，那么系统会默认给该类加一个空参数的构造函数：
   Person (){};
   而假如类只定义了Person（String n）和Person(String n , int a)时，当主函数中：Person p = new person();
   就会编译错误，原因是没有相应的构造函数，且此时已经没有默认的构造函数；
   当在类中自定义了构造函数后，默认的构造函数就没有了。

4、构造函数和一般函数在写法上有不同。
   在运行上也不同：构造函数是在对象一建立就运行，用以给函数初始化。
   而一般函数是对象调用才执行，是给对象添加对象具备的功能。

5、一个对象建立，构造函数只运行一次。
   而一般函数可以被该对象调用多次。

6、什么时候定义构造函数呢？
   当分析事物时，该事物存在具备一些特性或者行为，那么将这些内容定义在构造函数中。

*/

class Person
{
	private String name;//类中属性一
	private int age;//类中属性二
/*
下面定义构造函数：1.函数名必须与类名相同2.不定义返回值类型，不使用return;
*/
	Person()//构造函数一
	{
		System.out.print("A:name="+name+",,age="+age+",,");
		cry();
	}
	Person(String n)//构造函数二（重载）
	{
		name = n;
		System.out.print("B:name="+name+",,age="+age+",,");
		cry();
	}

	Person(String n,int a)//构造函数三（重载）
	{
		name=n;
		age=a;
		System.out.print("C:name="+name+",,age="+age+",,");
		cry();
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




class PersonDemo 
{
	public static void main(String[] args) 
	{
		Person p1 = new Person();//对象建立，就只调用一次构造函数一。
		new Person("李四");
		Person p3 = new Person("张三",10);//对象建立，就只调用一次构造函数三。
		//p3.age=0;//此语句编译错误。为什么？因为age属性是有封装权限的，只能通过构造函数改变。
		p1.cry();//但此语句可以，因为cry是public型。
		p3.setName("王五");//重新给p3对象中成员定义
		System.out.println(p3.getName());//获取改变后的值并打印
	}
}
