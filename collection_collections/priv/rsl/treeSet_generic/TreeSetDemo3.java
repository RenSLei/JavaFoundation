package priv.rsl.treeSet_generic;
import java.util.*;
/*
此文件是为了说明TreeSet底层的数据结构是二叉树：

|--Set:元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
	|--HashSet:底层数据结构是哈希表。线程非同步的。
			判断元素的HashCode值是否相同，若相同，才会判断equals是否为true
			如果元素的HashCode值不同，不会调用equals.

	|--TreeSet:可以对Set集合中的元素进行排序。自然顺序.
			底层数据结构是:  二叉树---说明1
			保证元素唯一性的依据：
			compareTo方法 return 0 

TreeSet排序的第一种方式：
			让元素自身具备比较性。元素需要实现Comparable接口，覆盖compareTo方法。
			这种方式也称为元素的自然顺序，或者默认顺序。
		

需求：往TreeSet集合中存储自定义对象学生
想按照学生的年龄进行排序。




*/
class TreeSetDemo3 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add(new Student3("lisi02",22));
		ts.add(new Student3("lisi007",20));
		ts.add(new Student3("lisi09",19));
		ts.add(new Student3("lisi01",19));
		ts.add(new Student3("lisi03",40));

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			Student3 stu = (Student3)it.next();
			sop(stu.getName()+"...."+stu.getAge());
		}

	}
}

class Student3 implements Comparable//实现Comparable接口
{
	private String name;
	private int age;

	Student3(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}

	public int compareTo(Object obj)//覆盖CompareTo方法
	{
		return 1;//说明2
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
二叉树数据结构就是一种排序结构，默认排序是从小到大排序，小的放左边，大的放右边
这样使得排序和查找提高效率。
如本例(若按原有的compareTo方法去覆盖)
底层数据结构：                  
                   22
                20   40
       lisi09 19
    lisi01 19

当数据特别多时，比较基数会自动折中，不会再每次以22为比较基数。

说明2：
此处return 1；是关于二叉树数据结构的一个实验，
目的：复写接口Comparable接口中的compareTo方法，
实现将数据按原顺序输出。
原理是把后面的认为比前面的大（小），然后按从小到大的顺序输出的时候就是原序了


运行结果：
lisi02....22
lisi007....20
lisi09....19
lisi01....19
lisi03....40

*/
