package priv.rsl.collection_list_set;
import java.util.*;
/*
将自定义对象作为元素存到ArrayList集合中，并去除重复元素。

比如：存人对象。同姓名同年龄，视为同一个人。为重复元素。

思路：
1，对人的描述，将数据封装进入对象
2，定义容器，将人存入。
3，取出。
*/

class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}
//实际开发过程中，要写setName和setAge函数。这里用构造函数对对象进行初始化。
	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	//底部有说明：重写Object的equals方法，使比较个性化
	public boolean equals(Object obj)
	{
		//判断一下传进来的是不是Person对象
		if(!(obj instanceof HashSetPerson))
			return false;

		//若是，则向下强制转型
		Person p = (Person)obj;

		//打印一下调用的过程：
		System.out.println("调用者："+this.name+"与"+p.name+"比较");

		if(this.name.equals(p.name) && this.age == p.age)
			System.out.println("找到目标元素："+this.name+"..."+this.age+"\n");
		

		//比较某一个对象的姓名和年龄真假
		return this.name.equals(p.name) && this.age == p.age; 
	}
	
}

class  ArrayListTest2
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
//注意，add方法是：al.add(Object obj);相当于Object obj = new Person("lisi01",30));
//即接受的元素是任意类型就要用Object提升类型
		al.add(new HashSetPerson("lisi01",31));
		al.add(new HashSetPerson("lisi02",32));
		al.add(new HashSetPerson("lisi01",31));
		al.add(new HashSetPerson("lisi03",33));
		al.add(new HashSetPerson("lisi02",32));
		al.add(new HashSetPerson("lisi04",34));

		al = singleElement(al);
		//sop("remove lisi04为真吗？："+al.remove(new Person("lisi04",34)));

		Iterator it = al.iterator();//使用迭代器，遍历al中的元素

		sop("\n去除重复对象结果：");
		while(it.hasNext())
		{
			//注意it中的元素是Person的对象，而在add时已经提升为Object类型，所以要强转类型
			HashSetPerson p = (HashSetPerson)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
	}

//使用去重复函数来去除相同的人对象
	public static ArrayList singleElement(ArrayList al)
	{
		//定义一个临时容器,用来存放修改后的数据，并返回
		ArrayList newAl = new ArrayList();
		
		//为了遍历传进来的容器的元素，使用迭代器Iterator
		Iterator it = al.iterator();

		//使用hasNext()和next方法、contatins方法
		while (it.hasNext())
		{
			Object obj = it.next();

			if(!newAl.contains(obj))//有说明
				newAl.add(obj);
		}
		return newAl;
	}
}
/*
注：
没有重写equals方法的时候，是不能达到去除重复人对象的效果的。
因为singleElement(ArrayList al)函数里的比较方法具体来说就是contains方法，
而contains方法实际上是调用的equals方法：
boolean contains(Object o)
当且仅当列表包含满足 (o==null ? e==null : o.equals(e)) 的元素 e 时才返回 true。
而我们知道equals方法对于比较对象是比较的地址址
所以比较任意两个new Person对象都会为假。即返回的newAl与原来的一样。

此时，就需要复写equals方法。实现特殊的比较功能。

运行结果：
调用者：lisi02与lisi01比较
调用者：lisi01与lisi01比较
找到目标元素：lisi01...31

调用者：lisi03与lisi01比较
调用者：lisi03与lisi02比较
调用者：lisi02与lisi01比较
调用者：lisi02与lisi02比较
找到目标元素：lisi02...32

调用者：lisi04与lisi01比较
调用者：lisi04与lisi02比较
调用者：lisi04与lisi03比较

去除重复对象结果：
lisi01::31
lisi02::32
lisi03::33
lisi04::34



另外，若将  al = singleElement(al);注释掉
换成  sop("remove lisi04为真吗？："+al.remove(new Person("lisi04",34)));
运行结果：
调用者：lisi04与lisi01比较
调用者：lisi04与lisi02比较
调用者：lisi04与lisi01比较
调用者：lisi04与lisi03比较
调用者：lisi04与lisi02比较
调用者：lisi04与lisi04比较
找到目标元素：lisi04...34

remove lisi04为真吗？：true

去除重复对象结果：
lisi01::31
lisi02::32
lisi01::31
lisi03::33
lisi02::32

可以看到remove 也是调用的equals方法
*/
