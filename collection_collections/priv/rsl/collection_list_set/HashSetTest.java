package priv.rsl.collection_list_set;
import java.util.*;
/*
|--Set:元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
	|--HashSet:底层数据结构是哈希表。
			**HashSet特点**(解释1)HashSet是如何保证元素的唯一性的呢？
			是通过元素的两个方法：hashCode()和equals()两个方法来完成。
			即如果元素的HashCode值相同，才会判断equals是否为true
			如果元素的HashCode值不同，不会调用equals.

			注意，对于判断元素是否存在，以及删除等操作，依赖的方法是：
			hashCode和equals方法。
			而ArrayList判断、删除、存储等方法只依赖equals。
			两者有差异是因为数据结构不同。

	|--TreeSet:
Set集合的功能和Collection是一致的。

*/

class  HashSetTest
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();

		hs.add(new Person("a1",11));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",13));
		hs.add(new Person("a2",12));
		//hs.add(new Person("a4",14));
		
		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			//注意it中的元素是Person的对象，而在add时已经提升为Object类型，所以要强转类型
			Person p = (Person)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
	}
	
}

class HashSetPerson
{
	private String name;
	private int age;
	HashSetPerson(String name,int age)
	{
		this.name = name;	
		this.age = age;	
	}
	
	//在实际开发中，涉及集合类，都要复写hashCode()和equals()方法
	//复写hashCode方法：
	public int hashCode()
	{
		//写此语句只是为了看出调用了hashCode方法没有
		System.out.println(this.name+"...hashCode");
		
	//注意，name是String类，也有hashCode方法，这里是使用name自己的hash值加age值//说明(1)*
		return name.hashCode()+age;//也可以使用return 固定Int型值//说明(2)**
	}

	//复写equals方法：
	public boolean equals(Object obj)
	{
		//判断一下传进来的是不是Person对象
		if(!(obj instanceof Person))
			return false;

		//若是，则向下强制转型
		HashSetPerson p = (HashSetPerson)obj;

		//打印一下调用的过程：
		System.out.println("调用者："+this.name+"与"+p.name+"比较");

		if(this.name.equals(p.name) && this.age == p.age)
			System.out.println("找到目标元素："+this.name+"..."+this.age+"\n");
		

		//比较某一个对象的姓名和年龄真假
		return this.name.equals(p.name) && this.age == p.age; 
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
}

/*
说明(1)*+说明(2)**:
为什么可以使用return 60（或者其他数）？
因为这要根据**(解释1)。
可以知道，若hashCode()返回固定的整形值，即每次都要调用equals方法，效率就很低
所以，返回对象本身的一些比较属性的HashCode值进行简单运算值，提高了效率
只有遇到内容相同的比较对象时才会调用equals方法。


运行结果：

a1...hashCode
a2...hashCode
a3...hashCode
a2...hashCode
调用者：a2与a2比较
找到目标元素：a2...12

a1::11
a2::12
a3::13

可以看到，这样（使用return name.hashCode()+age;）的好处就是保证了哈希值的唯一性
这样只需要比较很少次数。
还可以看到，HashSet的特点就是调用add方法的时候会得到元素的哈希值，
所以我们可以控制哈希值来控制是否调用equals。
当a2添加进来的时候，获取到的哈希值与之前的a2一样，即调用equals方法。
*/
