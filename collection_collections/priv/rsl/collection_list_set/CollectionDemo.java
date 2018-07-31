package priv.rsl.collection_list_set;
import java.util.*;
/*
1,add方法的参数类型是Object。以便于接受任意类型对象。

2,,集合中存储的都是对象的引用（地址）

*/
class CollectionDemo 
{
	public static void main(String[] args) 
	{
		sop("base_method:{");
		base_method();
		sop("}\nmethod_2:{");
		method_2();
		sop("}\nmethod_get:{");
		method_get();
		sop("}");
		
	}

	public static void base_method()
	{
		//创建一个集合容器。使用Collection接口的子类，ArrayList
		ArrayList al = new ArrayList();

		//1,添加元素
		al.add("java01");//add(Object obj);
		al.add("java02");
		al.add("java03");
		al.add("java04");

		//打印集合。
		sop("原集合："+al);

		//2，获取个数。集合长度。
		sop("原size:"+al.size());

		//3,删除元素
		al.remove("java02");

		//al.clear();//清空集合
		
		//4,判断元素
		sop("java03是否存在："+al.contains("java03"));
		sop("集合为空吗？："+al.isEmpty());

		//打印改变后的集合：
		sop("改变后的集合："+al);	
	}

	public static void method_2()
	{
		ArrayList al1 = new ArrayList();

		al1.add("java01");
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");

		ArrayList al2 = new ArrayList();

		al2.add("java01");
		al2.add("java02");
		al2.add("java05");
		al2.add("java06");
		
		//取交集，al1中只会保留和al2中相同的元素。
		al1.retainAll(al2);

		//去掉两集合相同的元素，保留原调用者al1的集合里的元素：
		//al1.removeAll(al2);

		sop("al1:"+al1);
		sop("al2:"+al2);
	}
/*
什么是迭代器？
是集合的取出元素的方式。
*/
	public static void method_get()//迭代器
	{
		ArrayList al = new ArrayList();

		//1,添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");

		//获取迭代器 ，用于取出集合中的元素
		Iterator it = al.iterator();//集合里的iterator方法返回的是一个接口的子类对象
//hasNext()和next()都是接口里的方法，一个是判断还有没有元素迭代，一个是返回迭代的下一个元素
		while(it.hasNext())
		{
			sop(it.next());
		}
		//sop(it.next());此时会抛出NoSuchElementException异常，因为没有下一个元素可以迭代
		
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*
运行结果：
base_method:{
原集合：[java01, java02, java03, java04]
原size:4
java03是否存在：true
集合为空吗？：false
改变后的集合：[java01, java03, java04]
}
method_2:{
al1:[java01, java02]
al2:[java01, java02, java05, java06]
}
method_get:{
java01
java02
java03
java04
}
*/
