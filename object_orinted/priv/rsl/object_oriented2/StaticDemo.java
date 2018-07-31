package priv.rsl.object_oriented2;
/*
静态：static。

用法：是一个修饰符，用于修饰成员（成员变量，成员函数）。
当成员被静态修饰后，就多了一个调用方式，除了对象调用以外，可以直接被类名调用。类名.静态成员;
特有内容随着对象存储，共有内容用Static;

特点：
1、随着类的加载而加载。
   即静态会随着类的消失而消失。说明他的生命周期最长
2、优先于对象存在
3、被所有对象所共有
4、可以直接被类名所调用

实例变量和类变量的区别：
1、存放位置：
类变量随着类的加载而存在于方法区中。
实例变量随着对象的建立而存在于堆内存中
2、生命周期：
类变量生命周期最长，随着类的消失而消失
实例变量生命周期随着对象的消失而消失


静态的使用注意事项：
1、静态方法只能访问静态成员（静态成员和静态方法）
   非静态方法即可以访问静态也可以访问非静态。
2、静态方法中不可以定义this，super关键字。
   因为静态优先于对象存在。所以静态方法中不可以出现this；
3、主函数是静态的（见MainDemo.java）

静态有利有弊
利：对对象的共享数据进行单独空间的存储，节省空间，
没有必要每个对象都存储。可以直接被类名调用。
弊端：生命周期过长。访问出现局限性。（静态虽好，但自己只能访问静态）

什么时候使用静态？
因为静态修饰的内容有成员变量和函数。
一、定义静态变量（类变量）：
1、当对象中出现共享数据时，该数据被静态所修饰。
2、对象中的特有数据要定义成非静态存在于堆内存中。
二、定义静态函数:
当功能内部没有访问到非静态数据（对象的特有数据），该功能可以定义成静态的。
*/
class PersonS
{
	String name;//成员变量，实例变量。
	static String country="CN";/*静态的成员变量，类变量*/
	public void show()
	{
		System.out.println(name+"::"+country);
	}

}
class StaticDemo 
{
	public static void main(String[] args) 
	{
		PersonS p = new PersonS();
		p.name = "lisi";
		p.show();
		System.out.println(PersonS.country);//可以直接被类名调用。类名.静态成员。
	}
}
