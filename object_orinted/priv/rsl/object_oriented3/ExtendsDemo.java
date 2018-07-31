package priv.rsl.object_oriented3;
/*
子父类出现后，类成员的特点：

类中成员：
1、变量
2、函数
3、构造函数

1、变量
如果子类中出现非私有的同名成员变量时，
子类要访问本类对象引用。
super代表的是父类对象的引用。
*/

class Fu
{
	int num = 4;
}

class Zi extends Fu/*Zi继承Fu，Zi中有Fu的全部内容*/
{
	int num = 5;
	void show()
	{
		System.out.println(this.num);/*本类对象中的引用，打印5*/
		System.out.println(super.num);/*父类对象中的引用，打印4*/
	}
}

class  ExtendsDemo
{
	public static void main(String[] args) 
	{
		Zi z = new Zi();
		z.show();
	}
}
