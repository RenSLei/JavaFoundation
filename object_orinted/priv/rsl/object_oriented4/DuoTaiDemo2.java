package priv.rsl.object_oriented4;
/*
多态：可以理解为事物存在的多种体现形态。

动物：猫，狗。
动物 x = new 猫();

1、多态的体现
   父类的引用指向自己的子类对象。
   父类的引用也可以接受自己的子类对象。

2、多态的前提
   必须是类与类之间有关系。要么是继承，要么是实现。
   通常还有一个前提：存在覆盖

3、多态的好处
   多态的出现大大地提高了程序的扩展性。

4、多态的弊端：
   提高了扩展性，但是只能使用父类的引用访问父类中的成员。

5、多态的应用

*/

/*
动物：
猫，狗

*/
/*父类，抽象*/
abstract class Animal2
{
	public abstract void eat();//定义功能

}
/*子类Cat、Dog、Pig都继承Animal，并都复写父类功能，且都有自己的功能*/
class Cat2 extends Animal2
{
	public void eat()
	{
		System.out.println("chiyu");
	}

	public void catchMouse()
	{
		System.out.println("zhualaoshu");
	}
}

class Dog2 extends Animal2
{
	public void eat()
	{
		System.out.println("chigutou");
	}

	public void kanJia()
	{
		System.out.println("kanjia");
	}
}

class Pig2 extends Animal2
{
	public void eat()
	{
		System.out.println("chisiliao");
	}

	public void gongDi()
	{
		System.out.println("gongdi");
	}
}

//-----------------------------------------------------------上面定义子类，下面调用

class DuoTaiDemo2
{
	public static void main(String[] args) 
	{
		Animal2 a = new Cat2();//类型提升。向上转型。
		a.eat();
		//如果想要调用猫的特有方法时，如何操作？
		
		Cat2 c = (Cat2)a;//强制将父类的引用转成子类型,向下转型！！！。
		c.catchMouse();
		/*注意别出现：将父类转成子类类型，能转换的是父类指向了自己的子对象时
		该应用可以被提升，也可以被强制转换。
		多态至始至终都是子类对象在做着变化.*/
		//Animal a = new Animal();
		//Cat c = (Cat)a;发生错误;
		function(new Cat2());
        function(new Dog2());
        function(new Pig2());

	}
	
	public static void function(Animal2 a)//注意是Animal相当于Animal a = new Cat();
	{
		a.eat();/*注意：若主函数中要使用此功能，则此函数相当于Animal a = new Cat();
				  因此要使用原对象的其他特有功能（如猫中的catchMouse）,则必须向下转型
				  */
	    //一般不这样用，因为子类若很多就很麻烦
		if(a instanceof Cat2)
		{
			Cat2 c = (Cat2)a;//重要！！向下转型，但万一不是传的猫类呢?因此需要提前判断
			c.catchMouse();
		}
		else if(a instanceof Dog2)
		{
			Dog2 c = (Dog2)a;
			c.kanJia();
		}
		else if(a instanceof Pig2)
		{
			Pig2 c = (Pig2)a;
			c.gongDi();
		}

	}
}
