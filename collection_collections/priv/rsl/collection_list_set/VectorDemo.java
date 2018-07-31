package priv.rsl.collection_list_set;
import java.util.*;
/*
枚举就是Vector特有的取出方式：
发现枚举和迭代器很像。
其实枚举和迭代是一样的。

因为枚举的名称以及方法的名称都过长。
所以被迭代器取代了。枚举就慢慢被淘汰了。

*/



class VectorDemo  
{
	public static void main(String[] args) 
	{
		Vector v = new Vector();
		
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		
		Enumeration en = v.elements();//elements()方法返回类型是枚举类型

		while (en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
		
	}
}
