package priv.rsl.object_oriented1;
/*
调用全是对象在调用！
this:看上去，是区别局部变量和成员变量同名的情况。
this为什么可以解决这个问题？
this到底代表的是什么？
this代表本类的对象，到底代表哪一个呢？
this代表它所在函数所属对象的引用。
简单说叫做：哪个对象在调用this所在的函数，this就代表哪个对象。
*/

class Person3
{
	private String name;
	private int age;
	Person3(int age)
	{
		this.age=age;
	}

	Person3(String name)
	{
		this.name = name;//this主要是看哪个对象在调用该this所在的函数
	}

	Person3(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void speak()
	{
        System.out.println("name="+this.name+"...age="+this.age);
	}
	//需求：给人定义一个用于比较年龄是否相同的功能。
	public boolean compare(Person3 p)/*注意参数列表，此函数实在一个类中，是要给对象调用的，
	                                  因此调用它的对象已经有一个age，因此只需传递另一个对象进来即可。*/
	{
		return this.age==p.age;/*this就是调用compare函数所属对象，p就是传进来的对象*/
	}
}
class PersonDemo3 
{
	public static void main(String[] args) 
	{
		Person3 p1 = new Person3(20);
		Person3 p2 = new Person3(25);
		boolean b = p1.compare(p2);//需要好好理解
		System.out.println(b);
		//Person p = new Person("lisi");
		//Person p1 = new Person("zhangsan");
		//p.speak();
		//p1.speak();
	}
}

