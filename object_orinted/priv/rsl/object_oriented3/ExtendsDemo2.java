package priv.rsl.object_oriented3;
/*
子父类出现后，类成员的特点：

类中成员：
1、变量
2、函数
3、构造函数

2、子父类中的函数
当子类出现和父类一模一样的函数时，
当子类对象调用该函数时，会运行子类函数的内容。
如同父类的函数被覆盖一样。

这种情况是函数的另一个特性：重写（覆盖）
利用覆盖的特点：当子类继承父类，沿袭了父类的功能到子类中，
但是子类虽具备该功能，但是功能的内容却和父类不一致，
这时，没有必要定义新的功能，而是使用覆盖特殊，保留父类的功能定义，
并重写功能内容。

覆盖：
子类覆盖父类，必须保证子类权限大于等于父类，才可以覆盖，否则编译失败；
静态只能覆盖静态

记住：
重载：只看同名函数的参数列表
重写：子父类方法要一模一样，包括返回值类型
*/

class Fu2
{
	/*private int num = 4;

	public void setNum(int num)
	{
		this.num=num;
	}

	public int getNum()
	{
		return this.num;
	}*/

	void show()
	{
		System.out.println("fu show");
	}
	
	void speak()
	{
		System.out.println("vb");
	}

}

class Zi2 extends Fu2/*Zi继承Fu，Zi中有Fu的全部内容*/
{
	
	void show()/*覆盖作用，有利于功能扩展*/
	{
		System.out.println("zi show");
	}

	void speak()/*覆盖作用，有利于功能扩展*/
	{
		System.out.println("java");
	}
}

class  ExtendsDemo2
{
	public static void main(String[] args) 
	{
		Zi2 z = new Zi2();
		z.show();
		z.speak();
		NewTel n = new NewTel();
		n.show();
	}
}

class Tel
{
	void show()
	{
		System.out.println("15123027837");
	}
}

class NewTel extends Tel/*假如出现了新手机功能，需要显示号码和姓名以及头像，则利用覆盖特性
							这样会使代码的扩展性变好*/
{
	void show()
	{
		System.out.printf("来电显示升级前:\n");
		super.show();
		System.out.printf("来电显示升级后:\n");
		super.show();/*这样还可以用父类中的某些功能，
						就不用再写：System.out.println("number");*/
		System.out.println("ren shilei");/*新加的功能*/
		System.out.println("pic");
	}
}
