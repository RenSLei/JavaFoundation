package priv.rsl.treeSet_generic;
import java.util.*;
/*
此文件是为了说明TreeSet排序的第二种方式：Comparator方式排序

|--Set:元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
	|--HashSet:底层数据结构是哈希表。线程非同步
	|--TreeSet:
			可以对Set集合中的元素进行排序。自然顺序.
			底层数据结构是:  二叉树---说明1
			保证元素唯一性的依据：
			compareTo方法 return 0 

TreeSet排序的第一种方式：
			当元素自身具备比较性。元素需要实现Comparable接口，覆盖compareTo方法。

TreeSet排序的第二种方式：
			当元素自身不具备比较性时，或者具备的比较性不是所需要的。
			这时候就需要让集合自身具备比较性。
			在集合初始化时就要给TreeSet集合定义好比较方式
			而恰好这个比较方式就是其构造函数里的参数：Comparator接口的子类对象
即：定义一个类，实现Comparator接口，覆盖compare方法。



注意：Comparable里面是compareTo方法
而Comparator里是compare方法
比较器比另一个好。只需要单独创建类去实现Comparator并复写方法就可不必修改类中的compareTo方法了。


在这个例子里可以看出，Comparator和Comparable都是接口
即接口是用于扩展功能的，让想拥有此功能的类去实现它就是了。


需求：往TreeSet集合中存储自定义对象学生
想按照学生的年龄进行排序。




*/
class TreeSetDemo4 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		//因为TreeSet的有参数是comparator的子类的构造方法，所以就建立接口Comparator的子类
		TreeSet ts = new TreeSet(new myCompare());
		
		ts.add(new Student4("lisi02",22));
		ts.add(new Student4("lisi007",20));
		ts.add(new Student4("lisi09",19));
		ts.add(new Student4("lisi01",19));
		ts.add(new Student4("lisi01",32));
		ts.add(new Student4("lisi03",40));
		ts.add(new Student4("lisi007",21));

		Iterator it = ts.iterator();

		while (it.hasNext())
		{
			Student4 stu = (Student4)it.next();
			sop(stu.getName()+"...."+stu.getAge());
		}

	}
}

class Student4 //implements Comparable//实现Comparable接口，强制让学生具备比较性。
{
	private String name;
	private int age;

	Student4(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}

	/*public int compareTo(Object obj)//覆盖CompareTo
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("不是学生对象");
		Student s= (Student)obj;

		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
		{
			return this.name.compareTo(s.name);
		}
		return -1;
	}*/

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}


//因为TreeSet的有参数是comparator的子类的构造方法，所以就建立接口Comparator的子类
class myCompare implements Comparator//比较器
{
	//定义自己的比较方法，按姓名排序。
	public int compare(Object o1,Object o2)
	{
		if (!(o1 instanceof Student4 && o2 instanceof Student4))
			throw new RuntimeException("不是学生对象");

			Student4 stu1 = (Student4)o1;
			Student4 stu2 = (Student4)o2;

			int num = stu1.getName().compareTo(stu2.getName());

			if (num==0)
			{
				return new Integer(stu1.getAge()).compareTo(new Integer(stu2.getAge()));
				
			}

			return num;
	}
}



/*


运行结果：
lisi007....20
lisi007....21
lisi01....19
lisi01....32
lisi02....22
lisi03....40
lisi09....19

*/
