package priv.rsl.object_oriented1;
/*
this语句：用于构造函数之间进行互相调用，且只能用this语句调用。
this语句只能定义在构造函数的第一行。为什么？
因为构造函数中的this调用也属于初始化，初始化内部的初始化需要先执行
*/

class Person4
{
	private String name;
	private int age;

	Person4(String name)//构造函数一
	{
		this.name = name;//this主要是看哪个对象在调用该this所在的函数
	}

	Person4(String name,int age)//构造函数二
	{
		//this.name=name;
		this(name);/*此语句也是初始化，
		             初始化传进来的name，调用函数一。
					 谁在调用？p在调用*/
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
}
class PersonDemo4 
{
	public static void main(String[] args) 
	{
		Person4 p = new Person4("lisi",30);
		p.setName("ren shilei");
		System.out.println("name is "+p.getName());
		p.setAge(24);
		System.out.println("age is "+p.getAge());
	}
}

