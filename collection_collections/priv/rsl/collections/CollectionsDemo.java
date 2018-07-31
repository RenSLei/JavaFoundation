package priv.rsl.collections;
/*
集合框架的工具类。
Collections:
讲解Collections集合框架工具类里的reverseOrder()：

public static <T> Comparator<T> reverseOrder()
返回一个比较器，它强行逆转实现了 Comparable 接口的对象 collection 的自然顺序。（自然顺序是通过对象自身的 compareTo 方法强行排序的。）
此方法允许使用单个语句，以逆自然顺序对实现了 Comparable 接口的对象 collection（或数组）进行排序（或维护）。
例如，假设 a 是一个字符串数组。那么：
Arrays.sort(a, Collections.reverseOrder());
将按照逆字典（字母）顺序对数组进行排序。

重载（按指定的比较器逆转）：
public static <T> Comparator<T> reverseOrder(Comparator<T>?cmp)
返回一个比较器，它强行逆转指定比较器的顺序。如果指定比较器为 null，则此方法等同于 reverseOrder()（换句话说，它返回一个比较器，该比较器将强行逆转实现了 Comparable 接口的对象 collection 的自然顺序）。 



*/



import java.util.*;
class  CollectionsDemo
{
	public static void main(String[] args) 
	{
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator2()));/*Collections.reverseOrder()*/
		ts.add("abcd");
		ts.add("aaa");
		ts.add("z");
		ts.add("kk");

		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			sop(it.next());
		}
	
		


		
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);

	}
}

	//其实这样实现反序也显得麻烦，因为Collections框架类中有相应的方法，即reveseOrder()
	class StrLenComparator1 implements Comparator<String>
	{
		public  int compare(String s1,String s2)
		{
			return s2.compareTo(s1);
		}
	}

	class StrLenComparator2 implements Comparator<String>
	{
		public  int compare(String s1,String s2)
		{
			if(s1.length()>s2.length())
				return 1;
			if(s1.length()<s2.length())
				return -1;
			return s1.compareTo(s2);
		}
	}

/*
使用在集合中传递参数Collections.reverseOrder()的结果（即按照自然顺序逆转后的）：
z
kk
abcd
aaa

使用重载的方法传递后的结果（即按照自己指定的比较器的逆序）：

abcd
aaa
kk
z


*/

