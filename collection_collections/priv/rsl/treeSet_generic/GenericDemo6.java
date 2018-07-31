package priv.rsl.treeSet_generic;
import java.util.*;

/*
泛型限定

*/



/*先看通配符<?>的优缺点：

class GenericDemo6
{
	public static void main(String[] args) 
	{
		//定义两个ArrayList集合，他们分别操作加上泛型以指定操作参数类型
		ArrayList<String> al1 = new ArrayList<String>();

		al1.add("abc1");
		al1.add("abc2");

		ArrayList<Integer> al2 = new ArrayList<Integer>();

		al2.add(1);
		al2.add(3);
		al2.add(5);

		//调用迭代器函数，参数是String类的ArrayList
		printColl(al1);//若当函数参数指定是String泛型的时候，传递al2就会编译出错
	}

	
	//说明1
	public static void printColl(ArrayList<?> al)
	{
		Iterator<String> it = al.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());//
		}
	}
}

/*
说明1：
printColl(ArrayList<?> al)

<?>:?代表通配符，也可以理解为占位符。意思是不知道往里面传递的数据类型是什么。
这样既可以传递String类也可以传递Integer类

但是具有局限性，如：不能使用类型特有方法。
如：System.out.println(it.next().length())因为Integer类里没有length方法
正如多态一样，虽然提高了扩展性，但是不能预先使用子类特有方法。


*/

//下面讲解泛型限定：

class GenericDemo6
{
	public static void main(String[] args) 
	{
		//定义两个ArrayList集合，他们分别操作加上泛型以指定操作参数类型
		ArrayList<Person> al1 = new ArrayList<Person>();

		al1.add(new Person("abc1"));
		al1.add(new Person("abc2"));
		al1.add(new Person("abc3"));

		ArrayList<Student6> al2 = new ArrayList<Student6>();
		
		al2.add(new Student6("abc--1"));
		al2.add(new Student6("abc--2"));
		al2.add(new Student6("abc--3"));
		
		//调用迭代器函数，参数是String类的ArrayList
		printColl(al2);//说明2
	}

	

	public static void printColl(ArrayList<? extends Person> al)
	{
		Iterator<? extends Person> it = al.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());//
		}
	}
}

class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}

class Student6 extends Person
{
	Student6(String name)
	{
		super(name);
	}
}




/*
说明2：
当函数是：printColl(ArrayList<Person> al)
时，往里面传递的是printColl(al2)即传递的是Student类，编译就会出错

而如果：printColl(ArrayList<?> al)的话，则意思是什么类型都可以传递，但此时
我们得需求是只想接受Person类以及其子类，该怎么办？
于是这就引出了泛型限定，即printColl(ArrayList<? extends Person> al)

<? super Student>也可以

泛型限定：
? extends E:可以接受E类型以及其子类型。上限
? super E:可以接受E类型以及其父类型。下限





泛型限定2：
如使用terrSet集合的时候，自定义比较器实现comparator接口的时候
使用如classs myComp implements Comparator<父类> 的好处是可以让此比较器适用于
该类及其子类，但前提是比较器里面调用的是父类的方法。
*/
