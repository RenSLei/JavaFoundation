package priv.rsl.collection_list_set;
/*
util包中的
接口Collection
	|--子接口List:元素是有序的，元素可以重复。因为该集合体系有索引。
		|--ArrayList:底层的数据结构使用的是数组结构。特点：查询速度很快。但是增删稍慢。线程不同步。
					 可变长度的数组：当超过默认长度10 时延长50%长度。
		|--LinkedList:底层使用的链表数据结构。特点：增删速度很快，查询稍慢。
		|--Vector:已经淘汰。底层是数组结构。线程同步。被ArrayList替代了。而Vector是延长的100%。

	|--子接口Set: 元素是无序的，元素不可以重复。

List:
	特有方法。凡是可以操作角标的方法都是该体系特有的方法。

增
add(index,element);
addAll(index,Collection);

删
remove(index);

改
set(index,element);

查
get(index);获取元素位置
subList(from,to);获取子列表，包含头不含尾
	listIterator();重点，特殊

*/

//List是Collection接口的子接口
import java.util.*;
class ListDemo 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args) 
	{
		List_method();
		sop("\nListIterator(重点部分)：");
		method_ListIterator();
	}

	public static void List_method()
	{
		ArrayList al = new ArrayList();

		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");

		sop("原集合："+al);

		//在指定位置(这里是角标为1的位置)添加元素("java09")
		al.add(1,"java09");
		sop("在角标为1的位置添加元素java09后的集合："+al);

		//删除指定位置(这里角标为2)的元素
		//al.remove(2);
		
		//修改指定角标的元素
		al.set(2,"java007");
		sop("将角标为2的元素替换为java007后的集合："+al);
		
		//注意在这里是简单打印，实际开发中是取出元素值进行操作
		sop("通过角标获取元素get(1):"+al.get(1));
		
		sop("获取所有元素:");
		for (int x=0;x<al.size() ;x++ )
		{
			sop("al("+x+")="+al.get(x));
		}
		sop("使用迭代器：");
		Iterator it = al.iterator();

		while (it.hasNext())
		{
			sop("next:"+it.next());
		}

		//通过indexOf获取对象的位置
		sop("index of java03 is："+al.indexOf("java03"));
		
		//注意，子列表返回的仍然是子列表，包含头不包含尾
		List sub = al.subList(1,3);
		sop("子列表是："+sub);

	}
//----------------------------------------------------------------
	/*
	演示：列表迭代器（特殊，重点）
	接口 ListIterator<E>
	public interface ListIterator<E> extends Iterator<E>

	可以看到它是Iterator的子类，是List集合特有的迭代器。

	*/

	//首先来引出Iterator存在的局限性：	
	//public static void method_ListIterator()
	{
	//注意ArrayList类里没有iterator方法，而是从类java.util.AbstractList 继承的方法
		ArrayList al = new ArrayList();

		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");

		
		Iterator it = al.iterator();//此时迭代器知道了集合al中有哪些元素了。
//需求：我们想要迭代器在迭代返回元素的过程中，对集合里的元素进行操作。
		while (it.hasNext())
		{
			//使用多态，因为不知道集合里是存放的什么类型的元素
			Object obj = it.next();

			if (obj.equals("java02"))
				//al.add("java008");
/*若使用al.add("java008");
出现以下运行结果：
obj=java01
obj=java02
Exception in thread "main" java.util.ConcurrentModificationException

说明：为什么会抛出此异常？因为集合元素在被迭代器操作的时候，又使用集合方法操作元素
而迭代器最开始时是只有3个元素的。所以要么全部用迭代器方法，要么全部用集合方法。

所以我们得找Iterator中的其他方法，通过查找API知道，只有三个动作：
hasNext()、next()、remove();
*/
			//使用remove()
			//it.remove();//将java02的引用从集合中删除。但是obj此时再用，所以在打印的时候会打印java02
//运行结果：obj=java01  obj=java02  obj=java03。但是al中已经没有java02了
			
			sop("obj="+obj);
		}
	}

//下面来演示子接口ListIterator,可以在迭代时有更多操作元素的方法。
	public static void method_ListIterator()
	{
		ArrayList al = new ArrayList();

		//添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");

		sop("原集合"+al);

		ListIterator it = al.listIterator();

		sop("hasPrevious():"+it.hasPrevious());

		while (it.hasNext())
		{
			Object obj = it.next();

			if (obj.equals("java02"))
				//it.add("java009");
				it.set("java006");
		}
		sop("hasNext():"+it.hasNext());
		sop("hasPrevious():"+it.hasPrevious());


		sop("修改后的集合"+al);
	}
	
}
/*
运行结果：
原集合：[java01, java02, java03]
在角标为1的位置添加元素java09后的集合：[java01, java09, java02, java03]
将角标为2的元素替换为java007后的集合：[java01, java09, java007, java03]
通过角标获取元素get(1):java09
获取所有元素:
al(0)=java01
al(1)=java09
al(2)=java007
al(3)=java03
使用迭代器：
next:java01
next:java09
next:java007
next:java03
index of java03 is：3
子列表是：[java09, java007]

ListIterator(重点部分)：
原集合[java01, java02, java03]
hasPrevious():false
hasNext():false
hasPrevious():true
修改后的集合[java01, java006, java03]

*/
