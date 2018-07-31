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

class Person2
{
	private String name;
	private int age;

	Person2(String name)
	{
		this.name = name;//this主要是看哪个对象在调用该this所在的函数
	}

	Person2(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void speak()
	{
        System.out.println("name="+this.name+"...age="+this.age);
	}
}
class PersonDemo2 
{
	public static void main(String[] args) 
	{
		Person2 p = new Person2("lisi");
		Person2 p1 = new Person2("zhangsan");
		p.speak();
		p1.speak();
	}
}

