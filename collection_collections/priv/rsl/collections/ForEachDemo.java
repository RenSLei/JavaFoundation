package priv.rsl.collections;
/*
高级for循环:
JDK1.5版本出现的新特性，简化了代码的书写，提高了程序效率
具体格式和功能：
for(数据类型 变量名 ：需要遍历的集合（collection）或者数组)
{

}

但是功能具有局限性：
高级for只能读取元素，不能操作集合中的元素，但是迭代器就可以remove集合中的元素
如果使用ListIterator,还可以对元素进行增删改查动作。

传统for和高级for有什么区别？

高级for有一个局限性：必须有被遍历的目标
建议在遍历数组的时候，还是希望是用传统for.因为传统for可以定义角标。

*/

import java.util.*;
class ForEachDemo
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		/*
		ArrayList取出元素有两种方式：遍历(因为是数组)和迭代（iterator）
		下面演示普通的使用迭代方法来取出元素：
	
		Iterator<String> it = al.iterator();
		
		while(it.hasNext())
		{
			sop(it.next());
		}
	
		/*
		此种方法也略带复杂不易书写，JDK添加了此方面的新特性:即增强for循环
		*/
		for(String s : al)
		{
			sop(s);
		}


	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
