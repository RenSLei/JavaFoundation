package priv.rsl.treeSet_generic;
/*
此文档用于说明泛型的使用范围：
泛型用于集合中，避免了强转的麻烦性，不管是集合还是迭代器以及比较器，都可以应用泛型
泛型的应用：
学习到这里，我们知道在定义类的时候：
1，应该让类具备比较性（实现Comparable接口）
2，应该定义hashCode和equals方法（HashSet的保证唯一性的原理）
3，应该复写compareTo方法（使类有自己的比较性）
4，当需要扩展功能的时候，只需要创建新的比较器（类），实现Comparator
	然后将子类对象作为参数传递到集合的构造函数里即可更新新的比较方法。
*/


import java.util.*;
class GenericDemo2 
{
	public static void main(String[] args) 
	{
		//使用TreeSet集合演示
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());

		ts.add("abcd");
		ts.add("ab");
		ts.add("a");
		ts.add("saf");
		ts.add("fesg");
		ts.add("grasgasrg");

		//迭代器：
		Iterator<String> it = ts.iterator();

		while (it.hasNext())
		{
			String s = it.next();
			System.out.println(s);
		}
		
	}

}

//现在的需求是不想要集合自定义的字符串比较功能，想按照长度排序
class LenComparator implements Comparator<String>//说明1
{
	public int compare(String s1,String s2)
	{
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num==0)
			return s1.compareTo(s2);
		return num;

	}
} 
/*
说明1：
泛型的特点在于避免强制换的麻烦，此处就是一个应用。
直接告诉接口接受的是String类型的对象。
但是，像equals方法就不能用泛型，必须转换，因为里面没有泛型
运行结果：
a
ab
saf
abcd
fesg
grasgasrg




*/











