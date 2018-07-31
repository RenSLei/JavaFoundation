package priv.rsl.treeSet_generic;
import java.util.*;
/*
|--Set:元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
	|--HashSet:底层数据结构是哈希表。线程非同步的。
			判断元素的HashCode值是否相同，若相同，才会判断equals是否为true
			如果元素的HashCode值不同，不会调用equals.

	|--TreeSet:可以对Set集合中的元素进行排序。自然顺序.

需求：往TreeSet集合中存储自定义对象学生
想按照学生的年龄进行排序。




*/
class TreeSetDemo2 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add(new Student2("lisi02",22));
		ts.add(new Student2("lisi007",20));
		ts.add(new Student2("lisi09",19));
		ts.add(new Student2("lisi01",19));

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			Student2 stu = (Student2)it.next();
			sop(stu.getName()+"...."+stu.getAge());
		}

	}
}

class Student2 implements Comparable//说明1
{
	private String name;
	private int age;

	Student2(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}

	public int compareTo(Object obj)
	{
		if(!(obj instanceof Student2))
			throw new RuntimeException("不是学生对象");
		Student2 s= (Student2)obj;

		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
		{
			return this.name.compareTo(s.name);//说明2 
		}
		return -1;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}



/*
说明1：
该接口强制让学生具备比较性
背后的原理：为什么要求学生类具备比较性？
因为TreeSet集合的特点就是对存储在它里面的元素进行自然排序，依据的是？
而现在存储的是学生类，不具备可比性
所以必须将类实现Comparable接口，而此接口的方法就只有一个：compareTo
int compareTo(T o)
比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
并复写方法compare To才具备可比性


说明2：
String类里面也有compareTo方法，其实他就是实现的接口comparable
记住，排序时，当主要条件相同时，一定判断一下次要条件。


运行结果：
lisi01....19
lisi09....19
lisi007....20
lisi02....22

*/
